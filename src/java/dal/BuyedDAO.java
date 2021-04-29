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
import model.Buyed;
import model.Cart;
import model.Product;

/**
 *
 * @author Admin
 */
public class BuyedDAO extends BaseDAO<Buyed> {

    @Override
    public Buyed get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public ArrayList<Buyed> list2(String username) {
        ArrayList<Buyed> Buyeds = new ArrayList<>();
        String sql = "SELECT c.id,       p.[name]\n"
                + "      ,p.[detail]\n"
                + "      ,p.[id] as pid\n"
                + "      ,p.[price] \n"
                + "      ,p.[image]\n"
                + "      ,p.[NewPrice],c.username \n"
                + " FROM ((Buyed as c\n"
                + " INNER JOIN Product as p ON c.pid = p.id)\n"
                + " INNER JOIN Account as a ON c.username = a.username)"
                + "  where a.username=? ";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Buyed s = new Buyed();
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
                Buyeds.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuyedDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Buyeds;
    }

    @Override
    public void insert(Buyed model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Buyed model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "delete from Buyed where id=? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Buyed> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
