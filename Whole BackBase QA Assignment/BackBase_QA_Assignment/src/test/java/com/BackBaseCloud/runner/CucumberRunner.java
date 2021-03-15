package com.BackBaseCloud.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "rerun:target/rerun.txt",
                "json:target/cucumber.json",
                "html:target/default-cucumber-report.html",
        },
        features = {
                "src/test/resources/features"
        },
        glue = "com/BackBaseCloud/step_definitions",
        dryRun = false,
        tags = "@register"

)
public class CucumberRunner {


}
