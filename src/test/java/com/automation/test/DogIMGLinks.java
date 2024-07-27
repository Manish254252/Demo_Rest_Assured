package com.automation.test;

import com.automation.Utils.TextWriter;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class DogIMGLinks {
    public static void main(String[] args) throws IOException {
        TextWriter writer = new TextWriter();
        RestAssured.baseURI = "https://random.dog/";

        String response = given()
                .log()
                .all()
                .when()
                .get("/woof.json")
                .then()
                .assertThat()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .asString();

        JsonPath jp = new JsonPath(response);
        String url = jp.getString("url");
        writer.writeText(url, "links.txt");
    }
}
