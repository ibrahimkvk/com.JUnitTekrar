package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
        }
    }

    public static void tamEkranGoruntusuCek(WebDriver driver) {

        //Sayfanin ekran goruntusunu almaka icin 4 asamda yapiyoruz

        //1- Bir TakeScreenshot objesi olusturup driverimizi ona cast yapiyoruz
        TakesScreenshot tss= (TakesScreenshot) driver;

        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih= ldt.format(dtf);
        String dosyaYolu="target/ekranResimleri/tumEkranSS " + tarih +".jpeg";

        //2-kayit edecegimiz ekran goruntusunu  projede istedigimiz yerin path yazarak olusturuyoruz
        File tumSayfaSS=new File(dosyaYolu);

        // 3-TakeScreenshot objesini kullanarak (tss) getScreenshotAs() metodunu kullanalim
        // ve gelen resmi gecici bir dosyaya kaydedelim

        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);

        //4-kaydettigimiz goruntuyu saklamak istedigimiz yere kaydedelim
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaSS);
        } catch (IOException e) {

        }

    }

    public static void istenenElemetSS(WebDriver driver, WebElement aramasonucElementi) {
        //bunun icin 4 asama vardir
        // 1-Istenilen webelemnt’i locate edin
        // 2- kaydettigimiz ekran goruntusunu projede istedigimiz yere kaydedebilmek icin
        //path ile yeni bir File olusturalim

        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih= ldt.format(dtf);

        File istenenElementSS = new File("target/ekranResimleri/istenenElementSS " + tarih + ".jpeg");

        // 3- Istenen webelement’i kullanarak getScreenshotAs( ) methodunu calistiralim ve
        //gelen resmi gecici bir file’a assign edelim


        File geciciResim = aramasonucElementi.getScreenshotAs(OutputType.FILE);

        // 4-Gecici resmi, saklamak istedigimiz dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciResim, istenenElementSS);
        } catch (IOException e) {

        }


    }
}
