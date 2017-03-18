package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.CheckBox;
import webdriver.elements.ComboBox;
import webdriver.elements.TextBox;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Sergey on 18.03.2017.
 */
public class TvCatalogPage extends BaseForm {

    private  CheckBox chbSumsung=new CheckBox(By.xpath("//label[@class=\"schema-filter__checkbox-item\"]/span[.='Samsung']/preceding-sibling::span"));
    private TextBox txbMaxPrice=new TextBox(By.xpath("//input[@placeholder=\"до\"]"));
    private TextBox txbDateFrom=new TextBox(By.xpath("//input[@placeholder=\"2010\"]"));
    private ComboBox cmbSizeFrom=new ComboBox(By.xpath("//div[@class=\"schema-filter-control schema-filter-control_select\"]/select[contains(@data-bind,'from')]"));
    private ComboBox cmbSizeTo=new ComboBox(By.xpath("//div[@class=\"schema-filter-control schema-filter-control_select\"]/select[contains(@data-bind,'to')]"));


    public TvCatalogPage(){
        super(By.xpath("//h1[contains(text(),'Телевизоры')]"),"Tv catalog page");
    }

    public void searchTvByParams(){
        chbSumsung.click();
        txbMaxPrice.setText("1000");
        txbDateFrom.setText("2013");
        cmbSizeFrom.click();
        cmbSizeFrom.selectByText("39\"");
        cmbSizeTo.click();
        cmbSizeTo.selectByText("42\"");


    }
}
