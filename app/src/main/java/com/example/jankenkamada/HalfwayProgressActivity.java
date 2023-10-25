package com.example.jankenkamada;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HalfwayProgressActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halfway);

        CountApp countApp = (CountApp) this.getApplication();
        int countWin = countApp.getWinCount();
        int countLose = countApp.getLoseCount();
        int countDraw = countApp.getDrawCount();

        TextView battleCount = findViewById(R.id.battleCount);
        TextView win = findViewById(R.id.count_win);
        TextView lose = findViewById(R.id.count_lose);
        TextView draw = findViewById(R.id.count_draw);
        Button button = findViewById(R.id.nextBattle);

        battleCount.setText(countApp.getAddCount() + "戦目だよ");
        win.setText("勝った数："+countWin);
        lose.setText("負けた数："+countLose);
        draw.setText("引き分け数："+countDraw);

        Intent intent = new Intent(getApplication(),MainActivity.class);
        button.setOnClickListener(v -> {
            startActivity(intent);
        });
    }

}
