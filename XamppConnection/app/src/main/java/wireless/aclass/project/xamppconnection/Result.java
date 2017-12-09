package wireless.aclass.project.xamppconnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        text = (TextView) findViewById(R.id.result_text);

        text.setText(getIntent().getStringExtra("data"));
    }
}
