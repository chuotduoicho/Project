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
import model.Product;

/**
 *
 * @author Admin
 */
public class CartDAO extends BaseDAO<Cart> {

    @Override
    public Cart get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cart> list() {
        ArrayList<Cart> Carts = new ArrayList<>();
        String sql = "SELECT c.id,       p.[name]\n"
                + "      ,p.[detail]\n"
                + "      ,p.[price] \n"
                + "      ,p.[image]\n"
                + "      ,p.[NewPrice],c.username\n"
                + "FROM ((Cart as c\n"
                + "INNER JOIN Product as p ON c.pid = p.id)\n"
                + "INNER JOIN Account as a ON c.username = a.username)";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Cart s = new Cart();
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
                Carts.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Carts;
    }

    public ArrayList<Cart> list2(String username) {
        ArrayList<Cart> Carts = new ArrayList<>();
        String sql = "SELECT c.id,       p.[name]\n"
                + "      ,p.[detail]\n"
                + "      ,p.[id] as pid\n"
                + "      ,p.[price] \n"
                + "      ,p.[image]\n"
                + "      ,p.[NewPrice],c.username \n"
                + " FROM ((Cart as c\n"
                + " INNER JOIN Product as p ON c.pid = p.id)\n"
                + " INNER JOIN Account as a ON c.username = a.username)"
                + "  where a.username=? ";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Cart s = new Cart();
                Account a = new Account();
                Product p = new Product();
                s.setId(rs.getInt("id"));
                a.setUsername(rs.getString("username"));
                p.setName(rs.getString("name"));
                p.setDetail(rs.getString("detail"));
                p.setId(rs.getInt("pid"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getFloat("price"));
                p.setNewPrice(rs.getFloat("NewPrice"));
                s.setAccount(a);
                s.setProduct(p);
                Carts.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Carts;
    }

    @Override
    public void insert(Cart model) {
        try {
            String sql = "INSERT INTO [project].[dbo].[Cart]\n"
                    + "           ([pid]\n"
                    + "           ,[username])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getProduct().getId());
            stm.setString(2, model.getAccount().getUsername());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert2(int id, String username) {
        try {
            String sql = "INSERT INTO [project].[dbo].[Cart]\n"
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
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Cart model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "delete from Cart where id=? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        CartDAO db = new CartDAO();
        db.insert2(2, "tai");
//        System.out.println(db.list2("tai"));
    }

    public int count(String username) {
        String sql = "SELECT COUNT(*) as total FROM \n"
                + "((Cart as c\n"
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

}
