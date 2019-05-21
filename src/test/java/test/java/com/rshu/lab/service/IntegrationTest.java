package test.java.com.rshu.lab.service;

import com.rshu.lab.dao.ReaderDao;
import com.rshu.lab.entity.Reader;
import com.rshu.lab.service.ReaderService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Integration test example
 */
@RunWith(MockitoJUnitRunner.class)
public class IntegrationTest {

    private static JdbcTemplate template;
    private static EmbeddedDatabase database;

    private static ReaderDao dao;
    private static ReaderService service;

    private static Reader readerExpected;

    @BeforeClass
    public static void setup() {
        database = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("h2-test.sql")
                .build();
        template = new JdbcTemplate(database);

        dao = new ReaderDao(template);
        service = new ReaderService(dao);

        readerExpected = new Reader("Surname",
                "Firstname",
                "Patronymic",
                "Address",
                123);
    }

    @Test
    public void add() throws Exception {
        service.add(readerExpected);

        Reader readerActual = service.getAll().get(0);

        assertThat(readerActual.getSurname()).isEqualTo(readerExpected.getSurname());
        assertThat(readerActual.getFirstName()).isEqualTo(readerExpected.getFirstName());
        assertThat(readerActual.getPatronymic()).isEqualTo(readerExpected.getPatronymic());
        assertThat(readerActual.getHomeAddress()).isEqualTo(readerExpected.getHomeAddress());
        assertThat(readerActual.getPhoneNumber()).isEqualTo(readerExpected.getPhoneNumber());
    }
}