package tests.tests;

import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.pages.LoginPage;
import tests.pages.ProfilePage;

import static com.codeborne.selenide.Selenide.open;
import static tests.TestData.LOGIN;
import static tests.TestData.PASSWORD;

public class ProfileTests extends TestBase {

    @Test
    void unauthorizedProfileHasRegisterLink() {
        open("/profile", ProfilePage.class)
                .shouldHaveRegisterLink();
    }

    @Test
    void authorizedCanGoToStore() {
        open("/login", LoginPage.class)
                .login(LOGIN, PASSWORD)
                .verifyLoggedIn()
                .gotoStore()
                .shouldHaveSearchBox();
    }
}
