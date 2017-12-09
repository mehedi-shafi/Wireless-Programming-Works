package wireless.aclass.project.xamppconnection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SignUp extends AppCompatActivity {

    private EditText name, email, user, pass;
    private TextView login;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = (EditText) findViewById(R.id.name_signup);
        email = (EditText) findViewById(R.id.email_signup);
        user = (EditText) findViewById(R.id.username_login);
        pass = (EditText) findViewById(R.id.password_login);

        login = (TextView) findViewById(R.id.signup_login);

        signup = (Button) findViewById(R.id.signup_button);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = user.getText().toString().trim();
                String email_ = email.getText().toString().trim();
                String password = pass.getText().toString().trim();
                String name_ = name.getText().toString().trim();

                OnlineHandler handler = new OnlineHandler(username, password, email_, name_, SignUp.this);
                handler.execute();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this, MainActivity.class));
                SignUp.this.finish();
            }
        });
    }

}
