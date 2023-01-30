package com.hanhu.serve.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.*;
import com.hanhu.serve.config.OssConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 阿里云OSS服务器工具类
 *
 */
@Component
public class OssUtil {

    @Autowired
    private OSS ossClient;

    @Autowired
    private OssConfig ossConfig;

    private static final long EXPIRATION = 3600l * 1000 * 24 * 7;// 七天

    // 允许上传的格式
    private static final String[] IMAGE_TYPE = new String[] { ".bmp", ".jpg", ".jpeg", ".gif", ".png" };

    private String PATH = "javakf/";

    /**
     * 单文件上传
     *
     * @param file
     * @return
     */
    public String uploadFile(MultipartFile file) {
        String fileUrl = putObject(file);
        return fileUrl;
    }

    /**
     * 多文件上传
     *
     * @param fileList
     * @return
     */
    public String multiUpload(List<MultipartFile> fileList) {
        String url = null;
        String fileUrl = null;
        for (int i = 0; i < fileList.size(); i++) {
            url = putObject(fileList.get(i));
            if (i == 0) {
                fileUrl = url;
            } else {
                fileUrl += ";" + url;
            }
        }
        return fileUrl.trim();
    }

    /**
     * 上传文件-支持单文件，多文件 -返回文件访问路径，多文件以分号‘；’分隔
     *
     * @param
     * @return
     */
    public String uploadFiles(MultipartFile... file) {
        if (file.length < 1) {
            throw new RuntimeException("上传文件为空！");
        }
        StringBuilder str = new StringBuilder();
        for (MultipartFile muFile : file) {
            str.append(putObject(muFile));
            str.append(";");
        }
        return str.deleteCharAt(str.length() - 1).toString();

    }

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    public String putObject(MultipartFile file) {
        try {
            //获取文件名
            String fileName = getFilePathName(file, true);
            // 上传到阿里云
            ossClient.putObject(ossConfig.getBucketName(), fileName, new ByteArrayInputStream(file.getBytes()));
            return this.ossConfig.getUrlPrefix() + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("上传文件失败！");
        }
    }

    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    public String uploadPic(MultipartFile file) {
        try {
            String fileName = getFilePathName(file, true);
            InputStream inputStream = file.getInputStream();
            // 如果是图片文件就进行压缩并添加水印
            if (ImageUtil.isImage(file.getOriginalFilename())) {
                inputStream = ImageUtil.getInputStream(
                        //图像添加水印
                        ImageUtil.setWatermark(ImageUtil.compress(ImageIO.read(inputStream))),
                        //获取文件后缀名称
                        ImageUtil.getFileExtention(file.getOriginalFilename()));
            }
            // 上传到阿里云
            ossClient.putObject(ossConfig.getBucketName(), fileName, inputStream);
            return this.ossConfig.getUrlPrefix() + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("上传文件失败！");
        }
    }

    /**
     * 校验图片格式
     *
     * @param file
     * @return
     */
    public boolean isImage(MultipartFile file) {
        boolean flag = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(file.getOriginalFilename(), type)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 删除文件
     *
     * @param fileName
     * @return
     */
    public Boolean deleteObject(String fileName) {
        try {
            ossClient.deleteObject(ossConfig.getBucketName(), fileName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 查询文件列表(默认100条)
     *
     * @return
     */
    public List<OSSObjectSummary> listObjects() {
        ObjectListing listObjects = ossClient.listObjects(ossConfig.getBucketName());
        List<OSSObjectSummary> fileList = listObjects.getObjectSummaries();
        return fileList;
    }

    /**
     * 查询文件列表(默认值100条，最大值1000条)
     *
     * @param maxKeys 要查询的条数
     * @return
     */
    public List<OSSObjectSummary> listObjects(Integer maxKeys) {
        if (maxKeys == null) {
            maxKeys = 100;
        }
        ObjectListing listObjects = ossClient
                .listObjects(new ListObjectsRequest(ossConfig.getBucketName()).withMaxKeys(maxKeys));
        List<OSSObjectSummary> fileList = listObjects.getObjectSummaries();
        return fileList;
    }

    /**
     * 查询指定前缀的文件列表
     *
     * @param prefix 前缀
     * @return
     */
    public List<OSSObjectSummary> listObjects(String prefix) {
        ObjectListing listObjects = ossClient.listObjects(ossConfig.getBucketName(), prefix);
        List<OSSObjectSummary> fileList = listObjects.getObjectSummaries();
        return fileList;
    }

    /**
     * 下载文件
     *
     * @param outputStream
     * @param fileName
     */
    public void download(OutputStream outputStream, String fileName) {
        try {
            OSSObject ossObject = ossClient.getObject(ossConfig.getBucketName(), fileName);
            BufferedInputStream in = new BufferedInputStream(ossObject.getObjectContent());
            BufferedOutputStream out = new BufferedOutputStream(outputStream);
            byte[] buffer = new byte[1024];
            int lenght = 0;
            while ((lenght = in.read(buffer)) != -1) {
                out.write(buffer, 0, lenght);
            }
            if (out != null) {
                out.flush();
                out.close();
            }
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成下载链接
     *
     * @param fileName
     * @return
     */
    public String getUrl(String fileName) {
        if (!StringUtils.isEmpty(fileName)) {
            // 设置URL过期时间为10年 3600l*1000*24*365*10
            Date expiration = new Date(new Date().getTime() + EXPIRATION);
            // 生成URL
            URL url = ossClient.generatePresignedUrl(ossConfig.getBucketName(), fileName, expiration);
            if (url != null) {
                return url.toString();
            }
        }
        return null;
    }

    /**
     * 上传文件
     *
     * @param inputStream
     * @param fileName
     * @return
     */
    public String putObject(InputStream inputStream, String fileName) {
        try {
            // 文件扩展名
            String fileSuffix = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
            // 新的文件名
            fileName = PATH + new Random().nextInt(10000) + System.currentTimeMillis() + fileSuffix;

            // 创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            // 上传的文件的长度
            objectMetadata.setContentLength(inputStream.available());
            // 指定该Object被下载时的网页的缓存行为
            objectMetadata.setCacheControl("no-cache");
            // 指定该Object下设置Header
            objectMetadata.setHeader("Pragma", "no-cache");
            // 指定该Object被下载时的内容编码格式
            objectMetadata.setContentEncoding("utf-8");
            // 文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
            // 如果没有扩展名则填默认值application/octet-stream
            objectMetadata.setContentType(getcontentType(fileSuffix));
            // 指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
            objectMetadata.setContentDisposition("inline;filename=" + fileName);

            // 上传文件
            ossClient.putObject(ossConfig.getBucketName(), fileName, inputStream, objectMetadata);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this.ossConfig.getUrlPrefix() + fileName;
    }

    /**
     * 获取文件名
     *
     * @param
     * @param isRetain 是否保留源文件名
     * @return 返回文件名，以当前年月日作为前缀路径
     */
    private String getFilePathName(MultipartFile file, boolean isRetain) {
        String fileName = file.getOriginalFilename();
        String name = fileName;
        String fileSuffix = "";
        if (fileName.indexOf('.') != -1) {
            name = fileName.substring(0, fileName.indexOf('.'));
            fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        }

        LocalDate date = LocalDate.now();
        StringBuilder filePathName = new StringBuilder(PATH);
//        filePathName.append(date.getYear());
//        filePathName.append("/");
//        filePathName.append(date.getMonthValue());
//        filePathName.append("/");
//        filePathName.append(date.getDayOfMonth());
//        filePathName.append("/");
//        // 添加随机后缀
//        Random r = new Random();
//        int pix = r.ints(1, (100 + 1)).findFirst().getAsInt();
//        filePathName.append(System.currentTimeMillis());
//        filePathName.append("" + pix);
//        // 文件名超过32字符则截取
//        if (isRetain) {
//            filePathName.append("_");
//            if (name.length() >= 32) {
//                name = name.substring(0, 32);
//            }
//            filePathName.append(name);
//        }
        filePathName.append(name);
        filePathName.append(fileSuffix);
        return filePathName.toString();
    }

    /**
     * 处理文件扩展名
     *
     * @param fileSuffix
     * @return
     */
    public String getcontentType(String fileSuffix) {
        if (fileSuffix.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (fileSuffix.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (fileSuffix.equalsIgnoreCase(".jpeg") || fileSuffix.equalsIgnoreCase(".jpg")
                || fileSuffix.equalsIgnoreCase(".png")) {
            return "image/jpeg";
        }
        if (fileSuffix.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (fileSuffix.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (fileSuffix.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (fileSuffix.equalsIgnoreCase(".pptx") || fileSuffix.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (fileSuffix.equalsIgnoreCase(".docx") || fileSuffix.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (fileSuffix.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        // 默认返回类型
        return "image/jpeg";
    }

    /**
     * 创建存储空间
     *
     * @param bucketName
     * @return
     */
    public boolean createBucket(String bucketName) {
        try {
            boolean flag = ossClient.doesBucketExist(bucketName);
            if (!flag) {
                ossClient.createBucket(bucketName);
                // 设置存储空间的权限为公共读，默认是私有。
                ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除存储空间
     *
     * @param bucketName
     * @return
     */
    public boolean deleteBucket(String bucketName) {
        try {
            boolean flag = ossClient.doesBucketExist(bucketName);
            if (flag) {
                ossClient.deleteBucket(bucketName);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 列举所有的存储空间(名称)
     *
     * @return
     */
    public List<String> listBuckets() {
        List<Bucket> buckets = ossClient.listBuckets();
        List<String> bucketNames = new ArrayList<>();
        for (Bucket bucket : buckets) {
            bucketNames.add(bucket.getName());
        }
        return bucketNames;
    }

}

