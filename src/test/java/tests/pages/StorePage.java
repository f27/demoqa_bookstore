package tests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class StorePage {
    private final static SelenideElement
            searchBox = $("#searchBox"),
            booksWrapper = $(".books-wrapper"),
            noData = $(".rt-noData");

    public StorePage shouldHaveSearchBox() {
        searchBox.shouldBe(visible);

        return this;
    }

    public StorePage search(String text) {
        searchBox.setValue(text);

        return this;
    }

    public StorePage shouldFind(String text) {
        noData.shouldNotBe(visible);
        booksWrapper.shouldHave(text(text));

        return this;
    }

    public StorePage shouldNotFind() {
        noData.shouldHave(text("No rows found"));

        return this;
    }
}
