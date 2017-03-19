package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;
import static org.testng.Assert.*;


public class TvPage extends BaseForm {
    private Label lblTitle=new Label(By.tagName("h1"));
    private Label lblPrice=new Label(By.xpath("//a[contains(@class,'offers-description__link')]"));
    private Label lblDate=new Label(By.xpath("//td[contains(text(),'Дата выхода на рынок')]/../td[2]/span"));
    private Label lblSize=new Label(By.xpath("//td[contains(text(),'Диагональ экрана')]/../td[2]/span"));
    private  Label lblNoPriceSecondary=new Label(By.xpath("//div[contains(@class,'offers-description__status_secondary' )]"),"lblPriceSecondary");
    private  Label lblPriceSecondary=new Label(By.xpath("//a[contains(@class,'offers-description__link offers-description__link_farther offers-description__link_nodecor')]"));


    public TvPage(){
        super(By.xpath("//h3[contains(text(),'Описание')]"),"Tv page");
    }
    public void checkParameters(String brend,String smaxPrice,String sdateFrom,String ssizeFrom,String ssizeTo){
        assertTrue(lblTitle.getText().contains(brend));

        int maxPrice=Integer.valueOf(smaxPrice).intValue();

        if(lblNoPriceSecondary.isPresent()){
        String[] spriceFrom=lblPrice.getText().split(",");
        int priceFrom=Integer.valueOf(spriceFrom[0]).intValue();
        assertTrue(priceFrom<=maxPrice);
        }
        else {
            String[] sPriceSecondary=lblPriceSecondary.getText().split(",");
            int priceSecondary=Integer.valueOf(sPriceSecondary[0]).intValue();
            assertTrue(priceSecondary<=maxPrice);
        };
        String sdate=lblDate.getText().substring(0,4);
        int date=Integer.valueOf(sdate).intValue();
        int dateFrom=Integer.valueOf(sdateFrom).intValue();
        assertTrue(date>=dateFrom);


        String ssize=lblSize.getText().substring(0,2);
        int size=Integer.valueOf(ssize).intValue();
        int sizeFrom=Integer.valueOf(ssizeFrom).intValue();
        int sizeTo=Integer.valueOf(ssizeTo).intValue();
        assertTrue(size>=sizeFrom&&size<=sizeTo);

    }
}
