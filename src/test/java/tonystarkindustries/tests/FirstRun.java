package tonystarkindustries.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.AssertJUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstRun {

	
	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		String date="20"; String month="February";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Initializing explicit wait
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
		
		//Soft Assert
		SoftAssert sa=new SoftAssert();
		
		driver.get("https://www.makemytrip.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class*='we_close']")));
		//popup close button css-> i[class='wewidgeticon we_close']            [class='close']
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='second-img']")));	
		Thread.sleep(5000);
		
		//To click anywhere on the screen based on location 
		Actions actions = new Actions(driver);
		Robot robot = new Robot();
		robot.mouseMove(100,50);
		actions.click().build().perform();
		
		
		//Assserting if roundtrip button is selected css-> [data-cy='roundTrip']
		Assert.assertFalse(driver.findElement(By.cssSelector("[data-cy='roundTrip']")).isSelected());
		//to select roundtrip radiobutton css-> [data-cy='roundTrip']		
		driver.findElement(By.cssSelector("[data-cy='roundTrip']")).click();
		
		//to select multicity radiobutton css-> [data-cy='mulitiCityTrip'] 
		Assert.assertFalse(driver.findElement(By.cssSelector("[data-cy='mulitiCityTrip']")).isSelected());
		driver.findElement(By.cssSelector("[data-cy='mulitiCityTrip']")).click();
		
		//to select the oneway radiobutton css-> [data-cy='oneWayTrip']
		Assert.assertFalse(driver.findElement(By.cssSelector("[data-cy='oneWayTrip']")).isSelected());
		driver.findElement(By.cssSelector("[data-cy='oneWayTrip']")).click();
		
		//To click on hotels css-> [data-cy='menu_Hotels']
		driver.findElement(By.cssSelector("[data-cy='menu_Hotels']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[data-cy='HotelSearchWidget_310']")));
		System.out.println(driver.findElement(By.cssSelector("[data-cy='HotelSearchWidget_310']")).getText());
		
		//to click on homestays&villas -> [data-cy='menu_Homestays']
		WebElement homeStaysAndVillas=driver.findElement(By.cssSelector("[data-cy='menu_Homestays']"));
		homeStaysAndVillas.click();
		
		//to click on holiday Packages -> [data-cy='menu_Holidays']
		WebElement holidayPackages=driver.findElement(By.cssSelector("[data-cy='menu_Holidays']"));
		holidayPackages.click();
		
		//To click on Trains-> [data-cy='menu_Trains']
		WebElement trains=driver.findElement(By.cssSelector("[data-cy='menu_Trains']"));
		trains.click();
		
		//To click on Buses-> [data-cy='menu_Buses']
		WebElement buses=driver.findElement(By.cssSelector("[data-cy='menu_Buses']"));
		buses.click();
		
		//To click on Cabs-> [data-cy='menu_Cabs']
		WebElement cabs=driver.findElement(By.cssSelector("[data-cy='menu_Cabs']"));
		cabs.click();
		
		//To click on ForexCard-> [data-cy='menu_Forex'] 
		WebElement forexCard=driver.findElement(By.cssSelector("[data-cy='menu_Forex']"));
		forexCard.click();
		
		/*To click on Travel Insurance-> [data-cy='menu_TravelInsurance']
		WebElement travelInsurance=driver.findElement(By.cssSelector("[data-cy='menu_TravelInsurance']"));
		travelInsurance.click();
		WebElement closeButton=driver.findElement(By.cssSelector("[data-cy='closeModal']"));
		closeButton.click();*/
		
		//To click back on flights section
		driver.findElement(By.cssSelector("[data-cy='menu_Flights']")).click();
		System.out.println("Entered flights section: "+driver.findElement(By.cssSelector("[class*='widgetTitle']")).getText());
		
		//To select Mumbai in from
		driver.findElement(By.cssSelector("[id='fromCity']")).sendKeys("Mumbai");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='react-autowhatever-1-section-0-item-0']")));
		driver.findElement(By.cssSelector("[id='react-autowhatever-1-section-0-item-0']")).click();
		
		//To select Chennai in Destination
		driver.findElement(By.cssSelector("[id='toCity']")).sendKeys("Chennai");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='react-autowhatever-1-section-0-item-0'] div")));
		//driver.findElement(By.cssSelector("[id='react-autowhatever-1-section-0-item-0'] div")).click();		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'MAA')]")));
		WebElement firstoption=driver.findElement(By.xpath("//div[contains(text(),'MAA')]"));
		Actions act=new Actions(driver);
		act.moveToElement(firstoption).click().build().perform();
		
		String monthName=driver.findElement(By.cssSelector("[class='DayPicker-Caption'] div")).getText().split(" ")[0].trim();
		System.out.println("Current monthName="+monthName+", Needed Month="+month);
		
		while(!(monthName.equalsIgnoreCase(month))) {
			WebElement monthRightArrow=driver.findElement(By.cssSelector("[aria-label='Next Month']"));
			monthRightArrow.click();
			monthName=driver.findElement(By.cssSelector("[class='DayPicker-Caption'] div")).getText().split(" ")[0].trim();
		}
		
		if(monthName.equalsIgnoreCase(month)) {
			List<WebElement> dates=driver.findElements(By.xpath("//div[@class='dateInnerCell']/p[1]"));
			for(int i=0;i<dates.size();i++) {
				String driverAtDate=dates.get(i).getText();
				if(driverAtDate.equalsIgnoreCase(date)) {
					System.out.println("Clicked date: "+dates.get(i).getText());
					dates.get(i).click();
					break;
				}					
			}
		}
		
		//TO click on Armed forces xpath-> //li/p[contains(text(),'Armed Forces')]
		WebElement checkBoxArmedForces=driver.findElement(By.xpath("//li/p[contains(text(),'Armed Forces')]"));
		checkBoxArmedForces.click();

		//To CLick on search button
				driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
				Thread.sleep(5000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='fareLockInfoContainer'] button")));
		//Prices popup xpath->  //button[contains(text(),'OKAY, GOT IT!')] or
		//			cssSelector-> div[class='fareLockInfoContainer'] button
		WebElement pricesPopUp=driver.findElement(By.cssSelector("div[class='fareLockInfoContainer'] button"));
		
		System.out.println("Clicking on pricesPopUp button:"+ pricesPopUp.getText());
		pricesPopUp.click();
		
		
		
		
		
		//To quit the driver
		driver.quit();
	}
		
}