package demo.tests;

import demo.pages.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriver.BaseTest;
import webdriver.Browser;

import java.util.List;


public class SearchTvTest extends BaseTest {
    private String brand;
    private String maxPrice;
    private String dateFrom;
    private String sizeFrom;
    private String sizeTo;

    @BeforeTest
    @Parameters({"brand","maxPrice", "dateFrom", "sizeFrom", "sizeTo"})
    public void setParameters(String brand,String maxPrice,String dateFrom,String sizeFrom,String sizeTo){
        this.brand=brand;
        this.maxPrice=maxPrice;
        this.dateFrom=dateFrom;
        this.sizeFrom=sizeFrom;
        this.sizeTo=sizeTo;
        System.out.println(brand);
    }

    @Override
    public void runTest(){
        logStep();
        MainPage mainPage = new MainPage();
        mainPage.goToCatalog();

        logStep();
        CatalogPage catalogPage=new CatalogPage();
        catalogPage.goToTvCategory();

        logStep();
        TvCatalogPage tvCatalogPage=new TvCatalogPage();
        tvCatalogPage.searchTvByParams(brand,maxPrice, dateFrom,sizeFrom, sizeTo);
        List<String> findLinks=tvCatalogPage.findLinks();
        for (String page : findLinks) {
            logStep();
            Browser.getInstance().getDriver().get(page);
            TvPage tvPage=new TvPage();
            tvPage.checkParameters(brand, maxPrice,dateFrom,sizeFrom,sizeTo);

        }
    }

}
