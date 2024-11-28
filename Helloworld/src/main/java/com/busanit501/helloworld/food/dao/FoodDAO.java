package com.busanit501.helloworld.food.dao;

import com.busanit501.helloworld.food.Utill.ConnectionUtil;
import com.busanit501.helloworld.food.vo.FoodVO;
import lombok.Cleanup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDAO {

    public void insert(FoodVO foodVO) throws SQLException {

        String sql = "insert into tbl_food (title, dueDate, finished) " +
                "values (?, ?, ?)";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, foodVO.getTitle());
        preparedStatement.setDate(2, Date.valueOf(foodVO.getDueDate()));
        preparedStatement.setBoolean(3, foodVO.isFinished());
        preparedStatement.executeUpdate();
    } //insert

    public List<FoodVO> selectAll() throws SQLException {
        String sql = "select * from tbl_food";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<FoodVO> list = new ArrayList<>();
        while (resultSet.next()) {
            FoodVO foodVO = FoodVO.builder()
                    .tno(resultSet.getLong("tno"))
                    .title(resultSet.getString("title"))
                    .dueDate(resultSet.getDate("duedate").toLocalDate())
                    .finished(resultSet.getBoolean("finished"))
                    .build();

            list.add(foodVO);
        }

        return list;
    }

    public FoodVO selectOne(Long tno) throws SQLException {
        String sql = "select * from tbl_food where tno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, tno);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        FoodVO foodVO = FoodVO.builder()
                .tno(resultSet.getLong("tno"))
                .title(resultSet.getString("title"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .finished(resultSet.getBoolean("finished"))
                .build();

        return foodVO;
    }

    public void updatedata(FoodVO foodVO) throws SQLException {
        // 수정할 내용을 받은걸 담아와야 함.
        // 화면에서 낱개로 넘어온 데이터는 DTO에 담아서 전달하고, 서비스 계층에서 DTO로 넘어온 것을 VO로 전달해서 데이터베이스로 감.
        //데이터 베이스와 직접적인 연관있음 VO클래스는 테이블과 컬럼이 동일
        //DTO화면은 출력에서 전달하고 싶은 데이터만 골라섯 사용할 수 있음.
        String sql = "update tbl_food set title = ?, dueDate = ?, finished=? where tno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, foodVO.getTitle());
        preparedStatement.setDate(2, Date.valueOf(foodVO.getDueDate()));
        preparedStatement.setBoolean(3, foodVO.isFinished());
        preparedStatement.setLong(4, foodVO.getTno());
        preparedStatement.executeUpdate();
    }

    //삭제
    public void deletedata(Long tno) throws SQLException {
        String sql = "delete from tbl_food where tno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        //db서버에서 필요한 아이디, 비번, 드라이브 같은걸 가져와서 연결 준비하기
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //sql에 담아서 전달하여 db를 들어감
        preparedStatement.setLong(1, tno);
        //where tno = ? 여기에 1을 표현하고, Long tno 이 값을 받아온게 tno임.
        preparedStatement.executeUpdate();
    }


} //class

