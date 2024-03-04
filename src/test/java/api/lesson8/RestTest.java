package api.lesson8;

import base.logger.CustomLogger;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.equalTo;

public class RestTest {

    public static final String BASE_URL = "https://reqres.in/";
    public JSONObject request = new JSONObject();

    //    @Test
    public void getTest() {
//        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
//
//        System.out.println(response.asString());
//
//        System.out.println(response.statusCode());
//
//        Assert.assertEquals(response.statusCode(), 200);
//
//        given()
//                .get("https://reqres.in/api/users?page=2")
//                .then()
//                .statusCode(200).log().body()
//                .body("data.id[1]", equalTo(8));

        Response response1 = given()
                .accept(ContentType.JSON)
                .get(BASE_URL + "api/users?page=2")
                .then()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response1.jsonPath().getString("data.first_name[0]"), "Michael");
    }

    //    @Test
    public void postTest() {
        request.put("name", "Marian");
        request.put("job", "aqa");
        given()
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post(BASE_URL + "api/users")
                .then()
                .statusCode(201).log().body();
    }

//    @Test
    public void putTest() {
        request.put("name", "Marian");
        request.put("job", "aqa");

        given()
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put(BASE_URL + "api/users/2")
                .then()
                .statusCode(200).log().body();
    }
    @Test
    public void deleteTest(){
        given().
                delete(BASE_URL + "api/users/2")
                .then()
                .statusCode(204).log().all();
    }
}
