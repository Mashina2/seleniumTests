package Tests.AddPortfoliosTests;

import AllPages.PortfolioPage.AddPortfolio;
import AllPages.PortfolioPage.LeftSideOfPagePortfolios;
import MainPackage.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

public class AddAllExchangesPositive extends Driver {

    AddPortfolio addPortfolio;
    LeftSideOfPagePortfolios leftSideOfPagePortfolios;
    AllURLs allURLs;
    SeleniumUtils utils;
    Paths paths;
    ExchangesWalletsAPIs exchangesWalletsAPIs;

    @BeforeClass
    public void beforeClass() {
        allURLs = new AllURLs(driver);
        utils = new SeleniumUtils(driver);
        addPortfolio = new AddPortfolio(driver);
        leftSideOfPagePortfolios = new LeftSideOfPagePortfolios(driver);
        paths = new Paths(driver);
        exchangesWalletsAPIs = new ExchangesWalletsAPIs(driver);
    }

    @Test
    public void connectAllExchanges() throws InterruptedException {
        allURLs.navigateToPortfolioPage();
        utils.enableCookie();

        String firstAPI = "";
        String secondAPI = "";
        String thirdAPI = "";

        Thread.sleep(4000);
        addPortfolio.clickOnAddPortfolio();
        addPortfolio.clickOnConnectExchange();

        List<WebElement> listTill = driver.findElements(By.className("qa-exchanges"));

        for (int i = 0; i < listTill.size(); i++) {

            List<WebElement> list = driver.findElements(By.className("qa-exchanges"));

            String exchangeName = list.get(i).getText();
            list.get(i).click();

            int loop = 0;

            switch (exchangeName) {
                case "Binance": {
                    firstAPI = exchangesWalletsAPIs.getBinanceAPIKey();
                    secondAPI = exchangesWalletsAPIs.getBinanceAPISecret();
                    loop = 1;
                    break;
                }

                case "Binance US": {
                    firstAPI = exchangesWalletsAPIs.getBinanceUSAPIKey();
                    secondAPI = exchangesWalletsAPIs.getBinanceUSAPISecret();
                    loop = 2;
                    break;
                }

                case "BitMax": {
                    firstAPI = exchangesWalletsAPIs.getBitmaxAPIKey();
                    secondAPI = exchangesWalletsAPIs.getBitmaxAPISecret();
                    loop = 2;
                    break;
                }

               //case "Bitmex": {
               //    //firstAPI = exchangesWalletsAPIs.getBitmexID();
               //    //secondAPI = exchangesWalletsAPIs.getBitmexAPISecret();
               //    loop = 2;
               //    break;
               //}

                case "Bitfinex": {
                    firstAPI = exchangesWalletsAPIs.getBitfinexAPIKey();
                    secondAPI = exchangesWalletsAPIs.getBitfinexAPISecret();
                    loop = 2;
                    break;
                }

                case "Bitso": {
                    firstAPI = exchangesWalletsAPIs.getBitsoAPIKey();
                    secondAPI = exchangesWalletsAPIs.getBitsoAPISecret();
                    loop = 2;
                    break;
                }

                case "Bybit": {
                    firstAPI = exchangesWalletsAPIs.getByBitAPIPrivateKey();
                    secondAPI = exchangesWalletsAPIs.getByBitPrivateKey();
                    loop = 8;
                    break;
                }

                case "Cex.io": {
                    firstAPI = exchangesWalletsAPIs.getCexioAPIKey();
                    secondAPI = exchangesWalletsAPIs.getCexioAPISecret();
                    thirdAPI = exchangesWalletsAPIs.getCexioUserID();
                    loop = 3;
                    break;
                }

                case "Deribit": {
                    firstAPI = exchangesWalletsAPIs.getDeribitClientID();
                    secondAPI = exchangesWalletsAPIs.getDeribitClientSecret();
                    loop = 2;
                    break;
                }

                case "FTX": {
                    firstAPI = exchangesWalletsAPIs.getFTXAPIKey();
                    secondAPI = exchangesWalletsAPIs.getFTXAPISecret();
                    loop = 8;
                    break;
                }

                case "HitBTC": {
                    firstAPI = exchangesWalletsAPIs.getHitBTCAPIKey();
                    secondAPI = exchangesWalletsAPIs.getHitBTCAPISecret();
                    loop = 2;
                    break;
                }

                case "Huobi": {
                    firstAPI = exchangesWalletsAPIs.getHuobiAccessKey();
                    secondAPI = exchangesWalletsAPIs.getHuobiAccessSecret();
                    loop = 2;
                    break;
                }

                case "IDEX": {
                    firstAPI = exchangesWalletsAPIs.getIdexAPICode();
                    secondAPI = exchangesWalletsAPIs.getIdexAPISecret();
                    loop = 2;
                    break;
                }

                case "Kraken": {
                    firstAPI = exchangesWalletsAPIs.getKrakenAPIKey();
                    secondAPI = exchangesWalletsAPIs.getKrakenAPISecret();
                    loop = 2;
                    break;
                }

                case "KuCoin": {
                    firstAPI = exchangesWalletsAPIs.getKucoinKey();
                    secondAPI = exchangesWalletsAPIs.getKucoinSecret();
                    thirdAPI = exchangesWalletsAPIs.getKucoinPassphrase();
                    loop = 3;
                    break;
                }

                case "Liquid": {
                    firstAPI = exchangesWalletsAPIs.getLiquidID();
                    secondAPI = exchangesWalletsAPIs.getLiquidTokenSecret();
                    loop = 2;
                    break;
                }

                case "OKEX": {
                    firstAPI = exchangesWalletsAPIs.getOkexKey();
                    secondAPI = exchangesWalletsAPIs.getOkexSecret();
                    thirdAPI = exchangesWalletsAPIs.getOkexPassphrase();
                    loop = 3;
                    break;
                }

                case "Poloniex": {
                    firstAPI = exchangesWalletsAPIs.getPoloniexAPIKey();
                    secondAPI = exchangesWalletsAPIs.getPoloniexAPISecret();
                    loop = 2;
                    break;
                }

                default:
                {
                    Thread.sleep(1000);
                    addPortfolio.clickOnBack();
                    continue;
                }
            }

            if (loop == 1)
            {
                addPortfolio.typeFirstAPI(firstAPI);
                addPortfolio.typeSecondAPI(secondAPI);
                Thread.sleep(1000);
                addPortfolio.clickOnSubmit();
                addPortfolio.clickOnBinanceAddAccounts();
                addPortfolio.clickOnSuccessYes();
                addPortfolio.clickOnConnectExchange();
                continue;
            }

            else if (loop == 2)
            {
                addPortfolio.typeFirstAPI(firstAPI);
                addPortfolio.typeSecondAPI(secondAPI);
            }

            else if (loop == 8)
            {
                addPortfolio.typeFirstAPI(firstAPI);
                addPortfolio.typeSecondAPIByBit(secondAPI);
            }

            else if (loop == 3)
            {
                addPortfolio.typeFirstAPI(firstAPI);
                addPortfolio.typeSecondAPI(secondAPI);
                addPortfolio.typeThirdAPI(thirdAPI);
            }
            
            Thread.sleep(1000);
            addPortfolio.clickOnSubmit();
            try {
                addPortfolio.clickOnNoShowMeSynced();
            }
            catch (NoSuchElementException e)
            {
                System.err.println(exchangeName + " exchange API is Invalid or exception with Submit button");
                addPortfolio.clickOnBack();
                continue;
            }

            List<WebElement> list2 = driver.findElements(By.className("qa-portfolios"));
            String addedExchangeName = list2.get(list2.size() - 1).getText();

            if (!exchangeName.equals(addedExchangeName))
            {
                System.err.println(exchangeName + " exchange API is invalid");
            }

            Thread.sleep(2000);
            addPortfolio.clickOnAddPortfolio();
            addPortfolio.clickOnConnectExchange();

        }

        deleteAllPortfolios();
    }


    public void deleteAllPortfolios() throws InterruptedException {
        allURLs.navigateToPortfolioPage();

        while (true) {

            try {
                leftSideOfPagePortfolios.moveToSecondPortfolioName();
                Thread.sleep(1000);
                try {
                    leftSideOfPagePortfolios.clickOnSecondPortfolioDelete();
                } catch (Exception e) {
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("ul#portfolio-list > li:nth-of-type(3) .icon-delete")));
                }
                leftSideOfPagePortfolios.clickOnDeleteInDelete();
                Thread.sleep(3000);
            }
            catch (NoSuchElementException e)
            {
                break;
            }
        }
    }
}