package com.anganwadi.nashtabhojanpavti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ThrInputActivity extends Activity {

    private EditText child6mTo3;
    private EditText pregnantLactating;
    private EditText adolescentGirls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thr_input);

        child6mTo3 = findViewById(R.id.inputThrChild);
        pregnantLactating = findViewById(R.id.inputThrPregnant);
        adolescentGirls = findViewById(R.id.inputThrAdolescent);

        Button nextButton = findViewById(R.id.thrNextButton);
        nextButton.setOnClickListener(v -> {
            Intent intent = new Intent(ThrInputActivity.this, ThrResultActivity.class);
            intent.putExtra("child", number(child6mTo3));
            intent.putExtra("pregnant", number(pregnantLactating));
            intent.putExtra("adolescent", number(adolescentGirls));
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
