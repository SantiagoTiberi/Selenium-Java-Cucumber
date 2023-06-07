package pages;

public class GooglePage extends BasePage{ //hereda las caracteristicas de BasePage
    
    public GooglePage(){ //al heredar se debe llamar al sconstructor que es esto
        super(driver);


    }

    public void navigateToGoogle(){

        navigateTo("https://www.google.com");
    }
}
