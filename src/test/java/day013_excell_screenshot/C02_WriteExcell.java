package day013_excell_screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcell {
    @Test
    public void test01() throws IOException {
        String dosyaYolu="src/test/java/day012_webTable_ExcelData/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        // simdi tabloya 4. bir sutun daha  ekleyelim bu sutun nufus bilgisi olsun

        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("NUFUS");

        // 5.Satidaki ulkenin nufusunu 3000000 yapalim
        workbook.getSheet("Sayfa1").getRow(4).createCell(4).setCellValue("3000000");

        // 15 . ulkenunin nufusunu 2500000 yapalim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("2500000");

        // 23. ulkenin nufusu 0 olsun :)
        workbook.getSheet("Sayfa1").getRow(22).createCell(4).setCellValue("0");

        // simdi bunlari bizim kopyamizdan gercek excell dosyasina atalim
        FileOutputStream fos= new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();

    }


}
