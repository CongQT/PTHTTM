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
import model.GameBoard;

/**
 *
 * @author 84382
 */
public class GameBoardDAO extends DAO{
    public GameBoardDAO() {
        super();
    }
    public static List<GameBoard> getGameBoardByMatch(Match match) {
        List<GameBoard> listMove = new ArrayList<>();
        String query = "SELECT * FROM gameboards WHERE match_id = ?";
        try (Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query)){           
            ps.setInt(1,match.getMatchId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GameBoard move = new GameBoard();
                move.setGameBoardId(rs.getInt("gameboard_id"));
                move.setCol1(rs.getInt("col1"));
                move.setRow1(rs.getInt("row1"));
                move.setSymbol(rs.getInt("symbol"));
                listMove.add(move); 
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMove;
    }
}
