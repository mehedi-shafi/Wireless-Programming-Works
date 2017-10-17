package personal.shafi.com.currencyconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CurrencyConverter extends AppCompatActivity{


    private static Button convert, back;
    private static RadioGroup choiceGroup;
    private static RadioButton usd, cad;
    private static EditText bdt;
    private static TextView solution, currencySign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);

        bdt = (EditText) findViewById(R.id.inputBdt);

        solution = (TextView) findViewById(R.id.converted_value);
        currencySign = (TextView) findViewById(R.id.currency_sign);

        solution.setVisibility(View.INVISIBLE);
        currencySign.setVisibility(View.INVISIBLE);


        convert = (Button) findViewById(R.id.calculateButton);
        back = (Button) findViewById(R.id.back_button);

        choiceGroup = (RadioGroup) findViewById(R.id.choiceGroup);

        usd = (RadioButton) findViewById(R.id.usd_button);
        cad = (RadioButton) findViewById(R.id.canadian_button);

        convert.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                converter();
                Toast.makeText(getApplicationContext(), "Converting.. ", Toast.LENGTH_LONG).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                backToMain();
                Toast.makeText(getApplicationContext(), "Quitting..", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void converter(){
        double rate = (choiceGroup.getCheckedRadioButtonId() == usd.getId()) ? 82.43 : 65.74;
        double taka = Double.parseDouble(bdt.getText().toString());
        double answer =  taka / rate;
        NumberFormat formatter = new DecimalFormat("#0.00");
        solution.setText(String.valueOf(formatter.format(answer)));
        currencySign.setText((choiceGroup.getCheckedRadioButtonId() == usd.getId()) ? R.string.us_dollar : R.string.ca_dollar);
        solution.setVisibility(View.VISIBLE);
        currencySign.setVisibility(View.VISIBLE);
    }

    public void backToMain(){
        Intent i = new Intent(CurrencyConverter.this, MainActivity.class);
        CurrencyConverter.this.finish();
        startActivity(i);
    }
}
