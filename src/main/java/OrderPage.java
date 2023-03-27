import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    public OrderPage(WebDriver driver){
        this.driver = driver;
    }
    private final WebDriver driver;
    //Локаторы для страницы оформления самоката
    private final By orderFirstName = By.xpath(".//input[@placeholder='* Имя']"); //Поле ввода Имени
    private final By orderLastName = By.xpath(".//input[@placeholder='* Фамилия']"); //Поле ввода Фамилии
    private final By orderAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); //Поле ввода адреса
    private final By orderStationMetro = By.xpath(".//input[@placeholder='* Станция метро']"); //Поле ввода станции метро
    private final By orderPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); //Поле ввода телефона
    private final By nextButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]"); //Кнопка далее

    //Методы заполнения полей заказа
    //Метод заполнения поля Имя
    public OrderPage fillTheFirstName(String firstName) {
        driver.findElement(orderFirstName).sendKeys(firstName);
        return this;
    }
    //Метод заполнения поля Фамилия
    public OrderPage fillTheLastName(String lastName) {
        driver.findElement(orderLastName).sendKeys(lastName);
        return this;
    }
    //Метод заполнения поля Адресс
    public OrderPage fillTheAddress(String address) {
        driver.findElement(orderAddress).sendKeys(address);
        return this;
    }
    //Метод выбора станции метро
    public OrderPage fillTheStationMetro(String metro) {
        driver.findElement(orderStationMetro).click();
        driver.findElement(orderStationMetro).sendKeys(metro);
        driver.findElement(orderStationMetro).sendKeys(Keys.DOWN,Keys.ENTER);
        return this;
    }
    //Метод заполнения поля телефон
    public OrderPage fillThePhone(String phone) {
        driver.findElement(orderPhone).sendKeys(phone);
        return this;
    }
    //Метод клика по кнопке Далее
    public OrderPage clickNextButton() {
        driver.findElement(nextButton).click();
        return this;
    }

}
