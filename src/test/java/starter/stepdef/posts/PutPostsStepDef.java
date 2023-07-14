package starter.stepdef.posts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.placeholder.JsonPlaceHolderAPI;
import starter.utils.Constants;

import java.io.File;

public class PutPostsStepDef {
    @Steps
    JsonPlaceHolderAPI jsonPlaceHolderAPI;

    @Given("Update post with valid parameter id {int}")
    public void updatePostWithValidParameter(int param) {
        File json = new File(Constants.REQ_BODY+"UpdatePost.json");
        jsonPlaceHolderAPI.putUpdatePost(param ,json);
    }

    @When("Send request update post")
    public void sendRequestUpdatePost() {
        SerenityRest.when().put(JsonPlaceHolderAPI.SINGLE_POSTS);
    }

    @Given("Update post with invalid parameter id {int}")
    public void updatePostWithInvalidParameterId(int param) {
        File json = new File(Constants.REQ_BODY+"UpdatePost.json");
        jsonPlaceHolderAPI.putUpdatePost(param,json);
    }

    @Given("Update post with string parameter id {string}")
    public void updatePostWithStringParameterId(String param) {
        File json = new File(Constants.REQ_BODY+"InvalidId.json");
        jsonPlaceHolderAPI.putPosts(param,json);
    }

    @Given("Update post with empty parameter {int}")
    public void updatePostWithEmptyParameter(int param) {
        File json = new File(Constants.REQ_BODY+"UpdatePost.json");
        jsonPlaceHolderAPI.putPosts(param,json);
    }
}
