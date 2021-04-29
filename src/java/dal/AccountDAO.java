/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Product;

/**
 *
 * @author Admin
 */
public class AccountDAO extends BaseDAO<Account> {

    @Override
    public Account get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Account get(Account model) {
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[rule]\n"
                + "      ,[email]\n"
                + "      ,[address]\n"
                + "      ,[tel]\n"
                + "  FROM [project].[dbo].[account]\n"
                + " where username=?";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, model.getUsername());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Account s = new Account();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setRule(rs.getInt("rule"));
                s.setEmail(rs.getString("email"));
                s.setAddress(rs.getString("address"));
                s.setTel(rs.getString("tel"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Account> list() {
        ArrayList<Account> Accounts = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[rule]\n"
                + "      ,[email]\n"
                + "      ,[address]\n"
                + "      ,[tel]\n"
                + "  FROM [project].[dbo].[account]\n"
                + "  where [rule] = 1 ";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Account s = new Account();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setRule(rs.getInt("rule"));
                s.setEmail(rs.getString("email"));
                s.setAddress(rs.getString("address"));
                s.setTel(rs.getString("tel"));
                Accounts.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Accounts;
    }

    @Override
    public void insert(Account model) {
        try {
            String sql = "INSERT INTO [project].[dbo].[Account]\n"
                    + "           ([id]\n"
                    + "           ,[name]\n"
                    + "           ,[username]\n"
                    + "           ,[password]\n"
                    + "           ,[rule]\n"
                    + "           ,[email])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)\n"
                    + "GO";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getName());
            stm.setString(2, model.getUsername());
            stm.setString(3, model.getPassword());
            stm.setInt(4, model.getRule());
            stm.setString(5, model.getEmail());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "delete from account where id=? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Account getAccountByUsernameAndPassword(String username, String password) {
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[rule]\n"
                + "      ,[email]\n"
                + "  FROM [project].[dbo].[account]\n"
                + "  where username=? and password=?";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Account s = new Account();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setRule(rs.getInt("rule"));
                s.setEmail(rs.getString("email"));
                return s;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void insert2(String name, String username, String password, String email,String address, String tel) {
        try {
            String sql = "INSERT INTO [project].[dbo].[Account]\n"
                    + "           (\n"
                    + "           [name]\n"
                    + "           ,[username]\n"
                    + "           ,[password]\n"
                    + "           ,[rule]\n"
                    + "           ,[email]\n"
                    + "           ,[address]\n"
                    + "           ,[tel])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           , ?\n"
                    + "           , ?\n"
                    + "           , ?)\n";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, username);
            stm.setString(3, password);
            stm.setInt(4, 1);
            stm.setString(5, email);
            stm.setString(6, address);
            stm.setString(7,tel);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        AccountDAO db = new AccountDAO();;
        db.insert2("Võ  Đức Tài", "taivd1", "1", "taivd@gmail.com", "thôn 9", " 0987654332");
        System.out.println(db.list());
    }
}
