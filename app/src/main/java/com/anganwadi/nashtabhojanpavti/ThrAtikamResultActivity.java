package com.anganwadi.nashtabhojanpavti;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ThrAtikamResultActivity extends Activity {

    private final DecimalFormat kgFormat = new DecimalFormat("0.000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        enterImmersiveMode();
        setContentView(R.layout.activity_thr_atikam_result);

        Button backButton = findViewById(R.id.thrAtikamBackButton);
        backButton.setOnClickListener(v -> finish());

        int a = getIntent().getIntExtra("age6to12", 0);
        int b = getIntent().getIntExtra("age13to24", 0);
        int c = getIntent().getIntExtra("age25to36", 0);
        int d = getIntent().getIntExtra("age37to48", 0);
        int e = getIntent().getIntExtra("age61to72", 0);

        double aKg = a * 410.0 / 1000.0;
        double bKg = b * 570.0 / 1000.0;
        double cKg = c * 650.0 / 1000.0;
        double dKg = d * 650.0 / 1000.0;
        double eKg = e * 650.0 / 1000.0;

        populateRow(R.id.a612Eligible, R.id.a612Packets, R.id.a612ExpectedKg,
                R.id.a612ReceivedPackets, R.id.a612ReceivedKg, a, aKg);
        populateRow(R.id.a1324Eligible, R.id.a1324Packets, R.id.a1324ExpectedKg,
                R.id.a1324ReceivedPackets, R.id.a1324ReceivedKg, b, bKg);
        populateRow(R.id.a2536Eligible, R.id.a2536Packets, R.id.a2536ExpectedKg,
                R.id.a2536ReceivedPackets, R.id.a2536ReceivedKg, c, cKg);
        populateRow(R.id.a3748Eligible, R.id.a3748Packets, R.id.a3748ExpectedKg,
                R.id.a3748ReceivedPackets, R.id.a3748ReceivedKg, d, dKg);
        populateRow(R.id.a6172Eligible, R.id.a6172Packets, R.id.a6172ExpectedKg,
                R.id.a6172ReceivedPackets, R.id.a6172ReceivedKg, e, eKg);

        int totalPackets = a + b + c + d + e;
        double totalKg = aKg + bKg + cKg + dKg + eKg;

        setInt(R.id.atikamTotalEligible, totalPackets);
        setInt(R.id.atikamTotalPacketsRow, totalPackets);
        setKg(R.id.atikamTotalExpectedKg, totalKg);
        setInt(R.id.atikamTotalReceivedPackets, totalPackets);
        setKg(R.id.atikamTotalReceivedKg, totalKg);

        setInt(R.id.atikamSummaryPackets, totalPackets);
        setText(R.id.atikamSummaryKg, kgFormat.format(totalKg) + " Kg");
    }

    private void populateRow(int eligibleId, int packetsId, int expectedKgId,
                             int receivedPacketsId, int receivedKgId,
                             int count, double kg) {
        setInt(eligibleId, count);
        setInt(packetsId, count);
        setKg(expectedKgId, kg);
        setInt(receivedPacketsId, count);
        setKg(receivedKgId, kg);
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
