/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GroupProduct;
import model.Product;

/**
 *
 * @author Admin
 */
public class ProductDAO extends BaseDAO<Product> {

    @Override
    public Product get(int id) {
        String sql = "SELECT p.[id]\n"
                + "      ,p.[name]\n"
                + "      ,[detail]\n"
                + "      ,[price]\n"
                + "      ,p.[image]\n"
                + "      ,[NewPrice]\n"
                + "      ,[date]\n"
                + "      ,[Group_ID]\n"
                + "            ,g.name as brand\n"
                + "      ,g.image as brand_img"
                + "  FROM [project].[dbo].[Product] p INNER JOIN Group_Product g on p.Group_ID=g.id where p.id=? \n";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product s = new Product();
                GroupProduct g = new GroupProduct();
                g.setName(rs.getString("brand"));
                g.setImage(rs.getString("brand_img"));
                s.setGroupProduct(g);
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDetail(rs.getString("detail"));
                s.setImage(rs.getString("image"));
                s.setPrice(rs.getFloat("price"));
                s.setNewPrice(rs.getFloat("NewPrice"));
                s.setDate(rs.getDate("date"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Product> list() {
        ArrayList<Product> Products = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[detail]\n"
                + "      ,[price]\n"
                + "      ,[image]\n"
                + "      ,[NewPrice]\n"
                + "      ,[date]\n"
                + "      ,[Group_ID]\n"
                + "  FROM [project].[dbo].[Product]\n"
                + "GO";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product s = new Product();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDetail(rs.getString("detail"));
                s.setImage(rs.getString("image"));
                s.setPrice(rs.getFloat("price"));
                s.setNewPrice(rs.getFloat("NewPrice"));
                s.setDate(rs.getDate("date"));
                Products.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Products;
    }

    @Override
    public void insert(Product model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insert2(String name, String detail, float price, String image, Date date, int groupID) {
        try {
            String sql = "INSERT INTO [project].[dbo].[Product]\n"
                    + "           ([name]\n"
                    + "           ,[detail]\n"
                    + "           ,[price]\n"
                    + "           ,[image]\n"
                    + "           ,[date]\n"
                    + "           ,[Group_ID])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, detail);
            stm.setFloat(3, price);
            stm.setString(4, image);
            stm.setDate(5, date);
            stm.setInt(6, groupID);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Product model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void update2(int id, String name, String detail, float price, float newprice, String image, Date date, int gid) {
        try {
            String sql = "UPDATE [project].[dbo].[Product]\n"
                    + "   SET [name] = ?\n"
                    + "      ,[detail] = ?\n"
                    + "      ,[price] = ?\n"
                    + "      ,[NewPrice] = ?\n"
                    + "      ,[image] = ?\n"
                    + "      ,[date] = ?\n"
                    + "      ,[Group_ID] = ?\n"
                    + " WHERE id = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, detail);
            stm.setFloat(3, price);
            stm.setFloat(4, newprice);
            stm.setString(5, image);
            stm.setDate(6, date);
            stm.setInt(7, gid);
            stm.setInt(8, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "delete from product where id=? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Product> searchByName(String name, Boolean sale, Float from, Float to, GroupProduct gr) {
        ArrayList<Product> Products = new ArrayList<>();
        Integer index = 0;
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[detail]\n"
                + "      ,[price]\n"
                + "      ,[image]\n"
                + "      ,[NewPrice]\n"
                + "      ,[date]\n"
                + "      ,[Group_ID]\n"
                + "  FROM [project].[dbo].[Product]\n"
                + "WHERE (1=1) ";

        if (name != null) {
            sql += " AND name like '%'+ ? + '%' ";
        }
        if (sale != null) {
            sql += "  and NewPrice>0 ";
        }

        if (from != null) {
            sql += " AND price >= ? ";
        }
        if (to != null) {
            sql += " AND price <= ? ";
        }
        if (gr != null) {
            sql += "  and Group_ID = ? ";
        }
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            if (name != null) {
                index++;
                stm.setString(index, name);
            }
            if (from != null) {
                index++;
                stm.setFloat(index, from);
            }
            if (to != null) {
                index++;
                stm.setFloat(index, to);
            }

            if (gr != null) {
                index++;
                stm.setInt(index, gr.getId());
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product s = new Product();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDetail(rs.getString("detail"));
                s.setImage(rs.getString("image"));
                s.setPrice(rs.getFloat("price"));
                s.setNewPrice(rs.getFloat("NewPrice"));
                s.setDate(rs.getDate("date"));
                Products.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Products;
    }

    public ArrayList<Product> search(String name, Boolean sale, Float from, Float to, GroupProduct gr, int pagesize, int pageindex) {
        ArrayList<Product> Products = new ArrayList<>();
        Integer index = 0;
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[detail]\n"
                + "      ,[price]\n"
                + "      ,[image]\n"
                + "      ,[NewPrice]\n"
                + "      ,[date]\n"
                + "      ,[Group_ID]\n"
                + "  FROM \n"
                + "(SELECT ROW_NUMBER() OVER (ORDER BY id ASC)\n"
                + "as rownum, *  FROM [project].[dbo].[Product]) tbl\n"
                + "WHERE (1=1)  \n";
        if (name != null) {
            sql += "  AND name like '%'+ ? + '%' ";
        }
        if (sale != null) {
            sql += "  and NewPrice>0 ";
        }

        if (from != null) {
            sql += " AND price >= ? ";
        }
        if (to != null) {
            sql += " AND price <= ? ";
        }
        if (gr != null) {
            sql += "  and Group_ID = ? ";
        }
        sql += " and rownum >= (? -1)*? + 1 AND rownum <= ? * ?";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            if (name != null) {
                index++;
                stm.setString(index, name);
            }
            if (from != null) {
                index++;
                stm.setFloat(index, from);
            }
            if (to != null) {
                index++;
                stm.setFloat(index, to);
            }

            if (gr != null) {
                index++;
                stm.setInt(index, gr.getId());
            }
            stm.setInt(index + 1, pageindex);
            stm.setInt(index + 2, pagesize);
            stm.setInt(index + 3, pageindex);
            stm.setInt(index + 4, pagesize);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product s = new Product();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDetail(rs.getString("detail"));
                s.setImage(rs.getString("image"));
                s.setPrice(rs.getFloat("price"));
                s.setNewPrice(rs.getFloat("NewPrice"));
                s.setDate(rs.getDate("date"));
                Products.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Products;
    }

    public ArrayList<Product> paging(int pagesize, int pageindex) {
        ArrayList<Product> Products = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[detail]\n"
                + "      ,[price]\n"
                + "      ,[image]\n"
                + "      ,[NewPrice]\n"
                + "      ,[date]\n"
                + "      ,[Group_ID]\n"
                + "  FROM \n"
                + "(SELECT ROW_NUMBER() OVER (ORDER BY id ASC)\n"
                + "as rownum, *  FROM [project].[dbo].[Product]) tbl\n"
                + "WHERE \n"
                + "rownum >= (? -1)*? + 1 AND rownum <= ? * ?";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product s = new Product();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDetail(rs.getString("detail"));
                s.setImage(rs.getString("image"));
                s.setPrice(rs.getFloat("price"));
                s.setNewPrice(rs.getFloat("NewPrice"));
                s.setDate(rs.getDate("date"));
                Products.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Products;
    }

    public int count() {
        ArrayList<Product> Products = new ArrayList<>();
        String sql = "SELECT COUNT(*) as total FROM Product";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
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
        ProductDAO db = new ProductDAO();
    }
}
