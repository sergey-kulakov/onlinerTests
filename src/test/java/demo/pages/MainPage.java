package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.TextBox;

/**
 * Created by nikikuzi on 3/16/17.
 */
public class MainPage extends BaseForm {

       private Button btnCatalog = new Button(By.xpath("//span[contains(text(),'Каталог')]/.."),"btnCatalog");

       public MainPage() {
        super(By.xpath("//div[contains(@class,'main-page')]"),"Main Page");
    }

       public void goToCatalog() {

        btnCatalog.click();
    }
}
