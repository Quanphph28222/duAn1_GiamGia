/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.impl;

import Model.MaGiamGia;
import Repository.MaGiamGiaRepository;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class MaGiamGiaRepositoryImpl implements MaGiamGiaRepository {

    @Override
    public List<MaGiamGia> getAll() {
        String query = "SELECT [id]\n"
                + "      ,[maGiamGia]\n"
                + "      ,[ngayBatDau]\n"
                + "      ,[ngayKetThuc]\n"
                + "      ,[trangThai]\n"
                + "  FROM [dbo].[GiamGia]";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<MaGiamGia> listMa = new ArrayList<>();
            while (rs.next()) {
                MaGiamGia ma = new MaGiamGia(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4));
                listMa.add(ma);
            }
            return listMa;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean addMa(MaGiamGia ma) {
        int check = 0;
        String query = "INSERT INTO [dbo].[GiamGia]\n"
                + "           ([id]\n"
                + "           ,[maGiamGia]\n"
                + "           ,[ngayBatDau]\n"
                + "           ,[ngayKetThuc])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?)";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma.getMaGiamGia());
            ps.setObject(2, ma.getNgayBatDau());
            ps.setObject(3, ma.getNgayKetThuc());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean updateMa(String id, MaGiamGia ma) {
        int check = 0;
        String sql = "UPDATE [dbo].[GiamGia]\n"
                + "   SET [id] = <id, uniqueidentifier,>\n"
                + "      ,[maGiamGia] = <maGiamGia, nchar(10),>\n"
                + "      ,[ngayBatDau] = <ngayBatDau, date,>\n"
                + "      ,[ngayKetThuc] = <ngayKetThuc, date,>\n"
                + " WHERE id = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma.getMaGiamGia());
            ps.setObject(2, ma.getNgayBatDau());
            ps.setObject(3, ma.getNgayKetThuc());
            ps.setObject(4, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(String id) {
        int check = 0;
        String sql = "DELETE FROM [dbo].[GiamGia]\n"
                + "      WHERE id = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean searchMa(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
