package com.forest.excelanalysis.service.XlsxServiceImpl;

import com.alibaba.excel.EasyExcel;
import com.forest.excelanalysis.controller.FileController;
import com.forest.excelanalysis.easyexcel.ExcelDataListener;
import com.forest.excelanalysis.service.XlsxService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
@Slf4j
public class XlsxServiceImpl implements XlsxService {

    @Override
    public Object processXlsxFile(MultipartFile file) {

        try (InputStream inputStream = file.getInputStream()) {
            ExcelDataListener listener = new ExcelDataListener();
            EasyExcel.read(inputStream, null, listener).sheet().doRead();
            log.info("XlsxService处理的数据{}",listener.getHeaders());
            return listener.getResultMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
