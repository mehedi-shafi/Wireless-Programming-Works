package lab.are.fun.ms.colorchanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity{

    RelativeLayout bg;
    TextView colorName;
    private static Random r = new Random();
    private static List<String> keys;
    private static HashMap<String, Integer> colorCodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bg = (RelativeLayout) findViewById(R.id.background);
        colorName = (TextView) findViewById(R.id.color_text);



        colorCodes = new HashMap<>();
        //adding colors to the list
        colorCodes.put("red", R.color.dripping_red);
        colorCodes.put("green_cyan", R.color.cyan_greenish);
        colorCodes.put("light_blue_grey", R.color.light_blue_grey);
        colorCodes.put("chocolate", R.color.deep_brown);
        colorCodes.put("green", R.color.deep_green);
        colorCodes.put("blue", R.color.sky_blue);
        colorCodes.put("yellow", R.color.bright_yellow);

        keys = new ArrayList<String>(colorCodes.keySet());

        String random_color = keys.get(r.nextInt(keys.size()));
        colorName.setText(random_color);
        bg.setBackgroundResource(colorCodes.get(random_color));

        bg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String random_color = keys.get(r.nextInt(keys.size()));
                colorName.setText(random_color);
                bg.setBackgroundResource(colorCodes.get(random_color));
            }
        });

        colorName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String random_color = keys.get(r.nextInt(keys.size()));
                colorName.setText(random_color);
                bg.setBackgroundResource(colorCodes.get(random_color));
            }
        });

    }
}
