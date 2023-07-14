package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.placeholder.BodyResponses;
import starter.placeholder.PathAPI;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateNewUser {
    @Steps
    PathAPI pathAPI;

    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constants.REQ_BODY + "CreateNewUser.json");
        pathAPI.createNewUser(json);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(PathAPI.USERS_PATH);
    }

    @Then("Status code should be {int} created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body name was {string}, username was {string} and email was {string}")
    public void responseBodyNameWasUsernameWasAndEmailWas(String name, String username, String email) {
        SerenityRest.and()
                .body(BodyResponses.NAME, equalTo(name))
                .body(BodyResponses.USERNAME, equalTo(username))
                .body(BodyResponses.EMAIL, equalTo(email));
    }

}
