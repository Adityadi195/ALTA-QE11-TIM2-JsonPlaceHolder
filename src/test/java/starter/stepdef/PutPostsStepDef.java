package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceholder.pathAPI;
import starter.utils.Constants;

import java.io.File;
import java.nio.file.Path;

public class PutPostsStepDef {
    @Steps
    pathAPI PathAPI;

    @Given("Update post with valid parameter id {int}")
    public void updatePostWithValidParameter(int id) {
        File json = new File(Constants.REQ_BODY+"/UpdatePost.json");
        PathAPI.putUpdatePost(id,json);
    }

    @When("Send request update post")
    public void sendRequestUpdatePost() {
        SerenityRest.when().put(pathAPI.SINGLE_POSTS);
    }

    @Given("Update post with invalid parameter id {int}")
    public void updatePostWithInvalidParameterId(int id) {
        File json = new File(Constants.REQ_BODY+"/UpdatePost.json");
        PathAPI.putUpdatePost(id,json);
    }

    @Given("Update post with string parameter id {string}")
    public void updatePostWithStringParameterId(String id) {
        File json = new File(Constants.REQ_BODY+"/InvalidId.json");
        PathAPI.putPosts(id,json);
    }

    @Given("Update post with empty parameter {int}")
    public void updatePostWithEmptyParameter(int id) {
        File json = new File(Constants.REQ_BODY+"/UpdatePost.json");
        PathAPI.putPosts(id,json);
    }
}
