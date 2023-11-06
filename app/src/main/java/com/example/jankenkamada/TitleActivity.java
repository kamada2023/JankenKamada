package com.example.jankenkamada;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TitleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_title);

        TextView overAllScore = findViewById(R.id.gameCount);
        TextView resetResult = findViewById(R.id.reset);
        TextView nextSean = findViewById(R.id.nextSean);

        overAllScore.setText(overAllResult());

        resetResult.setOnClickListener(view -> {
            ScoreManager.clearSetCount();
            overAllScore.setText(overAllResult());
        });

        nextSean.setOnClickListener(view -> {
            Intent intent = new Intent(getApplication(), SelectActivity.class);
            startActivity(intent);
        });
    }

    private String overAllResult() {
        return getString(R.string.total_result, ScoreManager.getNumOfMatchesWon(),
                ScoreManager.getNumOfMatchesLost(), ScoreManager.getNumOfMatchesDrawn());
    }
}