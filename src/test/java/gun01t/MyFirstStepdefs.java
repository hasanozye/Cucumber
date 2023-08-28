package gun01t;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyFirstStepdefs {
    @Given("toplama isleminde")
    public void toplamaIsleminde() {
        System.out.println("Islem basladi");
    }

    @When("İlk sayi {int} oldugunda")
    public void i̇lkSayiOldugunda(int num) {
        System.out.println(num);
    }

    @And("İkinci sayi {int} oldugunda")
    public void i̇kinciSayiOldugunda(int num) {
        System.out.println(num);
    }




    @Then("sonuc {int} olmali")
    public void sonucOlmali(int num) {
        System.out.println(num);
    }
}
