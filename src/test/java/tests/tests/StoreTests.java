package tests.tests;

import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.pages.StorePage;

import static com.codeborne.selenide.Selenide.open;
import static tests.TestData.BOOK_AUTHOR;
import static tests.TestData.BOOK_TITLE;

public class StoreTests extends TestBase {

    @Test
    void searchByExistingAuthorTest() {
        open("/books", StorePage.class)
                .hasSearchBox()
                .search(BOOK_AUTHOR)
                .foundBook(BOOK_TITLE);
    }

    @Test
    void searchNotExistingBook() {
        open("/books", StorePage.class)
                .hasSearchBox()
                .search(BOOK_AUTHOR + BOOK_AUTHOR)
                .noBooksFound();
    }
}
