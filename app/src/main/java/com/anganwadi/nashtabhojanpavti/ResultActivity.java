package com.anganwadi.nashtabhojanpavti;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );
        setContentView(R.layout.activity_result);

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        int a = getIntent().getIntExtra("age3to6", 0);
        int b = getIntent().getIntExtra("age6mto3", 0);
        int c = getIntent().getIntExtra("pregnant", 0);
        int d = getIntent().getIntExtra("atikam", 0);

        set(R.id.monBreakfast, a * 100);
        set(R.id.monMeal, a * 175);
        set(R.id.monAtikamCount, d);
        set(R.id.monAtikamQty, d * 135);

        set(R.id.tueBreakfast, (a + b) * 100);
        set(R.id.tueMeal, (a + b) * 130 + c * 250);
        set(R.id.tueAtikamCount, d);
        set(R.id.tueAtikamQty, d * 135);

        set(R.id.wedBreakfast, a * 100);
        set(R.id.wedMeal, a * 150);
        set(R.id.wedAtikamCount, d);
        set(R.id.wedAtikamQty, d * 135);

        set(R.id.thuBreakfast, a * 100);
        set(R.id.thuMeal, a * 170);
        set(R.id.thuAtikamCount, d);
        set(R.id.thuAtikamQty, d * 135);

        set(R.id.friBreakfast, a * 80);
        set(R.id.friMeal, a * 150);
        set(R.id.friAtikamCount, d);
        set(R.id.friAtikamQty, d * 110);

        set(R.id.satBreakfast, a * 100);
        set(R.id.satMeal, a * 175);
        set(R.id.satAtikamCount, d);
        set(R.id.satAtikamQty, d * 135);
    }

    private void set(int id, int value) {
        ((TextView) findViewById(id)).setText(String.valueOf(value));
    }
}


