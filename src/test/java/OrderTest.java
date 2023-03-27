import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OrderTest extends CommonBaseTest {

    // Тест заказа через кнопку вверху страницы
    @Test
    public void OrderingByHeaderOrderButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickHeaderOrderButton();

        new OrderPage(driver)
                .fillTheFirstName("Тест")
                .fillTheLastName("Тестович")
                .fillTheAddress("Москва, Ленинградское шоссе, д.1")
                .fillTheStationMetro("Черкизовская")
                .fillThePhone("+79111111111")
                .clickNextButton();

        boolean isDisplayed = new RentPage(driver)
                .selectRentalDate()
                .selectRentalTime()
                .clickCheckBoxBlackPearl()
                .rentComment("Домофон не работает")
                .clickRentButton()
                .clickButtonYes()
                .displayedOrderWindow();
        assertTrue("Ошибка - не открывается окно с номером заказа", isDisplayed);
    }
    //Тест заказа через кнопку в середине страницы
    @Test
    public void OrderingByBelowOrderButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickBelowOrderButton();

        new OrderPage(driver)
                .fillTheFirstName("ТестТест")
                .fillTheLastName("Тестовна")
                .fillTheAddress("Москва, ул. Академика Павлова, д.1")
                .fillTheStationMetro("Чистые пруды")
                .fillThePhone("+79222222222")
                .clickNextButton();

        boolean isDisplayed = new RentPage(driver)
                .selectRentalDate()
                .selectRentalTime()
                .clickCheckBoxGreyDespair()
                .rentComment("Домофон 123456")
                .clickRentButton()
                .clickButtonYes()
                .displayedOrderWindow();
        assertTrue("Ошибка - не открывается окно с номером заказа", isDisplayed);
    }

}
