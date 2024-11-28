package com.busanit501.helloworld.Member.dao;

import com.busanit501.helloworld.Member.vo.MemberVO;
import com.busanit501.helloworld.Food.Utill.ConnectionUtil;
import lombok.Cleanup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    public void insert(MemberVO memberVO) throws SQLException {

        String sql = "insert into Member_Table (id, password, uname) " +
                "values (?, ?, ?)";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, memberVO.getID());
        preparedStatement.setString(2, memberVO.getPassword());
        preparedStatement.setString(3, memberVO.getUname());
        preparedStatement.executeUpdate();
    } //insert

    public List<MemberVO> selectAll() throws SQLException {
        String sql = "select * from Member_Table";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<MemberVO> list = new ArrayList<>();
        while (resultSet.next()) {
            MemberVO memberVO = MemberVO.builder()
                    .Uno(resultSet.getLong("Uno"))
                    .ID(resultSet.getString("ID"))
                    .Password(resultSet.getString("Password"))
                    .Uname(resultSet.getString("Uname"))
                    .build();

            list.add(memberVO);
        }

        return list;
    }

    public MemberVO selectOne(Long uno) throws SQLException {
        String sql = "select * from Member_Table where uno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, uno);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        MemberVO memberVO = MemberVO.builder()
                .Uno(resultSet.getLong("Uno"))
                .ID(resultSet.getString("ID"))
                .Password(resultSet.getString("Password"))
                .Uname(resultSet.getString("Uname"))
                .build();

        return memberVO;
    }

    public void updatedata(MemberVO memberVO) throws SQLException {
        String sql = "update Member_Table set ID = ?, Password = ?, Uname = ? where Uno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, memberVO.getID());
        preparedStatement.setString(2, memberVO.getPassword());
        preparedStatement.setString(3, memberVO.getUname());
        preparedStatement.setLong(4, memberVO.getUno());
        preparedStatement.executeUpdate();
    }

    //삭제
    public void deletedata(Long Uno) throws SQLException {
        String sql = "delete from Member_Table where Uno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, Uno);
        preparedStatement.executeUpdate();
    }


} //class

