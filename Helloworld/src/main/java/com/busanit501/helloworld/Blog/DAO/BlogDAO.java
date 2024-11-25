package com.busanit501.helloworld.Blog.DAO;

import com.busanit501.helloworld.Blog.DTO.BlogVO;
import com.busanit501.helloworld.jdbcex.dao.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlogDAO {

    public void insertBlog(BlogVO blogVO) throws SQLException {
    String sql = "insert into BlogTable(Title,content,Bdate) values(?,?,?)";
    @Cleanup Connection connection = BlogconnectionUtill.INSTANCE.getConnection();
    @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, blogVO.getTitle());
    preparedStatement.setString(2, blogVO.getContent());
    preparedStatement.setDate(3, new java.sql.Date(blogVO.getBdate().getTime()));
    preparedStatement.executeUpdate();
    }


} //class

