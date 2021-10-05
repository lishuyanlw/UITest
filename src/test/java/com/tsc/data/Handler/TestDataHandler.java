package com.tsc.data.Handler;

import java.io.FileNotFoundException;
import com.tsc.data.pojos.ConstantDataFile;

import com.tsc.data.pojos.ConstantData;
import com.tsc.data.pojos.SauceSettings;

public class TestDataHandler {
	public static SauceSettings sauceSettings;
	public static ConstantData constantDataVariables;
	public static ConstantDataFile constantDataFile;

	public static void dataInit() throws FileNotFoundException {
		sauceSettings = YamlHandler.getSauceSettings("/src/test/resources/test-data/SauceSettings.yml");
		constantDataVariables = YamlHandler.getConstantDataVariables("/src/test/resources/test-data/ConstantData.yml");
		constantDataFile = YamlHandler.getConstantDataVariable("/src/test/resources/test-data/ConstantDataFile.yml");
	}
}