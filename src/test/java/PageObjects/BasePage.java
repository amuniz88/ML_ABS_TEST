package PageObjects;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage extends BasePO{

    protected navigatePage npage;
    protected Catalogo cata;

    public BasePage(WebDriver driver){
        super(driver);
        npage = new navigatePage(driver);
    }

    public CarList goToBuscarProducto(String producto){
        return npage.searchProduct(producto);
    }

    public void clickElement(WebElement webElement){
        SeleniumUtils.clickElement(webElement, wait);
    }
    public void setText(WebElement webElement, String text){ SeleniumUtils.setText(webElement, wait, text); }
}
