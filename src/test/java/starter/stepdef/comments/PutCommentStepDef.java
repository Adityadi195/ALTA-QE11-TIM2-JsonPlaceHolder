package starter.stepdef.comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.placeholder.BodyResponses;
import starter.placeholder.JsonPlaceHolderAPI;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
public class PutCommentStepDef {
    @Steps
    JsonPlaceHolderAPI jsonPlaceHolderAPI;
    @Given("Update comments with complete request and parameter {int}")
    public void updateCommentsWithCompleteRequestAndParameter(int id) {
        File json = new File(Constants.REQ_BODY+"ValidReqBody.json");
        jsonPlaceHolderAPI.putComments(id, json);
    }

    @When("Send request put comments")
    public void sendRequestPutComments() {
        SerenityRest.when().put(JsonPlaceHolderAPI.COMMENTS_PARAM);
    }

    @And("Response body exist {int} {int} {string} {string} {string}")
    public void responseBodyExist(int id, int postId, String name, String email, String body) {
        SerenityRest.and()
                .body(BodyResponses.ID, equalTo(id))
                .body(BodyResponses.POST_ID, equalTo(postId))
                .body(BodyResponses.NAME, equalTo(name))
                .body(BodyResponses.EMAIL, equalTo(email))
                .body(BodyResponses.BODY, equalTo(body));
    }

    @And("Validate put comments json schema")
    public void validatePutCommentsJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_COMMENTS+"Success.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Update comments with valid request body and string parameter {string}")
    public void updateCommentsWithValidRequestBodyAndStringParameter(String id) {
        File json = new File(Constants.REQ_BODY+"ValidReqBody.json");
        jsonPlaceHolderAPI.putComments(id, json);
    }

//    @Then("Status code should be {int} internal server error")
//    public void statusCodeShouldBeInternalServerError(int ISE) {
//        SerenityRest.then().statusCode(ISE);
//    }

    @Given("Update comments with valid request body and exceed parameter {int}")
    public void updateCommentsWithValidRequestBodyAndExceedParameter(int id) {
        File json = new File(Constants.REQ_BODY+"ValidReqBody.json");
        jsonPlaceHolderAPI.putComments(id, json);
    }

    @Given("Update comments with invalid key body request {int}")
    public void updateCommentsWithInvalidKeyBodyRequest(int id) {
        File json = new File(Constants.REQ_BODY+"InvalidKeyReqBody.json");
        jsonPlaceHolderAPI.putComments(id, json);
    }

    @Given("Update comments with empty value body request {}")
    public void updateCommentsWithEmptyValueBodyRequest(int id) {
        File json = new File(Constants.REQ_BODY+"EmptyValueReqBody.json");
        jsonPlaceHolderAPI.putComments(id, json);
    }

    @Given("Update comments with valid request body and special character parameter {string}")
    public void updateCommentsWithValidRequestBodyAndSpecialCharacterParameter(String id) {
        File json = new File(Constants.REQ_BODY+"ValidReqBody.json");
        jsonPlaceHolderAPI.putComments(id, json);
    }
}
