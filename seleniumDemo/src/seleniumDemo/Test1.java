package seleniumDemo;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public static String [][] arr= new String[143][3];

  @Before
  public void setUp() throws Exception {
	  String driverPath = "G:/geckodriver.exe";
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  driver = new FirefoxDriver();
	  baseUrl = "http://121.193.130.195:8800/";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBaidu() throws Exception {
	XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File("F:/»Ìº˛≤‚ ‘√˚µ•.xlsx")));
	XSSFSheet sheet = workbook.getSheetAt(0);
	for (int i = 2; i < sheet.getPhysicalNumberOfRows(); i++) {
		XSSFRow row = sheet.getRow(i);
		XSSFCell id = row.getCell(1);
		XSSFCell name = row.getCell(2);
		XSSFCell url = row.getCell(3);
		id.setCellType(HSSFCell.CELL_TYPE_STRING);
		arr[i - 2][0] = id.toString();
		arr[i - 2][1] = name.toString();
		arr[i - 2][2] = url.toString();
	} 
	  
	driver.get(baseUrl + "/");
    for(int k = 0; k < 143; k++) {
    	driver.findElement(By.name("id")).clear();
    	driver.findElement(By.name("id")).sendKeys(arr[k][0]);
    	driver.findElement(By.name("password")).clear();
    	driver.findElement(By.name("password")).sendKeys(arr[k][0].substring(4));
    	driver.findElement(By.id("btn_login")).click();
    	assertEquals(arr[k][0], driver.findElement(By.id("student-id")).getText());
    	assertEquals(arr[k][1], driver.findElement(By.id("student-name")).getText());
    	assertEquals(arr[k][2], driver.findElement(By.id("student-git")).getText());
    	driver.findElement(By.id("btn_logout")).click();
    	driver.findElement(By.id("btn_return")).click();
    }
    
  }

  @After
  public void tearDown() throws Exception {
	  driver.quit();
  }

}


