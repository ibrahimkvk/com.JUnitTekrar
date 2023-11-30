package day06_assertions;

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

public class C06_RadioButton {
    // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //a. Verilen web sayfasına gidin.
    //https://facebook.com
    //b. Cookies’i kabul edin
    //c. Create an account buton’una basin
    //d. Radio button elementlerini locate edin ve size uygun olani secin
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
    public void test() throws InterruptedException {
        //a. Verilen web sayfasına gidin.
        //https://facebook.com
        driver.get("https://facebook.com");


        //b. Cookies’i kabul edin
        //c. Create an account buton’una basin
       driver.findElement(By.xpath("//a[text()='Create new account']")).click();



        //d. Radio button elementlerini locate edin ve size uygun olani secin

        WebElement femaleButton=driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement maleButton=driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement customButton=driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
        femaleButton.click();
        Assert.assertTrue(maleButton.isSelected());
        Thread.sleep(3000);


    }
}

