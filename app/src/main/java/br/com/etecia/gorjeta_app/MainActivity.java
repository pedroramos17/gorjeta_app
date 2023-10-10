package br.com.etecia.gorjeta_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerQuality = (Spinner) findViewById(R.id.idServiceQuality);

    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
            this,
            R.array.qualities_array,
            android.R.layout.simple_spinner_item
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}