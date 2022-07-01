package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Test109Page;
import util.BrowserFactory;

public class Test2 extends BrowserFactory {
	Test109Page test109;

	@BeforeTest
	public void beforeRun() {
		init();
		test109 = PageFactory.initElements(driver, Test109Page.class);
	}
	
	@Test
	public void validateUserIsNotAbleToAddDuplicateCategory() {
		test109.inputCategoryInAddCategoryInputBox();
		test109.clickAddCategoryButton();
		test109.inputDuplicateInAddCategoryInputBox();
		test109.clickAddCategoryButton();
		test109.validateDuplicateMessageAppears();

	}
	
	
	@AfterTest
	public void afterRun() {
		tearDown();
	}
}
