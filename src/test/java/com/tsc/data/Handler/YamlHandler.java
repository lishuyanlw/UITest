package com.tsc.data.Handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import com.tsc.data.pojos.ConstantData;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import com.tsc.data.pojos.ConstantData_Old;
import com.tsc.data.pojos.SauceSettings;

public class YamlHandler {

	public static SauceSettings getSauceSettings(String strSauceSettingLocation) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(SauceSettings.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + strSauceSettingLocation));
		SauceSettings sauceSettings = yaml.load(inputStream);
		return sauceSettings;
	}

	public static ConstantData_Old getConstantDataVariables(String strConstantLocation) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(ConstantData_Old.class));
		FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir") + strConstantLocation));
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
		ConstantData_Old constantDataOld = yaml.load(inputStreamReader);
		return constantDataOld;
	}
	
	public static ConstantData getConstantDataVariable(String strConstantLocation) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(ConstantData.class));
		FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir") + strConstantLocation));
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
		ConstantData constantData = yaml.load(inputStreamReader);
		return constantData;
	}	

//	public static Map<String,Object> getConstantDataVariablesMap(String strConstantLocation) throws FileNotFoundException {
//		Yaml yaml = new Yaml();
//		InputStream inputStream;
//
//		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + strConstantLocation));
//		return yaml.load(inputStream);
//		//return headerFooterLinks.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toSet());
//	}
//
//	public static ConstantDataFile getConstantDataVariable(String strConstantLocation) throws FileNotFoundException {
//		Map<String, Object> dataMap = getConstantDataVariablesMap(strConstantLocation);
//		ObjectMapper objectMapper = new ObjectMapper();
//		return objectMapper.convertValue(dataMap, ConstantDataFile.class);
//	}

}
