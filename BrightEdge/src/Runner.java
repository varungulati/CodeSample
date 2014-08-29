import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Runner {
	public static final String CSS_GO_BUTTON = ".bigGoButton.searchIcon";
	public static final String CSS_NUMBER_RESULTS = ".floatLeft.numResults.mt5";
	public static final String XPATH_NEXT = "//a[contains(text(), 'Next')]";
	public static final String CSS_ADS = ".item";
	public static final String CSS_DIV_PRICE = ".bigPriceText2";
	public static final String CSS_DIV_PRICE_CENTS = ".smallPriceText2";
	public static final String CSS_AD_TITLE = ".prodLink.ListItemLink";
	public static final String ID_SEARCH_BOX = "searchText";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String query = "";
		int page_number = -1;
		
		// Parse command line.
		if(args.length < 1) {
			System.out.println("Less arguments. \nPlease run as: \n java -jar Assignment.jar <keyword> (e.g. java -jar Assignment.jar \"baby strollers\") \n java -jar Assignment.jar <keyword> <page number> (e.g. java -jar Assignment.jar \"baby strollers\" 2)");
			System.exit(0);
		} else if(args.length == 1) {
			query = args[0];
			System.out.println("Query string: " + query);
		} else {
			query = args[0];
			page_number = Integer.parseInt(args[1]);
			System.out.println("Query string: " + query);
			System.out.println("Page Number: " + page_number);
		}
        WebDriver driver = new FirefoxDriver();

        // Open base url.
        driver.get("http://www.walmart.com");

        // Fill search query in search box.
        try {
        	WebElement searchBox = driver.findElement(By.id(ID_SEARCH_BOX));
        	searchBox.sendKeys(query);
        } catch(NoSuchElementException e) {
        	// TODO(varun): Custom error handler.
        	System.out.println(e);
        }
        
        // Click on GO.
        try {
	        WebElement goButton = driver.findElement(By.cssSelector(CSS_GO_BUTTON));
	        goButton.click();
	    } catch(NoSuchElementException e) {
	    	// TODO(varun): Custom error handler.
	    	System.out.println(e);
	    }
        
        // Get number of results on new page.
        try {
        	WebElement numberResults = driver.findElement(By.cssSelector(CSS_NUMBER_RESULTS));
        	System.out.println(numberResults.getText());
        } catch(NoSuchElementException e) {
        	// TODO(varun): Custom error handler.
        	System.out.println(e);
        }
        
        // Execute query 2.
        if(page_number != -1) {
        	// Go to the page number by clicking on next.	
        	for(int i = 1; i < page_number; i++) {
        		try {
        			WebElement next = driver.findElement(By.xpath(XPATH_NEXT));
        			next.click();
                } catch(NoSuchElementException e) {
                	// TODO(varun): Custom error handler.
                	System.out.println(e);
                }
        	}
        	
        	List<WebElement> ads = driver.findElements(By.cssSelector(CSS_ADS));
        	ArrayList<Result> results = new ArrayList<Result>();
        	String ad_price = "", ad_title = "", ad_price_cents = "";
        	
        	// Get ad title and price for all ads.
        	for(WebElement ad: ads) {
        		ad_title = ad.findElement(By.cssSelector(CSS_AD_TITLE)).getText();
        		try {
        			List<WebElement> div_price = ad.findElements(By.cssSelector(CSS_DIV_PRICE));
        			List<WebElement> div_price_cents = ad.findElements(By.cssSelector(CSS_DIV_PRICE_CENTS));
        			
        			if(div_price.size() >= 1) {
        				ad_price = div_price.get(1).getText();
        			}
        			if(div_price_cents.size() >= 1) {
        				ad_price_cents = div_price_cents.get(1).getText();
        			}
        		} catch(NoSuchElementException e) {
        			System.out.println(e);
        		}
        		results.add(new Result(ad_title, ad_price + ad_price_cents));
        	}
        	
        	// Print entries in result array.
        	for(Result result: results) {
        		System.out.println(result.getTitle() + " | " + result.getPrice());
        	}
        }
        driver.quit();  
	}
}
