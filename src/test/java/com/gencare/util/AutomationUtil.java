package com.gencare.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class AutomationUtil {
	protected static final Logger logger = Logger.getLogger(AutomationUtil.class.getName());

	public static void main(String[] args) {
		// TODO Auto-gene
		String TEST_DATA_PROPERTIES = "testdata_en.properties";
		String EXPECTED_ASS_PROPERTIES = "expectedassertions_en.properties";
		String ANDROID_LANG_ASS_PROPERTIES = "androidxpaths_en.properties";
		String IOS_LANG_ASS_PROPERTIES = "iosxpaths_en.properties";
		System.out.println("French " + getLanguageFilePath("salus", TEST_DATA_PROPERTIES, "fr"));
		System.out.println("French " + getLanguageFilePath("salus", EXPECTED_ASS_PROPERTIES, "fr"));

		TEST_DATA_PROPERTIES = "testdata_en.properties";
		EXPECTED_ASS_PROPERTIES = "expectedassertions_en.properties";
		System.out.println("Default " + getLanguageFilePath("salus", TEST_DATA_PROPERTIES, "en"));
		System.out.println("French " + getLanguageFilePath("salus", EXPECTED_ASS_PROPERTIES, "en"));

		String androidLangxPathFile = getLanguageFilePath("salus", ANDROID_LANG_ASS_PROPERTIES, "en");
		FileReader androidLangxPathReader;
		try {
			androidLangxPathReader = new FileReader(androidLangxPathFile);
			Properties androidLangXPathsProp = new Properties();
			androidLangXPathsProp.load(androidLangxPathReader);

			System.out.println("Property value " + androidLangXPathsProp.getProperty("signuppage.btn.signup.xpath"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String iosLangxPathFile = getLanguageFilePath("salus", IOS_LANG_ASS_PROPERTIES, "en");
		FileReader iosLangxPathReader;
		try {
			iosLangxPathReader = new FileReader(iosLangxPathFile);
			Properties iosLangXPathsProp = new Properties();
			iosLangXPathsProp.load(iosLangxPathReader);

			System.out.println("Property value " + iosLangXPathsProp.getProperty("signuppage.btn.signup.xpath"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getLanguageFilePath(String flavour, String fileName, String lang) {

		logger.info("Starting of getLanguageFilePath method");
		if (lang == null) {
			lang = "en";
		}

		if (fileName.contains("_")) {
			fileName = fileName.split("_")[0] + "_" + lang + ".properties";
		}

		logger.info("End of getLanguageFilePath method");
		return Constants.LANG_RESOURCES_FILE_PATH + "/" + flavour + "/" + "lang" + "/" + lang + "/" + fileName;
	}
}
