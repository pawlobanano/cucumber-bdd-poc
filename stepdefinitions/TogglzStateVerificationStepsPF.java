//package stepdefinitions;
//
//import org.openqa.selenium.TakesScreenshot;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Scenario;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//
//public class TogglzStateVerificationStepsPF {
//
//    @After
//    public void doSomethingAfter(Scenario scenario){
//        if (scenario.isFailed()) {
//            byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", "name");
//        }
//    }
//
//    @Given("user is on the togglz home page")
//    public void user_is_on_the_togglz_home_page() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("toggles are in desired states:")
//    public void toggles_are_in_desired_states(io.cucumber.datatable.DataTable dataTable) {
//        // Write code here that turns the phrase above into concrete actions
//        // For automatic transformation, change DataTable to one of
//        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//        // Double, Byte, Short, Long, BigInteger or BigDecimal.
//        //
//        // For other transformations you can register a DataTableType.
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @And("take screenshot of the Togglz application index page")
//    public void take_screenshot_of_the_togglz_application_index_page() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//
//}
