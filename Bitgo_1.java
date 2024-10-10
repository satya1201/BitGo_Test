package Satya.Sample;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.junit.Assert;

public class Bitgo_1 {

	public static void main(String[] args) {
		//Setup WebDriver
		WebDriver driver = new ChromeDriver();
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Navigate to URL
		driver.get("https://blockstream.info/block/000000000000000000076c036ff5119e5a5a74df77abf64203473364509f7732");
		
		//Test-case 1 to validate heading
		String s = driver.findElement(By.cssSelector(".font-h3")).getText();
		
		Assert.assertEquals(s,"25 of 2875 Transactions");
		
		
		//Test-case 2 to Print the transaction hash of the transactions which has exactly 1 input and 2 outputs
		List<WebElement> tran = driver.findElements(By.cssSelector(".transaction-box"));
		
		for(WebElement trans: tran)
		{
			String tranhash = trans.findElement(By.cssSelector(".transaction-box .font-p2 a")).getText();
			List<WebElement> input = trans.findElements(By.cssSelector(".ins-and-outs .vins .vin"));
			List<WebElement> output = trans.findElements(By.cssSelector(".ins-and-outs .vouts .vout"));
			
			if(input.size() == 1 && output.size() == 2)
			{
				System.out.println(tranhash);
			}
		}
		
	}

}
