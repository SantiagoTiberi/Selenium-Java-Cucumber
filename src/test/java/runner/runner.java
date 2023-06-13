package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    publish = true,
    monochrome = true,
    glue = "steps",
    tags = "@Grid" //es para testear los dropdown en sandbox
)

public class runner {
       @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}