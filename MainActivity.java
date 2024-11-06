package com.example.mo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private LocationViewModel viewModel;
    private EditText etAddress, etLatitude, etLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(LocationViewModel.class);

        etAddress = findViewById(R.id.etAddress);
        etLatitude = findViewById(R.id.etLatitude);
        etLongitude = findViewById(R.id.etLongitude);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnUpdate = findViewById(R.id.btnUpdate);
        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnFind = findViewById(R.id.btnFind);

        btnAdd.setOnClickListener(v -> {
            Location location = new Location(
                    etAddress.getText().toString(),
                    Double.parseDouble(etLatitude.getText().toString()),
                    Double.parseDouble(etLongitude.getText().toString())
            );
            viewModel.addLocation(location);
            Toast.makeText(this, "Location Added", Toast.LENGTH_SHORT).show();
        });

        btnFind.setOnClickListener(v -> {
            Location location = viewModel.findLocation(etAddress.getText().toString());
            if (location != null) {
                etLatitude.setText(String.valueOf(location.getLatitude()));
                etLongitude.setText(String.valueOf(location.getLongitude()));
                Toast.makeText(this, "Location Found", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Location Not Found", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
