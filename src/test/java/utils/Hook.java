package utils;

import excelUtilities.ExcelUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Hook {

    public static String path = "src/test/java/excelUtilities/log2.xlsx";
    //public static String fileName = "log2.xlsx";
    public static String sheetName = "TestLog";

    @BeforeAll // senaryo başlamadan önce
    public static void beforeAll() throws IOException {
        ExcelUtil.writeToExcel(new ArrayList<>(Arrays.asList("Senaryo adı","Açıklama","Tarih-Saat")));
    }

    @Before //her adımıdan önce
    public void beforeHook(Scenario scenario) throws IOException {
        ExcelUtil.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(),"Başladı", ExcelUtil.getCurrentTime())));
    }

    @After //her adımdan sonra
    public void afterHook(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            System.out.println("senaryo başarısız");
            ExcelUtil.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(),"Başarısız",ExcelUtil.getCurrentTime())));
        }else {
            System.out.println("senaryo başarılı");
            ExcelUtil.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(),"Başarılı",ExcelUtil.getCurrentTime())));
        }
        ExcelUtil.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(),"Bitti",ExcelUtil.getCurrentTime())));
    }
}
