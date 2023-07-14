package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceholder.BodyResponses;
import starter.JsonPlaceholder.pathAPI;
import starter.utils.Constants;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.nio.file.Path;


public class PostPostsStepDef {
    @Steps
    pathAPI PathAPI;

    @Given("Create posts with valid id")
    public void createPostsWithValidId() {
        File json = new File(Constants.REQ_BODY+"/CreatePost.json");
        PathAPI.postPosts(json);
    }

    @When("Send request post create posts")
    public void sendRequestPostCreatePosts() {
        SerenityRest.when().post(pathAPI.LIST_POSTS);
    }

    @Then("Status code should be {int} created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @Given("Create posts with string parameter {string}")
    public void createPostsWithStringParameter(String id) {
    PathAPI.postPostsString(id);
    }

    @When("Send request post create new posts")
    public void sendRequestPostCreateNewPosts() {
        SerenityRest.when().post(pathAPI.SINGLE_POSTS);
    }

    @Then("Status code should be {int} internal server error")
    public void statusCodeShouldBeInternalServerError(int ise) {
        SerenityRest.then().statusCode(ise);
    }

    @Given("Create posts with integer parameter")
    public void createPostsWithIntegerParameter() {
        File json = new File(Constants.REQ_BODY+"/CreatePostBody.json");
        PathAPI.postPosts(json);
    }


    @Given("Create posts with invalid request body")
    public void createPostsWithInvalidRequestBody() {
        File json = new File(Constants.REQ_BODY+ "/UpdateInvalid.json");
        PathAPI.postPosts(json);

    }

    @Given("Create posts with empty parameter")
    public void createPostsWithEmptyParameter() {
        File json = new File(Constants.REQ_BODY+ "/EmptyParam.json");
        PathAPI.postPosts(json);
    }
}
