package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.CheckBox;
import webdriver.elements.ComboBox;
import webdriver.elements.Label;
import webdriver.elements.TextBox;

import java.util.List;


public class TvCatalogPage extends BaseForm {

    String lblBrand ="//label[@class=\"schema-filter__checkbox-item\"]/span[.='%s']/preceding-sibling::span";
    private TextBox txbMaxPrice=new TextBox(By.xpath("//input[@placeholder=\"до\"]"),"txbMaxPrice");
    private TextBox txbDateFrom=new TextBox(By.xpath("//input[@placeholder=\"2010\"]"),"txbDateFrom");
    private ComboBox cmbSizeFrom=new ComboBox(By.xpath("//div[@class=\"schema-filter-control schema-filter-control_select\"]/select[contains(@data-bind,'from')]"),"cmbSizeFrom");
    private ComboBox cmbSizeTo=new ComboBox(By.xpath("//div[@class=\"schema-filter-control schema-filter-control_select\"]/select[contains(@data-bind,'to')]"),"cmbSizeTo");
    private Label lblResultItem=new Label(By.xpath("//div[@class=\"schema-product__title\"]/a"),"lblResultItem");

    public TvCatalogPage(){
        super(By.xpath("//h1[contains(text(),'Телевизоры')]"),"Tv catalog page");
    }

    public void searchTvByParams(String brand,String maxPrice,String dateFrom, String sizeFrom, String sizeTo){

        CheckBox chbBrand=new CheckBox(By.xpath(String.format(lblBrand,brand)));
        chbBrand.click();
        txbMaxPrice.setText(maxPrice);
        txbDateFrom.setText(dateFrom);
        cmbSizeFrom.click();
        cmbSizeFrom.selectByText(sizeFrom+"\"");
        cmbSizeTo.click();
        cmbSizeTo.selectByText(sizeTo+"\"");


    }
    public List<String> findLinks(){

       return lblResultItem.getAllLinksFromList();
    }
}
