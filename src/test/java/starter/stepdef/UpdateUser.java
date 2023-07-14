package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.placeholder.BodyResponses;
import starter.placeholder.PathAPI;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateUser {
    @Steps
    PathAPI pathAPI;

    @Given("Put update user with valid id {int} and json")
    public void putUpdateUserWithValidIdAndJson(int id) {
        File json = new File(Constants.REQ_BODY + "UpdateUser.json");
        pathAPI.updateUser(id, json);
    }

    @When("User send request update user")
    public void userSendRequestUpdateUser() {
        SerenityRest.when().put(PathAPI.USERS_PARAM);
    }

    @And("Response body name should be {string}, username should be {string} and email is {string}")
    public void responseBodyNameShouldBeUsernameShouldBeAndEmailIs(String name, String username, String email) {
        SerenityRest.and()
                .body(BodyResponses.NAME, equalTo(name))
                .body(BodyResponses.USERNAME, equalTo(username))
                .body(BodyResponses.EMAIL, equalTo(email));
    }

    @And("Validate put update user schema")
    public void validatePutUpdateUserSchema() {
        File json = new File(Constants.JSON_SCHEMA_USERS + "UpdateUserSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Put update user with invalid id {string} and json")
    public void putUpdateUserWithInvalidIdAndJson(String id) {
        File json = new File(Constants.REQ_BODY + "UpdateUser.json");
        pathAPI.updateUser(id, json);
    }
    @Then("Status code should be {int} Internal Server Error")
    public void statusCodeShouldBeInternalServerError(int error) {
        SerenityRest.then().statusCode(error);
    }
}
