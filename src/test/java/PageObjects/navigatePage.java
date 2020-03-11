package PageObjects;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class navigatePage {

    @FindBy(name = "as_word")
    WebElement txt_searchProduct;

    @FindBy(xpath = "//button[@class='nav-search-btn']")
    WebElement btn_search;

    WebDriver driver;
    WebDriverWait wait;

    public navigatePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public CarList searchProduct(String prod){
        SeleniumUtils.setText(txt_searchProduct, wait, prod);
        SeleniumUtils.clickElement(btn_search, wait);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("breadcrumb__title")));
        return new CarList(driver);
    }
}
