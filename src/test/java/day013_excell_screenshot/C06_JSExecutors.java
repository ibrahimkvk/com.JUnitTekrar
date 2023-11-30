package day013_excell_screenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_JSExecutors extends TestBase {
    @Test
    public void test01() {
        //bkm kitapa git
        driver.get("https://www.bkmkitap.com");

        // kirtasiye linkine JSExecutor kullanarak tukla
        WebElement kirtasiyeElement=driver.findElement(By.xpath("(//a[@title='Kırtasiye'])[2]"));
         // kirtasiyeElement.click();
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement kesfetElement=driver.findElement(By.xpath("//a[@class='box kesfetBtn']"));

        jse.executeScript("arguments[0].click();",kirtasiyeElement);

        jse.executeScript("alert('Bu is insallah olacak');");

        // jse.executeScript("arguments[0].scrollIntoView();",kesfetElement); yapamadim!!!!!!!!

        ReusableMethods.bekle(5);

    }
}
