package com.example.a05_actividad_events;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    //VARIABLES
    private CheckBox enableViews;
    private TextView eventsTextView;
    private LinearLayout myViewsLayout;
    private RadioButton myRadioButton;
    private ToggleButton toggleVisibility;

    private int clicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initConfig();

    }

    //METODOS
    private void initConfig() {
        setContentView(R.layout.activity_main);

        enableViews = (CheckBox) findViewById(R.id.enableViews);
        eventsTextView = (TextView) findViewById(R.id.eventsTextView);
        myViewsLayout = (LinearLayout) findViewById(R.id.myViewsLayout);
        myRadioButton = (RadioButton) findViewById(R.id.myRadioButton);
        toggleVisibility = (ToggleButton) findViewById(R.id.toggleVisibility);


        //LISTENERS
        enableViews.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    eventsTextView.setVisibility(View.VISIBLE);
                } else {
                    eventsTextView.setVisibility(View.GONE);

                }
            }
        });

        /** myRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                eventsTextView.setText("myRadioButton ha cambiado de estado ");
            }
        }); **/

        myRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks++;
                eventsTextView.setText("myRadioButton ha cambiado de estado "+clicks+" veces");
            }
        });


        toggleVisibility.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!enableViews.isChecked()) {
                    if (isChecked)
                        eventsTextView.setVisibility(View.INVISIBLE);
                    else
                        eventsTextView.setVisibility(View.GONE);

                }
            }
        });


    } //FIN INITCONFIG
}