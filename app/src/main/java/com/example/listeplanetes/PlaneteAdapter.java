package com.example.listeplanetes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.MainThread;

import java.util.ArrayList;

public class PlaneteAdapter extends BaseAdapter {
    private final MainActivity mainActivityContext;
    private ArrayList<String> planetes;
    private Data data;
    public static int nb=0;

    public PlaneteAdapter(MainActivity mainActivityContext, Data data) {
        this.planetes = data.getPlanetes();
        this.data = data;
        this.planetes= data.getPlanetes();
        this.mainActivityContext = mainActivityContext;
    }

    @Override
    public int getCount() {
        return planetes.size();
    }

    @Override
    public Object getItem(int i) {
        return planetes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    mainActivityContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listitem, null);
        }
        final TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) itemView.findViewById(R.id.spinner);

        nomPlanete.setText(planetes.get(position));

        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(mainActivityContext, android.R.layout.simple_spinner_item, data.getTaillePlanetes());
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CheckBox checkBox = (CheckBox) compoundButton.findViewById(R.id.checkbox);
                spinner.setEnabled(!checkBox.isChecked());
                spinadapter.notifyDataSetChanged();

                if(checkBox.isChecked()) {
                    nb++;
                } else {
                    nb--;
                }
                if (nb==planetes.size()) {
                    Button btn = mainActivityContext.findViewById(R.id.button);
                    btn.setEnabled(true);
                }
                else
                {
                    Button btn = mainActivityContext.findViewById(R.id.button);
                    btn.setEnabled(false);

                }
            }
        });
        return itemView;
    }
}