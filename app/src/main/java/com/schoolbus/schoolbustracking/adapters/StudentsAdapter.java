package com.schoolbus.schoolbustracking.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.schoolbus.schoolbustracking.R;
import com.schoolbus.schoolbustracking.models.StudentsInfo;

import java.util.ArrayList;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by Eve on 7/12/17.
 */

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.ViewHolder> {

    public ArrayList<StudentsInfo> studentsInfos;
    private Context context;

    public StudentsAdapter(ArrayList<StudentsInfo> list, Context context) {
        this.studentsInfos = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_students, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentsAdapter.ViewHolder holder, int position) {

        final StudentsInfo mInfo = studentsInfos.get(position);

        holder.studentID.setText(mInfo.getStudentID());
        holder.studentName.setText(mInfo.getStudentName());

        //TODO: problem with pics showing  Aamir
//        Picasso.with(context).load(mInfo.getStudentPhoto()).into(holder.studentPhoto);
    }

    @Override
    public int getItemCount() {
        return studentsInfos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView studentID, studentName;
        private ImageView studentPhoto;

        public ViewHolder(View itemView) {
            super(itemView);

            studentName = (TextView) itemView.findViewById(R.id.studentName);
            studentID = (TextView) itemView.findViewById(R.id.studentID);
     //       studentPhoto = (ImageView) itemView.findViewById(R.id.studentPhoto);
        }
    }

}
