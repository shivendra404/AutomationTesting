package org.kgisl.utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static void launchBrowser() {
		
//		System.setProperty("webdriver.chrome.driver", "D:\\KGMTesting\\SeleniumKGM\\Drivers\\chromedriver.exe" );
//		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	
	public static void windowMaximize() {
		driver.manage().window().maximize();
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	public void pageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	public void pageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}
	
	public static void passText(String txt, WebElement ele) {
		ele.sendKeys(txt);
	}
	
	public void closeEntireBrowser() {
		driver.quit();
	}
	
	public void clickBtn(WebElement ele) {
		ele.click();
	}
	
	public static void screenShot(String imgName) throws IOException {
	    // Define screenshot folder path (inside your project directory)
	    String folderPath = System.getProperty("user.dir") + "/bugShots";

	    // Create the folder if it doesn't exist
	    File screenshotFolder = new File(folderPath);
	    if (!screenshotFolder.exists()) {
	        screenshotFolder.mkdirs();
	    }

	    // Take screenshot
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File image = ts.getScreenshotAs(OutputType.FILE);

	    // Define full image path
	    LocalDateTime d = LocalDateTime.now();
	    String fileName = d.toString().replace(":", "_").replace(" ", "_")+"_"+imgName + ".png";
	    String imagePath = folderPath + "/" + fileName ;
	    File destination = new File(imagePath);

	    // Copy the image to the destination folder
	    FileUtils.copyFile(image, destination);
	}
	
	public static void scrollToElement( WebElement element) {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	
	public static Actions a;
	
	public void moveTheCursor(WebElement targetWebElement) {
		a = new Actions(driver);	
		a.moveToElement(targetWebElement).perform();
	}
	
	public void dragDrop(WebElement dragWebElement, WebElement dropWebElement) {
		a = new Actions(driver);	
		a.dragAndDrop(dragWebElement, dropWebElement);
	}
	
	public static JavascriptExecutor js;

	public void scrollThePage(WebElement tarWebEle) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tarWebEle);
	}
	
	public void scroll(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public static void Dropdown(String xPath) {
		WebElement Menu = driver.findElement(By.xpath(xPath));
		
		Select selectMenu = new Select(Menu);
		selectMenu.selectByIndex(2);
	}
	
//	public void excelRead(String sheetName, int rollNum, int cellNum) throws IOException {
//		File f = new File ("excellocation.xlsx");
//		FileInputStream fis = new FileInputStream(f);
//		Workbook wb = new XSSFWorkbook(fis);
//		Sheet mySheet = wb.getSheet("Data");
//		Row r = mySheet.getRow(rollNum);
//		Cell c = r.getCell(cellNum);
//		int cellType = c.getCellType();
//		
//		String value = " ";
//		if(cellType == 1) {
//			String value2 = c.getStringCellValue();
//		}	
//		else if (DateUtil.isCellDateFormatted(c)) {			
//			Date dd = c.getDateCellValue(); // To get the date format cell values			
//			SimpleDateFormat s = new SimpleDateFormat(value); // To specify the user format of the date			
//			String value1 = s.format(dd); // To convert the date format to string format
//			System.out.println(value1); // Print the convert value
//		}
//
//		else {
//			double numericCellValue = c.getNumericCellValue();
//			long l = (long) numericCellValue; // Down casting is done to change the double data to long data type			
//			String valueOf = String.valueOf(l);// To convert the value into string format
//			System.out.println(valueOf);
//		}
//	}

//		public static void createNewExcelFile(int rowNum, int cellNum, String writeData) throws IOException {
//			File f = new File ("C:\\Users\\HARISH D\\eclipse-workspace\\BaseClass\\Excel\\NewAssignmentSampleFile.xlsx");
//			Workbook wb = new XSSFWorkbook();
//			Sheet newSheet = wb.createSheet("Sheet1");
//			Row newRow = newSheet.createRow(rowNum);
//			Cell newCell = newRow.createCell(cellNum);
//			newCell.setCellValue(writeData);
//			FileOutputStream fos = new FileOutputStream(f);
//			wb.write(fos);
//		}
//		public static void createCell(int getRow, int creCell, String newData) throws IOException {
//			File f = new File("C:\\Users\\HARISH D\\eclipse-workspace\\BaseClass\\Excel\\NewAssignmentSampleFile.xlsx");
//			FileInputStream fis = new FileInputStream(f);
//			Workbook wb = new XSSFWorkbook(fis);
//			Sheet sheet = wb.getSheet("Sheet1");
//			Row row = sheet.getRow(getRow);
//			
//			if(row==null) {	
//		         row = sheet.createRow(getRow);  
//			}
//			
//			Cell createCell = row.createCell(creCell);
//			createCell.setCellValue(newData);
//			FileOutputStream fos = new FileOutputStream(f);
//			wb.write(fos);	
//		}
//		
//		public static void createRow(int creRow, int creCell, String data) throws IOException {
//			File f = new File("C:\\Users\\HARISH D\\eclipse-workspace\\BaseClass\\Excel\\NewAssignmentSampleFile.xlsx");
//			FileInputStream fis = new FileInputStream(f);
//			Workbook wb = new XSSFWorkbook(fis);
//			Sheet sheet = wb.getSheet("Sheet1");
//			Row row = sheet.getRow(creRow);
//			Cell createCell = row.createCell(creCell);
//			createCell.setCellValue(data);
//			FileOutputStream fos = new FileOutputStream(f);
//			wb.write(fos);	
//		}
//		
//		public void updateDataToParticularCell(int getTheRow, int getTheCell, String existingData, String newData) throws IOException {
//			File f = new File("C:\\Users\\HARISH D\\eclipse-workspace\\BaseClass\\Excel\\SampleFile.xlsx");
//			FileInputStream fis = new FileInputStream(f);
//			Workbook wb = new XSSFWorkbook();
//			Sheet sheet = wb.getSheet("Data");
//			Row row = sheet.getRow(getTheRow);
//			Cell createdCell = row.createCell(getTheCell);
//			String str = createdCell.getStringCellValue();
//			
//			if(str.equals(existingData)) {
//				createdCell.setCellValue(newData);
//			}
//			FileOutputStream fos = new FileOutputStream(f);
//			wb.write(fos);	
//		}	
}
