/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DAO.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Match;
import model.BXH;

/**
 *
 * @author 84382
 */
public class BXHDAO extends DAO{
    public BXHDAO() {
        super();
    }
    public static List<BXH> getRanking() {
        List<BXH> listBXH = new ArrayList<>();
        String query = "SELECT Players.player_id, Players.name," +
"			COUNT(Matches.match_id) AS total," +
"                       SUM(CASE WHEN Matches.result = 1 THEN 1 ELSE 0 END) AS wins, " +
"                       (SUM(CASE WHEN Matches.result = 1 THEN 1 ELSE 0 END) / COUNT(Matches.match_id)) * 100 AS percent" +
"                       FROM Players" +
"                       LEFT JOIN Matches ON Players.player_id = Matches.player_id" +
"                       GROUP BY Players.player_id, Players.name" +
"                       ORDER BY percent DESC,wins DESC";
        try (Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query)){           
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BXH bxh = new BXH();
                bxh.setPlayerId(rs.getInt("player_id"));
                bxh.setName(rs.getString("name"));               
                bxh.setWins(rs.getInt("wins"));
                bxh.setTotal(rs.getInt("total"));
                bxh.setPercent(rs.getInt("percent"));
                listBXH.add(bxh); 
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBXH;
    }
}
