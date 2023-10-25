package com.example.jankenkamada;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;


public class ResultActivity extends AppCompatActivity {

    private CountApp countApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        long seed = System.currentTimeMillis();
        Random rnd = new Random(seed);
        int r = rnd.nextInt(3);

        Intent intent = getIntent();
        int id = intent.getIntExtra("hand",0);

        Button button = findViewById(R.id.nextBattle);
        ImageView myImage = findViewById(R.id.result_draw);

        countApp = (CountApp)this.getApplication();
        countApp.setAddCount(1);

        if (id == r) {
            if (countApp.getAddCount() <= countApp.getCount()){
                countApp.setDrawCount(1);
            }
            myImage.setImageResource(R.drawable.draw);
            TextView textView = findViewById(R.id.result);
            textView.setText("引き分け");
        } else if ((id==2 && r==0) || (id+1)==r) {
            if (countApp.getAddCount() <= countApp.getCount()){
                countApp.setWinCount(1);
            }
            myImage.setImageResource(R.drawable.win);
            TextView textView = findViewById(R.id.result);
            textView.setText("あんたの勝ち！！");
        } else {
            if (countApp.getAddCount() <= countApp.getCount()){
                countApp.setLoseCount(1);
            }
            myImage.setImageResource(R.drawable.lose);
            TextView textView = findViewById(R.id.result);
            textView.setText("あなたの負け..");
        }

        if(r==0){
            ImageView cpu_hands = findViewById(R.id.cpu_hand);
            cpu_hands.setImageResource(R.drawable.j_gu02);
        } else if (r==1) {
            ImageView cpu_hands = findViewById(R.id.cpu_hand);
            cpu_hands.setImageResource(R.drawable.j_ch02);
        }else{
            ImageView cpu_hands = findViewById(R.id.cpu_hand);
            cpu_hands.setImageResource(R.drawable.j_pa02);
        }

        if(id==0){
            ImageView cpu_hands = findViewById(R.id.user_hand);
            cpu_hands.setImageResource(R.drawable.j_gu02);
        } else if (id==1) {
            ImageView cpu_hands = findViewById(R.id.user_hand);
            cpu_hands.setImageResource(R.drawable.j_ch02);
        }else{
            ImageView cpu_hands = findViewById(R.id.user_hand);
            cpu_hands.setImageResource(R.drawable.j_pa02);
        }

        if(countApp.getAddCount() == 1){
            button.setText("次の対戦へ");
        }else {
            button.setText("次のシーンへ");
        }

        button.setOnClickListener(v -> {
            ContinueOrEnd();
        });
    }
    private void ContinueOrEnd(){
        Intent ConOrEnd;
        Intent first = new Intent(getApplication(),MainActivity.class);
        Intent con = new Intent(getApplication(),HalfwayProgressActivity.class);
        Intent end = new Intent(getApplication(),FinalResultActivity.class);

        countApp = (CountApp)this.getApplication();
        int game = countApp.getCount();
        int rounds = countApp.getAddCount();
        int win = countApp.getWinCount();
        int lose = countApp.getLoseCount() ;

        if(rounds == 1) {ConOrEnd = first;}
        else {ConOrEnd = con;}

        if (countApp.getBattleFormat() == 1){
            if ((win - lose) > (game-rounds)){
                ConOrEnd = end;
            } else if ((lose - win) > (game-rounds)) {
                ConOrEnd = end;
            } else if (countApp.getDrawCount() > (game/2)) {
                ConOrEnd = end;
            }
        }

        if (game == rounds) {
            ConOrEnd = end;
        } else if (game < rounds){
            ConOrEnd = end;
        }


        startActivity(ConOrEnd);
    }
}
