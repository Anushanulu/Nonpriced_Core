
package nPRICED_US_main;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import lib.Excel;
import nPRICED_US.Step02_AddResponse;
import nPRICED_US.Step03_Finalize;


public class AddResponse
{
	// TestNG logger

	public static Logger log = Logger.getLogger("TnM");

	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	public String sheet="Login"; 
	public String url;
	public String id;
	public String paswd;
	public String id_green;
	public String paswd_green;
	public String url_green;
	public String url2;

	public WebDriver driver;


	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SriSwathiAnushaNulu\\Documents\\Project csa\\Softwares\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();

		//System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver();

		//id = Excel.getCellValue(xlsFilePath, sheet, 2, 0);
		//paswd = Excel.getCellValue(xlsFilePath, sheet, 2, 1);
		url = Excel.getCellValue(xlsFilePath, sheet, 2, 2);

		//String url1 = "https://" +  id + ":" + paswd + "@" + url;

		driver.get(url);  
		driver.manage().window().maximize();

	}	



	// Test to add response
	@Test(priority=0)
	public void add_response() throws IOException
	{
		log.debug("Inside open_CSA_Tab() function");

		Step02_AddResponse addresp = new Step02_AddResponse(driver); 
		addresp.login();
		addresp.openRequest();

		for (int i=1; i<4; i++)
		{
			if(i==1)
			{

				addresp.FillRespdetails("fResp"+i , "US" , "lResp"+i, "100", "10");
			}  
			else if(i==2)
			{
				//addresp.login();
				addresp.FillRespdetails("fResp"+i , "US" , "lResp"+i, "120", "10");
			}
			else
			{
				//addresp.login();
				addresp.FillRespdetails("fResp"+i , "US" , "lResp"+i, "150", "10");
				
			}
		}
		addresp.Submit();
	}
}




