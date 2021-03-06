/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import models.KienNghi;

/**
 *
 * @author MSI GV62
 */
public class SapXepService {
    public static Connection conn;
    public static ArrayList<KienNghi> OrderByNameASC() throws SQLException, ClassNotFoundException {
        ArrayList<KienNghi> listKN  = new ArrayList<>();
        conn = MySqlConnection.getMySqlConnection();
        Statement st = conn.createStatement();
        String sql = "SELECT * FROM kien_nghi "
                +    "ORDER BY tieuDe ASC";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            int maKienNghi = rs.getInt("id");
            String tieuDe = rs.getString("tieuDe");
            Date ngayPhanAnh = rs.getDate("ngayPhanAnh");
            String noiDung = rs.getString("noiDung");
            String phanLoai = rs.getString("phanLoai");
            String trangThai = rs.getString("trangThai");
            int nguoigui_id = rs.getInt("nguoigui_id");
            KienNghi kienNghi = new KienNghi(maKienNghi, tieuDe, phanLoai, nguoigui_id, ngayPhanAnh, noiDung, trangThai);
            listKN.add(kienNghi);
        }
        conn = null;
        return listKN;
    }
    
    public static ArrayList<KienNghi> OrderByNameDESC() throws SQLException, ClassNotFoundException {
        ArrayList<KienNghi> listKN  = new ArrayList<>();
        conn = MySqlConnection.getMySqlConnection();
        Statement st = conn.createStatement();
        String sql = "SELECT * FROM kien_nghi "
                +    "ORDER BY tieuDe DESC";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            int maKienNghi = rs.getInt("id");
            String tieuDe = rs.getString("tieuDe");
            Date ngayPhanAnh = rs.getDate("ngayPhanAnh");
            String noiDung = rs.getString("noiDung");
            String phanLoai = rs.getString("phanLoai");
            String trangThai = rs.getString("trangThai");
            int nguoigui_id = rs.getInt("nguoigui_id");
            KienNghi kienNghi = new KienNghi(maKienNghi, tieuDe, phanLoai, nguoigui_id, ngayPhanAnh, noiDung, trangThai);
            listKN.add(kienNghi);
        }
        conn = null;
        return listKN;
    }
    
    public static ArrayList<KienNghi> OrderByDateASC() throws SQLException, ClassNotFoundException {
        Connection conn = MySqlConnection.getMySqlConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM kien_nghi "
                + "WHERE kien_nghi.id NOT IN ("
                + "SELECT kien_nghi_id FROM kn_kng) "
                + "ORDER BY ngayPhanAnh ASC");
        if (rs == null) {
            return null;
        }
        ArrayList<KienNghi> listKienNghiChuaGop = new ArrayList<>();
        while (rs.next()) {
            int maKienNghi = rs.getInt("id");
            String tieuDe = rs.getString("tieuDe");
            Date ngayPhanAnh = rs.getDate("ngayPhanAnh");
            String noiDung = rs.getString("noiDung");
            String phanLoai = rs.getString("phanLoai");
            String trangThai = rs.getString("trangThai");
            int nguoigui_id = rs.getInt("nguoigui_id");
            KienNghi kienNghi = new KienNghi(maKienNghi, tieuDe, phanLoai, nguoigui_id, ngayPhanAnh, noiDung, trangThai);
            listKienNghiChuaGop.add(kienNghi);
            
        }
        conn.close();
        return listKienNghiChuaGop;
  
    }
    
    public static ArrayList<KienNghi> OrderByDateDESC() throws SQLException, ClassNotFoundException {
        ArrayList<KienNghi> listKN  = new ArrayList<>();
        conn = MySqlConnection.getMySqlConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM kien_nghi "
                + "WHERE kien_nghi.id NOT IN ("
                + "SELECT kien_nghi_id FROM kn_kng) "
                + "ORDER BY ngayPhanAnh DESC");
        while (rs.next()) {
            int maKienNghi = rs.getInt("id");
            String tieuDe = rs.getString("tieuDe");
            Date ngayPhanAnh = rs.getDate("ngayPhanAnh");
            String noiDung = rs.getString("noiDung");
            String phanLoai = rs.getString("phanLoai");
            String trangThai = rs.getString("trangThai");
            int nguoigui_id = rs.getInt("nguoigui_id");
            KienNghi kienNghi = new KienNghi(maKienNghi, tieuDe, phanLoai, nguoigui_id, ngayPhanAnh, noiDung, trangThai);
            listKN.add(kienNghi);
        }
        conn = null;
        return listKN;
    }
    public static ArrayList<KienNghi> OrderByStatus(String status) throws SQLException, ClassNotFoundException {
        ArrayList<KienNghi> listKN  = new ArrayList<>();
        conn = MySqlConnection.getMySqlConnection();
        Statement st = conn.createStatement();
        String sql = "SELECT * FROM kien_nghi "
                +    "WHERE trangThai ='" +status +"'";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            int maKienNghi = rs.getInt("id");
            String tieuDe = rs.getString("tieuDe");
            Date ngayPhanAnh = rs.getDate("ngayPhanAnh");
            String noiDung = rs.getString("noiDung");
            String phanLoai = rs.getString("phanLoai");
            String trangThai = rs.getString("trangThai");
            int nguoigui_id = rs.getInt("nguoigui_id");
            KienNghi kienNghi = new KienNghi(maKienNghi, tieuDe, phanLoai, nguoigui_id, ngayPhanAnh, noiDung, trangThai);
            listKN.add(kienNghi);
        }
        conn = null;
        return listKN;
    }
    
    public static ArrayList<KienNghi> OrderByType(String type) throws SQLException, ClassNotFoundException {
        ArrayList<KienNghi> listKN  = new ArrayList<>();
        conn = MySqlConnection.getMySqlConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM kien_nghi "
                + "WHERE kien_nghi.id NOT IN ("
                + "SELECT kien_nghi_id FROM kn_kng) "
                + "AND phanLoai='" + type+"' "
                + "ORDER BY ngayPhanAnh DESC");
        while (rs.next()) {
            int maKienNghi = rs.getInt("id");
            String tieuDe = rs.getString("tieuDe");
            Date ngayPhanAnh = rs.getDate("ngayPhanAnh");
            String noiDung = rs.getString("noiDung");
            String phanLoai = rs.getString("phanLoai");
            String trangThai = rs.getString("trangThai");
            int nguoigui_id = rs.getInt("nguoigui_id");
            KienNghi kienNghi = new KienNghi(maKienNghi, tieuDe, phanLoai, nguoigui_id, ngayPhanAnh, noiDung, trangThai);
            listKN.add(kienNghi);
        }
        conn = null;
        return listKN;
    }    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        List<KienNghi> listkn = OrderByType("Chính sách");
        System.out.println(listkn.toString());
    }
}
