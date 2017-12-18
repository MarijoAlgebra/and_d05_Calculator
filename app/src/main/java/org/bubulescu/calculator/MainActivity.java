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
                if (getnumbers()) {
                    String result = prviBroj + "+" + drugiBroj + "=" + (prviBroj + drugiBroj);
                    setResult(result);
                }
            }
        });

        bSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getnumbers()) {
                    String result = prviBroj + "-" + drugiBroj + "=" + (prviBroj - drugiBroj);
                    setResult(result);
                }
            }
        });

        bMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getnumbers()) {
                    String result = prviBroj + "*" + drugiBroj + "=" + (prviBroj * drugiBroj);
                    setResult(result);
                }
            }
        });

        bDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getnumbers()) {
                    String result = prviBroj + "/" + drugiBroj + "=" + (prviBroj / drugiBroj);
                    setResult(result);
                }
            }
        });
    }

    private Boolean getnumbers() {
        Boolean retVal;

        if (!etPrviBroj.getText().toString().trim().isEmpty()) {
            prviBroj = Double.valueOf(etPrviBroj.getText().toString());
            retVal = true;
        } else {
            etPrviBroj.setError("Unesi prvi broj!");
            retVal = false;
        }

        if (retVal && !etDrugiBroj.getText().toString().trim().isEmpty()) {
            drugiBroj = Double.valueOf(etDrugiBroj.getText().toString());
            retVal = true;
        } else {
            etDrugiBroj.setError("Unesi drugi broj!");
            retVal = false;
        }

        return retVal;
    }

    private void setResult(String result) {
        tvResult.setText(result);
    }

}
