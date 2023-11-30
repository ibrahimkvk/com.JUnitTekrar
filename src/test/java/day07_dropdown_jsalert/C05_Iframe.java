package day07_dropdown_jsalert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Iframe {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown() {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //2 ) Bir metod olusturun: iframeTest
        //- “An IFrame containing….” textinin erisilebilir oldugunu test edin
        WebElement actualYaziElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(actualYaziElementi.isEnabled());


        //- Text Box’a “Merhaba Dunya!” yazin.

        // normal locate yapip yazdirmayi denedigimizde NoSuchElementException verdi
        // yani elementi bulamadi
        // kontrol ederken istedigimiz webelement'in bir iframe icinde oldugunu gorduk
        // Bu durumda once o iframe'e switchTo() yapmaliyiz

        WebElement iframeElementi= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElementi);
        WebElement textboxelementi= driver.findElement(By.xpath("//body[@id='tinymce']"));
        textboxelementi.clear();
        textboxelementi.sendKeys("Merhaba Ibrahim!!!");
        Thread.sleep(5000);


        // Iframe'in icine girdikten sonra, oradan cik denilinceye kadar
        // driver iframe'in icinde kalir
        // eger disina cikmak isterseniz

        //driver.switchTo().parentFrame(); // bulundugu iframe'den bir ust html sayfasina gecer
        // bu daha cok ic icice iframe'ler oldugunda tercih edilir
        // driver.switchTo().defaultContent(); // anasayfaya gecis yapar

        driver.switchTo().parentFrame();

        //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
        WebElement actualyazi= driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(actualyazi.isDisplayed());
        System.out.println(actualyazi.getText());


    }

}
