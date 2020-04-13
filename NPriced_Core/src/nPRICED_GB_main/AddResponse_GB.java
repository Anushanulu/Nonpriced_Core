package nPRICED_GB_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.log4j.Logger;

import lib.Excel;
import nPRICED_GB.Step02_AddResponse_GB;


public class AddResponse_GB
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

		//ProfilesIni ini = new ProfilesIni();
		//FirefoxProfile profile = ini.getProfile("default");
		//WebDriver driver =  new FirefoxDriver(profile);

		driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SriSwathiAnushaNulu\\Documents\\Project csa\\Softwares\\chromedriver_win32\\chromedriver.exe");
//		driver = new ChromeDriver();


		//id = Excel.getCellValue(xlsFilePath, sheet, 8, 0);
		//paswd = Excel.getCellValue(xlsFilePath, sheet, 8, 1);
		url = Excel.getCellValue(xlsFilePath, sheet, 8, 2);

		//String url1 = "https://" +  id + ":" + paswd + "@" + url;

		driver.get(url); 
		driver.manage().window().maximize();
	}	



	// Test to add response
	@Test(priority=0)
	public void add_response() throws IOException
	{
		log.debug("Inside open_CSA_Tab() function");

		Step02_AddResponse_GB addresp = new Step02_AddResponse_GB(driver); 
		addresp.login();
		addresp.openRequest();
		addresp.FillRespdetails("fResp" , "GB" , "lResp", "09/09", "200");
//		for (int i=1; i<4; i++)
//		{
//			if(i==1)
//			{
//				
//				addresp.FillRespdetails("fResp"+i , "GB" , "lResp"+i, "09/09", "700");
//			}  
//			else if(i==2)
//			{
//				//addresp.login();
//				addresp.FillRespdetails("fResp"+i , "GB" , "lResp"+i, "10/10", "800");
//			}
//			else
//			{
//				//addresp.login();
//				addresp.FillRespdetails("fResp"+i , "GB" , "lResp"+i, "11/11", "900");
//				
//			}
//		}
//		addresp.Submit();
	}
}




