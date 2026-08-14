package com.anganwadi.nashtabhojanpavti;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText age3to6;
    private EditText age6mto3;
    private EditText pregnant;
    private EditText atikam;

    private int[] outputIds = {
            R.id.monBreakfast, R.id.monMeal, R.id.monAtikamCount, R.id.monAtikamQty,
            R.id.tueBreakfast, R.id.tueMeal, R.id.tueAtikamCount, R.id.tueAtikamQty,
            R.id.wedBreakfast, R.id.wedMeal, R.id.wedAtikamCount, R.id.wedAtikamQty,
            R.id.thuBreakfast, R.id.thuMeal, R.id.thuAtikamCount, R.id.thuAtikamQty,
            R.id.friBreakfast, R.id.friMeal, R.id.friAtikamCount, R.id.friAtikamQty,
            R.id.satBreakfast, R.id.satMeal, R.id.satAtikamCount, R.id.satAtikamQty
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        age3to6 = findViewById(R.id.inputAge3to6);
        age6mto3 = findViewById(R.id.inputAge6mto3);
        pregnant = findViewById(R.id.inputPregnant);
        atikam = findViewById(R.id.inputAtikam);

        TextWatcher watcher = new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateResults();
            }
            @Override public void afterTextChanged(Editable s) {}
        };

        age3to6.addTextChangedListener(watcher);
        age6mto3.addTextChangedListener(watcher);
        pregnant.addTextChangedListener(watcher);
        atikam.addTextChangedListener(watcher);

        updateResults();
    }

    private int number(EditText editText) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty()) return 0;
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    private void set(int id, int value) {
        ((TextView) findViewById(id)).setText(String.valueOf(value));
    }

    private void updateResults() {
        int a = number(age3to6);   // 03 से 06 वर्ष
        int b = number(age6mto3);  // 06 माह से 03 वर्ष
        int c = number(pregnant);  // गर्भवती/धात्री
        int d = number(atikam);    // अतिकम

        // सोमवार
        set(R.id.monBreakfast, a * 100);
        set(R.id.monMeal, a * 175);
        set(R.id.monAtikamCount, d);
        set(R.id.monAtikamQty, d * 135);

        // मंगलवार
        set(R.id.tueBreakfast, (a + b) * 100);
        set(R.id.tueMeal, (a + b) * 130 + c * 250);
        set(R.id.tueAtikamCount, d);
        set(R.id.tueAtikamQty, d * 135);

        // बुधवार
        set(R.id.wedBreakfast, a * 100);
        set(R.id.wedMeal, a * 150);
        set(R.id.wedAtikamCount, d);
        set(R.id.wedAtikamQty, d * 135);

        // गुरुवार
        set(R.id.thuBreakfast, a * 100);
        set(R.id.thuMeal, a * 170);
        set(R.id.thuAtikamCount, d);
        set(R.id.thuAtikamQty, d * 135);

        // शुक्रवार
        set(R.id.friBreakfast, a * 80);
        set(R.id.friMeal, a * 150);
        set(R.id.friAtikamCount, d);
        set(R.id.friAtikamQty, d * 110);

        // शनिवार
        set(R.id.satBreakfast, a * 100);
        set(R.id.satMeal, a * 175);
        set(R.id.satAtikamCount, d);
        set(R.id.satAtikamQty, d * 135);
    }
}
