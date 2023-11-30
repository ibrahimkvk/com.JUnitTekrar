package day013_excell_screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_TakeScreenshotTamSayfa extends TestBase {
    @Test
    public void test01() throws IOException {
        //amazon sitesine gidelim
        driver.get("https://www.amazon.com");

        // arama motorundan nutella aratalim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // arama sonucunun nutella icerdigini test edelim
        WebElement aramasonucElementi=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        String actualsonucElementi=aramasonucElementi.getText();
        String expectedKelime="Nutella";

        Assert.assertTrue(actualsonucElementi.contains(expectedKelime));

        //sayfanin tum goruntusunun fotografinin cekelim
        ReusableMethods.tamEkranGoruntusuCek(driver);



    }
}
