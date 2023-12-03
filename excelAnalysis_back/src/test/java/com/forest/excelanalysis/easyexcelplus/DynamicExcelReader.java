package com.forest.excelanalysis.easyexcelplus;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

public class DynamicExcelReader {
    public static void main(String[] args) {
        String fileName = "G:\\软件项目区\\Excel可视化分析\\excelAnalysis_back\\src\\test\\java\\com\\forest\\excelanalysis\\datas\\demoData.xlsx";
        readExcel(fileName);
    }
    public static void readExcel(String filePath) {
        EasyExcel.read(filePath, new AnalysisEventListener<Map<Integer, String>>() {
            @Override
            public void invoke(Map<Integer, String> data, AnalysisContext context) {
                // 处理每一行数据，data 是一个 Map，key 是列索引，value 是单元格的值
                System.out.println("Read data: " + data);
            }

            @Override
            public void invokeHeadMap(Map headMap, AnalysisContext context) {

                System.out.println("解析到的表头数据: {}"+headMap);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                // 读取完成后的操作，可以在这里进行一些清理工作
            }


        }).sheet().doRead();
    }
}
