package mehedi.shafi.labwork3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Utilites.Data;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static Data data;
    private static Button dhaka, ctg, sylhet, rajshahi, khulna, rangpur, barishal, mymensingh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new Data();

        dhaka = (Button) findViewById(R.id.dhaka_button);
        dhaka.setOnClickListener(this);
        ctg = (Button) findViewById(R.id.chittagong_button);
        ctg.setOnClickListener(this);
        rajshahi = (Button) findViewById(R.id.rajshahi_button);
        rajshahi.setOnClickListener(this);
        barishal = (Button) findViewById(R.id.barishal_button);
        barishal.setOnClickListener(this);
        sylhet = (Button) findViewById(R.id.sylhet_button);
        sylhet.setOnClickListener(this);
        mymensingh = (Button) findViewById(R.id.mymensingh_button);
        mymensingh.setOnClickListener(this);
        khulna = (Button) findViewById(R.id.khulna_button);
        khulna.setOnClickListener(this);
        rangpur = (Button) findViewById(R.id.rangpur_button);
        rangpur.setOnClickListener(this);

        dataInitiaLize();


    }

    public static void dataInitiaLize(){
        data.addImage("dhaka", R.drawable.dhaka_bg);
        data.addImage("khulna", R.drawable.khulna_bg);
        data.addImage("sylhet", R.drawable.sylhet_bg);
        data.addImage("rajshahi", R.drawable.rajshahi_bg);
        data.addImage("mymensingh", R.drawable.mymensingh_bg);
        data.addImage("rangpur", R.drawable.rangpur_bg);
        data.addImage("chittagong", R.drawable.chittagong_bg);
        data.addImage("barishal", R.drawable.barishal_bg);

        String[] dhakaPlaces = new String[]{"Lalbag Fort", "Sonargaon", "Parliament House", "National Monument", "Museum", "Ahsan Manjil", "Zoo", "Eco Park", "Fantasy Kingdom", "Nandan Park", "Ramna Park"};
        String[] chittagongPlaces = new String[]{"Butterfly Park", "Saint Martin", "inani", "Coxs Bazar", "Shalban Vihara", "Kaptai", "Himchori", "Chittagong Zoo", "Bangladesh Railway Museum", "Batali Hill", "Potenga", "Foyes Lake", "Shrine of Bayezid Bostami", "Ctg University"};
        String[] sylhetPlaces = new String[]{"Tea Gardens", "Bata Kandi", "Bichana Kandi", "Keane Bridge", "Sri Mongol"};

        data.addPlaces("dhaka", new ArrayList<>(Arrays.asList(dhakaPlaces)));
        data.addPlaces("sylhet", new ArrayList<String>(Arrays.asList(sylhetPlaces)));
        data.addPlaces("chittagong", new ArrayList<String>(Arrays.asList(chittagongPlaces)));
        data.addPlaces("rajshahi", new ArrayList<String>(Arrays.asList(new String[] {"Varendra Research Museum", "Balur Ghat", "Padma Garden", "Boro Kuthi"})));
        data.addPlaces("mymensingh", new ArrayList<String>(Arrays.asList(new String[] {"Shoshi Lodge", "Zainul Abedin Museum", "Hasan Monzil", "Alexander Castle"})));
        data.addPlaces("khulna", new ArrayList<String>(Arrays.asList(new String[] {"Shahid Hadis Park", "KUET", "Bangladesh Biman Monument", "Khan Jahan Ali Bridge",})));
        data.addPlaces("barishal", new ArrayList<String>(Arrays.asList(new String[] {"Durga Sagar", "Oxford Mission Church", "Muktijoddha Park"})));
        data.addPlaces("rangpur", new ArrayList<String>(Arrays.asList(new String[] {"Rangpur Zoo", "Shopnopuri Artificial Park", "Ramsagar National Park", "Karbala Eid Math", })));

    }

    @Override
    public void onClick(View v) {
        Bundle mBundle = new Bundle();
        mBundle.putSerializable("data", data);
        Intent i = new Intent(MainActivity.this, DivisionActivity.class);
        switch (v.getId()){
            case R.id.dhaka_button:
                mBundle.putString("div", "dhaka");
                i.putExtras(mBundle);
                startActivity(i);
                break;
            case R.id.sylhet_button:
                mBundle.putString("div", "sylhet");
                i.putExtras(mBundle);
                startActivity(i);
                break;
            case R.id.chittagong_button:
                mBundle.putString("div", "chittagong");
                i.putExtras(mBundle);
                startActivity(i);
                break;
            case R.id.khulna_button:
                mBundle.putString("div", "khulna");
                i.putExtras(mBundle);
                startActivity(i);
                break;
            case R.id.mymensingh_button:
                mBundle.putString("div", "mymensingh");
                i.putExtras(mBundle);
                startActivity(i);
                break;
            case R.id.rangpur_button:
                mBundle.putString("div", "rangpur");
                i.putExtras(mBundle);
                startActivity(i);
                break;
            case R.id.barishal_button:
                mBundle.putString("div", "barishal");
                i.putExtras(mBundle);
                startActivity(i);
                break;
            case R.id.rajshahi_button:
                mBundle.putString("div", "rajshahi");
                i.putExtras(mBundle);
                startActivity(i);
                break;
        }
    }
}
