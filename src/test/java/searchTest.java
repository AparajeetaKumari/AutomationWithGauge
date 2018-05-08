import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class searchTest {
    WebDriver driver = new ChromeDriver();

    @Step("Navigate to <https://mex-sams-apacheweb-qa.walmart.com/>")
    public void login(String url) {
       System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
     driver.get(url);

    }

    @Step("Search for following products <table>")
    public void searchProduct(Table table) throws InterruptedException {


        WebElement popup=driver.findElement(By.cssSelector("div#sams-popups"));


        WebDriverWait wait=new WebDriverWait(driver,20);
//        String cssOfSearchBox= "input#searchBox";
//        WebElement inputfieldQ;
//        try {
//             inputfieldQ = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfSearchBox)));
//        }
//        catch(org.openqa.selenium.StaleElementReferenceException ex)
//        {
//             inputfieldQ = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfSearchBox)));
//        }
//        //WebElement inputfieldQ = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfSearchBox)));
//        if(table.getTableRows().size()==0) {
//            System.out.println("Please give some values");
//        }
        for(int i=0;i<table.getTableRows().size();i++) {

            String cssOfSearchBox= "input#searchBox";
            WebElement inputfieldQ;
            try {
                inputfieldQ = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfSearchBox)));
            }
            catch(org.openqa.selenium.StaleElementReferenceException ex)
            {
                inputfieldQ = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfSearchBox)));
            }
            //WebElement inputfieldQ = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfSearchBox)));
            if(table.getTableRows().size()==0) {
                System.out.println("Please give some values");
            }

            TableRow eachRow=table.getTableRows().get(i);
            String skuId=eachRow.getCell("skuid");
            System.out.println(skuId);
            inputfieldQ.sendKeys(skuId);
            String itemName=eachRow.getCell("productdesc");

            //Verify if the item is searched
            inputfieldQ.sendKeys(Keys.RETURN);

            //WebElement item_name=driver.findElement(By.xpath("//div/a[@class='item-name']"));
            WebElement itemimage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='itemBox-container-wrp grid-itemBox-wrp first']")));
            WebElement itemimageisClickable=driver.findElement(By.xpath("//a[@class='item-name']"));
            String href=itemimageisClickable.getAttribute("href");
            driver.get(href);


            WebElement itempdppage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='desktop pdp-info-container']")));
            WebElement itemSkuIdDisplayed=driver.findElement(By.xpath("//span[@class='prod-id']"));
            String text=itemSkuIdDisplayed.getText();
            System.out.append("Item text::"+text);
            if(text.contains(skuId)){
                System.out.append("Item found successfully");
//                WebElement homeIcon=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/home']")));
//                homeIcon.click();
            }







            //String elemnet ="//span[text()='Art. "+skuId+"']";
            //System.out.println("Element::"+elemnet);
            //WebElement itemDisplayed=driver.findElement(By.cssSelector(elemnet));


            //WebElement productDiscription=driver.findElement(By.cssSelector("a.item-name"));
           // System.out.println(productDiscription);

//            WebElement itemNameDisplayed=driver.findElement(By.xpath("//div/a[@class='item-name']"));
//            String namedisplayed=itemNameDisplayed.getText();
//            if(itemName==namedisplayed){
//                System.out.println("Item dispalyed on the screen::"+itemName);
//            }

        }

    }

//    @Step("Search for product <skuid>")
//    public void searchItem(String skuId) {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        String cssOfSearchBox = "input#searchBox";
//        WebElement inputfieldQ = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfSearchBox)));
//        inputfieldQ.sendKeys(skuId);
//        String searchButtonxpath = "//span[text()='Granos de Elote La Huerta 2 kg']";
//        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchButtonxpath)));
//
//        //WebElement searchButton=driver.findElement(By.xpath(searchButtonxpath));
//        searchButton.click();
//
//
//    }


//    @Step("Search for following products <skuid> <description>")
//    public void implementation1(String skuId, String value) {
//
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        String cssOfSearchBox = "input#searchBox";
//        WebElement inputfieldQ = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfSearchBox)));
//        inputfieldQ.sendKeys(skuId);
//        String searchButtonxpath = "//span[text()=value]";
//        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchButtonxpath)));
//        //WebElement searchButton=driver.findElement(By.xpath(searchButtonxpath));
//        searchButton.click();
//
//    }
//
//    @Step("Search for following products <skuid> <description> <table>")
//    public void searchProduct(String tablename,Table table) {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        String cssOfSearchBox = "input#searchBox";
//        WebElement inputfieldQ = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfSearchBox)));
//        WebElement searchBox=driver.findElement(By.xpath("//div/input[@id='searchBox']"));
//        for(int i=0;i<=table.getTableRows().size();i++){
//            inputfieldQ.sendKeys(table.getColumnValues(skuId).get(i));
//            searchBox.sendKeys(Keys.RETURN);
//
//        }


}



