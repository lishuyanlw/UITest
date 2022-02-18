package com.tsc.data.Handler;

import java.io.FileNotFoundException;
import com.tsc.data.pojos.ConstantData;

import com.tsc.data.pojos.ConstantData_Old;
import com.tsc.data.pojos.SauceSettings;

public class TestDataHandler {
	public static SauceSettings sauceSettings;
	public static ConstantData_Old constantDataOldVariables;
	public static ConstantData constantData;

	public static void dataInit() throws FileNotFoundException {
		sauceSettings = YamlHandler.getSauceSettings("/src/test/resources/test-data/SauceSettings.yml");
		constantDataOldVariables = YamlHandler.getConstantDataVariables("/src/test/resources/test-data/ConstantData_Old.yml");
		if(System.getProperty("QaUrl").toLowerCase().contains("qa")){
			constantData = YamlHandler.getConstantDataVariable("/src/test/resources/test-data/ConstantData_QA.yml");
		}
		else{
			constantData = YamlHandler.getConstantDataVariable("/src/test/resources/test-data/ConstantData_ST.yml");
		}

	}
}