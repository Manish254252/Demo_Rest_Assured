package com.automation.test;

import com.automation.Utils.TextWriter;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class GuruApi {
    public static void main(String[] args) {
        TextWriter writer = new TextWriter();
        RestAssured.baseURI = "https://api.apis.guru/";


        String response = given()
                .log()
                .all()
                .when()
                .get("/v2/list.json")
                .then()
                .assertThat()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .asString();


    }
}
