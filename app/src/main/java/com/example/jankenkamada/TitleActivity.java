package com.example.jankenkamada;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TitleActivity extends AppCompatActivity {
    private CountApp countApp;
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_title);

        countApp = (CountApp)this.getApplication();

        TextView textView1 = findViewById(R.id.gameCount);
        TextView textView2 = findViewById(R.id.reset);
        TextView textView3 = findViewById(R.id.nextSean);

        String totalResult = getString(R.string.total_result,countApp.getNumOfWins(),
                countApp.getNumOfLoses(),countApp.getNumOfDraws());
        textView1.setText(totalResult);

        textView2.setOnClickListener(view -> {
            countApp.clearSetCount();
            textView1.setText(totalResult);
        });

        textView3.setOnClickListener(view -> {
            Intent intent = new Intent(getApplication(), SelectActivity.class);
            startActivity(intent);
        });
    }
}
