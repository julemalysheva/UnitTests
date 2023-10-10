package five;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        // Установите путь к драйверу браузера Chrome
        System.setProperty("webdriver.chrome.driver",
                "D:\\JavaProjects\\UnitTests\\unitTests5\\chromedriver.exe");
        // Опциональные настройки браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Максимизация окна браузера
        // Инициализация WebDriver
        WebDriver driver = new ChromeDriver(options);
        // Открытие главной страницы Google
        driver.get("https://www.google.com");
        // Находим элемент поисковой строки и вводим текст "Selenium"
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");

        // Нажимаем кнопку "Поиск в Google"
        searchBox.submit();

        sleep(1000);
        // Ожидание появления результатов поиска
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".g"))); //.rc

        // Поиск ссылки на официальный сайт Selenium
        WebElement officialLink = driver.findElement(By.partialLinkText("Selenium"));

// Проверка, что ссылка действительно присутствует среди результатов поиска
        if (officialLink != null) {
            System.out.println("Ссылка на официальный сайт Selenium найдена.");
        } else {
            System.out.println("Ссылка на официальный сайт Selenium не найдена.");
        }

// Завершение сеанса браузера
        driver.quit();
    }
}

/*
        Для указания типа Duration вместо int 10 в методе WebDriverWait можно
                использовать следующий код:
        import java.time.Duration;

        // создание объекта Duration с указанием временного интервала
        Duration timeout = Duration.ofSeconds(10);
        // использование объекта Duration в методе WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Таким образом, вы указываете тип Duration и создаете объект timeout,
        который содержит временной интервал в секундах. Затем, объект timeout передается
        в конструктор класса WebDriverWait.
         */
