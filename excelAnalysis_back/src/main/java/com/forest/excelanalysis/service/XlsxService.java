package com.forest.excelanalysis.service;

import org.springframework.web.multipart.MultipartFile;

public interface XlsxService {
    Object processXlsxFile(MultipartFile file);
}
