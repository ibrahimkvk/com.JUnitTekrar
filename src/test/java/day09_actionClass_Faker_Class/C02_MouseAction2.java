package day09_actionClass_Faker_Class;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_MouseAction2 extends TestBase {
    @Test
    public void test01() {
        //Yeni bir class olusturalim: MouseActions2
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMeButon=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement DropHereButon= driver.findElement(By.xpath("(//p[text()='Drop here'])[1]"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragMeButon,DropHereButon).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String actualYazi=DropHereButon.getText();
        String expectedYazi="Dropped!";
        Assert.assertEquals(expectedYazi,actualYazi);

    }
}
