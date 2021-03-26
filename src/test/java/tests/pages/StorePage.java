package tests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class StorePage {
    private final static SelenideElement
            searchBox = $("#searchBox");

    public StorePage hasSearchBox() {
        searchBox.shouldBe(visible);

        return this;
    }
}
