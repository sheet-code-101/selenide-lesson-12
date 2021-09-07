package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class BlogTests extends TestBase{

    @Test
    void verifyThatHeaderBlockPresent(){
        step("Check that 'Own your work' text present on landing page", () ->
            $(withText("Own you work")).isDisplayed());
    }

    @Test
    void verifyThatRegistrationIsLockedForNonUSUsers(){
        step("Click on 'Start for free' button", () ->
            $(withText("Start for free")).click());
        step("Hover on text to display tooltip", () ->
            $(withText("Indy isn’t available")).hover());
        step("Verify that tooltip has appropriate text inside", () ->
            $("[data-id=tooltip]:nth-child(2)").shouldBe(visible)
                    .shouldHave(text("Indy isn’t available in your region yet.")));
    }

    @Test
    void verifyThatUserIsAbleToNavigateToProfilesPage(){
        step("Click on 'Profiles' link", () ->
            $(withText("Indy Profiles")).click());
        step("Check that 'You might have to get used to all the new attention.' text is present on profiles page",
                () -> $(withText("You might have to get used to all the new attention."))
                    .shouldHave(text("You might have to get used to all the new attention.")));
    }

    @Test
    void verifyThatUserIsAbleToPreviewInvoiceGenerator(){
        step("Go to invoice generator page", () ->
                $(withText("Invoice generator")).click());
        step("Input invoice number", () ->
                $("[name=\"invoiceNumber\"]").setValue("23333"));
        step("Preview the invoice and verify set number", () ->
                $(".style_preview__1iWlJ:nth-child(1)")).click();
        step("Check that input matches to preview value", () ->
                $x("//span[text()='Inv#:']/following-sibling::div").shouldHave(text("0123333")));
    }

    @Test
    void verifyThatUserIsAbleToLandOnSignInPage(){
        step("Go to sign in page", () ->
                $(withText("Sign in")).click());
        step("Verify that user has landed on sign in page", () ->
                $(withText("Sign in to your account")).shouldHave(text("Sign in to your account")));
    }
}
