package com.example.jankenkamada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class ResultActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        long seed = System.currentTimeMillis();
        Random rnd = new Random(seed);
        int cpu_hand = rnd.nextInt(3);

        Intent intent = getIntent();
        int user_hand = intent.getIntExtra("hand", 0);

        Button button = findViewById(R.id.nextBattle);
        ImageView myImage = findViewById(R.id.result_draw);

        ScoreManager.setNumOfGames();

        if (user_hand == cpu_hand) {
            if (ScoreManager.getNumOfGames() <= ScoreManager.getTotalNumOfGames()) {
                ScoreManager.setNumOfDraws();
            }
            myImage.setImageResource(R.drawable.draw);
            TextView textView = findViewById(R.id.result);
            textView.setText(R.string.draw);
        } else if ((user_hand == 2 && cpu_hand == 0) || (user_hand + 1) == cpu_hand) {
            if (ScoreManager.getNumOfGames() <= ScoreManager.getTotalNumOfGames()) {
                ScoreManager.setNumOfWins();
            }
            myImage.setImageResource(R.drawable.win);
            TextView textView = findViewById(R.id.result);
            textView.setText(R.string.win);
        } else {
            if (ScoreManager.getNumOfGames() <= ScoreManager.getTotalNumOfGames()) {
                ScoreManager.setNumOfLoses();
            }
            myImage.setImageResource(R.drawable.lose);
            TextView textView = findViewById(R.id.result);
            textView.setText(R.string.lose);
        }

        ImageView cpu_hands = findViewById(R.id.cpu_hand);
        cpu_hands.setImageResource(handDisplay(cpu_hand));

        ImageView user_hands = findViewById(R.id.user_hand);
        user_hands.setImageResource(handDisplay(user_hand));

        if (ScoreManager.getNumOfGames() == 1) {
            button.setText(R.string.next_battle);
        } else {
            button.setText(R.string.next_sean);
        }

        button.setOnClickListener(v -> ContinueOrEnd());
    }

    private int handDisplay(int hand_id) {
        if (hand_id == Hand.GU.id) {
            return R.drawable.j_gu02;
        } else if (hand_id == Hand.CH.id) {
            return R.drawable.j_ch02;
        } else {
            return R.drawable.j_pa02;
        }
    }

    private void ContinueOrEnd() {
        Intent ConOrEnd;
        Intent first = new Intent(getApplication(), MainActivity.class);
        Intent con = new Intent(getApplication(), HalfwayProgressActivity.class);
        Intent end = new Intent(getApplication(), FinalResultActivity.class);

        int game = ScoreManager.getTotalNumOfGames();
        int rounds = ScoreManager.getNumOfGames();
        int win = ScoreManager.getNumOfWins();
        int lose = ScoreManager.getNumOfLoses();

        if (rounds == 1) {
            ConOrEnd = first;
        } else {
            ConOrEnd = con;
        }

        if (ScoreManager.getBattleFormat() == 1) {
            if ((win - lose) > (game - rounds)) {
                ConOrEnd = end;
            } else if ((lose - win) > (game - rounds)) {
                ConOrEnd = end;
            } else if (ScoreManager.getNumOfDraws() > (game / 2)) {
                ConOrEnd = end;
            }
        }

        if (game == rounds) {
            ConOrEnd = end;
        } else if (game < rounds) {
            ConOrEnd = end;
        }

        startActivity(ConOrEnd);
    }
}
