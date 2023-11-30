package day011_seleniuWait_cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ImplicitlyWait {
    protected WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // Selenium 4'e kadar 15 saniyeyi belirtmek icin
        // Timeouts class'indan 15  saniye tanimliyorduk
        // Selenium4 ile birlikte zaman belirleme class'i Duration oldu
    }

    @Test
    public void explicitWaitTest() {
        //  3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //  4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        //  5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsgoneElementi = driver.findElement(By.id("message"));
        Assert.assertTrue(itsgoneElementi.isDisplayed());

    }
}
