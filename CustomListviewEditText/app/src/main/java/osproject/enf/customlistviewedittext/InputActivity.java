package osproject.enf.customlistviewedittext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Adapter.CustomListAdapter;
import Model.Course;

public class InputActivity extends AppCompatActivity {

    private ListView listInput;
    private Button submitData;
    private int numberOfCourse;
    private CustomListAdapter dataAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        listInput = (ListView) findViewById(R.id.inputList);
        submitData = (Button) findViewById(R.id.submit_data);

        numberOfCourse = getIntent().getIntExtra("data", 1);

        ArrayList<Course> dataToSend = new ArrayList<>();
        for (int i = 0; i < numberOfCourse; i++){
            Course course = new Course();
            dataToSend.add(course);
        }

        dataAdapter = new CustomListAdapter(this, R.layout.input_row, dataToSend);
        listInput.setAdapter(dataAdapter);

        submitData.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                double totalGPA = 0;
                int totalCredit = 0;
                double CGPA = 0;

                for (int i = 0; i < numberOfCourse; i++){
                    EditText temp_credit = (EditText) listInput.getChildAt(i).findViewById(R.id.credit_input);
                    EditText temp_grade = (EditText) listInput.getChildAt(i).findViewById(R.id.grade_input);

                    int creditHour;
                    double grade;
                    String ed_text = temp_credit.getText().toString().trim();
                    if (ed_text.isEmpty() || ed_text.equals("") || ed_text.length() == 0 || ed_text == null) {
                       creditHour = 0;
                    }else{
                        creditHour = Integer.parseInt(ed_text);
                    }
                    ed_text = temp_grade.getText().toString().trim();
                    if (ed_text.isEmpty() || ed_text.equals("") || ed_text.length() == 0 || ed_text == null){
                        grade = 0;
                    }else{
                        grade = Double.parseDouble(ed_text);
                    }

                    System.out.println(i);
                    System.out.println(creditHour + " " + grade);

                    totalCredit += creditHour;
                    totalGPA += grade * creditHour;

                    System.out.println (totalGPA);
                    System.out.println();
                }

                CGPA = totalGPA / totalCredit;

                Intent i = new Intent(InputActivity.this, ResultActivity.class);

                i.putExtra("cgpa", CGPA);

                startActivity(i);
            }
        });

        dataAdapter.notifyDataSetChanged();
    }

}
