package com.example.tuan1.repositories;

import com.example.tuan1.controller.AccountController;
import com.example.tuan1.models.Account;
import com.example.tuan1.models.Status;

import java.sql.*;
import java.util.logging.Logger;

public class AccountRepository {


    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(AccountController.class.getName());


    public AccountRepository() throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        String url = "jdbc:mariadb://localhost:3306/mydb";
        connection = DriverManager.getConnection(url, "root", "sapassword");
    }


    public boolean insert(Account account) throws Exception {
        String sql = "insert into account values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, account.getAccount_id());
        ps.setString(2, account.getFull_name());
        ps.setString(3, account.getPassword());
        ps.setString(4, account.getEmail());
        ps.setString(5, account.getPhone());
        ps.setInt(6, account.getStatus().getStatus());
        ps.executeUpdate();
        return true;
    }

    public boolean update(Account account) throws Exception {
        String sql = "update account set full_name= ?, " +
                "    password = ?,\n" +
                "    email = ?,\n" +
                "    phone = ?,\n" +
                "    status = ?   \n" +
                "WHERE account_id = ? ;";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, account.getFull_name());
        ps.setString(2, account.getPassword());
        ps.setString(3, account.getEmail());
        ps.setString(4, account.getPhone());
        ps.setInt(5, account.getStatus().getStatus());
        ps.setString(6, account.getAccount_id());
        ps.executeUpdate();
        return true;
    }


    public boolean delete(long account_id)throws Exception{
        String sql="delete from account where account_id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1, account_id);
        ps.executeUpdate();
        return true;

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


        return null;
    }


    public boolean checkRoleAdmin(Account account) throws SQLException {
        String sql = "SELECT role_name FROM grant_access g JOIN role r ON\n" +
                "g.role_id = r.role_id\n" +
                " where account_id = ? ";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, account.getAccount_id());
        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            String role = resultSet.getString("role_name");
            // avoid null pointer
            if ("admin".equals(role)) {
                return true;
            }

        }
        return false;
    }





}
