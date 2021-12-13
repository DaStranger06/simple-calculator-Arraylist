package com.siamsoft.add_hw_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spn1, spn2;
    EditText etx1, etx2;
    Button button;
    TextView txtv;

    ArrayAdapter<Integer> adp1;
    ArrayAdapter<Integer> adp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.sp1);
        spn2 = findViewById(R.id.sp2);
        txtv = findViewById(R.id.tv);
        button = findViewById(R.id.btn);
        etx1 = findViewById(R.id.et1);
        etx2 =findViewById(R.id.et2);

        Integer[] n1 = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55};
        Integer[] n2 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        adp1 = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1,n1);
        adp2 = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1,n2);

        spn1.setAdapter(adp1);
        spn2.setAdapter(adp2);



        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
/*
                int pos1 = spn1.getS*/

                String txt = parent.getItemAtPosition(position).toString();

                etx1.setText(txt);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spn2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               /* int pos = n2[position];
                etx2.setText(pos);
*/

                String txt = parent.getItemAtPosition(position).toString();

                etx2.setText(txt);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num1 =Integer.parseInt(etx1.getText().toString());
                int num2 = Integer.parseInt(etx2.getText().toString());

                int sum = num1 + num2;

                txtv.setText(String.valueOf(sum));
            }
        });

    }
}