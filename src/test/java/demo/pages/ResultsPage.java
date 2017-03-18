package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;

/**
 * Created by nikikuzi on 3/16/17.
 */
public class ResultsPage extends BaseForm {

    private String lblResultLocator = "//*[contains(@class, 'b-results-list')]//a[contains(.,'%s')]";

    public ResultsPage() {
        super(By.className("logo"), "Results Page");
    }

    public void assertResultIsPresent(String text) {
        new Label(By.xpath(String.format(lblResultLocator, text)), text).waitForIsElementPresent();
    }
}
