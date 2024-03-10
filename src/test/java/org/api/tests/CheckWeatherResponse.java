package org.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.api.pojo.FullWeather;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckWeatherResponse {
    static RequestSpecification reqSpec;
    public static String uri = "https://api.openweathermap.org/data/2.5";
    public static String pathWeather = "/weather";
    public String coord1 = "55.75";
    public String coord2 = "37.61";
    public String myapi = "97a77e9da6149804f78f114affc04b26";
    public String wrongapi = "97a77e9da6149804f78f114affc04b261";

    @Test
    public void responseContainsCityName(){
        Response response = RestAssured.given()
                .baseUri(uri)
                .queryParam("lat",coord1)
                .queryParam("lon",coord2)
                .queryParam("appid",myapi)
                .when()
                .contentType("application/json")
                .get(pathWeather);

        System.out.println("Response: " + response.getBody().asString());
        Assert.assertTrue(response.getBody().asString().contains("Moscow"));
        FullWeather message = response.getBody().as(FullWeather.class);
        System.out.println("Coordinates: " + message.coord.toString());

        //Assert.assertEquals("Nothing to geocode", message.getMessage());
    }

    @Test
    public void responseContainsCorrectCoordinates(){
        Response response = RestAssured.given()
                .baseUri(uri)
                .queryParam("lat",coord1)
                .queryParam("lon",coord2)
                .queryParam("appid",myapi)
                .when()
                .contentType("application/json")
                .get(pathWeather);

        FullWeather message = response.getBody().as(FullWeather.class);
        System.out.println("Coordinates, lat: " + message.coord.lat);
        System.out.println("Coordinates, lon: " + message.coord.lon);

        Assert.assertEquals(message.coord.lat+"", coord1);
        Assert.assertEquals(message.coord.lon+"", coord2);

        //Assert.assertEquals("Nothing to geocode", message.getMessage());
    }

}
