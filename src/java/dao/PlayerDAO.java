/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DAO.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Player;

/**
 *
 * @author 84382
 */
public class PlayerDAO extends DAO{
    public PlayerDAO() {
        super();
    }

    public static boolean kiemtraDangnhap(Player player) {
        boolean kq = false;
        String sql = "select * from players where username = ? and password = ?";
        try {
            Connection con = null;
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, player.getUsername());
            ps.setString(2, player.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                player.setPlayerId(rs.getInt("player_id"));
                player.setEmail(rs.getString("email"));
                player.setName(rs.getString("name"));
                kq = true;
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            kq = false;
        }
        return kq;
    }
}
