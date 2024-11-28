package com.busanit501.helloworld.food.dao;

import com.busanit501.helloworld.food.Utill.ConnectionUtil;
import com.busanit501.helloworld.food.vo.MemVO;
import lombok.Cleanup;
import org.modelmapper.Converters;

import javax.management.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class MemDAO {

    public MemVO getMember(String mid, String mpw) throws SQLException {
        String sql = "select * from tbl_member where mid = ? and mpw = ?";
        MemVO mem = new MemVO();
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, mid);
        preparedStatement.setString(2, mpw);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        mem = MemVO.builder()
                .mid(resultSet.getString("mid"))
                .mpw(resultSet.getString("mpw"))
                .mname(resultSet.getString("mname"))
                .build();
        return mem;
    }
}
