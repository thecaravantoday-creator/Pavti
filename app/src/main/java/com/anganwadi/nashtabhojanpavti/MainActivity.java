package com.anganwadi.nashtabhojanpavti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button hcmButton = findViewById(R.id.hcmButton);
        Button thrButton = findViewById(R.id.thrButton);
        Button thrAtikamButton = findViewById(R.id.thrAtikamButton);
        TextView attribution = findViewById(R.id.hiddenAttribution);

        hcmButton.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, HcmInputActivity.class)));

        thrButton.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ThrInputActivity.class)));

        thrAtikamButton.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ThrAtikamInputActivity.class)));

        attribution.setOnLongClickListener(v -> {
            attribution.setTextColor(0xFF444444);
            attribution.setTextIsSelectable(true);
            return false;
        });

        attribution.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                attribution.setTextColor(0x00000000);
            }
        });
    }
}
