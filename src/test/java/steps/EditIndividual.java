package steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.NewIndividualPage;
import Pages.VerifyPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EditIndividual extends BaseClass
{
	@And ("navigate to individuals from App launcher for edit")
	public void SendIndividual() throws InterruptedException
	{
	//click toggle button 
	driver.findElement(By.xpath("//div[@class='appLauncher slds-context-bar__icon-action']")).click();
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//label[text()='Search apps or items...']/following::input")).sendKeys("Individuals");;
	driver.findElement(By.xpath("//mark[text()='Individuals']")).click();
	}
	
	@Then("^give data for first name to edit$")
	public void givedata(DataTable table) throws InterruptedException
	{
	List<List<String>> rows = table.asLists();
	WebDriverWait wait= new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search this list...']"))).sendKeys(rows.get(1).get(0));
	driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);		
    WebElement drpDwn = driver.findElement(By.xpath("//span[text()='Show Actions']/ancestor::a[1]"));
	driver.executeScript("arguments[0].click();", drpDwn);
	}
	
	@And ("Click Edit")
	public void EditIndividuals() throws InterruptedException 
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		
	}
	
	@Then("^Edit data for first name$")
	public void Editdata(DataTable table)
	{
		List<List<String>> rows = table.asLists();
		driver.findElement(By.xpath("(//a[@class='select'])[1]")).click();
		driver.findElement(By.linkText("Mrs.")).click();
		driver.findElement(By.xpath("(//span[text()='*']/following::input)[1]")).sendKeys(rows.get(1).get(0));
		
	}
	
	@And ("click save")
	public void ClickSave()
	{

	driver.findElement(By.xpath("//button[@title='Save']")).click();
			
	}
	
	
	@And ("verify edited message")
	public void verifymessage() throws InterruptedException 
	{
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//div[@class='toastContent slds-notify__content']")).getText();
        System.out.println(text);
	}
	
	
}
