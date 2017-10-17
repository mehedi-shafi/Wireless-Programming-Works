package osproject.enf.customlistviewedittext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    private TextView resultText;
    private Button mainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        double result = getIntent().getDoubleExtra("cgpa", 0);

        resultText = (TextView) findViewById(R.id.CGPA);
        mainButton = (Button) findViewById(R.id.button_main_back);

        DecimalFormat numberFormat = new DecimalFormat("00.00");
        resultText.setText(String.valueOf(numberFormat.format(result)));

        mainButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));

                ResultActivity.this.finish();
            }
        });
    }

}
