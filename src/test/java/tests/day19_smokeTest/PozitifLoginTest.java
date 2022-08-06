package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitifLoginTest {
    // Bir test method olustur positiveLoginTest()
    //       https://www.bluerentalcars.com/ adresine git
    //      login butonuna bas
    //test data user email: customer@bluerentalcars.com ,
    //test data password : 12345
    //login butonuna tıklayın
    //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

    BrcPage brcPage=new BrcPage();

    @Test
    public void positiveLoginTest(){
        // Bir test method olustur positiveLoginTest()
        //		 https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //		login butonuna bas
        brcPage.ilkLoginButonu.click();
        // test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        // test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        // login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String expectedUsername=ConfigReader.getProperty("brcValidUsername");
        String actualUsername=brcPage.kullaniciProfilIsmi.getText();
        Assert.assertEquals(actualUsername,expectedUsername);
    }
}
