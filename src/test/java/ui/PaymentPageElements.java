package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaymentPageElements {

    public static Target MAKEPAYMENT_BUTTON = Target.the("make payment btn")
            .located(By.id("makePaymentButton"));

    public static Target PHONE_FIELD = Target.the("phone field")
            .located(By.id("phoneTextField"));

    public static Target NAME_FIELD = Target.the("name field")
            .located(By.id("nameTextField"));

    public static Target AMOUNT_BAR = Target.the("amount bar")
            .located(By.id("amount"));

    public static Target COUNTRYSELECT_BUTTON = Target.the("amount bar")
            .located(By.id("countryButton"));

    public static Target COUNTRY_CANADA = Target.the("amount bar")
            .located(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget" +
                    ".FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[12]"));

    public static Target COUNTRY_FIELD= Target.the("country field")
            .located(By.id("countryTextField"));

    public static Target SENDPAYMENT_BUTTON= Target.the("sendpayment button")
            .located(By.id("sendPaymentButton"));

    public static Target SENDPAYMENTYES_BUTTON= Target.the("sendpayment yes button")
            .located(By.id("android:id/button1"));

    public static Target getLastBalance(int Balance){
        Target BALANCE_TEXT = Target.the("last balance text")
                .located(By.xpath("//android.view.View[@content-desc=\"Your balance is: "+Balance+".00$\"]\n"));
        return  BALANCE_TEXT;
    }

    public static Target BALANCE_TEXT= Target.the("balance text")
            .located(By.xpath("//android.view.View[@content-desc=\"Your balance is: 100.00$\""));

    public static Target COUNTRY_USA = Target.the("amount bar")
            .located(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget." +
                    "FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[2]"));



    public static Target COUNTRY_RT= Target.the("balance text")
            .located(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView["+"countries"+"]"));
}
