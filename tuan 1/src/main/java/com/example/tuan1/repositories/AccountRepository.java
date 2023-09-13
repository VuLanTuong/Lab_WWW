package com.example.tuan1.repositories;

import com.example.tuan1.controller.AccountController;
import com.example.tuan1.models.Account;
import com.example.tuan1.models.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class AccountRepository {


    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(AccountController.class.getName());
    public void insert(Account account)throws Exception{
        String sql="insert into account values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,account.getAccount_id());
        ps.setString(2,account.getFull_name());
        ps.setString(3,account.getPassword());
        ps.setString(4,account.getEmail());
        ps.setString(5,account.getPhone());
        ps.setInt(6,account.getStatus().getStatus());
        ps.executeUpdate();
    }


    public Account findByUsernameAndPassword(String username, String password) throws SQLException {
        final String sql = "select * from account where account_id = ? and password = ?   ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            int statusIndex = resultSet.getInt(6);
            Status status = Status.DEACTIVE;

            if (statusIndex == 1) {
                status = Status.ACTIVE;
            }

            if (statusIndex == -1) {
                status = Status.REMOVE;
            }
            return new Account(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4),
                    resultSet.getString(5),
                    status
            );
        }
        //ResultSet rs = stmt.executeQuery();
        //			if (rs.next()) {
        //				return new BangLuongCongNhan(rs.getString("maBangLuong"),
        //						congNhanDao.timCongNhanBangMaCongNhan(rs.getString("maCongNhan")),
        //						rs.getDate("ngayLapBangLuong"), rs.getDouble("luong"), rs.getDouble("tienthuongchuyencan"));
        //			}

        return null;
    }

}
