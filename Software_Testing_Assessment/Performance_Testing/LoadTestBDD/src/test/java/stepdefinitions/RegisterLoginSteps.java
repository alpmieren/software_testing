package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class RegisterLoginSteps {
    private ThreadLocal<Map<String, String>> userData = ThreadLocal.withInitial(HashMap::new);

    private Response response;

    @Given("I have random user data")
    public void i_have_random_user_data() {
        Map<String, String> data = userData.get();
        Random random = new Random();

        data.put("fullName", "Test User " + UUID.randomUUID());
        data.put("userName", "user_" + System.currentTimeMillis() + random.nextInt(1000));
        data.put("email", "test" + System.currentTimeMillis() + random.nextInt(1000) + "@example.com");
        data.put("password", "Pass_" + UUID.randomUUID().toString().substring(0, 6));
        data.put("phone", "555-" + (1000000 + random.nextInt(9000000)));
    }

    @When("I send a POST request to register endpoint with the user data")
    public void i_send_register_request() {
        Map<String, String> data = userData.get();

        response = given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("fullName", data.get("fullName"))
                .formParam("userName", data.get("userName"))
                .formParam("email", data.get("email"))
                .formParam("password", data.get("password"))
                .formParam("phone", data.get("phone"))
                .when()
                .post("/client_registeration");
    }

    @Then("I should get a 200 response for registration")
    public void i_should_get_200_for_registration() {
        Assert.assertEquals(200, response.getStatusCode());
    }

    @When("I send a POST request to login endpoint with the same user data")
    public void i_send_login_request() {
        Map<String, String> data = userData.get(); // ThreadLocal'dan veri al

        response = given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("userName", data.get("userName"))
                .formParam("email", data.get("email"))
                .formParam("password", data.get("password"))
                .when()
                .post("/client_login");
    }

    @Then("I should get a 200 response for login")
    public void i_should_get_200_for_login() {
        assertEquals(200, response.getStatusCode());
    }
}