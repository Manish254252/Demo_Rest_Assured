package com.automation.test;

import com.automation.Utils.TextWriter;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ChuckNorris {
    public static void main(String[] args) throws IOException {

            TextWriter writer = new TextWriter();

            RestAssured.baseURI = "https://api.chucknorris.io/";


            String response = given()
                    .log()
                    .all()
                    .when()
                    .get("/jokes/random")
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .log()
                    .all()
                    .extract()
                    .asString();

            JsonPath jp = new JsonPath(response);
            String text = jp.getString("value");
            writer.writeText(text, "ChuckNorris.txt");

    }
}
