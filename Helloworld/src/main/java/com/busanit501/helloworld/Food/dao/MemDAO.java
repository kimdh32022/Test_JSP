package com.busanit501.helloworld.Food.dao;

import com.busanit501.helloworld.Food.Utill.ConnectionUtil;
import com.busanit501.helloworld.Food.vo.MemVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemDAO {

    public MemVO getMemberWithMpw(String mid, String mpw) throws SQLException {
        String query = "select * from tbl_member where mid = ? and mpw = ?";
        MemVO memVO = null;
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, mid);
        preparedStatement.setString(2, mpw);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        memVO = MemVO.builder()
                .mid(resultSet.getString("mid"))
                .mpw(resultSet.getString("mpw"))
                .mname(resultSet.getString("mname"))
                .uuid(resultSet.getString("uuid"))
                .build();
        return memVO;
    }
    public void updateUuid(String mid, String uuid) throws SQLException {
        String query = "update tbl_member set uuid=? where mid=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, uuid);
        preparedStatement.setString(2, mid);
        preparedStatement.executeUpdate();
    }

    public MemVO getMemberWithUuid(String uuid) throws SQLException {
        String query = "select * from tbl_member where uuid = ?";
        MemVO memVO = null;
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, uuid);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        memVO = MemVO.builder()
                .mid(resultSet.getString("mid"))
                .mpw(resultSet.getString("mpw"))
                .mname(resultSet.getString("mname"))
                .uuid(resultSet.getString("uuid"))
                .build();
        return memVO;
    }
}
