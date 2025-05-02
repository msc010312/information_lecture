package com.example.demo.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@SpringBootTest
class DataSourceConfigTest {

    @Autowired
    private DataSource datasource2;

    @Autowired
    private DataSource datasource3;

    @Test
    public void t1() throws Exception{
        System.out.println(datasource2);
        Connection conn = datasource2.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("insert into tbl_memo values(?,?,?,now())");
        pstmt.setInt(1, 112);
        pstmt.setString(2, "ccc");
        pstmt.setString(3, "ddd");
        pstmt.executeUpdate();
    }

    @Test
    public void t2() throws Exception{
        System.out.println(datasource3);
        Connection conn = datasource3.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("insert into tbl_memo values(?,?,?,now())");
        pstmt.setInt(1, 333);
        pstmt.setString(2, "ccc");
        pstmt.setString(3, "ddd");
        pstmt.executeUpdate();
    }
}