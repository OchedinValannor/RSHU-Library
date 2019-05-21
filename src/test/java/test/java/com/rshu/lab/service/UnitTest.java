package test.java.com.rshu.lab.service;

import com.rshu.lab.dao.BookDao;
import com.rshu.lab.entity.Book;
import com.rshu.lab.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

/**
 * Unit tests example
 */
@RunWith(MockitoJUnitRunner.class)
public class UnitTest {

    @Mock
    private BookDao dao;

    private BookService bookService;

    Book expected;

    @Before
    public void init() {
        bookService = new BookService(dao);
        expected = new Book("Title", "Author", 1, 1, "Genre");
    }

    @Test
    public void add() throws Exception {
        List<Book> books = new ArrayList<>();
        doAnswer(a -> {
            Book actual = a.getArgumentAt(0, Book.class);
            books.add(actual);
            return null;
        }).when(dao).add(any(Book.class));

        bookService.add(expected);

        assertThat(books.get(0)).isEqualTo(expected);
    }

    @Test
    public void getByID() throws Exception {
        when(dao.getByID(1)).thenReturn(expected);

        Book actual = bookService.getByID(1);

        assertThat(actual).isEqualTo(expected);
    }
}