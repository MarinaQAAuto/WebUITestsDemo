package org.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.api.pojo.ErrorMessage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckErrorMessage {
    static RequestSpecification reqSpec;
    public static String uri = "https://api.openweathermap.org/data/2.5";
    public static String pathWeather = "/weather";
    public String coord1 = "55.75";
    public String coord2 = "37.61";
    public String myapi = "97a77e9da6149804f78f114affc04b26";
    public String wrongapi = "97a77e9da6149804f78f114affc04b261";

    @Test
    public void checkingStatusCodeWrongApi(){
        RestAssured.given()
                .baseUri(uri)
                .queryParam("lat",coord1)
                .queryParam("lon",coord2)
                .queryParam("appid",wrongapi)
                .when()
                .contentType("application/json")
                .get(pathWeather)
                .then()
                .statusCode(401);
    }

    @Test
    public void checkingMessageTextWrongApi(){
        Response response = RestAssured.given()
                .baseUri(uri)
                .queryParam("lat",coord1)
                .queryParam("lon",coord2)
                .queryParam("appid",wrongapi)
                .when()
                .contentType("application/json")
                .get(pathWeather);
        ErrorMessage message = response.getBody().as(ErrorMessage.class);
        System.out.println("Error message: " + message.toString());

        Assert.assertTrue(message.toString().contains("Invalid API key"));
         }

    @Test
    public void checkingStatusCodeWrongCoordinates(){

        RestAssured.given()
                .baseUri(uri)
                .queryParam("latt",coord1)
                .queryParam("lon",coord2)
                .queryParam("appid",myapi)
                .when()
                .contentType("application/json")
                .get(pathWeather)
                .then()
                .statusCode(400);

    }

    @Test
    public void checkingMessageTextWrongCoordinates(){
        Response response = RestAssured.given()
                .baseUri(uri)
                .queryParam("lat",coord1)
                .queryParam("lonn",coord2)
                .queryParam("appid",myapi)
                .when()
                .contentType("application/json")
                .get(pathWeather);
        ErrorMessage message = response.getBody().as(ErrorMessage.class);
        System.out.println("Error message: " + message.toString());

        Assert.assertEquals("Nothing to geocode", message.getMessage());
    }
}
