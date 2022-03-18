package keyword;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import javax.swing.text.html.parser.Element;

import static object.repository.ObjectRepository.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class Keyword {

    private static WebDriver driver;
    
    public static void clickOn(String xPath) {
    	driver.findElement(By.xpath(xPath)).click();
    }
    
    public static void ouvrirNavigateur(String website) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(website);
        driver.switchTo().defaultContent();
    }

    public static void fermerNavigateur() {
        driver.quit();
    }

    public static void saisirCaracteristiquesVehicule(Object marque, Object modele, Object carburant) {
    	driver.findElement(By.xpath(xpath_marque)).sendKeys((CharSequence[]) marque);
    	driver.findElement(By.xpath(xpath_modele)).sendKeys((CharSequence[]) modele);
    	driver.findElement(By.xpath(xpath_carburant)).sendKeys((CharSequence[]) carburant);
    	
    }
    
    public static void saisirAnneeMiseEnCirculation(Object annee) {
    	driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[5]/div/input")).sendKeys((CharSequence[]) annee);
    }
    
    public static void saisirLesDonneesConducteur(Object datePermis, Object codePostal, Object nom) {
    	driver.findElement(By.xpath(xpath_datepermis)).sendKeys((CharSequence[]) datePermis);
    	driver.findElement(By.xpath(xpath_codepostal)).sendKeys((CharSequence[]) codePostal);
    	driver.findElement(By.xpath(xpath_nom)).sendKeys((CharSequence[]) nom);
    	
    }
    
    public static void saisirBonusMalus(Object bonusOuMalus) {
    	driver.findElement(By.xpath(xpath_bonusetmalus)).sendKeys((CharSequence[]) bonusOuMalus);
    	
    }
    
    public static void choisirAssuranceAuTiers() {
    	WebElement selectElement = driver.findElement(By.id("thirdParty"));
    	new Select(selectElement);
    }
    
    public static void choisirAssurenceTousRisques() {
    	WebElement selectElement = driver.findElement(By.id("comprehensive"));
    	new Select(selectElement);
    }
    
    public static void simulerEtVerifierTarif(String tarif) {
    	saisirCaracteristiquesVehicule("Citroën", "Berlingo", "Petrol");
    	saisirAnneeMiseEnCirculation(2019);
    	saisirLesDonneesConducteur("01/01/2010", "33320", "John Doe");
    	saisirBonusMalus(10);
    	choisirAssuranceAuTiers();
    	clickOn(xpath_simuler);
    }
    
    public static void verifierMessageErreur() {
    	Thread.sleep(5000);
		WebElement element = waitWebElement(carErrorField);
        if(element == null){
            Assert.fail("Element non trouve :" + carErrorField);
        }
        else {
            if(element.getText().equals("Vehicule non trouve")){
                Assert.assertTrue(true);
            }
            else {
                Assert.fail("Message incorrect : " + element.getText() + ", attendu : " + "Vehicule non trouve" );
            }
        }
    }
    
    public static void wait (int temps) throws InterruptedException {
        Thread.sleep(2000);
    }
    
    public static void checkMessage (String xpath, String text) {
        
    }
    
    public static void select (String xpath, Object text) {
    	new Select((WebElement) text);
    }
    
    public static void checkIsElementPresent (String xpath) {
		WebElement element = waitWebElement(xpath);
        if(element == null){
            Assert.fail("Element non present :" + xpath);
        }
    }
        
    public static WebElement waitWebElement (String xpath) {
        return null;
    }
}
