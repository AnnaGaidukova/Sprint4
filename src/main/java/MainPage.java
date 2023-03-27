//package java;

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
    //Локаторы для главной страницы
    private final By cookieButton = By.className("App_CookieButton__3cvqF"); //поп-ап с кнопкой принять куки
    private final By headerOrderButton = By.className("Button_Button__ra12g"); //кнопка Заказать вверху страницы
    private final By belowOrderButton= By.className("Button_UltraBig__UU3Lp"); //кнопка заказать, которая по-середине Button_Button__ra12g Button_UltraBig__UU3Lp

    //Массив Вопросов в виде кнопок-аккордионов
    private static final String[] accordionQuestionsArray = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"
    };
    //Массив выпадающих Ответов
    private static final String[] accordionAnswersArray = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"
    };
    //Методы (открыть, кликнуть, сравнить и т.д.)
    //метод открыть сайт
    public final MainPage openSite() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
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
        WebElement lastQuestionArrow = driver.findElement(By.id(accordionQuestionsArray[7]));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastQuestionArrow);
        return this;
    }
    //клик по вопросу
    public static void clickQuestionArrow(int questionNumber) {
        new WebDriverWait(driver,Duration.ofSeconds(9))
                .until(ExpectedConditions.elementToBeClickable(By.id(accordionQuestionsArray[questionNumber])));
        driver.findElement(By.id(accordionQuestionsArray[questionNumber])).click();
    }
    //Проверить вопрос-ответ
    public static void checkTextQuestions(String expectedText, int answerNumber) {
        new WebDriverWait(driver,Duration.ofSeconds(9)).until(ExpectedConditions.visibilityOfElementLocated(By.id(accordionAnswersArray[answerNumber])));
        String answerText = driver.findElement(By.id(accordionAnswersArray[answerNumber])).getText();
        assertEquals(expectedText, answerText);
    }
    public MainPage clickQuestionButton(String questionButtonLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(9))
                .until(ExpectedConditions.elementToBeClickable(By.id(questionButtonLocator)));
        driver.findElement(By.id(questionButtonLocator)).click();
        return this;
    }

}
