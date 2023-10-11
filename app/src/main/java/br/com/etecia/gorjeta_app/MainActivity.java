package br.com.etecia.gorjeta_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText editTextAccountValue, editTextTipValue, editTextAccountTotalValue;
    Spinner spinnerQuality;

    Button btnCalcTip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAccountValue = (EditText) findViewById(R.id.idAccountValue);
        spinnerQuality = (Spinner) findViewById(R.id.idServiceQuality);
        editTextTipValue = (EditText) findViewById(R.id.idTipValue);
        editTextAccountTotalValue = (EditText) findViewById(R.id.idAccountTotalValue);
        btnCalcTip = (Button) findViewById(R.id.idBtnCalcTip);


        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(
                this,
                R.array.qualities_array,
                android.R.layout.simple_spinner_item
        );

        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerQuality.setAdapter(adapterSpinner);

        disableEditText(editTextTipValue);
        disableEditText(editTextAccountTotalValue);

        btnCalcTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextTipValue.setText("R$ " + getTipValue());
            }
        });


    }

    private void disableEditText(EditText editText) {
        editText.setFocusable(false);
        editText.setEnabled(false);
        editText.setCursorVisible(false);
        editText.setKeyListener(null);
        editText.setBackgroundColor(Color.TRANSPARENT);
    }

    String quality = spinnerQuality.getSelectedItem().toString();

    public String getTipValue() {
        int accountValue = Integer.parseInt(editTextAccountValue.getText().toString());

        double tipValue = accountValue * getQualityResult(quality);

        return String.valueOf(tipValue);
    }

    public double getQualityResult(String q) {
        if(quality.equals("Excelente - 10%")) {
            return setIntInQualitySpinner(QualityType.EXCELLENT);
        }
        if(quality.equals("Ótimo - 8%")) {
            return setIntInQualitySpinner(QualityType.GREAT);
        }
        if(quality.equals("Bom - 5%")) {
            return setIntInQualitySpinner(QualityType.GOOD);
        }
        if(quality.equals("Ruim - 2%")) {
            return setIntInQualitySpinner(QualityType.BAD);
        }
        return 0D;
    }

    public double setIntInQualitySpinner(QualityType type) {
        switch (type) {
            case EXCELLENT:
                return 0.1;
            case GREAT:
                return 0.08;
            case GOOD:
                return 0.05;
            case BAD:
                return 0.02;
        }
        return 0D;
    }
}