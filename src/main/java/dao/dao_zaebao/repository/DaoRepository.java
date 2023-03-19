package dao.dao_zaebao.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DaoRepository {
    @Autowired
    public DaoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {

        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static final String queryPath = "query.sql";
    private String query;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<String> getProductName(String name){
        query = read(queryPath);
        SqlParameterSource namedParameters = new MapSqlParameterSource("name", name);
        return namedParameterJdbcTemplate.query(query,
                namedParameters,
                (rs, rowNum) -> rs.getString("product_name"));
    }
    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}