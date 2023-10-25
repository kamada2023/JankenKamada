package com.example.jankenkamada;

import android.app.Application;

public class CountApp extends Application {
    private static int Count = 1;
    private static int AddCount = 0;
    private static int WinCount = 0;
    private static int LoseCount = 0;
    private static int DrawCount = 0;
    private static int BattleFormat = 0;
    private static int NumOfWins = 0;
    private static int NumOfLoses = 0;
    private static int NumOfDraws = 0;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public int getCount(){
        return Count;
    }

    public void setCount(int count){
        Count = count;
    }

    public int getAddCount(){
        return AddCount;
    }

    public void setAddCount(int addCount){
        AddCount += addCount;
    }

    public int getWinCount() {
        return WinCount;
    }

    public void setWinCount(int winCount) {
        WinCount += winCount;
    }

    public int getLoseCount() {
        return LoseCount;
    }

    public void setLoseCount(int loseCount) {
        LoseCount += loseCount;
    }

    public int getDrawCount() {
        return DrawCount;
    }

    public void setDrawCount(int drawCount) {
        DrawCount += drawCount;
    }

    public void clearCount(){
        Count = 1;
        AddCount = 0;
        WinCount = 0;
        LoseCount = 0;
        DrawCount = 0;
    }

    public int getBattleFormat() {
        return BattleFormat;
    }

    public void setBattleFormat(int battleFormat) {
        BattleFormat = battleFormat;
    }

    public int getNumOfWins() {
        return NumOfWins;
    }

    public void setNumOfWins(int numOfWins) {
        NumOfWins += numOfWins;
    }

    public int getNumOfLoses() {
        return NumOfLoses;
    }

    public void setNumOfLoses(int numOfLoses) {
        NumOfLoses += numOfLoses;
    }

    public int getNumOfDraws() {
        return NumOfDraws;
    }

    public void setNumOfDraws(int numOfDraws) {
        NumOfDraws += numOfDraws;
    }

    public void clearSetCount(){
        NumOfWins = 0;
        NumOfLoses = 0;
        NumOfDraws = 0;
    }
}
