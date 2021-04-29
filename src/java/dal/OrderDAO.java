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
import model.Cart;
import model.Order;
import model.Product;

/**
 *
 * @author Admin
 */
public class OrderDAO extends BaseDAO<Order> {

    @Override
    public Order get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Order> list() {
        ArrayList<Order> Orders = new ArrayList<>();
        String sql = "SELECT c.id,       p.[name]\n"
                + "      ,p.[detail]\n"
                + "      ,p.[price] \n"
                + "      ,p.[image]\n"
                + "      ,p.[NewPrice],c.username\n"
                + "FROM (([Order] as c\n"
                + "INNER JOIN Product as p ON c.pid = p.id)\n"
                + "INNER JOIN Account as a ON c.username = a.username)";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Order s = new Order();
                Account a = new Account();
                Product p = new Product();
                s.setId(rs.getInt("id"));
                a.setUsername(rs.getString("username"));
                p.setName(rs.getString("name"));
                p.setDetail(rs.getString("detail"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getFloat("price"));
                p.setNewPrice(rs.getFloat("NewPrice"));
                s.setAccount(a);
                s.setProduct(p);
                Orders.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Orders;
    }

    public ArrayList<Order> list2(String username) {
        ArrayList<Order> Orders = new ArrayList<>();
        String sql = "SELECT c.id,       p.[name]\n"
                + "      ,p.[detail]\n"
                + "      ,p.[price] \n"
                + "      ,p.[image]\n"
                + "      ,p.[NewPrice],c.username \n"
                + " FROM (([Order] as c\n"
                + " INNER JOIN Product as p ON c.pid = p.id)\n"
                + " INNER JOIN Account as a ON c.username = a.username)"
                + "  where a.username=? ";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Order s = new Order();
                Account a = new Account();
                Product p = new Product();
                s.setId(rs.getInt("id"));
                a.setUsername(rs.getString("username"));
                p.setName(rs.getString("name"));
                p.setDetail(rs.getString("detail"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getFloat("price"));
                p.setNewPrice(rs.getFloat("NewPrice"));
                s.setAccount(a);
                s.setProduct(p);
                Orders.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Orders;
    }

    @Override
    public void insert(Order model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insert2(int id, String username) {
        try {
            String sql = "INSERT INTO [project].[dbo].[Order]\n"
                    + "           ([pid]\n"
                    + "           ,[username])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, username);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Order model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM [project].[dbo].[Order]\n"
                    + "      WHERE id=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int count(String username) {
        String sql = "SELECT COUNT(*) as total FROM \n"
                + "(([Order] as c\n"
                + "INNER JOIN Product as p ON c.pid = p.id)\n"
                + "INNER JOIN Account as a ON c.username = a.username)\n"
                + "where a.username=? ";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void main(String[] args) {
        OrderDAO db = new OrderDAO();
        db.insert2(1,"tai");
        System.out.println(db.list2("tai"));
    }
}
