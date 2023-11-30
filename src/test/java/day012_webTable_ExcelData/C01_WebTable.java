package day012_webTable_ExcelData;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTable extends TestBase {
    @Test
    public void test01() {
        // Bir Class olusturun D19_WebtablesHomework
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //2. Headers da bulunan basliklari yazdirin
        WebElement headers=driver.findElement(By.xpath("//div[@class='rt-thead -header']"));
        System.out.println("Headers da bulunan basliklar : "+headers.getText());

        //3. 3.sutunun basligini yazdirin
       List<WebElement> headersListesi=driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        System.out.println("3. basligin ismi  : " + headersListesi.get(3).getText());

        //4. Tablodaki tum datalari yazdirin
        WebElement tumdatalar=driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        System.out.println("Tum datalar : " + tumdatalar.getText());

        //5. Tabloda kac tane bos olmayan cell (data) oldugunu
        List<WebElement> tumDatalarListesi=driver.findElements(By.xpath("//div[@class='rt-td']"));
        int sirano=1;
        for (WebElement eachData:tumDatalarListesi
             ) {
            if(!(eachData.getText().equals(" ") || eachData.getText().equals("")))
                System.out.println(sirano + ".-" + eachData.getText());
                sirano++;

        }

        //6. Tablodaki satir sayisini yazdirini
        List<WebElement> satirlarListesi=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("satir sayisi : " + satirlarListesi.size());


        //7. Tablodaki sutun sayisini yazdirin

        List<WebElement> sutunlarListesi=driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        System.out.println("tablodaki sutun sayisi : " + sutunlarListesi.size());

        //8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncusutunElemanlari=driver.findElements(By.xpath("(//div[@class='rt-tr-group'])//div[1]//div[3]"));

        for (WebElement eachData:ucuncusutunElemanlari
        ) {
            if(!(eachData.getText().equals(" ") || eachData.getText().equals("")))
                System.out.println(eachData.getText());

                    }

        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        List<WebElement> tumdatalarListesi=driver.findElements(By.xpath("//div[@class='rt-td']"));
        for (int i = 1; i <tumdatalarListesi.size() ; i++) {
            if(tumdatalarListesi.get(i).getText().equals("Kierra")) {
                System.out.println(tumdatalarListesi.get(i+4).getText());
            }
        }

        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
        //sayisini girdigimde bana datayi yazdirsin
    }
}
