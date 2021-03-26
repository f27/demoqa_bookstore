package tests.tests;

import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static tests.TestData.*;

public class LoginTests extends TestBase {

    @Test
    void unsuccessfulLoginTest() {
        open("/login", LoginPage.class)
                .unsuccessfulLogin(BAD_LOGIN, PASSWORD)
                .shouldHaveError("Invalid username or password!");
    }

    @Test
    void successfulLoginTest() {
        open("/login", LoginPage.class)
                .login(LOGIN, PASSWORD)
                .verifyLoggedIn()
                .logout();
    }
}
