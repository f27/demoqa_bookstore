package tests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static tests.TestData.LOGIN;

public class ProfilePage {

    private final static SelenideElement
            username = $("#userName-value"),
            logoutButton = $("#books-wrapper").$(byText("Log out")),
            notLoggedInLabel = $("#notLoggin-label"),
            gotoStoreButton = $("#gotoStore");

    public LoginPage logout() {
        logoutButton.click();

        return page(LoginPage.class);
    }

    public String getUsername() {
        return username.getText();
    }

    public ProfilePage isLoggedIn() {
        assertThat(getUsername(), is(LOGIN));

        return this;
    }

    public ProfilePage hasRegisterLink() {
        notLoggedInLabel.$(byLinkText("register")).shouldBe(visible);

        return this;
    }

    public StorePage gotoStore() {
        gotoStoreButton.click();

        return page(StorePage.class);
    }
}
