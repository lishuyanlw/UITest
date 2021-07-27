package com.tsc.data.Handler;

import java.io.FileNotFoundException;
import java.util.List;

import org.testng.ITestNGMethod;

import com.tsc.data.pojos.ConstantData;
import com.tsc.data.pojos.SauceSettings;

public class TestDataHandler {
	public static SauceSettings sauceSettings;
	public static ConstantData constantDataVariables;

	public static void dataInit(List<ITestNGMethod> lstTestMethodName) throws FileNotFoundException {
		sauceSettings = YamlHandler.getSauceSettings("/src/test/resources/test-data/SauceSettings.yml");
		constantDataVariables = YamlHandler.getConstantDataVariables("/src/test/resources/test-data/ConstantData.yml");
	}

	public static void dataInit() throws FileNotFoundException {
		sauceSettings = YamlHandler.getSauceSettings("/src/test/resources/test-data/SauceSettings.yml");
		constantDataVariables = YamlHandler.getConstantDataVariables("/src/test/resources/test-data/ConstantData.yml");
	}

}