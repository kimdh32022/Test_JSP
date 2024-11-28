package com.busanit501.helloworld.Blog.DAO;

import com.busanit501.helloworld.Blog.DTO.BlogVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<BlogVO> selectAllBlog() throws SQLException {
        String sql = "select * from BlogTable";
        @Cleanup Connection connection = BlogconnectionUtill.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<BlogVO> list = new ArrayList<>();
        while (resultSet.next()) {
            BlogVO blogVO = BlogVO.builder()
                    .title(resultSet.getString("Title"))
                    .content(resultSet.getString("content"))
                    .Bdate(resultSet.getDate("Bdate"))
                    .build();

            list.add(blogVO);
        }
        return list;
    }

    public BlogVO selectone(Long bno) throws SQLException {
        String sql = "select * from BlogTable where Bno=?";
        @Cleanup Connection connection = BlogconnectionUtill.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, bno);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        BlogVO blogVO = BlogVO.builder()
                .Bno(resultSet.getLong("bno"))
                .title(resultSet.getString("Title"))
                .content(resultSet.getString("content"))
                .Bdate(resultSet.getDate("Bdate"))
                .build();

        return blogVO;
    }

    public void updateBlog(BlogVO blogVO) throws SQLException {
        String sql = " update BlogTable set Title=?,content=?,Bdate=?";
        @Cleanup Connection connection = BlogconnectionUtill.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, blogVO.getTitle());
        preparedStatement.setString(2, blogVO.getContent());
        preparedStatement.setDate(3, new java.sql.Date(blogVO.getBdate().getTime()));
        preparedStatement.executeUpdate();

    }

    public void deleteBlog(Long bno) throws SQLException {
        String sql = "delete from BlogTable where Bno=?";
        @Cleanup Connection connection = BlogconnectionUtill.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, bno);
        preparedStatement.executeUpdate();
    }
} //class

