package com.anganwadi.nashtabhojanpavti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ThrAtikamInputActivity extends Activity {

    private EditText age6to12;
    private EditText age13to24;
    private EditText age25to36;
    private EditText age37to48;
    private EditText age61to72;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thr_atikam_input);

        age6to12 = findViewById(R.id.inputAtikam6to12);
        age13to24 = findViewById(R.id.inputAtikam13to24);
        age25to36 = findViewById(R.id.inputAtikam25to36);
        age37to48 = findViewById(R.id.inputAtikam37to48);
        age61to72 = findViewById(R.id.inputAtikam61to72);

        Button nextButton = findViewById(R.id.thrAtikamNextButton);
        nextButton.setOnClickListener(v -> {
            Intent intent = new Intent(ThrAtikamInputActivity.this, ThrAtikamResultActivity.class);
            intent.putExtra("age6to12", number(age6to12));
            intent.putExtra("age13to24", number(age13to24));
            intent.putExtra("age25to36", number(age25to36));
            intent.putExtra("age37to48", number(age37to48));
            intent.putExtra("age61to72", number(age61to72));
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
