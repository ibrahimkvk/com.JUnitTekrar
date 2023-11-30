package day09_actionClass_Faker_Class;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C01_MouseAction extends TestBase {
    @Test
    public void test01() {
        // 1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String ilkSayfaWHD=driver.getWindowHandle();

        //3- Cizili alan uzerinde sag click yapin
        Actions actions=new Actions(driver);
        WebElement cizgiliAlan= driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(cizgiliAlan).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String actualAlertYazi=driver.switchTo().alert().getText();
        String expectedAlertYazi="You selected a context menu";
        Assert.assertEquals(expectedAlertYazi,actualAlertYazi);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        WebElement elementalSelenium= driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        actions.click(elementalSelenium).perform();
        Set<String> tumWHD=driver.getWindowHandles();
        String ikinciSayfaWHD="";
        for (String eachWHD:tumWHD
             ) {
            if(!eachWHD.equals(ilkSayfaWHD)) {
                ikinciSayfaWHD=eachWHD;
            }
        }
        driver.switchTo().window(ikinciSayfaWHD);

        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
        String actualSayfaYaziElementi=driver.findElement(By.tagName("h1")).getText();
        String expectedSayfaYaziElementi="Make sure your code lands";
        Assert.assertEquals(expectedAlertYazi,actualAlertYazi);
    }

}
