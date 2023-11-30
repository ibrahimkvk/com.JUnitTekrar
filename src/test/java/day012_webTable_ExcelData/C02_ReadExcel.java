package day012_webTable_ExcelData;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void test01() throws IOException {

        String dosyaYolu="src/test/java/day012_webTable_ExcelData/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        Sheet sheet=workbook.getSheet("Sayfa1");
        Row row=sheet.getRow(3);
        Cell cell=row.getCell(2);
        System.out.println(cell);


    }
}
