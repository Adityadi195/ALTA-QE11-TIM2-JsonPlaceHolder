package starter.stepdef.posts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.placeholder.JsonPlaceHolderAPI;

public class DeletePostsStepDef {
    @Steps
    JsonPlaceHolderAPI jsonPlaceHolderAPI;

    @Given("Delete posts with valid parameter ID {int}")
    public void deletePostsWithValidParameterID(int id) {
        JsonPlaceHolderAPI.deletePosts(id);
    }

    @When("Send delete posts")
    public void sendDeletePosts() {
        SerenityRest.when().get(JsonPlaceHolderAPI.SINGLE_POSTS);
    }

    @Given("Delete posts with invalid parameter ID {string}")
    public void deletePostsWithInvalidParameterID(String id) {
        JsonPlaceHolderAPI.deletePosts(id);
    }

    @Given("Delete posts with exceed parameter ID {int}")
    public void deletePostsWithExceedParameterID(int id) {
        JsonPlaceHolderAPI.deletePosts(id);
    }

    @Given("Delete posts with empty parameter ID {string}")
    public void deletePostsWithEmptyParameterID(String id) {
        JsonPlaceHolderAPI.deletePosts(id);
    }
}
