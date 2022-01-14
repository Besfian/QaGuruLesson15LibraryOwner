package ru.mail.besfian.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleTest extends TestBase {

    @Test
    public void textBoxValueSourceTest() {
        open("https://demoqa.com/text-box");
        $("[id=userName]").setValue("TEST");
        $("#userEmail").setValue("test@mail.ru");
        $("#currentAddress").setValue("TEST");
        $("#permanentAddress").setValue("TEST");
        $("#submit").scrollTo().click();
        $("#output #name").shouldHave(text("TEST"));
        $("#output").$("#email").shouldHave(text("test@mail.ru"));
        $("#output").$("#currentAddress").shouldHave(text("TEST"));
        $("#output").$("#permanentAddress").shouldHave(text("TEST"));
    }
}

