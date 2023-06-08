package steps;

import io.cucumber.java.en.*; //asi puede traer todas las libresias de cucumber juntas
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
import pages.GooglePage;

public class GoogleSteps {

    GooglePage google = new GooglePage();


    @Given("^I am on the Google search page$") //le agredo ^ al principio y $ al final del step para definir  que cucumber lea entre esos dos simbolos
    public void navigateToGoogle(){
        google.navigateToGoogle();
    
    }

    @When("^I enter a search criteria$") //le agredo ^ al principio y $ al final del step para definir  que cucumber lea entre esos dos simbolos
    public void enterSearchCriteria(){
        google.enterSearchCriteria("Google");
    }

    @And("^click on the search button$") //le agredo ^ al principio y $ al final del step para definir  que cucumber lea entre esos dos simbolos
    public void clickSearchButton(){
        google.clickGoogleSearch();
    }

    @Then("^the results match the criteria$") //le agredo ^ al principio y $ al final del step para definir  que cucumber lea entre esos dos simbolos
    public void validateResults(){

    }
}
