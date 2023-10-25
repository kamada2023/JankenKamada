package com.example.jankenkamada;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinalResultActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalresult);

        CountApp countApp = (CountApp) this.getApplication();
        int countWin_fin = countApp.getWinCount();
        int countLose_fin = countApp.getLoseCount();
        int countDraw_fin = countApp.getDrawCount();

        ImageView result = findViewById(R.id.result_draw_final);
        TextView win = findViewById(R.id.fin_countWin);
        TextView lose = findViewById(R.id.fin_countLose);
        TextView draw = findViewById(R.id.fin_countDraw);
        Button button = findViewById(R.id.backTitle);

        Intent intent = new Intent(getApplication(),TitleActivity.class);

        if (countWin_fin > countLose_fin){
            result.setImageResource(R.drawable.youwin);
            countApp.setNumOfWins(1);
        } else if (countLose_fin > countWin_fin){
            result.setImageResource(R.drawable.youlose);
            countApp.setNumOfLoses(1);
        } else {
            result.setImageResource(R.drawable.drawgame);
            countApp.setNumOfDraws(1);
        }
        if(countApp.getBattleFormat() == 1){
            if (countDraw_fin > (countApp.getCount() / 2)){
                result.setImageResource(R.drawable.drawgame);
                countApp.setNumOfDraws(1);
            }
        }

        win.setText("勝った数："+countWin_fin);
        lose.setText("負けた数："+countLose_fin);
        draw.setText("引き分け数："+countDraw_fin);

        button.setOnClickListener(view -> {
            countApp.clearCount();
            startActivity(intent);
        });
    }
}
