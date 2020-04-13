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
import org.apache.log4j.Logger;

import lib.Excel;
import nPRICED_GB.Step01_CreateRequest_GB;
import nPRICED_IN.Step01_CreateRequest_IN;
import nPRICED_US.Step01_CreateRequest;
import nPRICED_US.Step02_AddResponse;
import nPRICED_US.Step03_Finalize;


public class CreateRequest_IN
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
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SriSwathiAnushaNulu\\Documents\\Project csa\\Softwares\\chromedriver_win32\\chromedriver.exe");
//		driver = new ChromeDriver();

		//id = Excel.getCellValue(xlsFilePath, sheet, 12, 0);
		//paswd = Excel.getCellValue(xlsFilePath, sheet, 12, 1);
		url = Excel.getCellValue(xlsFilePath, sheet, 12, 2);

		//String url1 = "https://" +  id + ":" + paswd + "@" + url;

		driver.get(url); 
		driver.manage().window().maximize();
	}	

	// test to Login to the application as RIPC
	@Test(priority=0)
	public void RIPC_Login() 
	{

		Step01_CreateRequest_IN login = new Step01_CreateRequest_IN(driver);
		login.login();
		login.Create_New_Request();
		login.Skill_Request();
		login.Select_Requestor();
		login.Select_JRSS();
		login.Request_detailpage();
		login.Skill_detailLocationpage();
		login.isAlertPresent();
		login.Skill_detail_skillpricepage();
		login.SupplierSelectionPage();

				
	}


}
