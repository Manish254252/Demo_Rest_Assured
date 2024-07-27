package com.automation.test;

import com.automation.Utils.TextWriter;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.*;

public class UUIDApi {

    public static void main(String[] args) throws IOException {
        TextWriter writer = new TextWriter();
        RestAssured.baseURI="https://www.uuidtools.com/api/generate";

     String response =   given()
                .log()
                .all()
                .get("/v1/count/50")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract()
                .asString();

        JsonPath jp = new JsonPath(response);
        List<String> text = jp.getList("");
        for (String x:text)
        {
            writer.writeText(x,"UUID.txt");
        }
    }


}
