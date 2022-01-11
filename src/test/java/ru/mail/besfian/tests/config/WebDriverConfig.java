package ru.mail.besfian.tests.config;
import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/${mode}.properties"})
public interface WebDriverConfig extends Config {

    @Key("browser")
    @DefaultValue("CHROME")
    String browser();

    @Key("remoteBrowserUrl")
    String remoteBrowserUrl();

}


