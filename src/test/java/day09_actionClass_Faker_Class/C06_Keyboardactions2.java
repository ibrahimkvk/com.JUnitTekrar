package day09_actionClass_Faker_Class;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_Keyboardactions2 extends TestBase {
    @Test
    public void test01() {
        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement namebutton=driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String emailAdres=faker.internet().emailAddress();
        actions.click(namebutton)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(emailAdres)
                .sendKeys(Keys.TAB)
                .sendKeys(emailAdres)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("10")
                .sendKeys(Keys.TAB)
                .sendKeys("july")
                .sendKeys(Keys.TAB)
                .sendKeys("2010")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .click()
                .perform();
        // driver.findElement(By.xpath("//label[text()='Male']")).click();
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
        ReusableMethods.bekle(10);

        //4- Kaydol tusuna basalim
    }
}
