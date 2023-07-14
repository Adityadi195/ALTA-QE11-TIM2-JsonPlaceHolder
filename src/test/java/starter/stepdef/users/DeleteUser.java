package starter.stepdef.users;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.placeholder.JsonPlaceHolderAPI;

public class DeleteUser {
    @Steps
    JsonPlaceHolderAPI jsonPlaceHolderAPI;

    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int param) {
        jsonPlaceHolderAPI.deleteUser(param);
    }

    @When("User send request delete user")
    public void userSendRequestDeleteUser() {
        SerenityRest.when().delete(JsonPlaceHolderAPI.USERS_PARAM);
    }
}
