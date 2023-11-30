package day013_excell_screenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_TakeScreenshotTamSayfa1 extends TestBase {

    @Test
    public void test01() {
        // wisequarter sitesine git
        driver.get("https://wisequarter.com");

        // siteye gittiginizi test et
        String actualTitle=driver.getTitle();
        String expectedkelime="Wise Quarter";
        System.out.println(actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedkelime));

        //siteye gittiginin fotografinin cek
        ReusableMethods.tamEkranGoruntusuCek(driver);
    }

}
