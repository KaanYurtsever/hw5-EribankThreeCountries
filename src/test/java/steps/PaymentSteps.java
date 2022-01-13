package steps;

import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.java.Log;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.EnsureFieldVisible;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Text;

import tasks.LoginToEriBank;
import tasks.MakePayment;
import ui.PaymentPageElements;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class PaymentSteps {
    public static int balance;

    @Managed(driver = "Appium")
    public WebDriver hisMobileDevice;

    String actorName="kaan";
    Actor actor = Actor.named(actorName);

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("Open browser and homepage screen")
    public void open_browser_and_homepage_screen() {
        actor.can(BrowseTheWeb.with(hisMobileDevice));
    }
    @When("Login with company username and password")
    public void login_with_company_username_and_password() {
        actor.attemptsTo((LoginToEriBank.login("company","company")));

    }

    @And("Make {string} with the values {string},{int},{string}")
    public void makeWithTheValues(String phone, String name, Integer payments, String country) {
        actor.attemptsTo(MakePayment.payment(phone, name,payments,country));
        balance = 100;
        balance = balance - payments;



    }




    @Then("Should see that log out page")
    public void should_see_that_log_out_page() {


        Ensure.that(PaymentPageElements.getLastBalance(balance)).isDisplayed();


    }



}


