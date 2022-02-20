package step_def;

import action_data.PetTestActionsClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ApiTestStepDef {
    @Given("User serach for pet id {int}")
    public void search_by_id(int id) {
        PetTestActionsClass.getPetName(id);
    }

    @Then("Service return code is {int}")
    public void verify_status_code(int code) {
        PetTestActionsClass.verifyResponse(code);

    }

    @Given("User update info for pet id {int}")
    public void update_by_id(int id) {
        PetTestActionsClass.updatePetInfo(id);
    }

    @Given("User deletes info for pet id {int}")
    public void delete_by_id(int id) {
        PetTestActionsClass.deletePetName(id);
    }
}
