package pages;

public class GooglePage extends BasePage{ //hereda las caracteristicas de BasePage
    
    private String searchButton = "//input[@value='Buscar con Google']";
    private String searchTextField = "//textarea[@id='APjFqb']";
    private String firstResult = "";

    public GooglePage(){ //al heredar se debe llamar al sconstructor que es esto
        super(driver);
    }

    public void navigateToGoogle(){

        navigateTo("https://www.google.com");
    }

    public void clickGoogleSearch(){
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria){
        write(searchTextField, criteria);
    }

    public String firstResult(){
        return textFromElement(firstResult);
    }


}
