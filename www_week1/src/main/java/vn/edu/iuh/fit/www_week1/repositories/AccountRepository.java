package vn.edu.iuh.fit.www_week1.repositories;

import vn.edu.iuh.fit.www_week1.models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AccountRepository {


    private Connection connection;
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

}
