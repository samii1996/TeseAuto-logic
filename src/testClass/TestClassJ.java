package testClass;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class TestClassJ {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.edge.driver", "D:\\firefox driver\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();

		driver.get("http://127.0.0.1:5555/index.html");

//		Date currentDate = new Date();
//		
//		String TheActualDate = currentDate.toString().replace(":", "-");
//
//		TakesScreenshot src = ((TakesScreenshot) driver);
//		File srcFile = src.getScreenshotAs(OutputType.FILE);
//		
//		File Dest = new File(".\\mypictures/"+TheActualDate +" .png");
//		FileUtils.copyFile(srcFile, Dest);

		List<WebElement> TheStudent = driver.findElements(By.tagName("option"));

		int TotalNumOfStudent = TheStudent.size();
		System.out.println("the total number for student is " + TotalNumOfStudent);

		int howManyIsStudents = 10;

		System.out.println("This is number i want to removed " + howManyIsStudents);

		for (int i = 0; i < howManyIsStudents; i++) {

			driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();

		}
		List<WebElement> TheStudentAfterRemoved = driver.findElements(By.tagName("option"));

		int ActualStudentNumber = TheStudentAfterRemoved.size();
		
		System.out.println("the actual student after delet " + ActualStudentNumber);

		int ExpectedNumberStudent = TotalNumOfStudent - howManyIsStudents;
		
		System.out.println("the expected value " + ExpectedNumberStudent);
		
		Assert.assertEquals(ActualStudentNumber, ExpectedNumberStudent);
	}

}
