package com.example.jankenkamada;

public class ScoreManager {
    private static int totalNumOfGames;
    private static int numOfGames;
    private static int numOfWins;
    private static int numOfLoses;
    private static int numOfDraws;
    private static int battleFormat;
    private static int numOfMatchesWon;
    private static int numOfMatchesLost;
    private static int numOfMatchesDrawn;

    public static int getTotalNumOfGames() {
        return totalNumOfGames;
    }

    public static void setTotalNumOfGames(int totalNumOfGame) {
        ScoreManager.totalNumOfGames = totalNumOfGame;
    }

    public static int getNumOfGames() {
        return numOfGames;
    }

    public static void setNumOfGames() {
        ScoreManager.numOfGames++;
    }

    public static int getNumOfWins() {
        return numOfWins;
    }

    public static void setNumOfWins() {
        ScoreManager.numOfWins++;
    }

    public static int getNumOfLoses() {
        return numOfLoses;
    }

    public static void setNumOfLoses() {
        ScoreManager.numOfLoses++;
    }

    public static int getNumOfDraws() {
        return numOfDraws;
    }

    public static void setNumOfDraws() {
        ScoreManager.numOfDraws++;
    }

    public static void clearCount() {
        totalNumOfGames = 1;
        numOfGames = 0;
        numOfWins = 0;
        numOfLoses = 0;
        numOfDraws = 0;
    }

    public static int getBattleFormat() {
        return battleFormat;
    }

    public static void setBattleFormat(int battleFormat) {
        ScoreManager.battleFormat = battleFormat;
    }

    public static int getNumOfMatchesWon() {
        return numOfMatchesWon;
    }

    public static void setNumOfMatchesWon() {
        ScoreManager.numOfMatchesWon++;
    }

    public static int getNumOfMatchesLost() {
        return numOfMatchesLost;
    }

    public static void setNumOfMatchesLost() {
        ScoreManager.numOfMatchesLost++;
    }

    public static int getNumOfMatchesDrawn() {
        return numOfMatchesDrawn;
    }

    public static void setNumOfMatchesDrawn() {
        ScoreManager.numOfMatchesDrawn++;
    }

    public static void clearSetCount() {
        numOfMatchesWon = 0;
        numOfMatchesLost = 0;
        numOfMatchesDrawn = 0;
    }
}
