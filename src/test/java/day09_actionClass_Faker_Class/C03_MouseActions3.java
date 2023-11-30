package day09_actionClass_Faker_Class;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_MouseActions3 extends TestBase {
     @Test
    public void test01() {
         // Yeni bir class olusturalim: MouseActions3
         //1- https://www.amazon.com/ adresine gidin
         driver.get("https://www.amazon.com/");

         //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
         //mouse’u bu menunun ustune getirin
         Actions actions=new Actions(driver);
         WebElement buton=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
         actions.moveToElement(buton).perform();


         //3- “Create a list” butonuna basin
         driver.findElement(By.xpath("//span[text()='Create a List']")).click();
         ReusableMethods.bekle(5);
         //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
         WebElement yourlistElementi=driver.findElement(By.xpath("//div[@role='heading']"));
         Assert.assertTrue(yourlistElementi.isDisplayed());
     }

}
