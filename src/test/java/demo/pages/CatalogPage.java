package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;

/**
 * Created by Sergey on 18.03.2017.
 */
public class CatalogPage extends BaseForm {
    private Button btnElectronica=new Button(By.xpath("//span[contains(text(),'Электроника')]/../.."),"btnElectronica");
    private Button btnTvAndVideo=new Button(By.xpath(".//div[contains(text(),'Телевидение')]"),"btnTvAndVideo");
    private Button btnTv=new Button(By.xpath("//span[contains(text(),'Телевизоры')]/../.."),"btnTv");

    public CatalogPage(){
        super(By.xpath("//h1[contains(text(),'Каталог')]"),"Catalog page");
    }

    public void goToTvCategory(){
        btnElectronica.click();
        btnTvAndVideo.click();
        btnTv.click();
    }
}
