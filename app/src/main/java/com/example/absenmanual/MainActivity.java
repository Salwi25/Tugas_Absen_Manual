package com.example.absenmanual;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button submitBtn;
    EditText tanggal, waktu, keterangan;
    Spinner spinner;
    String mSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanggal = findViewById(R.id.tanggal_masuk);
        waktu = findViewById(R.id.waktu_masuk);
        spinner = findViewById(R.id.label_spinner);
        keterangan = findViewById(R.id.keterangan);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        if(spinner != null){
            spinner.setOnItemSelectedListener(this);
        }

        findViewById(R.id.submit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showAlertDialog();
            }

            private void showAlertDialog() {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setTitle("Konfirmasi");
                alertBuilder.setMessage("Apakah kamu yakin data yang akan kamu kirim sudah sesuai?");

                alertBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Toast.makeText(getApplicationContext(),"Absen berhasil", Toast.LENGTH_LONG).show();
                        finish();
                        startActivity(getIntent());
                    }
                });
                alertBuilder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alertBuilder.show();
            }
        });

        findViewById(R.id.tanggal_masuk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });
        findViewById(R.id.waktu_masuk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
            }
        });
    }

    public void showDatePicker() {
        DialogFragment dateFragment = new DatePickerFragment();
        dateFragment.show(getSupportFragmentManager(), "date-picker");
    }

    public void showTimePicker() {
        DialogFragment timeFragment = new TimePickerFragment();
        timeFragment.show(getSupportFragmentManager(), "time-picker");
    }

    public void processDatePickerResult(int day, int month, int year) {
        String day_string = Integer.toString(day);
        String month_string = Integer.toString(month+1);
        String year_string = Integer.toString(year);

        String dateMessage = day_string + "-" + month_string + "-" + year_string;
        tanggal.setText(dateMessage);
    }

    public void processTimePickerResult(int hour, int minute) {
        String hour_string = Integer.toString(hour);
        String minute_string = Integer.toString(minute);

        String timeMessage = hour_string + ":" + minute_string;
        waktu.setText(timeMessage);
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mSpinner = adapterView.getItemAtPosition(i).toString();
        if (mSpinner.equals("Hadir tepat waktu")){
            keterangan.setVisibility(View.INVISIBLE);
        }
        else keterangan.setVisibility(View.VISIBLE);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}