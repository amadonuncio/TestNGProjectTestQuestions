package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Test109Page;
import util.BrowserFactory;

public class Test3 extends BrowserFactory {
	Test109Page test109;

	@BeforeTest
	public void beforeRun() {
		init();
		test109 = PageFactory.initElements(driver, Test109Page.class);
	}
	
	@Test
	public void validateMonthDropDownInDueDateSectionHasAll12Months() {
		test109.validateMonthDropDownHasAllMonths();
	}
	
	
	@AfterTest
	public void afterRun() {
		tearDown();
	}
}
