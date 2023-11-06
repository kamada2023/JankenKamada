package com.example.jankenkamada;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    enum Hand {
        GU(0),
        CH(1),
        PA(2),
        ;

        private final int id;

        Hand(final int id) {
            this.id = id;
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int count = ScoreManager.getNumOfGames();

        TextView battleShout = findViewById(R.id.battle_shout);
        ImageButton img_g = findViewById(R.id.Gu);
        ImageButton img_t = findViewById(R.id.Tyo);
        ImageButton img_p = findViewById(R.id.Pa);

        if (count > 0) {
            battleShout.setText("第" + (count + 1) + "戦目：じゃーんけーん......");
        }

        Intent intent = new Intent(getApplication(), ResultActivity.class);
        img_g.setOnClickListener(v -> {
            intent.putExtra("hand", Hand.GU.id);
            startActivity(intent);
        });
        img_t.setOnClickListener(v -> {
            intent.putExtra("hand", Hand.CH.id);
            startActivity(intent);
        });
        img_p.setOnClickListener(v -> {
            intent.putExtra("hand", Hand.PA.id);
            startActivity(intent);
        });
    }
}