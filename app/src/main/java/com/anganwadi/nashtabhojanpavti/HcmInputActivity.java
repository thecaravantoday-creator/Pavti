package com.anganwadi.nashtabhojanpavti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HcmInputActivity extends Activity {

    private EditText age3to6;
    private EditText age6mto3;
    private EditText pregnant;
    private EditText atikam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hcm_input);

        age3to6 = findViewById(R.id.inputAge3to6);
        age6mto3 = findViewById(R.id.inputAge6mto3);
        pregnant = findViewById(R.id.inputPregnant);
        atikam = findViewById(R.id.inputAtikam);

        TextView attribution = findViewById(R.id.hiddenAttribution);
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

        Button okButton = findViewById(R.id.okButton);
        okButton.setOnClickListener(v -> {
            Intent intent = new Intent(HcmInputActivity.this, ResultActivity.class);
            intent.putExtra("age3to6", number(age3to6));
            intent.putExtra("age6mto3", number(age6mto3));
            intent.putExtra("pregnant", number(pregnant));
            intent.putExtra("atikam", number(atikam));
            startActivity(intent);
        });
    }

    private int number(EditText editText) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
