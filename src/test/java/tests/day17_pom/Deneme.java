package tests.day17_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class Deneme {

    @Test
    public void test01() {
        FacebookPage facebookPage = new FacebookPage();

        //Facebboka gidin
        Driver.getDriver().get("https://www.facebook.com");
        //Çıkarsa cookies kabul edin
        //facebookPage.cookieButonu.click();
        //mail butonuna rastgele bir isim yazdırın
        Faker faker=new Faker();
        facebookPage.mailKutusu.sendKeys(faker.internet().emailAddress());
        //kullanıcısı sifre kutusuna rastgele bir password yazın
        facebookPage.sifreKutusu.sendKeys(faker.internet().password());
        //login butonuna basın
        facebookPage.loginTusu.click();
        //giriş yapılamadığını test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());
        Driver.closeDriver();
    }
}
