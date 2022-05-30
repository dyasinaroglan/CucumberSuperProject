package excelUtilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.Hook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExcelUtil {

    public static void writeToExcel(String path, String sheetName, List<String> data) {

        File f = new File(path);

        if (!f.exists()) {
            XSSFWorkbook workbook = new XSSFWorkbook(); // RAMde yeni bir xlsx calisma sayfasi olusturuldu
            XSSFSheet sheet = workbook.createSheet(sheetName);  // excel icinde sayfa olusturuldu

            Row row = sheet.createRow(0);   // satirlar olusturuluyor
            for (int i = 0; i < data.size(); i++) {
                Cell cell = row.createCell(i);  // hücreler olusturuluyor
                cell.setCellValue(data.get(i));
                //Ram'da oluşturduk
            }

            FileOutputStream out = null;
            try {
                out = new FileOutputStream(path);
                workbook.write(out);
                workbook.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else { //eğer varsa üzerine ekleme yapacağım. ekleme yapmak için önce var olan dosyayı okumam lazım
            FileInputStream input = null;
            Workbook workbook = null;
            Sheet sheet = null;
            try {
                input = new FileInputStream(path);
                workbook = WorkbookFactory.create(input);

                sheet = workbook.getSheet(sheetName);
                if (sheet == null)
                    sheet = workbook.createSheet(sheetName);
            }catch (IOException e){
                e.printStackTrace();
            }

            int numOfRows = sheet.getPhysicalNumberOfRows(); //sayfa içerisindeki satır sayısı

            Row row = sheet.createRow(numOfRows);
            for (int i = 0; i < data.size(); i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(data.get(i));
            }
            //tek tek tüm hücreleri okuduktan sonra ekleme yapacağız
            FileOutputStream output = null;
            try {
                input.close();
                output = new FileOutputStream(path);
                workbook.write(output);
                workbook.close();
                output.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }

    }
    public static String getCurrentTime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    public static void writeToExcel(List<String> data) throws IOException {
        writeToExcel(Hook.path, Hook.sheetName,data);
    }
}
