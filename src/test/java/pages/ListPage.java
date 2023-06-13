package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ListPage extends BasePage {

    private String searchField = "/html[1]/body[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]";
    private String searchResults = "lista";

    public ListPage(){ //costructor
        super(driver);
    }

    public void navigateToListPage(){
        navigateTo("https://www.argentinaturismo.com.ar/destinos.html");
    }
    


    public void enterSearchCriteria(String state) throws InterruptedException {
        try{
        Thread.sleep(600);
        write(searchField, state);
        Thread.sleep(600);
        }catch(NoSuchElementException e){
            System.out.println("The WebElement Search Field couldn't be found.");
            e.printStackTrace();
        }
    }

    public List<String> getAllSearchResults(){
        List<WebElement> list = bringMeAllElements(searchResults);
        List<String> stringsFromList = new ArrayList<String>();

        for(WebElement e :list){
            stringsFromList.add(e.getText());
        }
        return stringsFromList;
    }
}