package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;


import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

public class TestBase {
    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class, System.getProperties());
        String login = credentials.login();
        String password = credentials.password();
        boolean remote = credentials.remote();
        if (remote) {Configuration.remote =format("https://%s:%s@%s",login, password,System.getProperty("selenoid"));} //selenoid.autotests.cloud/wd/hub/
        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://weareindy.com/";
        Configuration.startMaximized = true;

    }

    @BeforeEach
    void eachSetup() {
        step("Open blog page", () -> open(baseUrl));
    }

    @AfterEach
    void tearDown (){
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }
}