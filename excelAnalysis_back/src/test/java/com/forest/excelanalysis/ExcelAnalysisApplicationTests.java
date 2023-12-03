package com.forest.excelanalysis;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.fastjson2.JSON;
import com.forest.excelanalysis.datas.TestFileUtil;
import com.forest.excelanalysis.easyexcel.DemoData;
import com.forest.excelanalysis.easyexcel.DemoDataListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;

@Slf4j
@SpringBootTest
class ExcelAnalysisApplicationTests {

    /**
     * 官方写法1
     * @throws FileNotFoundException
     */
    @Test
    void contextLoads() throws FileNotFoundException {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "G:\\软件项目区\\Excel可视化分析\\excelAnalysis_back\\src\\test\\java\\com\\forest\\excelanalysis\\datas\\demoData.xlsx";
        // 这里默认每次会读取100条数据 然后返回过来 直接调用使用数据就行
        // 具体需要返回多少行可以在`PageReadListener`的构造函数设置
        EasyExcel.read(fileName, DemoData.class, new PageReadListener<DemoData>(dataList -> {
            for (DemoData demoData : dataList) {
//                log.info("读取到一条数据{}", JSON.toJSONString(demoData));
//                System.out.println("读取到一条数据{}"+ JSON.toJSONString(demoData));
                System.out.println("读取到一条数据{}"+ demoData);

            }
        })).sheet().doRead();

    }

    /**
     * 官方写法2
     */
    void test2(){

    }

    /**
     * 官方写法3
     */
    @Test
    void  test3(){
        String fileName = "G:\\软件项目区\\Excel可视化分析\\excelAnalysis_back\\src\\test\\java\\com\\forest\\excelanalysis\\datas\\demoData.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
    }

    /**
     * 官方写法4
     */
    @Test
    void test4(){

        ExcelReader excelReader = null;
        String fileName = "G:\\软件项目区\\Excel可视化分析\\excelAnalysis_back\\src\\test\\java\\com\\forest\\excelanalysis\\datas\\demoData.xlsx";

        try {
            excelReader = EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).build();
            // 构建一个sheet 这里可以指定名字或者no
            ReadSheet readSheet = EasyExcel.readSheet(0).build();
            // 读取一个sheet
            excelReader.read(readSheet);

            // 在 try 语句块内部的其他操作...
        } catch (Exception e) {
            // 异常处理
            e.printStackTrace();
        } finally {
            // 关闭资源，确保资源被释放
            if (excelReader != null) {
                excelReader.finish();
            }
        }

    }
}
