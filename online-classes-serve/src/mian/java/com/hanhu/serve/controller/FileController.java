package com.hanhu.serve.controller;


import com.aliyun.oss.OSS;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.hanhu.serve.AdminUtils;
import com.hanhu.serve.config.OssConfig;
import com.hanhu.serve.entity.Courses;
import com.hanhu.serve.entity.File;
import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.service.FileService;
import com.hanhu.serve.utils.OssUtil;
import io.swagger.annotations.ApiOperation;
import lombok.val;
import onway.org.cn.comm.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hanhu
 * @since 2022-02-14
 */
@RestController
@RequestMapping("/file/manager")
public class FileController extends BaseController {

    @Autowired
    private FileService fileService;

    @Autowired
    private OssUtil ossUtil;

    @Autowired
    private OSS ossClient;

    @Autowired
    private OssConfig ossConfig;


    @ApiOperation(value = "获取所有文件")
    @GetMapping("/")
    public List<File> getAllFiles(){
        return fileService.list();
    }

    @ApiOperation(value = "根据关键词获取文件")
    @GetMapping("/{keywords}")
    public List<File> getAllFiles(@PathVariable String keywords){
        return fileService.getFileByKeyWords(keywords);
    }








    @ApiOperation(value = "上传文件")
    @PostMapping("/")
    public RespBean addFile(@RequestParam("multipartFile")MultipartFile multipartFile){

        //文件上传到服务器
        ossUtil.uploadFile(multipartFile);
        //获取文件名字与服务器中的文件名字
        String fileName = multipartFile.getOriginalFilename();
        String searchFileName = "javakf/"+fileName;

        //根据文件名搜索阿里云服务器中的对应文件
        ObjectListing listObjects = ossClient.listObjects(ossConfig.getBucketName(), searchFileName);
        List<OSSObjectSummary> fileList = listObjects.getObjectSummaries();

        //获取当前用户姓名
        String loadUser =  AdminUtils.getCurrentAdmin().getName();
        //获取当前时间
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");

        //文件大小
        Long fileSize = fileList.get(0).getSize();
        //文件类型,获取后缀
        String fileType = fileName.substring(fileName.lastIndexOf(".")+1);
        //下载链接
        String fileUrl = ossUtil.getUrl(searchFileName);

        //将文件信息存入数据库
        File file = new File();
        file.setName(fileName);
        file.setTrueName(searchFileName);
        file.setFileSize(fileSize);
        file.setFileType(fileType);
        file.setUploadTime(dateFormat.format(date));
        file.setUploadUser(loadUser);
        file.setFileUrl(fileUrl);

//        System.out.println("上传的文件名："+fileName);
//        System.out.println("用来在阿里云中搜索的文件名："+searchFileName);
//        System.out.println("搜索到的文件:"+fileList);
//        System.out.println("当前时间:"+dateFormat.format(date));
//        System.out.println("当前登录用户名："+loadUser);
//        System.out.println("文件大小："+fileSize);
//        System.out.println("文件类型："+fileType);
//        System.out.println("文件下载链接："+fileUrl);
//

        if(fileService.save(file)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }




    @ApiOperation(value = "删除文件")
    @DeleteMapping("/{id}")
    public RespBean deleteFile(@PathVariable Integer id){
        if(fileService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }


}

