package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CarItem {

    WebElement element;

    public CarItem(WebElement main){
        this.element = main;
    }

    public String getName(){
        String name = element.findElement(By.className("main-title")).getText();
        return name;
    }

    public String getLink() {
        String link = element.findElement(By.xpath("//*[contains(@class,'item__info-link')]")).getAttribute("href");
        return link;

    }
}
