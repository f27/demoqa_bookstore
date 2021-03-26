package tests.tests;

import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.pages.LoginPage;
import tests.pages.ProfilePage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static tests.TestData.*;

public class LoginTests extends TestBase {
    LoginPage loginPage;

    @Test
    void unsuccessfulLoginTest() {
        loginPage = open("/login", LoginPage.class);
        loginPage.unsuccessfulLogin(BAD_LOGIN,PASSWORD);
        assertThat(loginPage.getError(), is("Invalid username or password!"));
    }

    @Test
    void successfulLoginTest() {
        loginPage = open("/login", LoginPage.class);
        ProfilePage profilePage = loginPage.login(LOGIN,PASSWORD);
        assertThat(profilePage.getUsername(), is(LOGIN));
        profilePage.logout();
    }
}
