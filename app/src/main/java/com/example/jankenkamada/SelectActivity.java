package com.example.jankenkamada;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SelectActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        CountApp countApp = (CountApp) this.getApplication();
        Intent intent = new Intent(getApplication(),MainActivity.class);

        TextView textView = findViewById(R.id.gameMode);
        TextView textView2 = findViewById(R.id.rule);
        TextView textView3 = findViewById(R.id.round_count);
        SeekBar modeSeekbar = findViewById(R.id.mode_change);
        SeekBar countSet = findViewById(R.id.gameCount);
        Button button = findViewById(R.id.game_start);

        countApp.setBattleFormat(0);
        textView.setText("総当たり戦");
        textView3.setText("回数："+countApp.getCount());

        modeSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (i == 1){
                    countApp.setBattleFormat(i);
                    textView.setText("星取り　戦");
                    textView2.setText(
                            "1.対戦形式は任意で1～10まで対戦できます\n" +
                            "2.設定した回戦数の半分以上を満たした場合終了します\n" +
                            "3.設定した回数を達した場合終了します\n"+
                            "4.設定した回数が半分以上があいこだった場合は引き分けとします");

                }else {
                    countApp.setBattleFormat(i);
                    textView.setText("総当たり戦");
                    textView2.setText(
                            "1.対戦形式は任意で1～10まで対戦できます\n" +
                            "2.対戦は勝敗に問わずカウントします\n" +
                            "3.設定した値まで終了しません\n" +
                            "4.結果は総合的に判断します");
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
                countApp.setCount(i+1);
                textView3.setText("回数："+(i+1));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(v -> {
            startActivity(intent);
        });
    }
}
