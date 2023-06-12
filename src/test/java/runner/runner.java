package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    publish = true,
    glue = "steps",
    tags = "@Grid" //es para testear los dropdown en sandbox
)

public class runner {

}