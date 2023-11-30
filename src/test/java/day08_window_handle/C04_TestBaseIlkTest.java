package day08_window_handle;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_TestBaseIlkTest extends TestBase {

    @Test
    public void test() {

        //wiseQaurter a git
        driver.get("https://www.wisequarter.com");


        //o siteye gittigini test et
       String expectedKelime="wisequarter";
       String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedKelime));
        ReusableMethods.bekle(3);


    }
}