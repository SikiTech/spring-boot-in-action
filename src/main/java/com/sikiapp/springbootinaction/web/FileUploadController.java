/**
 * projectName: spring-boot-in-action
 * fileName: FileUploadController.java
 * packageName: com.sikiapp.springbootinaction.web
 * date: 2019-05-24 下午12:30
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.web;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: FileUploadController
 * @packageName: com.sikiapp.springbootinaction.web
 * @description: 文件上传
 * @author: Robert
 * @data: 2019-05-24 下午12:30
 * @version: V1.0
 **/
@Controller
@RequestMapping("/uploads")
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @GetMapping
    public String index() {
        return "file_upload";
    }

    @PostMapping("/upload1")
    @ResponseBody
    public Map<String, String> upload1(@RequestParam("file") MultipartFile file) throws IOException {
        logger.info("[文件类型] - [{}]", file.getContentType());
        logger.info("[文件名称] - [{}]", file.getOriginalFilename());
        logger.info("[文件大小] - [{}]", file.getSize());
        // 将文件写入到指定目录（具体开发中有可能是将文件写入到云存储/或者指定目录通过 Nginx 进行 gzip 压缩和反向代理，此处只是为了演示故将地址写成本地电脑指定目录）
        file.transferTo(new File("/Users/tsai/Desktop/fileupload/" + file.getOriginalFilename()));
        Map<String, String> result = new HashMap<>(16);
        result.put("contentType", file.getContentType());
        result.put("fileName", file.getOriginalFilename());
        result.put("fileSize", file.getSize() + "");
        return result;
    }

    @PostMapping("/upload2")
    @ResponseBody
    public List<Map<String, String>> upload2(@RequestParam("file") MultipartFile[] files) throws IOException {
        if (files == null || files.length == 0) {
            return null;
        }
        List<Map<String, String>> results = new ArrayList<>();
        for (MultipartFile file : files) {
            // Spring Mvc 提供的写入方式
            file.transferTo(new File("/Users/tsai/Desktop/fileupload/" + file.getOriginalFilename()));
            Map<String, String> map = new HashMap<>(16);
            map.put("contentType", file.getContentType());
            map.put("fileName", file.getOriginalFilename());
            map.put("fileSize", file.getSize() + "");
            results.add(map);
        }
        return results;
    }

    @PostMapping("/upload3")
    @ResponseBody
    public String upload3(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        CommonsMultipartFile commonsmultipartfile = (CommonsMultipartFile) multipartFile;
        DiskFileItem diskFileItem = (DiskFileItem) commonsmultipartfile.getFileItem();
        // 读取硬盘中的临时文件，需要配置maxInMemory
        File tempFile = diskFileItem.getStoreLocation();
        InputStream inputStream = diskFileItem.getInputStream();
        final File file = new File("/Users/tsai/Desktop/fileupload/test1.jpg");
        final File file2 = new File("/Users/tsai/Desktop/fileupload/test2.jpg");

        OutputStream outputStream = new FileOutputStream(file2);
        FileCopyUtils.copy(tempFile, file);
        IOUtils.copy(inputStream, outputStream);

        return "upload succeed";
    }

    @PostMapping("/upload4")
    @ResponseBody
    public void upload3(String base64) throws IOException {
        // BASE64 方式的 格式和名字需要自己控制（如 png 图片编码后前缀就会是 data:image/png;base64,）
        final File tempFile = new File("/Users/tsai/Desktop/fileupload/test.jpg");
        // 防止有的传了 data:image/png;base64, 有的没传的情况
        String[] d = base64.split("base64,");
        final byte[] bytes = Base64Utils.decodeFromString(d.length > 1 ? d[1] : d[0]);
        FileCopyUtils.copy(bytes, tempFile);
    }



}