package shehransyed.com.bmicalculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView bmiView = (TextView) findViewById(R.id.resultView);
        TextView message = (TextView) findViewById(R.id.message);

        Bundle bmi = getIntent().getExtras();
        double result = bmi.getDouble("bmi");
        bmiView.setText(Double.toString(result));

        if (result < 19 || result > 25) {
            bmiView.setTextColor(Color.rgb(176, 58, 46));
            if (result < 19) {
                message.setText("Your BMI is too low!\nYou need to gain some weight.");
                message.setTextColor(Color.rgb(176, 58, 46));
            } else {
                message.setText("Your BMI is too high!\nYou need to lose some weight.");
                message.setTextColor(Color.rgb(176, 58, 46));
            }
        } else {
            bmiView.setTextColor(Color.rgb(25, 111, 61));
            message.setText("Congrats!\nYou're in good shape!");
            message.setTextColor(Color.rgb(25, 111, 61));
        }
    }

    public void testAgain(View view) {
        Intent testAgain = new Intent(this, Input.class);
        startActivity(testAgain);
        finish();
    }

    public void exitApp(View view) {
        finish();
    }
}
