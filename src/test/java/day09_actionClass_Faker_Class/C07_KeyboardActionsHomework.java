package day09_actionClass_Faker_Class;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C07_KeyboardActionsHomework extends TestBase {
    @Test
    public void test01() {
        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin
        WebElement buton1=driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(buton1).perform();

        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();

        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6- “Click and hold" kutusuna basili tutun
        WebElement clickHoldButon=driver.findElement(By.xpath("//p[text()='Click and Hold!']"));
        actions.moveToElement(clickHoldButon).click().perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement ClickHoldYazi=driver.findElement(By.xpath("//div[text()='Dont release me!!!']"));
        System.out.println(ClickHoldYazi.getText());

        //8- “Double click me" butonunu cift tiklayin
        WebElement doublebutton=driver.findElement(By.tagName("h2"));
        actions.doubleClick(doublebutton).perform();
    }
}
