package day010_fileTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {
    @Test
    public void test01() {
        // File Exist
        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. logo.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='sample.txt']")).click();
        String dosyaYolu=System.getProperty("user.home")+ "\\Downloads\\LambdaTest.txt";

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

}
