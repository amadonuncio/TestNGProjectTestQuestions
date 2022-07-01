package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Test109Page {
	static WebDriver driver;
	BasePage basePage;
	int r = BasePage.randNum();
	String beforeRanNum = "Amado ";
	String beforeMonthDropDownValue = "//select[3]/option[";
	String afterMonthDropDownValue = "]";

	public Test109Page(WebDriver driver) {
		Test109Page.driver = driver;
	}

//	Element Lists
	@FindBy(how = How.CSS, using = "input[name = 'categorydata']")
	WebElement ADD_CATEGORY_INPUT_BOX_ELEMENT;
	@FindBy(how = How.CSS, using = "input[value= 'Add category']")
	WebElement ADD_CATEGORY_BUTTON_ELEMENT;
	@FindBy(how = How.CSS, using = "select[name = 'due_month']")
	WebElement MONTH_DROP_DOWN_ELEMENT;
	@FindBy(how = How.LINK_TEXT, using = "Nevermind")
	WebElement NEVERMIND_HYPERLINK_ELEMENT;

//	Methods
	public void objectForBasePage() {
		basePage = PageFactory.initElements(driver, BasePage.class);
	}

	public void validateCategoryIsAddedToDisplay() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(beforeRanNum + r))));
		Assert.assertTrue(element.isDisplayed());
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public WebElement inputCategoryInAddCategoryInputBox() {
		ADD_CATEGORY_INPUT_BOX_ELEMENT.sendKeys("Amado " + r);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ADD_CATEGORY_INPUT_BOX_ELEMENT;
	}

	public void clickAddCategoryButton() {
		ADD_CATEGORY_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void inputDuplicateInAddCategoryInputBox() {
		inputCategoryInAddCategoryInputBox();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateDuplicateMessageAppears() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(NEVERMIND_HYPERLINK_ELEMENT));
		Assert.assertEquals(NEVERMIND_HYPERLINK_ELEMENT.getText(), "Nevermind");

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateMonthDropDownHasAllMonths() {
		for (int i = 2; i <= 13; i++) {
			WebElement monthDropDownValues = driver
					.findElement(By.xpath(beforeMonthDropDownValue + i + afterMonthDropDownValue));
			Assert.assertTrue(monthDropDownValues.isDisplayed());
		}
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		

	}

}
