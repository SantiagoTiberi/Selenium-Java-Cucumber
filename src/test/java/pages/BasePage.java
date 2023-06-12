//se crea una unica instancia del web driver y se comparte esta con las demas clases de paginas que heredaran esa funcionalidad (se aplica herencia y encapsulamiento)
package pages;


//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import io.cucumber.java.eo.Se;

public class BasePage { //en este caso se usara para tener abierta una ventana de chrome usando el webdriver descargado de chrome
    
    protected static WebDriver driver; //static es para que haya un solo valor para todas las instancias del objeto que se creara y se compartira para todas las clases
    private static WebDriverWait wait; 
    private static Actions action;
    
    static{ //bloque estatico que se ejecuta al comienzo de todo
        System.setProperty("webdriver.chrome.driver", "C:/Users/santibox/Documents/chromedriver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions); //se crea el objeto del driver usando las opciones de chrome
        wait = new WebDriverWait(driver, 10);//ESPERA EXPLICITA: espera 10 segundos probando a ue se habra el driver si no se abre en ese timepo tira error, con el until se hace que pruebe varias veces dentro de los 10 segundos pactados
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //ESPERA IMPLICITA: espera 10 segundos si o si para ejecutar el siguiente comando 
        //Thread.sleep(1000); //NO ES RECOMENDABLE USARLO(NO DEBERIA ESTA NUNCA EN AUTOMATION) ES MEJOR USAR LAS ESPERAS
    }

    public BasePage(WebDriver driver){ // Contructor de la clase (usa un objeto llamado driver)
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public static void navigateTo(String url){ //funcion de navegar
        driver.get(url);
    }

    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))); //espera hasta ...

    }

    public void clickElement(String locator){ //dado un xpath, lo localiza y hace click sobre ese elemnto en caso de localizarlo
        Find(locator).click();
    }

    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }

    public void hoverOverElement(String locator){  //es para marcar una palabra con el mouse
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator){
        action.contextClick(Find(locator));
    }

    public String getValueFromTable(String locator, int row, int column){
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        return Find(cellINeed).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String stringToSend){
        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        Find(cellToFill).sendKeys(stringToSend);
    }

    public void switchToiFrame(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public String textFromElement (String locator){
        return Find(locator).getText();

    }

        public boolean elementEnabled(String locator){
        return Find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(String locator){
        
        return Find(locator).isDisplayed();
    }

    public boolean elementIsSelected(String locator){

        return Find(locator).isSelected();
    }

}