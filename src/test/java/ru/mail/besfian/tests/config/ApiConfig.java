package ru.mail.besfian.tests.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:/tmp/token.properties",
        "classpath:token.properties"
})
public interface ApiConfig extends Config {

    @Key("base.url")
    @DefaultValue("https://reqres.in/api/login")
    String baseUrl();

    @Key("token")
    String token();

}
