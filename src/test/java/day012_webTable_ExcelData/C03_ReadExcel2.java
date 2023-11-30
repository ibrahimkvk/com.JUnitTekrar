package day012_webTable_ExcelData;

import io.github.bonigarcia.wdm.versions.Shell;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C03_ReadExcel2 {
    @Test
    public void test01() throws IOException {
        // Yeni bir test method olusturalim readExcel2( )
        String dosyaYolu="src/test/java/day012_webTable_ExcelData/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

          //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
          //  Sheet sheet=workbook.getSheet("Sayfa1");
          //  Row row=sheet.getRow(0);
         //   Cell cell=row.getCell(1);
         //   System.out.println(cell); bunlarin hepsini tek seferde yapabiliyoruz

         System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));


        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String birinciSatirIkinciHucre=workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println("1. satir 2. hucre elemani:  "+birinciSatirIkinciHucre);

        //- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String actualKelime=workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expectedKelime ="Kabil";
        Assert.assertEquals(expectedKelime,actualKelime);

        //- Satir sayisini bulalim
        System.out.println("sayfadaki satir sayisi:  " + workbook.getSheet("Sayfa1").getLastRowNum());

        //- Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("Sayfada kullanilan satir sayisi: " + workbook.getSheet("Sayfa2").getLastRowNum());
        System.out.println("Saydaki fiziki olarak kullanilan satir sayisi:  " + workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());

        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String,String> ulkelerMap= new TreeMap<>();
        String key="";
        String value="";
        int satirSayisi=workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 0; i <=satirSayisi ; i++) {
            key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + "," +
                  workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + "," +
                  workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);
        }
        System.out.println(ulkelerMap);
    }
}
