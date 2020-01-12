package com.codepractice.jdbc.dao;

import com.codepractice.jdbc.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class JdbcDaoImpl {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public Circle getCircle(Integer circleId) throws SQLException {
        Connection conn;
//        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF8&useSSL=false","root","root");
        conn = dataSource.getConnection();

        PreparedStatement ps = conn.prepareStatement("select * from circle where id = ?");
        ps.setInt(1,circleId);

        Circle circle = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            circle = new Circle(circleId, rs.getString("name"));
        }
        rs.close();
        ps.close();
        conn.close();
        return circle;

    }

//    public int insertCircle(Circle circle) {
//        String sql = "insert into circle (id,name) values (?,?)";
//       return  jdbcTemplate.update(sql, new Object[]{circle.getId(),circle.getName()});
//    }

    public int insertCircle(Circle circle) {
        String sql = "Insert into circle (id, name) values (:id, :name)";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", circle.getId())
                .addValue("name", circle.getName());
        return namedParameterJdbcTemplate.update(sql,namedParameters);
    }

    public void createTriangleTable(){
        String sql = "Create table triangle(id int auto_increment primary key, name varchar(50))";
        jdbcTemplate.execute(sql);
    }

    public Integer getCircleCount(){
        String sql = "select count(*) from circle";
        jdbcTemplate.setDataSource(this.getDataSource());
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    public List<Circle> getAllCircle(){
        List<Circle> circleList = new ArrayList<>();
        String sql = "select * from circle";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            Circle circle = new Circle();
            circle.setId(((Integer) row.get("id")).intValue());
            circle.setName(((String) row.get("name")));
            circleList.add(circle);
        }
        return circleList;
    }

    public String getCircleName(Integer circleId) {
        String sql = "select name from circle where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, String.class);
    }

    public Circle getCircleForId(Integer circleId) {
        String sql = "select * from circle where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, new CircleMapper());
    }

    public List<Circle> getAllCirclesList(){
        String sql = "select * from circle";
        return jdbcTemplate.query(sql, new CircleMapper());
    }

    private static final class CircleMapper implements RowMapper<Circle> {

        @Override
        public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
            Circle circle = new Circle();
            circle.setId(rs.getInt("id"));
            circle.setName(rs.getString("name"));
            return circle;
        }

    }
    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
