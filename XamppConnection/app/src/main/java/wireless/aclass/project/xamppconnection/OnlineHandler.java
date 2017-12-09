package wireless.aclass.project.xamppconnection;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Shafi on 12/9/2017.
 */

public class OnlineHandler extends AsyncTask{


    private OkHttpClient client = new OkHttpClient();

    private String username;
    private String password;
    private String email;
    private String name;

    private String data;

    private int type;

    private Activity activity;

    public OnlineHandler(String username, String password, Activity activity){
        this.username = username;
        this.password = password;
        this.activity = activity;
        this.type = 1;
    }

    public OnlineHandler(String username, String password, String email, String name, Activity activity){
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.activity = activity;
        this.type = 2;
    }

    private void signin () throws  Exception{
        String url = "http://192.168.0.104/api/signin.php";
        RequestBody body = new FormBody.Builder().add("user", username).add("password", password).build();
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();
        this.data = response.body().string();
        System.out.println (data.length());
    }

    private void signUp() throws Exception{
        String url = "http://192.168.0.104/api/signup.php";
        RequestBody body = new FormBody.Builder().add("user", username).add("password", password).add("email", email).add("name", name).build();
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();
        this.data = response.body().string();
        System.out.println(data.length());
    }

    @Override
    protected void onPostExecute(Object o) {
        Toast.makeText(activity, "Done", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(activity, Result.class);
        i.putExtra("data", data);
        activity.startActivity(i);
        super.onPostExecute(o);
    }

    @Override
    protected Object doInBackground(Object[] params) {
        try{
            if (type == 1){
                signin();
            }
            else{
                signUp();
            }
            System.out.println("came to this");
        }catch (Exception e){
            System.out.println ("Caught in action doInBackground.");
            e.printStackTrace();
        }
        return null;
    }
}
