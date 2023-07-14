package starter.stepdef.posts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.placeholder.JsonPlaceHolderAPI;
import starter.utils.Constants;

import java.io.File;


public class PostPostsStepDef {
    @Steps
    JsonPlaceHolderAPI jsonPlaceHolderAPI;

    @Given("Create posts with valid id")
    public void createPostsWithValidId() {
        File json = new File(Constants.REQ_BODY+"CreatePost.json");
        jsonPlaceHolderAPI.postPosts(json);
    }

    @When("Send request post create posts")
    public void sendRequestPostCreatePosts() {
        SerenityRest.when().post(JsonPlaceHolderAPI.LIST_POSTS);
    }

//    @Then("Status code should be {int} created")
//    public void statusCodeShouldBeCreated(int created) {
//        SerenityRest.then().statusCode(created);
//    }

    @Given("Create posts with string parameter {string}")
    public void createPostsWithStringParameter(String param) {
    jsonPlaceHolderAPI.postPostsString(param);
    }

    @When("Send request post create new posts")
    public void sendRequestPostCreateNewPosts() {
        SerenityRest.when().post(JsonPlaceHolderAPI.SINGLE_POSTS);
    }

    @Then("Status code should be {int} internal server error")
    public void statusCodeShouldBeInternalServerError(int ise) {
        SerenityRest.then().statusCode(ise);
    }

    @Given("Create posts with integer parameter")
    public void createPostsWithIntegerParameter() {
        File json = new File(Constants.REQ_BODY+"CreatePostBody.json");
        jsonPlaceHolderAPI.postPosts(json);
    }


    @Given("Create posts with invalid request body")
    public void createPostsWithInvalidRequestBody() {
        File json = new File(Constants.REQ_BODY+ "/UpdateInvalid.json");
        jsonPlaceHolderAPI.postPosts(json);

    }

    @Given("Create posts with empty parameter")
    public void createPostsWithEmptyParameter() {
        File json = new File(Constants.REQ_BODY+ "/EmptyParam.json");
        jsonPlaceHolderAPI.postPosts(json);
    }
}
