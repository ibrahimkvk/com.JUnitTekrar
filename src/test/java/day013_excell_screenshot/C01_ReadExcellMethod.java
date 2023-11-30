package day013_excell_screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcellMethod {

    @Test
    public void test01() throws IOException {
        String dosyaYolu="src/test/java/day012_webTable_ExcelData/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sayfa1").getRow(2).getCell(2).toString());

        getdata(3,3);

    }

    private void getdata(int satir, int sutun) throws IOException {
        String dosyaYolu="src/test/java/day012_webTable_ExcelData/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sayfa1").getRow(satir).getCell(sutun).toString());

    }
}
