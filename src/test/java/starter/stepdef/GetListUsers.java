package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.placeholder.PathAPI;
import starter.utils.Constants;

import java.io.File;

public class GetListUsers {
    @Steps
    PathAPI pathAPI;

    @Given("Get list users data")
    public void getListUsersData() {
        pathAPI.getListUsers();
    }

    @When("User send request get list users")
    public void userSendRequestGetListUsers() {
        SerenityRest.when().get(PathAPI.USERS_PATH);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Validate get list users schema")
    public void validateGetListUsersSchema() {
        File json = new File(Constants.JSON_SCHEMA_USERS + "GetListUsersSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
