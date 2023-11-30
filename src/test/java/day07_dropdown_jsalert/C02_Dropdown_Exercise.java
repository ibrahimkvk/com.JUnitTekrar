package day07_dropdown_jsalert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C02_Dropdown_Exercise {

    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown() {
         driver.close();
    }

     @Test
    public void test() {
       // Handle Dropdown
         //1. http://zero.webappsecurity.com/ Adresine gidin
         driver.get("http://zero.webappsecurity.com/");

         //2. Sign in butonuna basin
         driver.findElement(By.xpath("//button[@id='signin_button']")).click();

         //3. Login kutusuna “username” yazin
         driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

         //4. Password kutusuna “password.” yazin
         driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

         //5. Sign in tusuna basin
         driver.findElement(By.xpath("//input[@value='Sign in']")).click();

         //6. Pay Bills sayfasina gidin
         driver.navigate().back();
         driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
         driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

         //7. “Purchase Foreign Currency” tusuna basin
         driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();

         //8. “Currency” drop down menusunden Eurozone’u secin
         WebElement ddm=driver.findElement(By.id("pc_currency"));
         Select select=new Select(ddm);
         select.selectByVisibleText("Eurozone (euro)");


         //9. “amount” kutusuna bir sayi girin
         driver.findElement(By.id("pc_amount")).sendKeys("500");

         //10. “US Dollars” in secilmedigini test edin
         WebElement dolar= driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
         WebElement selectedCurrently= driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
         Assert.assertFalse(dolar.isSelected());

         //11. “Selected currency” butonunu secin
         if(!selectedCurrently.isSelected()) {
             selectedCurrently.click();
         }

         //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
         driver.findElement(By.id("pc_calculate_costs")).click();
         //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
         driver.findElement(By.xpath("(//input[@class='btn btn-primary'])[2]")).click();
         WebElement kayitYazisi=driver.findElement(By.xpath("//div[text()='Foreign currency cash was successfully purchased.']"));
         Assert.assertTrue(kayitYazisi.isDisplayed());

     }
}
