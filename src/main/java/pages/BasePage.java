package pages;

import java.util.Random;

public class BasePage {

	public static int randNum() {
		Random rand = new Random();
		int randNum = rand.nextInt(999);
		return randNum;
	}
}
