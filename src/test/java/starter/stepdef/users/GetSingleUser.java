package starter.stepdef.users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.placeholder.JsonPlaceHolderAPI;

import static org.hamcrest.Matchers.equalTo;

public class GetSingleUser {
    @Steps
    JsonPlaceHolderAPI jsonPlaceHolderAPI;

    //SINGLE USER WITH VALID ID
    @Given("Get single user with valid  id {int}")
    public void getSingleUserWithValidId(int id) {
        jsonPlaceHolderAPI.getSingleUser(id);
    }
    @When("User send request get single user")
    public void userSendRequestGetSingleUser() {
        SerenityRest.when().get(JsonPlaceHolderAPI.USERS_PARAM);
    }
    @And("Response body id should be id {int}")
    public void responseBodyIdShouldBeId(int id) {
        SerenityRest.and().body("id", equalTo(id));
    }

    //SINGLE USER WITH INVALID ID
    @Given("Get single user with invalid id {string}")
    public void getSingleUserWithInvalidId(String id) {
        jsonPlaceHolderAPI.getSingleUser(id);
    }
    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

}
