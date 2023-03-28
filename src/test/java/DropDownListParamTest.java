import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
    @RunWith(Parameterized.class)
    public class DropDownListParamTest extends CommonBaseTest {
        private final String numberSelector;
        private final String answerText;

        //Конструктор класса

        public DropDownListParamTest(String numberSelector, String answerText) {
            this.numberSelector = numberSelector;
            this.answerText = answerText;
        }
//     //   Массив с вопросами для непараметризированного метода
//        private final String[] expectedAnswersList = new String[]{
//                "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
//                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
//                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
//                "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
//                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
//                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
//                "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
//                "Да, обязательно. Всем самокатов! И Москве, и Московской области."
//        };
//
        //Массив с текстом ожидаемых ответов
        @Parameterized.Parameters
        public static Object[][] expectedAnswersParamList() {
            return new Object[][]{
                    {"0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                    {"1", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                    {"2", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                    {"3", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                    {"4", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                    {"5", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                    {"6", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                    {"7", "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
            };
        }
        // {"0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},

        //Проверека непараметризированным методом
//        @Test
//        public void CheckDropDownListText() {
//            new MainPage(driver)
//                    .openSite()
//                    .clickCookieButton()
//                    .scrollToEndOfList();
//            for (int i = 0; i < 8; i++) {
//                MainPage.clickQuestionArrow(i);
//                MainPage.checkTextQuestions(expectedAnswersList[i], i);
//            }
//        }

        @Test
        public void dropDownListTest() {
            new MainPage(driver)
                    .openSite()
                    .clickCookieButton()
                    .scrollToEndOfList()
                    .clickQuestionButton(numberSelector);
          //  new MainPage(driver);
            assertEquals("Текст в ответе не соответствует ожидаемому тексту.", answerText, MainPage.getAnswerText(numberSelector));
        }
    }
