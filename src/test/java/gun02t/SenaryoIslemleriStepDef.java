package gun02t;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SenaryoIslemleriStepDef {
    int sayi;

    @Given("baslangic sayisi {int} olsun")
    public void baslangicSayisiOlsun(int basSayi) {
        sayi = basSayi;
        System.out.println("sayi initalize edildi = " + basSayi);

    }

    @When("kullanici {int} eklediginde")
    public void kullaniciEklediginde(int ikinciSayi) {
        sayi += ikinciSayi;
    }

    @Then("sonuc {int} olmalidir")
    public void sonucOlmalidir(int ucuncuSayi) {
        Assert.assertEquals(ucuncuSayi, sayi);
    }

    @And("kullanici {int} cikardiginda")
    public void kullaniciCikardiginda(int cikarSayi) {
        sayi -= cikarSayi;
    }
}
