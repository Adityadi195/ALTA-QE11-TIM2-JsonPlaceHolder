package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.placeholder.JsonPlaceHolderAPI;

public class DeleteCommentStepDef {

    @Steps
    JsonPlaceHolderAPI jsonPlaceHolderAPI;

    @Given("Set path {} delete")
    public void setPathDelete(int id) {
        jsonPlaceHolderAPI.deleteComments(id);
    }

    @When("Send request delete comments")
    public void sendRequestDeleteComments() {
        SerenityRest.when().get(JsonPlaceHolderAPI.COMMENTS_PARAM);
    }

    @Given("Set path {string} delete with string")
    public void setPathDeleteWithString(String id) {
        jsonPlaceHolderAPI.deleteComments(id);
    }

    @Given("Set path delete with empty parameter {string}")
    public void setPathDeleteWithEmptyParameter(String id) {
        jsonPlaceHolderAPI.deleteComments(id);
    }

    @Given("Set path {string} delete with special character")
    public void setPathDeleteWithSpecialCharacter(String id) {
        jsonPlaceHolderAPI.deleteComments(id);
    }
}
