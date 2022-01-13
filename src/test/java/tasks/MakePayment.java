package tasks;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import ui.PaymentPageElements;


import static net.serenitybdd.screenplay.Tasks.instrumented;



import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class MakePayment implements Task {


    private String country="";
    private Integer payments;
    private String phone = "";
    private String name = "";



    public MakePayment(String phone, String name, Integer payments, String country) {


        this.country = country;
        this.payments = payments;
        this.phone = phone;
        this.name = name;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                WaitUntil.the(PaymentPageElements.MAKEPAYMENT_BUTTON, isClickable()).forNoMoreThan(3).seconds(),
                Click.on(PaymentPageElements.MAKEPAYMENT_BUTTON),
                SendKeys.of(this.phone).into(PaymentPageElements.PHONE_FIELD),
                SendKeys.of(this.name).into(PaymentPageElements.NAME_FIELD),
                SendKeys.of(String.valueOf(this.payments)).into(PaymentPageElements.AMOUNT_BAR),
                Click.on(PaymentPageElements.COUNTRY_FIELD),
                //Click.on(PaymentPageElements.COUNTRYSELECT_BUTTON),
                Enter.theValue(this.country).into(PaymentPageElements.COUNTRY_FIELD),
                Click.on(PaymentPageElements.SENDPAYMENT_BUTTON),
                //Switch.toTheOtherWindow(),
                WaitUntil.the(PaymentPageElements.SENDPAYMENTYES_BUTTON, isClickable()).forNoMoreThan(3).seconds(),
                Click.on(PaymentPageElements.SENDPAYMENTYES_BUTTON)



        );




    }




    public static MakePayment payment(String phone, String name, Integer payments,String country) {
        return instrumented(MakePayment.class, phone,name,payments,country);
    }
}