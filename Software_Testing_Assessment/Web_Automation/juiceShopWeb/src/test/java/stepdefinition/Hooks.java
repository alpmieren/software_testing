package stepdefinition;


import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utilities.Driver;

public class Hooks {

    @After
    public void close(Scenario scenario) {
        Driver.quitDriver();
    }
}
