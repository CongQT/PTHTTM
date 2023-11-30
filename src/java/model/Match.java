/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84382
 */
public class Match {
    private int matchId;
    private Player player;
    private int result;
    private int firstPlayer;

    public Match(int matchId, Player player, int result, int firstPlayer) {
        this.matchId = matchId;
        this.player = player;
        this.result = result;
        this.firstPlayer = firstPlayer;
    }

    public Match() {
    }
    
    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(int firstPlayer) {
        this.firstPlayer = firstPlayer;
    }
    
    
}
