package day011_seleniuWait_cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ExplicitlyWait {
    protected WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void teardown() {

        driver.close();
    }

    //  1. Bir class olusturun : WaitTest
    //  2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //  Iki metod icin de asagidaki adimlari test edin.
    //  3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //  4. Remove butonuna basin.
    //  5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //  6. Add buttonuna basin
    //  7. It’s back mesajinin gorundugunu test edin


    @Test
    public void implicitWaitTest() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //  3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        //  4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();


        //  5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsgoneElementi = driver.findElement(By.id("message"));
        Assert.assertTrue(itsgoneElementi.isDisplayed());

        //  6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //  7. It’s back mesajinin gorundugunu test edin
        WebElement itsbackElementi = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsbackElementi.isDisplayed());


    }

    @Test
    public void explicitWaitTest() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));


        //  4. Remove butonuna basin.
        WebElement itsgoneElementi= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsgoneElementi.isDisplayed());


        //  6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();


        //  7. It’s back mesajinin gorundugunu test edin
        WebElement itsbackElementi= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsbackElementi.isDisplayed());

    }
}