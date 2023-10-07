package daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
@Component
public abstract class AbtractDao<T, ID> {

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public AbtractDao() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
