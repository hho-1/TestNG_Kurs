package _05_SomeAdditionalTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _03_PlaceOrderElements {

    public _03_PlaceOrderElements(WebDriver driver) {        //Bu constructor asagidaki elementlerin hepsinin Webdriver baglantisini sagliyor
        PageFactory.initElements(driver, this);        //Bu sekilde bu elemanlar ancak kendilerinden bir nesne uretildigi zaman aktif oluyorlar.
                                                            //Bu yapinin adi Page Object Model (POM)
    }

    @FindBy(css="input.form-control.input-lg")
    public WebElement searchBox;

    @FindBy(className = "input-group-btn")
    public WebElement searchButton;

    @FindBy(xpath = "//span[text()='Add to Cart']")
    public WebElement addToCart;

    @FindBy(linkText = "Shopping Cart")
    public WebElement shoppingCart;

    @FindBy(css = "i.fa.fa-share")
    public WebElement checkout;

    @FindBy(id = "button-payment-address")
    public WebElement continue1;

    @FindBy(id = "button-shipping-address")
    public WebElement continue2;

    @FindBy(id = "button-shipping-method")
    public WebElement continue3;

    @FindBy(name = "agree")
    public WebElement agree;

    @FindBy(id = "button-payment-method")
    public WebElement continue4;

    @FindBy(id = "button-confirm")
    public WebElement confirm;

    @FindBy(css = "[id='content'] > h1")
    public WebElement confirmText;

    @FindBy(id = "wishlist-total")
    public WebElement wishList;
}
