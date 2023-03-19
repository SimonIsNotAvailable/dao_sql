package pizda.dao_zaebao.repository;


import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Repository
public class DaoRepository {
    private final String queryPath = "src/main/resources/query.sql";
    private String query;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public String getProductName(String name){
        query = read(queryPath);
        SqlParameterSource namedParameters = new MapSqlParameterSource("name", name);
        return namedParameterJdbcTemplate.queryForObject(query, namedParameters, String.class);
    }
    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource("src/main/resources/query.sql").getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

