package com.automation.test;

import com.automation.Objs.holidays.Event;
import com.automation.Utils.TextWriter;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HolidayApi {

    public static void main(String[] args) throws IOException {

        TextWriter writer = new TextWriter();

        RestAssured.baseURI = "https://www.gov.uk/";


        String response = given()
                .log()
                .all()
                .when()
                .get("/bank-holidays.json")
                .then()
                .assertThat()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .asString();


        JsonPath jp = new JsonPath(response);

        List<Map<String, Event>> holidays = jp.getList("england-and-wales.events");

        for (Map<String, Event> x : holidays) {
            String text = "";
            for (Map.Entry<String, Event> y : x.entrySet()) {
                text += y.getKey() + " : " + y.getValue() + " ";
            }
            writer.writeText(text, "holidays.txt");
            System.out.println();
        }


    }
}
