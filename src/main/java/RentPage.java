import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentPage {
    public RentPage(WebDriver driver) {
        this.driver = driver;
    }
    private final WebDriver driver;
    //Локаторы для страницы оформления аренды
    private final By rentDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']"); //календарь когда привезти
    private final By lastDayInCalendar = By.xpath(".//div[contains(@class, 'react-datepicker__week')][last()]/div[contains(@class, 'react-datepicker__day')][last()]"); //последний день в календаре
    private final By rentTimeField = By.className("Dropdown-placeholder"); //поле с дропдауном
    private final By rentTime = By.xpath(".//*[(@role ='option' and text()='двое суток')]"); //выбор на сколько дней привезти
    private final By checkBoxBlackPearl = By.xpath(".//input[@id='black']"); // цвет черный
    private final By checkBoxGreyDespair = By.xpath(".//input[@id='grey']"); //цвет серый
    private final By rentComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By rentButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]"); //кнопка заказать
    private final By modalOrderWindow = By.xpath(".//div[contains(@class, 'Order_ModalHeader')]"); // Модальное окно
    private final By orderButtonYes = By.xpath(".//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]"); //Кнопка да в модальном окне
    public boolean displayedOrderWindow() {
        return driver.findElement(modalOrderWindow).isDisplayed();
    } //модальное окно заказ формлен

    //Методы заполнения аренды и оформления заказа
    //метод выбора даты, когда привезти самокат
    public RentPage selectRentalDate() {
        driver.findElement(rentDate).click();
        driver.findElement(lastDayInCalendar).click();
      //  driver.findElement(rentDate).sendKeys(Keys.ENTER);
        return this;
    }
    //метод выбора на сколько арендовать самокат
    public RentPage selectRentalTime() {
        driver.findElement(rentTimeField).click();
        driver.findElement(rentTime).click();
        return this;
    }
    //Выбрать черный цвет
    public RentPage clickCheckBoxBlackPearl() {
        driver.findElement(checkBoxBlackPearl).click();
        return this;
    }
    //Выбрать серый цвет
    public RentPage clickCheckBoxGreyDespair() {
        driver.findElement(checkBoxGreyDespair).click();
        return this;
    }
    //метод ввода комментария
    public RentPage rentComment(String userComment) {
        driver.findElement(rentComment).sendKeys(userComment);
        return this;
    }
    // метод кликнуть по кнопке заказать
    public RentPage clickRentButton() {
        driver.findElement(rentButton).click();
        return this;
    }
    //Метод кликнуть по кнопке Да
    public RentPage clickButtonYes() {
        driver.findElement(orderButtonYes).click();
        return this;
    }
}
