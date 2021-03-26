package tests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginPage {
    private final static SelenideElement
            loginInput = $("#userName"),
            passwordInput = $("#password"),
            submitButton = $("#login"),
            errorMessage = $("#name");

    public LoginPage unsuccessfulLogin(String login, String password) {
        loginInput.setValue(login);
        passwordInput.setValue(password);
        submitButton.click();

        return this;
    }

    public ProfilePage login(String login, String password) {
        loginInput.setValue(login);
        passwordInput.setValue(password);
        submitButton.click();

        return page(ProfilePage.class);
    }

    public LoginPage shouldHaveError(String error) {
        assertThat(errorMessage.getText(), is(error));

        return this;
    }
}
