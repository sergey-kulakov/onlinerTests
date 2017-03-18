package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;

/**
 * Created by Sergey on 18.03.2017.
 */
public class CatalogPage extends BaseForm {
    private Button btnElectronica=new Button(By.xpath("//span[contains(text(),'Электроника')]/../.."));
    private Button btnTvAndVideo=new Button(By.xpath("//*[@id='container']/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div[1]/div/div[2]/div[1]"));
    private Button btnTv=new Button(By.xpath("//span[contains(text(),'Телевизоры')]/../.."));

    public CatalogPage(){
        super(By.xpath("//h1[contains(text(),'Каталог')]"),"Catalog page");
    }

    public void goToTvCategory(){
        btnElectronica.click();
        btnTvAndVideo.click();
        btnTv.click();
    }
}
