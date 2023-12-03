package com.forest.excelanalysis.controller;

import com.forest.excelanalysis.service.XlsxService;
import com.forest.excelanalysis.utils.FileUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
public class FileController {
    @Autowired
    private XlsxService xlsxService;

    @PostMapping("/upload")
    public Object handleFileUpload(@RequestParam("file") MultipartFile file) {
        log.info("handleFileUpload fileName=>" + file.getOriginalFilename());
        final String fileExtension = FileUtils.getFileExtension(file.getOriginalFilename());

        // 根据文件后缀调用不同的服务处理
        if ("xlsx".equals(fileExtension) || "xls".equals(fileExtension)) {
            return xlsxService.processXlsxFile(file);
        } else if ("csv".equals(fileExtension)) {
            // 处理CSV文件的服务逻辑
        } else if ("txt".equals(fileExtension)) {
            // 处理TXT文件的服务逻辑
        } else {
            // 处理其他文件类型的逻辑
        }
        return "UploadSuccessful ~";
    }
}
