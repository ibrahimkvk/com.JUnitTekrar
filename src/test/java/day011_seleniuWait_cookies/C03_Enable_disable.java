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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C03_Enable_disable {

    protected WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }
    @After
    public void teardown() {
        driver.quit();
    }
    // 1. Bir class olusturun : EnableTest
    // 2. Bir metod olusturun : isEnabled()
    // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 4. Textbox’in etkin olmadigini(enabled) dogrulayın
    // 5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    // 6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    // 7. Textbox’in etkin oldugunu(enabled) dogrulayın
    @Test
    public void implicityWait() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1-https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2-Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textboxElementi=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textboxElementi.isEnabled());

        // 3-Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        // 4-“It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsenableElementi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsenableElementi.isDisplayed());

        // 5-Textbox’in etkin oldugunu(enabled) dogrulayın
        Assert.assertTrue(textboxElementi.isEnabled());
    }
    @Test
    public void explicitlyWait() {
        // 1-https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2-Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textboxElementi=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textboxElementi.isEnabled());

        // 3-Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        // 4-“It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement itsenableElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        // 5-Textbox’in etkin oldugunu(enabled) dogrulayın
        Assert.assertTrue(textboxElementi.isEnabled());

    }
}
