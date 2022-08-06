package tests.day21_reusableMethods_HtmlReports;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PozitifLoginTestiRaporlu extends TestBaseRapor {
        BrcPage brcPage=new BrcPage();

    @Test
    public void positiveLoginTest() {
        //ilk satırda değer atarız
        // Bir test method olustur positiveLoginTest()
        extentTest=extentReports.createTest("Pozitif Login","Gecerli username ve sifre ile giriş yapabilmeli");
        //		 https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anasayfaya gidildi");
        //		login butonuna bas
        brcPage.ilkLoginButonu.click();
        extentTest.info("login butonuna tıklandı");
        // test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("Gecerli e mail yazıldı");
        // test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("gecerli passworld girildi");
        // login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();
        extentTest.info("login butonuna basıldı");
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String expectedUsername = ConfigReader.getProperty("brcValidUsername");
        String actualUsername = brcPage.kullaniciProfilIsmi.getText();
        Assert.assertEquals(actualUsername, expectedUsername);
        extentTest.pass("kullanıcı basarılı sekilde giriş yaptı");
        Driver.closeDriver();
    }
}
