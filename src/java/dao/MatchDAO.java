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
import java.util.Date;
import java.util.List;
import model.Match;
import model.GameBoard;
import model.Player;

/**
 *
 * @author 84382
 */
public class MatchDAO extends DAO{
    public MatchDAO() {
        super();
    }
    public static List<Match> getMatchHistoryByPlayer(Player player) {
        List<Match> listMatch = new ArrayList<>();
        String query = "SELECT * FROM matches WHERE player_id = ?";
        try (Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query)){           
            ps.setInt(1,player.getPlayerId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Match match = new Match();
                match.setMatchId(rs.getInt("match_id"));
                match.setFirstPlayer(rs.getInt("first_player"));
                match.setResult(rs.getInt("result"));
                listMatch.add(match); 
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMatch;
    }
    
}

