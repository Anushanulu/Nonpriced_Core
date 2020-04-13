package nPRICED_IN_main;

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
import nPRICED_IN.Step02_AddResponse_IN;


public class AddResponse_IN
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

//		System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
//		driver = new ChromeDriver();

		//id = Excel.getCellValue(xlsFilePath, sheet, 14, 0);
		//paswd = Excel.getCellValue(xlsFilePath, sheet, 14, 1);
		url = Excel.getCellValue(xlsFilePath, sheet, 14, 2);

		//String url1 = "https://" +  id + ":" + paswd + "@" + url;

		driver.get(url);  
		driver.manage().window().maximize();
	}	



	// Test to add response
	@Test(priority=0)
	public void add_response() throws IOException
	{
		log.debug("Inside open_CSA_Tab() function");

		Step02_AddResponse_IN addresp = new Step02_AddResponse_IN(driver); 
		addresp.login();
		addresp.openRequest();
		addresp.FillRespdetails("fResp1" , "IN" , "lResp1", "RefNum1", "09/09", "30");

//		for (int i=1; i<4; i++)
//		{
//			if(i==1)
//			{
//
//				addresp.FillRespdetails("fResp"+i , "IN" , "lResp"+i, "RefNum"+i, "40000");
//			}  
//			else if(i==2)
//			{
//				//addresp.login();
//				addresp.FillRespdetails("fResp"+i , "IN" , "lResp"+i,"RefNum"+i, "45000");
//			}
//			else
//			{
//				//addresp.login();
//				addresp.FillRespdetails("fResp"+i , "IN" , "lResp"+i,"RefNum"+i, "50000");
//				
//			}
//		}
		addresp.Submit();
	}
}




