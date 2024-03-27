package com.universitaskuningan.modul3;

import static android.widget.Toast.LENGTH_LONG;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    AutoCompleteTextView ac;
    public String[] stringdataprodi = {
            "Program Studi Teknik Informatika",
            "Program Studi Sistem Informasi",
            "Program Studi Desain Komunikasi Visual",
            "Program Studi Teknik Sipil",
            "Program Studi Manajemen Informatika "
    };
    EditText lv;
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
        ac = (AutoCompleteTextView) findViewById(R.id.dataautocomplete);
        ac.addTextChangedListener(this);
        ac.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, stringdataprodi));
    }
    public void pilihprodi (View v) {
        lv = (EditText) findViewById(R.id.datalistview);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Data Program Studi di Fakultas Ilmu Komputer Universitas Kuningan");
        builder.setItems(stringdataprodi, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                lv.setText(stringdataprodi[item]);
                dialog.dismiss();
            }
        }).show();
    }
    public void onTextChanged(CharSequence s, int start, int before, int count) { }
    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
    public void afterTextChanged(Editable s) { }

    public void onStart() {
        super.onStart();
        Toast.makeText(this, "Posisi lagi start nih  nih", LENGTH_LONG).show();

    }

    public void onStop() {
        super.onStop();
        Toast.makeText(this, "Posisi lagi stop  nih", LENGTH_LONG).show();
    }

    public void onPause() {
        super.onPause();
        LinearLayout linearLayout = findViewById(R.id.linearParent);
        linearLayout.setBackgroundColor(getColor(R.color.cool));
        Toast.makeText(this, "Posisi lagi pause  nih", LENGTH_LONG).show();

    }

    public void onResume() {
        super.onResume();
        Toast.makeText(this, "Posisi lagi Resume  nih", LENGTH_LONG).show();
        LinearLayout linearLayout = findViewById(R.id.linearParent);
        linearLayout.setBackgroundColor(getColor(R.color.warm));
    }

    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Posisi udah hancur  nih", LENGTH_LONG).show();
    }
}