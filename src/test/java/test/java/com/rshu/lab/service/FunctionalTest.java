package test.java.com.rshu.lab.service;

import com.rshu.lab.dao.BookDao;
import com.rshu.lab.entity.Book;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Functional test example
 */
@RunWith(MockitoJUnitRunner.class)
public class FunctionalTest {

    private static JdbcTemplate template;
    private static EmbeddedDatabase database;

    private static BookDao dao;

    private static Book bookExpected;

    @BeforeClass
    public static void setup() {
        database = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("h2-test.sql")
                .build();
        template = new JdbcTemplate(database);

        dao = new BookDao(template);

        bookExpected = new Book(1, "Title", "Author", 1, 1, "Genre");
    }

    @Test
    public void add() throws Exception {
        dao.add(bookExpected);

        List<Book> bookActual = dao.getAll();
        assertThat(bookActual.size()).isEqualTo(1);

        dao.remove(bookExpected);
        bookActual = dao.getAll();
        assertThat(bookActual.size()).isEqualTo(0);
    }
}