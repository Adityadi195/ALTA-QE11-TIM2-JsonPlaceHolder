package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.placeholder.BodyResponses;
import starter.placeholder.JsonPlaceHolderAPI;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetCommentsStepDef {
    @Steps
    JsonPlaceHolderAPI jsonPlaceHolderAPI;

    @Given("Set path")
    public void setPath() {
        jsonPlaceHolderAPI.getAllComments();
    }

    @When("Send request get comments")
    public void sendRequestGetComments() {
        SerenityRest.when().get(JsonPlaceHolderAPI.COMMENTS_PATH);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("All data comments should be shown on response body")
    public void allDataCommentsShouldBeShownOnResponseBody() {
        SerenityRest.and()
                .body(BodyResponses.POST_ID, notNullValue())
                .body(BodyResponses.ID, notNullValue())
                .body(BodyResponses.EMAIL, notNullValue())
                .body(BodyResponses.NAME, notNullValue())
                .body(BodyResponses.BODY, notNullValue());
    }

    @Given("Set path comment with valid parameter {int}")
    public void setPathCommentWithValidParameter(int param) {
        jsonPlaceHolderAPI.getSingleComment(param);
    }

    @And("Single data comments should be shown on response body {int}")
    public void singleDataCommentsShouldBeShownOnResponseBody(int param) {
        SerenityRest.and().body(BodyResponses.ID, equalTo(param));
    }

    @And("Validate comment JSON Schema all")
    public void validateCommentJSONSchemaAll() {
        File json = new File(Constants.JSON_SCHEMA_COMMENTS + "SuccessAll.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @When("Send request get comments param")
    public void sendRequestGetCommentsParam() {
        SerenityRest.when().get(JsonPlaceHolderAPI.COMMENTS_PARAM);
    }


    @Given("Set path comment with valid parameter string {string}")
    public void setPathCommentWithValidParameterString(String param) {
        jsonPlaceHolderAPI.getSingleComment(param);
    }

    @Then("Status code should be {int} not found")
    public void statusCodeShouldBeNotFound(int NF) {
        SerenityRest.then().statusCode(NF);
    }

    @And("Response body should be invalid request response")
    public void responseBodyShouldBeInvalidRequestResponse() {
        File json = new File(Constants.JSON_SCHEMA_COMMENTS + "NotFound.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Set path comment with exceeds the limit parameter {int}")
    public void setPathCommentWithExceedsTheLimitParameter(int param) {
        jsonPlaceHolderAPI.getSingleComment(param);
    }

    @Given("Set path comment with valid parameter key value {int}")
    public void setPathCommentWithValidParameterKeyValue(int param) {
        jsonPlaceHolderAPI.getCommentWithParam(param);
    }

    @When("Send request get comments param key value {string}")
    public void sendRequestGetCommentsParamKeyValue() {
        SerenityRest.when().get(JsonPlaceHolderAPI.COMMENTS_PARAM);
    }

    @Given("Set path comment with valid parameter special character {string}")
    public void setPathCommentWithValidParameterSpecialCharacter(String param) {
        jsonPlaceHolderAPI.getSingleComment(param);
    }

    @And("Validate comment JSON Schema")
    public void validateCommentJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_COMMENTS + "Success.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
