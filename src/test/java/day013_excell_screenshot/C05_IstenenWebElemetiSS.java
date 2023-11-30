package day013_excell_screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_IstenenWebElemetiSS extends TestBase {

    @Test

    public void test01() throws IOException {

            // amazona git
            driver.get("https://www.amazon.com");

            //nutella arattir
            WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
            aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

            // arama sonucunun nutella icerdigini test et
            WebElement aramasonucElementi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

            String actualsonucElementi = aramasonucElementi.getText();
            String expectedKelime = "Nutella";

            // arama sonuc elementinin ekran goruntusunu al

        ReusableMethods.istenenElemetSS(driver,aramasonucElementi);



        }

    }

