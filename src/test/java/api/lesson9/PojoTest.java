package api.lesson9;

import base.pojos.createUser.CreateUserRequest;
import base.pojos.createUser.CreateUserResponse;
import base.pojos.getPets.Pet;
import base.pojos.getUser.GetUserData;
import base.pojos.updateUser.UpdateUserResponse;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static base.helpers.Specifications.*;
import static io.restassured.RestAssured.given;

public class PojoTest {
    public static final String BASE_URL = "https://reqres.in/";

    //    @Test
    public void getUsers() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(200));
        List<GetUserData> usersList = given()
                .when()
                .get("api/users?page=2")
                .then()
                .extract().body().jsonPath().getList("data", GetUserData.class);

        Assert.assertNotNull(usersList);

        for (int i = 0; i < usersList.size(); i++) {
            Assert.assertTrue(usersList.get(i).getEmail().contains("@reqres.in"));
            Assert.assertTrue(usersList.get(i).getAvatar().contains(usersList.get(i).getId().toString()));
        }
    }

    //    @Test
    public void createUserTest() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(201));
        CreateUserRequest request = new CreateUserRequest();

        request.setName("morpheus");
        request.setJob("leader");

        CreateUserResponse createUserResponse = given()
                .body(request)
                .when()
                .post("api/users")
                .then()
                .log().body().extract().as(CreateUserResponse.class);

        Assert.assertNotNull(createUserResponse);

        Assert.assertEquals(request.getName(), createUserResponse.getName());
        Assert.assertEquals(request.getJob(), createUserResponse.getJob());
    }

    //    @Test
    public void updateUserTest() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(200));

        CreateUserRequest requestUpdate = new CreateUserRequest("morpheus", "zion resident");

        UpdateUserResponse updateUserResponse = given()
                .body(requestUpdate)
                .when()
                .put("api/users/2")
                .then()
                .extract().as(UpdateUserResponse.class);

        Assert.assertEquals(requestUpdate.getName(), updateUserResponse.getName());
        Assert.assertEquals(requestUpdate.getJob(), updateUserResponse.getJob());

        System.out.println(updateUserResponse.getUpdatedAt());
    }

    @Test
    public void getPetsTest() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(200));

        Pet[] petResponse = given()
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
                .then()
                .extract().as(Pet[].class);

        List<Pet> list = Arrays.asList(petResponse);

        for (Pet pet : list) {
            Assert.assertEquals(pet.getStatus(), "available");
        }

    }
}
