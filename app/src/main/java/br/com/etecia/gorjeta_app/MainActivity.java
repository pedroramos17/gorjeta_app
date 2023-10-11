package br.com.etecia.gorjeta_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText editTextAccountValue, editTextTipValue, editTextAccountTotalValue;
    Spinner spinnerQuality;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAccountValue = (EditText) findViewById(R.id.idAccountValue);
        spinnerQuality = (Spinner) findViewById(R.id.idServiceQuality);
        editTextTipValue = (EditText) findViewById(R.id.idTipValue);
        editTextAccountTotalValue = (EditText) findViewById(R.id.idAccountTotalValue);


        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(
                this,
                R.array.qualities_array,
                android.R.layout.simple_spinner_item
        );

        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerQuality.setAdapter(adapterSpinner);

        disableEditText(editTextTipValue);
        disableEditText(editTextAccountTotalValue);
    }

    private void disableEditText(EditText editText) {
        editText.setFocusable(false);
        editText.setEnabled(false);
        editText.setCursorVisible(false);
        editText.setKeyListener(null);
        editText.setBackgroundColor(Color.TRANSPARENT);
    }
}