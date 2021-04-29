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
import model.GroupProduct;
import model.Product;

/**
 *
 * @author Admin
 */
public class GroupProductDAO extends BaseDAO<GroupProduct> {

    @Override
    public GroupProduct get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<GroupProduct> list() {
        ArrayList<GroupProduct> GroupProducts = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[content]\n"
                + "      ,[image]\n"
                + "      ,[order]\n"
                + "      ,[status]\n"
                + "  FROM [project].[dbo].[Group_Product]\n"
                + "GO";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                GroupProduct s = new GroupProduct();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setContent(rs.getString("content"));
                s.setImage(rs.getString("image"));
                GroupProducts.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return GroupProducts;
    }

    @Override
    public void insert(GroupProduct model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(GroupProduct model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
