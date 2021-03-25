package com.example.listeplanetes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    PlaneteAdapter adapter;
    Button checkBtn;
    Spinner spinner;

    Data data = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new Data();
        listview = (ListView) findViewById(R.id.listView);
        adapter = new PlaneteAdapter(this, data);
        listview.setAdapter(adapter);

        checkBtn = findViewById(R.id.button);

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = 0;
                String[] taillesPlanetes = data.getTaillePlanetes();
                for(int i=0; i<taillesPlanetes.length; i++) {
                    View vw = listview.getChildAt(i);
                    spinner = vw.findViewById(R.id.spinner);
                    if (spinner.getSelectedItem().toString().equals(taillesPlanetes[i])) {
                        score += 1;
                    }
                }
                Toast.makeText(MainActivity.this, "Score : "+score+"/"+taillesPlanetes.length, Toast.LENGTH_LONG).show();

            }
        });

}
}

