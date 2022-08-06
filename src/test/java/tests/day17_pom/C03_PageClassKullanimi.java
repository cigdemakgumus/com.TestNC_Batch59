package tests.day17_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_PageClassKullanimi {
    //Facebboka gidin
    //Çıkarsa cookies kabul edin
    //mail butonuna rastgele bir isim yazdırın
    //kullanıcısı sifre kutusuna rastgele bir password yazın
    //login butonuna basın
    //giriş yapılamadığını test edin

    @Test
    public void test01() {
        FacebookPage facebookPage = new FacebookPage();
        // facebook anasayfaya gidin
        Driver.getDriver().get("https://www.facebook.com");
        // cikarsa cookies kabul edin
        //facebookPage.cookieButonu.click();
        // kullanici mail kutusuna rastgele bir isim yazdirin
        Faker faker = new Faker();
        facebookPage.mailKutusu.sendKeys(faker.internet().emailAddress());
        // kullanici sifre kutusuna rastgele bir password yazdirin
        facebookPage.sifreKutusu.sendKeys(faker.internet().password());
        // login butonuna basin
        facebookPage.loginTusu.click();
        // giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());
        Driver.closeDriver();
    }
}
