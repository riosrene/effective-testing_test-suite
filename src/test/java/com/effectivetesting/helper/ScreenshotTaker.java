package com.effectivetesting.helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotTaker {
	
	public void takeScreenshot(WebDriver driver, String command) {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			Date date = new Date();
			
			FileUtils.copyFile(src, new File("C:/repositories/" + command + dateFormat.format(date) + ".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
