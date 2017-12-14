package org.bubulescu.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private EditText etPrviBroj, etDrugiBroj;
    private Button bSum, bSubtract, bMultiply, bDivide;
    private Double prviBroj, drugiBroj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();

    }

    private void initWidgets() {
        tvResult = findViewById(R.id.tvRezultat);
        etPrviBroj = findViewById(R.id.etPrviBroj);
        etDrugiBroj = findViewById(R.id.etDrugiBroj);
        bSum = findViewById(R.id.bSum);
        bSubtract = findViewById(R.id.bSubtract);
        bMultiply = findViewById(R.id.bMultiply);
        bDivide = findViewById(R.id.bDivide);
    }

    private void setupListeners() {
        bSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getnumbers();
                String result = prviBroj + "+" + drugiBroj + "=" + (prviBroj + drugiBroj);
                setResult(result);
            }
        });

        bSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getnumbers();
                String result = prviBroj + "-" + drugiBroj + "=" + (prviBroj - drugiBroj);
                setResult(result);
            }
        });

        bMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getnumbers();
                String result = prviBroj + "*" + drugiBroj + "=" + (prviBroj * drugiBroj);
                setResult(result);
            }
        });

        bDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getnumbers();
                String result = prviBroj + "/" + drugiBroj + "=" + (prviBroj / drugiBroj);
                setResult(result);
            }
        });
    }

    private void getnumbers() {
        if (etPrviBroj.getText().toString().matches("")) prviBroj = 0.0;
        else prviBroj = Double.valueOf(etPrviBroj.getText().toString());

        if (etDrugiBroj.getText().toString().matches("")) drugiBroj = 0.0;
        else drugiBroj = Double.valueOf(etDrugiBroj.getText().toString());
    }

    private void setResult(String result) {
        tvResult.setText(result);
    }

}
