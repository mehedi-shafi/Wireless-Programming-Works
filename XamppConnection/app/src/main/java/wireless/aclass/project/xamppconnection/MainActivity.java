package wireless.aclass.project.xamppconnection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    private EditText user, password;
    private Button login;
    private TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.username_login);
        password = (EditText) findViewById(R.id.password_login);

        login = (Button) findViewById(R.id.login_button_login);

        signup = (TextView) findViewById(R.id.signup_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUp.class));
                MainActivity.this.finish();
            }
        });

    }

    private void attemptLogin(){
        String username = user.getText().toString().trim();
        String passwordText = password.getText().toString().trim();
        try {
            OnlineHandler handler = new OnlineHandler(username, passwordText, this);
            handler.execute();
        }
        catch (Exception E){
            E.printStackTrace();
            System.out.println("Couldnt connect.");
        }

    }
}
