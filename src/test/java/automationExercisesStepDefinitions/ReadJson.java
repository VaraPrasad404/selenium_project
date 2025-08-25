package automationExercisesStepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import utils.JsonReader;

public class ReadJson {

	
	@Given("compare source and destination json")
	public void compareJsonFiles() throws IOException {
	    String base = "src/test/resources/testdata/";
	    Assert.assertTrue(JsonReader.compareJsonfiles(base + "source.json", base + "dest.json"));
	}
}

