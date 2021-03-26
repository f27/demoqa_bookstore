package tests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ProfilePage {
    private final static SelenideElement
            username = $("#userName-value"),
            logoutButton = $("#books-wrapper").$(byText("Log out"));

    public LoginPage logout() {
        logoutButton.click();

        return page(LoginPage.class);
    }

    public String getUsername() {
        return username.getText();
    }
}
