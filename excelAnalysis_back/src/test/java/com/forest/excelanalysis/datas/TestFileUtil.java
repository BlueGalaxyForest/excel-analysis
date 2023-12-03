package com.forest.excelanalysis.datas;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestFileUtil {
    public static String getPath() {
        log.info("path-->"+TestFileUtil.class.getResource("/").getPath());
        return TestFileUtil.class.getResource("/").getPath();
    }

}
