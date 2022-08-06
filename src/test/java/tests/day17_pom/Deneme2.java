package tests.day17_pom;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class Deneme2 {

    @Test
    public void test01(){
        AmazonPage amazonPage=new AmazonPage();

        // amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");
        // nutella aratalim
        amazonPage.aramaKutusu.sendKeys("nutella" + Keys.ENTER);
        // sonuc yazisinin nutella icerdigini test edelim
        String expectedSonucYazisi="nutella";
        String actualSonucYazisi=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucYazisi));


    }
}
