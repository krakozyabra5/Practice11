package com.example.practice_11_glazirinnp_maliginaa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CarActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Activity activity = this;
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        try
        {
            this.getSupportActionBar().hide();
        }

        catch (NullPointerException e) {}
        setContentView(R.layout.activity_car);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
    public boolean Started = false;
    public boolean Finished = false;
    public void Start(View view) {
        Button button = (Button) findViewById(R.id.start);
        if (!Finished) {
            if (!Started) {
                button.setBackgroundColor(Color.RED);
                button.setText("Пауза");

                Started = true;
            }
        } else if (Started) {
            button.setBackgroundColor(Color.GREEN);
            button.setText("Старт");
            Started = false;
        } else {
            Intent intent = new Intent(CarActivity.this, CarActivity.class);
            startActivity(intent);
        }
    }
    View.OnClickListener oclBtnGoToSecAct = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        }
    };
        public void Drive1(View view) {
            Button button = (Button) findViewById(R.id.start);
            ImageView Car = (ImageView) findViewById(R.id.p1car);
            TextView result = (TextView) findViewById(R.id.tvResult);
            if (Started && !Finished) {
                ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams) Car.getLayoutParams();
                margin.leftMargin += 60;
                margin.rightMargin -= 60;
                Car.requestLayout();

                if (margin.rightMargin <= -1400) {
                    result.setTextColor(0xff800080);
                    result.setText("Победа 1 игрока");
                    button.setText("Заново");
                    Finished = true;
                }
            }
        }
    public void Drive2(View view) {
        Button button = (Button) findViewById(R.id.start);
        ImageView Car = (ImageView) findViewById(R.id.p2car);
        TextView result = (TextView) findViewById(R.id.tvResult);
        if (Started && !Finished) {
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams) Car.getLayoutParams();
            margin.leftMargin += 60;
            margin.rightMargin -= 60;
            Car.requestLayout();

            if (margin.rightMargin <= -1400) {
                result.setTextColor(0xff0000ff);
                result.setText("Победа 2 игрока");
                button.setText("Заново");
                Finished = true;
            }
        }
    }
}



