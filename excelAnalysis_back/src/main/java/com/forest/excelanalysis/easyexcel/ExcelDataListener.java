package com.forest.excelanalysis.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelDataListener implements ReadListener<Map<Integer, String>> {

    private List<String> headers = new ArrayList<>();
    private final List<List<String>> columns = new ArrayList<>();
    private final Map<String, List<String>> resultMap = new HashMap<>();

    @Override
    public void invoke(Map<Integer, String> map, AnalysisContext analysisContext) {
//        System.out.println("invoke->" + map);
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer columnIndex = entry.getKey();
            String cellValue = entry.getValue();
//            System.out.println("key-value " + columnIndex + ":" + cellValue);

            while (columns.size() <= columnIndex) {
                columns.add(new ArrayList<>());
            }
            columns.get(columnIndex).add(cellValue);

        }
        // 在这里将当前数据直接加入 resultMap
        for (int i = 0; i < columns.size(); i++) {
            resultMap.put("ArrayList" + (i + 1), columns.get(i));
        }

    }

    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {

        // 遍历 headMap 获取表头信息
        for (Map.Entry<Integer, ReadCellData<?>> entry : headMap.entrySet()) {
            ReadCellData<?> cellData = entry.getValue();
            headers.add(cellData.getStringValue());
        }
        System.out.println("headers->" + headers);

    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("resultMap==>"+resultMap);
    }

    /**
     * 获取表头数组
     *
     * @return
     */
    public List<String> getHeaders() {
        return headers;
    }

    public  Map<String, List<String>> getResultMap(){
        return resultMap;
    }


}
