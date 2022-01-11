package ru.mail.besfian.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.mail.besfian.tests.config.WebDriverConfig;

public class TestBase {
    @BeforeAll
    static void setup() {
        WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();

        Configuration.browser = webDriverConfig.browser();
        Configuration.startMaximized = true;

        if (System.getProperty("mode").equals("remote")) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = webDriverConfig.remoteBrowserUrl();
        }

        Configuration.browserCapabilities = capabilities;
    }

}
