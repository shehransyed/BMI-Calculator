package shehransyed.com.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class Input extends AppCompatActivity {

    private EditText height;
    private EditText weight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        height = (EditText) findViewById(R.id.heightInput);
        weight = (EditText) findViewById(R.id.weightInput);
    }

    public void calculate(View view) {

        try {
            Intent bmiCalc = new Intent(this, Result.class);

            double h = (Double.parseDouble(height.getText().toString())) / 100;
            double w = Double.parseDouble(weight.getText().toString());

            double bmi = Math.round(w / (Math.pow(h, 2)));

            bmiCalc.putExtra("bmi", bmi);

            startActivity(bmiCalc);
            finish();

        } catch (NumberFormatException e) {
            Toast toast = Toast.makeText(getApplicationContext(), "Oops! You can only enter numbers. Try again.", Toast.LENGTH_SHORT);
            toast.show();
            height.setText("");
            weight.setText("");
        }
    }
}
