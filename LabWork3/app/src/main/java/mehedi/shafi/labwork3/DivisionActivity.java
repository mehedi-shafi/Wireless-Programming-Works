package mehedi.shafi.labwork3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import Utilites.Data;

public class DivisionActivity extends AppCompatActivity {

    private static ImageView bg;
    private static ListView placeList;
    private static TextView divisionName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);

        Bundle dataBundle = getIntent().getExtras();
        Data data = (Data) dataBundle.getSerializable("data");
        String div_name = dataBundle.getString("div");

        bg = (ImageView) findViewById(R.id.division_image);
        placeList = (ListView) findViewById(R.id.place_list);
        divisionName = (TextView) findViewById(R.id.division_name);
        divisionName.setText(data.getDivisionName(div_name));

        bg.setImageResource(data.getImageRes(div_name));
        System.out.println(data.getPlaces(div_name));
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (DivisionActivity.this, android.R.layout.simple_list_item_1,  data.getPlaces(div_name));
        placeList.setAdapter(adapter);

    }
}
