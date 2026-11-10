package com.anganwadi.nashtabhojanpavti;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ThrResultActivity extends Activity {

    private final DecimalFormat kgFormat = new DecimalFormat("0.###");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        enterImmersiveMode();
        setContentView(R.layout.activity_thr_result);

        Button backButton = findViewById(R.id.thrBackButton);
        backButton.setOnClickListener(v -> finish());

        int child = getIntent().getIntExtra("child", 0);
        int pregnant = getIntent().getIntExtra("pregnant", 0);
        int adolescent = getIntent().getIntExtra("adolescent", 0);

        int childPackets = child * 2;
        double childKg = childPackets * 725.0 / 1000.0;

        int pregnantPackets = pregnant * 2;
        double pregnantKg = pregnantPackets * 850.0 / 1000.0;

        setInt(R.id.thrChildCount, child);
        setInt(R.id.thrChildPackets, childPackets);
        setKg(R.id.thrChildExpectedKg, childKg);
        setInt(R.id.thrChildReceivedPackets, childPackets);
        setKg(R.id.thrChildReceivedKg, childKg);

        setInt(R.id.thrPregnantCount, pregnant);
        setInt(R.id.thrPregnantPackets, pregnantPackets);
        setKg(R.id.thrPregnantExpectedKg, pregnantKg);
        setInt(R.id.thrPregnantReceivedPackets, pregnantPackets);
        setKg(R.id.thrPregnantReceivedKg, pregnantKg);

        // The current source sheet contains this beneficiary category but no verified
        // packet/weight formula. Keep the entered count visible and calculation cells blank.
        setInt(R.id.thrAdolescentCount, adolescent);
        setText(R.id.thrAdolescentPackets, "");
        setText(R.id.thrAdolescentExpectedKg, "");
        setText(R.id.thrAdolescentReceivedPackets, "");
        setText(R.id.thrAdolescentReceivedKg, "");

        setInt(R.id.thrTotalPackets, childPackets + pregnantPackets);
        setText(R.id.thrTotalKg, kgFormat.format(childKg + pregnantKg) + " Kg");
    }

    private void enterImmersiveMode() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );
    }

    private void setInt(int id, int value) {
        setText(id, String.valueOf(value));
    }

    private void setKg(int id, double value) {
        setText(id, kgFormat.format(value));
    }

    private void setText(int id, String value) {
        ((TextView) findViewById(id)).setText(value);
    }
}
