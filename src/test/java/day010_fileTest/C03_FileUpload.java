package day010_fileTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileUpload extends TestBase {
    @Test
    public void test01() {
        // 1. Tests packagenin altina bir class oluşturun : C05_UploadFile
        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //3. chooseFile butonuna basalim
        //4. Yuklemek istediginiz dosyayi secelim.
        //5. Upload butonuna basalim.
        WebElement choosebuton=driver.findElement(By.xpath("//input[@id='file-upload']"));
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\deneme.docx";
        choosebuton.sendKeys(dosyaYolu);
        driver.findElement(By.id("file-submit")).click();

        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement uploadYazi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(uploadYazi.isDisplayed());
    }
}
