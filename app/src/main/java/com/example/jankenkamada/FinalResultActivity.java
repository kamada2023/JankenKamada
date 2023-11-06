package com.example.jankenkamada;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinalResultActivity extends AppCompatActivity {

    int countWin_fin = ScoreManager.getNumOfWins();
    int countLose_fin = ScoreManager.getNumOfLoses();
    int countDraw_fin = ScoreManager.getNumOfDraws();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalresult);

        ImageView result = findViewById(R.id.result_draw_final);
        TextView win = findViewById(R.id.fin_countWin);
        TextView lose = findViewById(R.id.fin_countLose);
        TextView draw = findViewById(R.id.fin_countDraw);
        Button button = findViewById(R.id.backTitle);

        Intent intent = new Intent(getApplication(), TitleActivity.class);

        result.setImageResource(resultTitle());

        win.setText("勝った数：" + countWin_fin);
        lose.setText("負けた数：" + countLose_fin);
        draw.setText("引き分け数：" + countDraw_fin);

        button.setOnClickListener(view -> {
            ScoreManager.clearCount();
            startActivity(intent);
        });
    }

    private int resultTitle() {
        int HalfDrawCount = ScoreManager.getTotalNumOfGames() / 2;

        if (ScoreManager.getBattleFormat() == 1 && countDraw_fin > HalfDrawCount) {
            ScoreManager.setNumOfMatchesDrawn();
            return R.drawable.drawgame;
        } else {
            if (countWin_fin > countLose_fin) {
                ScoreManager.setNumOfMatchesWon();
                return R.drawable.youwin;
            } else if (countLose_fin > countWin_fin) {
                ScoreManager.setNumOfMatchesLost();
                return R.drawable.youlose;
            } else {
                ScoreManager.setNumOfMatchesDrawn();
                return R.drawable.drawgame;
            }
        }
    }
}
