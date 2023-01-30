package com.hanhu.serve.controller;

import com.aliyun.oss.model.OSSObjectSummary;
import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.utils.OssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * 文件上传下载
 * 测试类
 */
@RestController
public class OssTestController {

    @Autowired
    private OssUtil ossUtil;

    /**
     * 文件上传到oss
     *
     * @param
     * @return
     */
    @PostMapping("/oss/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        return ossUtil.putObject(file);
    }





    /**
     * 删除文件
     *
     * @param fileName
     * @return
     */
    @GetMapping("oss/delete")
    public String delete(@RequestParam("fileName") String fileName) {
        Boolean flag = ossUtil.deleteObject(fileName);
        if (flag) {
            return "删除成功";
        }
        return "删除失败";
    }

    /**
     * 查询文件列表
     *
     * @return
     */
    @GetMapping("oss/list")
    public List<OSSObjectSummary> list() {
        List<OSSObjectSummary> fileList = ossUtil.listObjects();
        return fileList;
    }

    /**
     * 查询文件列表
     *
     * @return
     */
    @GetMapping("oss/listPre")
    public List<OSSObjectSummary> listPre(@RequestParam("prefix") String prefix) {
        List<OSSObjectSummary> fileList = ossUtil.listObjects(prefix);
        return fileList;
    }

    /**
     * 下载文件
     *
     * @param fileName
     * @param response
     * @throws IOException
     */
    @GetMapping(value = "oss/download",produces = "application/octet-stream")
    public void download(@RequestParam("fileName") String fileName, HttpServletResponse response) throws IOException {
        // 通知浏览器以附件形式下载
        //用流的形式传出
        response.setHeader("content-type","application/octet-stream");
        //防止中文乱码
        response.setHeader("Content-Disposition",
                "attachment;filename=" + URLEncoder.encode(new String(fileName.getBytes()), "utf-8"));
        ossUtil.download(response.getOutputStream(), fileName);
    }

    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    @PostMapping("/oss/uploadPic")
    public String uploadPic(@RequestParam("file") MultipartFile file) {
        boolean flag = ossUtil.isImage(file);
        if (flag) {
            return ossUtil.uploadPic(file);
        }
        return "图片上传失败";
    }

}
