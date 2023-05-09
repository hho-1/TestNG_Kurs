package _05_SomeAdditionalTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _05_WishListPOM {


    public _05_WishListPOM(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="input.form-control.input-lg")
    public WebElement searchBox;

    @FindBy(className = "input-group-btn")
    public WebElement searchButton;

    @FindBy(css = "div.caption>h4>a")
    List<WebElement> searchResults;

    @FindBy(css = "button[data-original-title='Add to Wish List']")
    List<WebElement> addToWishListButtons;

    @FindBy(id = "wishlist-total")
    public WebElement wishList;

    @FindBy(css = "td[class='text-left']>a")
    List<WebElement> tableNames;
}
