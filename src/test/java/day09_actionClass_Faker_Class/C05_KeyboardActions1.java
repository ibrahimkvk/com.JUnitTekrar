package day09_actionClass_Faker_Class;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_KeyboardActions1 extends TestBase {
    @Test
    public void test01() {
        // 1- Bir Class olusturalim KeyboardActions1
        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve
        //Enter’a basarak arama yaptirin
        WebElement searchboxs=driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions=new Actions(driver);
        actions.click(searchboxs)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung")
                .sendKeys(Keys.SPACE)
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();
        ReusableMethods.bekle(5);

        //4- aramanin gerceklestigini test edin
        WebElement sonucElementi=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String actualSonucElementi=sonucElementi.getText();
        String expectedKelime="Samsung A71";
        Assert.assertTrue(actualSonucElementi.contains(expectedKelime));
    }
}
