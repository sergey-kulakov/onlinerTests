package demo.tests;

import demo.pages.CatalogPage;
import demo.pages.MainPage;
import demo.pages.ResultsPage;
import demo.pages.TvCatalogPage;
import webdriver.BaseTest;
/**
 * Created by Sergey on 18.03.2017.
 */
public class SearchTvTest extends BaseTest {
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
        tvCatalogPage.searchTvByParams();
    }
}
