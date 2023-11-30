package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeAfterClass {
    // 3 ayri test classi olusturun
    // 1-de amazon adresine gidip gittigimizi test edelim
    // 2-de nutella aratip sonuclarin nutella icerdigini test edelim
    // 3- denutella arama sonuc sayisinin 50 den fazla oldugunu test edelim
     static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("setup metodu calisti");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("teardown metodu calisti");
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
        String expectedKelime="Amazon";
        String actualTitle=driver.getTitle();
        if(actualTitle.contains(expectedKelime)) {
            System.out.println("Amazon a gidis TESTI PASSED");
        } else {
            System.out.println("Amazon a gidis TESTI FAILED");
        }

    }

    @Test
    public void test02() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime="nutella";
        String actualBaslik=driver.getTitle();
        System.out.println(sonucYazisi.getText());
        if(actualBaslik.contains(expectedKelime)) {
            System.out.println("arama sonucunun nutella icerdigi testi PASSED");
        } else {
            System.out.println("arama sonucunun netella icerdigi testi FAILED");
        }


    }

    @Test
    public void test03() {
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisiStr=sonucYazisi.getText();
        String [] sonucyazisiArr= sonucYazisiStr.split(" ");
        String sonucAdediStr= sonucyazisiArr[2];
        Integer sonucAdediInt=Integer.parseInt(sonucAdediStr);
        Integer expectedAdet=50;
        if(sonucAdediInt>expectedAdet) {
            System.out.println("Nutella arama sonuc sayisi 50 den buyuk TESTI PASSED");
        } else {
            System.out.println("Nutella arama sonuc sayisi 50 den buyuk TESTI FAILED");
        }

    }
}
