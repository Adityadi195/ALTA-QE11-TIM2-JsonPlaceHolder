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
public class PostCommentStepDef {
    @Steps
    JsonPlaceHolderAPI jsonPlaceHolderAPI;

    @Given("Post new comment with complete request body")
    public void postNewCommentWithCompleteRequestBody() {
        File json = new File(Constants.REQ_BODY+"comments/ValidReqBody.json");
        jsonPlaceHolderAPI.postComments(json);
    }

    @When("Send request post comments")
    public void sendRequestPostComments() {
        SerenityRest.when()
                .post(JsonPlaceHolderAPI.COMMENTS_PATH);
    }

    @Then("Status code should be {int} created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then()
                .statusCode(created);
    }

    @And("Response body exist {int} {string} {string} {string}")
    public void responseBodyExist(int postId, String name, String email, String body) {
        SerenityRest.and()
                .body(BodyResponses.POST_ID, equalTo(postId))
                .body(BodyResponses.ID, notNullValue())
                .body(BodyResponses.NAME, equalTo(name))
                .body(BodyResponses.EMAIL, equalTo(email))
                .body(BodyResponses.BODY, equalTo(body));
    }

//    @And("Validate post comment json schema")
//    public void validatePostCommentJsonSchema() {
//        File json = new File(Constants.JSON_SCHEMA_COMMENTS + "Success.json");
//        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
//    }

    @Given("Post new comment with empty request body")
    public void postNewCommentWithEmptyRequestBody() {
        File json = new File(Constants.REQ_BODY+"comments/EmptyBodyRequest.json");
        jsonPlaceHolderAPI.postComments(json);
    }

    @Then("Status code should be {int} bad request")
    public void statusCodeShouldBeBadRequest(int BR) {
        SerenityRest.then()
                .statusCode(BR);
    }

    @Given("Post new comment with empty value request body")
    public void postNewCommentWithEmptyValueRequestBody() {
        File json = new File(Constants.REQ_BODY+"comments/EmptyValueReqBody.json");
        jsonPlaceHolderAPI.postComments(json);
    }

    @Given("Post new comment with path parameter {int}")
    public void postNewCommentWithPathParameter(int param) {
        File json = new File(Constants.REQ_BODY+"Comments/ValidReqBody.json");
        jsonPlaceHolderAPI.putComments(param, json);
    }

    @When("Send request comments param")
    public void sendRequestCommentsParam() {
        SerenityRest.when().post(JsonPlaceHolderAPI.COMMENTS_PARAM);

    }

    @Given("Post new comment with with invalid key request")
    public void postNewCommentWithWithInvalidKeyRequest() {
        File json = new File(Constants.REQ_BODY+"comments/InvalidKeyReqBody.json");
        jsonPlaceHolderAPI.postComments(json);
    }

    @Given("Post create comments with invalid format request body email")
    public void postCreateCommentsWithInvalidFormatRequestBodyEmail() {
        File json = new File(Constants.REQ_BODY+ "comments/InvalidFormatEmail.json");
        jsonPlaceHolderAPI.postPosts(json);
    }

    @Given("Post create comments invalid without key PostId")
    public void postCreateCommentsWithInvalidWithoutKeyPostId() {
        File json = new File(Constants.REQ_BODY+ "comments/InvalidWithoutKeyPostId.json");
        jsonPlaceHolderAPI.postPosts(json);
    }

    @Given("Post create comments invalid empty value PostId")
    public void postCreateCommentsInvalidEmptyValuePostId() {
        File json = new File(Constants.REQ_BODY+ "comments/InvalidEmptyValuePostId.json");
        jsonPlaceHolderAPI.postPosts(json);
    }

    @Given("Post create comments invalid without key name")
    public void postCreateCommentsInvalidWithoutKeyName() {
        File json = new File(Constants.REQ_BODY+ "comments/InvalidWithoutKeyName.json");
        jsonPlaceHolderAPI.postPosts(json);
    }

    @Given("Post create comments invalid empty value name")
    public void postCreateCommentsInvalidEmptyValueName() {
        File json = new File(Constants.REQ_BODY+ "comments/InvalidEmptyValueName.json");
        jsonPlaceHolderAPI.postPosts(json);
    }

    @Given("Post create comments invalid without key email")
    public void postCreateCommentsInvalidWithoutKeyEmail() {
        File json = new File(Constants.REQ_BODY+ "comments/InvalidWithoutKeyEmail.json");
        jsonPlaceHolderAPI.postPosts(json);
    }

    @Given("Post create comments invalid empty value email")
    public void postCreateCommentsInvalidEmptyValueEmail() {
        File json = new File(Constants.REQ_BODY+ "comments/InvalidEmptyValueEmail.json");
        jsonPlaceHolderAPI.postPosts(json);
    }

    @Given("Post create comments invalid without key body")
    public void postCreateCommentsInvalidWithoutKeyBody() {
        File json = new File(Constants.REQ_BODY+ "comments/InvalidWithoutKeyBody.json");
        jsonPlaceHolderAPI.postPosts(json);
    }

    @Given("Post create comments invalid empty value body")
    public void postCreateCommentsInvalidEmptyValueBody() {
        File json = new File(Constants.REQ_BODY+ "comments/InvalidEmptyValueBody.json");
        jsonPlaceHolderAPI.postPosts(json);
    }
}
