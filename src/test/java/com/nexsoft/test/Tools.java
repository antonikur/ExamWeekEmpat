package com.nexsoft.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Tools {

	
	
	public void stopForMoment() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void stopForMoment(int miliSec) {
		try {
			Thread.sleep(miliSec);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void scroolVerticalWindows(WebDriver driver, int y) {
		//positive y for going down, negative y for going up
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+y+")", "");
	}
	
	public String screenShoot(WebDriver driver) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String namaFile = "C:\\Antoni\\selenium\\TestNG\\screenshoot\\Error_" + waktu + ".PNG";
		File screenshoot = new File(namaFile);
		try {
			FileUtils.copyFile(srcFile, screenshoot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return namaFile;
	}
	
	
}
