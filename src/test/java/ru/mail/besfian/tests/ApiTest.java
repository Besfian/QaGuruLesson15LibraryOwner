package ru.mail.besfian.tests;


import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import ru.mail.besfian.tests.config.ApiConfig;

import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.core.Is.is;


public class ApiTest {



    @Test
    void loginSuccessful() {
        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        String data = "{\"email\": \"eve.holt@reqres.in\",\"password\": \"pistol\" }";
        RestAssured
                .given().log().all()
                .contentType(JSON)
                .body(data)
                .when()
                .post(apiConfig.baseUrl())
                .then().log().all()
                .body("token", is(apiConfig.token()))
                .statusCode(200);

    }


}
