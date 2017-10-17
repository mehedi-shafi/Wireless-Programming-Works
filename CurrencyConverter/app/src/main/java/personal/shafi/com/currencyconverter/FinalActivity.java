package personal.shafi.com.currencyconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FinalActivity extends AppCompatActivity {

    private static Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        back = (Button) findViewById(R.id.back_to_main);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FinalActivity.this, MainActivity.class);
                FinalActivity.this.finish();
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        FinalActivity.this.finish();
    }
}
