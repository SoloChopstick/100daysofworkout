package com.example.a100daysofworkout.ui.landingPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.a100daysofworkout.MainActivity;
import com.example.a100daysofworkout.R;

public class LandingPageActivity extends AppCompatActivity {
    EditText tartgetWeight_et;
    EditText currentWeight_et;
    TextView calorieTarget;
    TextView calorieCurrent;
    Button calculateDayCalories;
    Button getStarted;
    static double parameter;
    int currentWeight;
    int targetWeight;
    int currentCalories;
    int targetCalories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        tartgetWeight_et = findViewById(R.id.targetWeight);
        currentWeight_et = findViewById(R.id.currentWeight);
        calorieTarget = findViewById(R.id.calorieTarget);
        calorieCurrent = findViewById(R.id.calorieCurrent);
        calculateDayCalories = findViewById(R.id.calculateDayCal);
    }

    //Adult male: 66 + (6.3 x body weight in lbs.) + (12.9 x height in inches) - (6.8 x age in years) = BMR
    //Adult female: 655 + (4.3 x weight in lbs.) + (4.7 x height in inches) - (4.7 x age in years) = BMR

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        //Calculate daily calories button
        boolean checked = ((RadioButton) view).isChecked();
        Button button = findViewById(R.id.calculateDayCal);

        final double kglbConvert = 2.20462;

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_female:
                if (checked)
                    parameter = 0.9;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        currentWeight = Integer.valueOf(String.valueOf(currentWeight_et.getText()));
                        currentCalories = (int) (currentWeight * parameter * 24);
                        calorieCurrent.setText(String.valueOf((int) currentCalories));

                        targetWeight = Integer.valueOf(String.valueOf(tartgetWeight_et.getText()));
                        targetCalories = (int) (targetWeight * parameter * 24);
                        calorieTarget.setText(String.valueOf((targetCalories)));
                    }
                });
                break;
            case R.id.radio_male:
                if (checked)
                    parameter = 1.0;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        currentWeight = Integer.valueOf(String.valueOf(currentWeight_et.getText()));
                        currentCalories = (int) (currentWeight * parameter * 24);
                        calorieCurrent.setText(String.valueOf((int) currentCalories));

                        targetWeight = Integer.valueOf(String.valueOf(tartgetWeight_et.getText()));
                        targetCalories = (int) (targetWeight * parameter * 24);
                        calorieTarget.setText(String.valueOf((targetCalories)));

                    }
                });
                break;

        }
    }

    public void getStarted(View view) {
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference ref_basicInfo = database.getReference("basicInfo");
        Intent intent = new Intent(this, MainActivity.class);
        LandingPage getStart = new LandingPage(currentWeight, targetWeight, currentCalories, targetCalories);
        //ref_basicInfo.setValue(getStart);
        startActivity(intent);
    }
}