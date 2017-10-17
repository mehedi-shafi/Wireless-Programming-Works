package Adapter;

import android.app.Activity;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import Model.Course;
import osproject.enf.customlistviewedittext.R;

/**
 * Created by shafi on 8/27/2017.
 */

public class CustomListAdapter extends ArrayAdapter {

    private Activity activity;
    private int layoutResource;
    private ArrayList<Course> data;

    private int lastFocussedPosition = -1;
    private Handler handler = new Handler();

    public CustomListAdapter(Activity ac, int resource, ArrayList<Course> data){
        super(ac, resource, data);

        this.activity = ac;
        this.layoutResource = resource;
        this.data  = data;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getPosition(@Nullable Object item) {
        return super.getPosition(item);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
         View row  = convertView;
         InputViewHolder holder = null;

        if (holder == null || row.getTag() == null){
            LayoutInflater inflater = LayoutInflater.from(activity);
            row = inflater.inflate(layoutResource, null);

            holder = new InputViewHolder();

            holder.courseCredit = (EditText) row.findViewById(R.id.credit_input);
            holder.courseGrade = (EditText) row.findViewById(R.id.grade_input);
            holder.course_id = (TextView) row.findViewById(R.id.course_id);

            String tagTitle = "Course " + (position + 1);
            holder.course_id.setText(tagTitle);

            row.setTag(holder);
        }
        else{
            holder = (InputViewHolder) row.getTag();
        }

        holder.course = (Course) getItem(position);

        return row;
    }


    public class InputViewHolder {
        Course course;
        EditText courseCredit;
        EditText courseGrade;
        TextView course_id;
    }

}
