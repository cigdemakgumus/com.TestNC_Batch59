package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {



    @Test
    public void test01(){
        AmazonPage amazonPage=new AmazonPage();
        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //nutella için arama yapalım
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //sonucların nutella içerdiğini test edelim
        String expectedKelime="Nutella";
        String actualSonucYazisi=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        //Sayfayı kapatalım
        Driver.closeDriver();

    }
    @DataProvider
    public static Object[][] AranacakKelimeler() {

        Object[][] arananKelimeArrayi={{"Nutella"}, {"java"}, {"cigdem"},{"Netherlands"}};
        return arananKelimeArrayi;
    }

    @Test(dataProvider = "AranacakKelimeler")
    //arayacağimiz kelimeleri bir liste gibi tutup bana yollayacak bir veri sağlayıcısı olusturacağız
    public void dataProviderTesti(String arananKelime){
        AmazonPage amazonPage=new AmazonPage();
        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //Nutella, Java, cigdem, Netherland icin arama yapalım
        amazonPage.aramaKutusu.sendKeys("arananKelime"+Keys.ENTER);
        //Sonucların aradığımız kelime içerdiğini test edelim
        String expectedKelime=arananKelime;
        String actualKelime=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualKelime.contains(expectedKelime));
        //Sayfayı kapatalım
        Driver.closeDriver();

    }
}
