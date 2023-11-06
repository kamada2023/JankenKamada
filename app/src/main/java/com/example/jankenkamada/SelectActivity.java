package com.example.jankenkamada;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SelectActivity extends AppCompatActivity {

    enum battleMode {
        ROUND_ROBIN_BATTLE(0),
        STAR_BATTLE(1),
        ;

        final int mode;

        battleMode(final int mode) {
            this.mode = mode;
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        Intent intent = new Intent(getApplication(), MainActivity.class);

        TextView gameMode = findViewById(R.id.gameMode);
        TextView rule = findViewById(R.id.rule);
        TextView roundCount = findViewById(R.id.round_count);
        SeekBar modeSeekbar = findViewById(R.id.mode_change);
        SeekBar countSet = findViewById(R.id.gameCount);
        Button gameStart = findViewById(R.id.game_start);

        ScoreManager.setBattleFormat(0);
        gameMode.setText(R.string.round_robin_battle);
        roundCount.setText("回数：" + ScoreManager.getTotalNumOfGames());

        modeSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (i == battleMode.STAR_BATTLE.mode) {
                    ScoreManager.setBattleFormat(battleMode.STAR_BATTLE.mode);
                    gameMode.setText(R.string.star_battle);
                    rule.setText(R.string.rule2);

                } else {
                    ScoreManager.setBattleFormat(battleMode.ROUND_ROBIN_BATTLE.mode);
                    gameMode.setText(R.string.round_robin_battle);
                    rule.setText(R.string.rule1);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        countSet.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ScoreManager.setTotalNumOfGames(i + 1);
                roundCount.setText("回数：" + (i + 1));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        gameStart.setOnClickListener(v -> startActivity(intent));
    }
}
