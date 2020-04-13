package nPRICED_IN;


import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import lib.Excel;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step05_CRB_Auth_IN {
 
  
  private WebDriver driver;
	
	// Define the element 
  @FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
  @FindBy ( id="btn_signin") private WebElement Signin_Button ;
  @FindBy ( xpath=".//*[@id='desktop']") private WebElement Username_Box ;
  @FindBy ( xpath=".//*[@id='body']/div[1]/div[2]/div/div/form/input[4]") private WebElement Password_Box ;
	
	// Define all web elements under test displayed on home page
		@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Switch instance')]") private WebElement Switch_Instance;
		@FindBy (id="FLD_SELECT_INSTANCE") private WebElement Instance ;
		@FindBy (name="btnGo") private WebElement GO ;
		@FindBy (xpath = ".//*[@value='Exit request'] ") private WebElement ExitRequest;
		@FindBy (xpath = ".//*[@id='content-main']/form/table[1]/tbody/tr[1]/td[3]/a") private WebElement SkillLink ;
		@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Awaiting client review board action')]") private WebElement Awaiting_CRB_auth_link ;
		@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Candidates')]") private WebElement Candidates ;
		@FindBy (id="FLD_REQUEST_NUMBER") private WebElement Req_Num_Search ;
		@FindBy (name="btnGo") private WebElement GO_reqnum ;
		@FindBy (name = "btnAuthCandidate") private WebElement Auth_Link;
		@FindBy (xpath =" .//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[3]/a" ) private WebElement Request_Number ;
		           
		
		@FindBy (xpath = ".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[5]/a" ) private WebElement Skill_link ;
		@FindBy(name="tblcolCandId") private WebElement  Select_Checkbox ;
		@FindBy (name="btnAuthSel") private WebElement Authorize_selected ;
		@FindBy (name ="btnRejectSel") private WebElement Reject;
		@FindBy (name ="btnRejectCandidate") private WebElement Reject_Cand;
		@FindBy( name = "btnReturnAsFinalistCandidate") private WebElement Return_Cand;
		@FindBy (xpath = ".//*[@id='finalCandForm']/table[3]/tbody/tr/td[2]/input") private WebElement Reject_sel;
		@FindBy (name = "FLD_REJ_REASON") private WebElement Reason;
		@FindBy (name = "txtReturnSelAsFinalist") private WebElement Return;
		@FindBy (name ="txtSaveAndReturnAsFinalist") private WebElement Save_Return;
		@FindBy (xpath=".//*[@id='FLD_CMTS_TO_REQSTR']") private WebElement ReturnReason;
		@FindBy (xpath=".//*[@id='FLD_CMTS_TO_REQSTR']") private WebElement Comments;
		//@FindBy(xpath = ".//*[@value='002~S23CZG~001~1000118974~IBMSAPGC0~AUTH~0'] ") private WebElement  Resp2_Checkbox ;
		//@FindBy(xpath = ".//*[@value='003~S23CZG~001~1000118974~IBMSAPGC0~AUTH~0'] ") private WebElement  Resp3_Checkbox ;
		@FindBy(xpath = ".//*[@value='001~S23CZG~001~1000118974~IBMSAPGC0~AUTH~0'] ") private WebElement  Resp1_Checkbox ;
		
		@FindBy (xpath= ".//*[@id='content-main']/form/table[3]/tbody/tr[2]/td[5]/a") private WebElement service_identification;
		@FindBy (name="FLD_CMTS_TO_REQSTR") private WebElement CommentsToRequester ;

	    @FindBy (name="btnAuthCandidate") private WebElement Auth_Button;
	    @FindBy (name="btnAuthSel") private WebElement Auth_Selected_Button;
	    
		public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
		 public String sheet="Login";
	// Initialize the web elements 
	public Step05_CRB_Auth_IN(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// Function to login to the application
	
	public void login()
	{
		
		WebDriverWait wait00 = new WebDriverWait(driver, 180);
		wait00.until(ExpectedConditions.visibilityOf(loginToContractor_Link));
		
		loginToContractor_Link.click();
		
		WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(Signin_Button));
				
		Username_Box.clear();
		Username_Box.sendKeys(Excel.getCellValue(xlsFilePath, sheet, 15, 0));
		Password_Box.clear();
		Password_Box.sendKeys(Excel.getCellValue(xlsFilePath, sheet, 15, 1));
		
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\SriSwathiAnushaNulu\\Documents\\Project csa\\Practice Automation\\NPrice\\Ind");
		
		Signin_Button.click();
  
    }

	//Function to click Create New Request button
    public void crb_auth()
    {
    	
		
		WebDriverWait wait02 = new WebDriverWait(driver, 180);
		wait02.until(ExpectedConditions.visibilityOf(Awaiting_CRB_auth_link));
				
		Awaiting_CRB_auth_link.click();
		
		WebDriverWait wait03 = new WebDriverWait(driver, 180);
		wait03.until(ExpectedConditions.visibilityOf(Candidates));
		
		Candidates.click();
		
		WebDriverWait wait04 = new WebDriverWait(driver, 180);
		wait04.until(ExpectedConditions.visibilityOf(Req_Num_Search));
		
		Req_Num_Search.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 15));
		GO_reqnum.click();

		String Req_Num = Excel.getCellValue(xlsFilePath, "Request_creation", 3, 15) ;
		
		WebDriverWait wait05 = new WebDriverWait(driver, 160);
		wait05.until(ExpectedConditions.visibilityOf(Request_Number)); 
		
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\SriSwathiAnushaNulu\\Documents\\Project csa\\Practice Automation\\NPrice\\Ind");
		
		Request_Number.click();
			
		//Resp Selection Page
	    WebDriverWait wait06 = new WebDriverWait(driver, 160);
		wait06.until(ExpectedConditions.visibilityOf(service_identification));
	
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\SriSwathiAnushaNulu\\Documents\\Project csa\\Practice Automation\\NPrice\\Ind");
		
		service_identification.click();
		
		WebDriverWait wait08 = new WebDriverWait(driver, 160);
		wait08.until(ExpectedConditions.visibilityOf(Auth_Button)); 
		
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\SriSwathiAnushaNulu\\Documents\\Project csa\\Practice Automation\\NPrice\\Ind");
		
		Auth_Button.click();
		
		WebDriverWait wait09 = new WebDriverWait(driver, 160);
		wait09.until(ExpectedConditions.visibilityOf(CommentsToRequester)); 
		
		CommentsToRequester.sendKeys("Approved");
			
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\SriSwathiAnushaNulu\\Documents\\Project csa\\Practice Automation\\NPrice\\Ind");
		
		Auth_Selected_Button.click();

	
	
    }
    
	}
