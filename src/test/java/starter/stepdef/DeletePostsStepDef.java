package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceholder.pathAPI;

public class DeletePostsStepDef {
    @Steps
    pathAPI PathAPI;

    @Given("Delete posts with valid parameter ID {int}")
    public void deletePostsWithValidParameterID(int id) {
        PathAPI.deletePosts(id);
    }

    @When("Send delete posts")
    public void sendDeletePosts() {
        SerenityRest.when().get(pathAPI.SINGLE_POSTS);
    }

    @Given("Delete posts with invalid parameter ID {string}")
    public void deletePostsWithInvalidParameterID(String id) {
        PathAPI.deletePosts(id);
    }

    @Given("Delete posts with exceed parameter ID {int}")
    public void deletePostsWithExceedParameterID(int id) {
        pathAPI.deletePosts(id);
    }

    @Given("Delete posts with empty parameter ID {string}")
    public void deletePostsWithEmptyParameterID(String id) {
        pathAPI.deletePosts(id);
    }
}
