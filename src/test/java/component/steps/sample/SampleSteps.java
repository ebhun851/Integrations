package component.steps.sample;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.Is;

import component.steps.common.ComponentBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SampleSteps extends ComponentBase{

	private Integer num1;
	private Integer num2;
	private Integer result;
	@Given("^we have (\\d+) numbers$")
	public void we_have_numbers(int arg1) throws Throwable {
		num1 = 6;
		num2 = 5;
	}

	@When("^add two numbers$")
	public void add_two_numbers() throws Throwable {
		servlet.get("/get");
		result = num1 + num2;
	}

	@Then("^result should be expected$")
	public void result_should_be_expected() throws Throwable {
		assertThat(result, Is.is(10));
	}

}
