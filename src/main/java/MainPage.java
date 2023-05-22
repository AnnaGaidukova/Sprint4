//package java;

import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.Assert.assertEquals;
public class MainPage {
    public MainPage(WebDriver driver){

        MainPage.driver = driver;
    }
    private static WebDriver driver;
    private static String url = "https://qa-scooter.praktikum-services.ru/";
    //Локаторы для главной страницы
    private final By cookieButton = By.className("App_CookieButton__3cvqF"); //поп-ап с кнопкой принять куки
    private final By headerOrderButton = By.className("Button_Button__ra12g"); //кнопка Заказать вверху страницы
    private final By belowOrderButton= By.className("Button_UltraBig__UU3Lp"); //кнопка заказать, которая по-середине Button_Button__ra12g Button_UltraBig__UU3Lp

    private static final String headingSelector = "accordion__heading-"; // шаблон селектора вопроса
    private static final String panelSelector = "accordion__panel-"; // шаблон селектора ответа

    //Методы (открыть, кликнуть, сравнить и т.д.)
    //метод открыть сайт
    public final MainPage openSite() {
        driver.get(url);
        return this;
    }
    //метод кликнуть по кнопке принятия куки
    public MainPage clickCookieButton() {
        driver.findElement(cookieButton).click();
        return this;
    }
    //метод кликнуть по верхней кнопке Заказть
    public MainPage clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
        return this;
    }
    public MainPage clickBelowOrderButton() {
        driver.findElement(belowOrderButton).click();
        return this;
    }
    //Проскроллить страницу до последнего вопроса
    public MainPage scrollToEndOfList() {
        WebElement lastQuestionArrow = driver.findElement(By.id(headingSelector+7));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastQuestionArrow);
        return this;
    }
    //клик по вопросу
    public static void clickQuestionArrow(int questionNumber) {
        new WebDriverWait(driver,Duration.ofSeconds(9))
                .until(ExpectedConditions.elementToBeClickable(By.id(headingSelector+questionNumber)));
        driver.findElement(By.id(headingSelector+ questionNumber)).click();
    }
    //Проверить вопрос-ответ
    public static void checkTextQuestions(String expectedText, int answerNumber) {
        new WebDriverWait(driver,Duration.ofSeconds(9)).until(ExpectedConditions.visibilityOfElementLocated(By.id(panelSelector + answerNumber)));
        String answerText = driver.findElement(By.id(panelSelector + answerNumber)).getText();
        assertEquals(expectedText, answerText);
    }
    public MainPage clickQuestionButton(String numberSelector) {
        new WebDriverWait(driver, Duration.ofSeconds(9))
                .until(ExpectedConditions.elementToBeClickable(By.id(headingSelector + numberSelector)));
        driver.findElement(By.id(headingSelector + numberSelector)).click();
        return this;
    }
    public static String getAnswerText(String numberSelector) {
        new WebDriverWait(driver, Duration.ofSeconds(9))
                .until(ExpectedConditions.elementToBeClickable(By.id(panelSelector + numberSelector)));
        return driver.findElement(By.id(panelSelector + numberSelector)).getText();
    }

}
