package com.schoolbus.schoolbustracking.fragments.home;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.schoolbus.schoolbustracking.Controller;
import com.schoolbus.schoolbustracking.R;
import com.schoolbus.schoolbustracking.adapters.StudentsAdapter;
import com.schoolbus.schoolbustracking.models.StudentsInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Eve on 7/12/17.
 */

public class StudentsFragment extends Fragment {

    private StringBuilder stringBuilder;
    private RecyclerView mRecyclerView;
    public ArrayList<StudentsInfo> studentsInfos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_students, container, false);

        stringBuilder = new StringBuilder("http://rjtmobile.com/aamir/school-mgt/school_bus_driver_app/student_route.php?&route_id=101");


        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_students_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);

        studentsInfos = new ArrayList<>();
        fetchStudents();

        return view;
    }

    private void fetchStudents() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, stringBuilder.toString(), new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {
 //                   if (response.contains("ID")) {

                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = jsonObject.getJSONArray("Stops");

                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject infoObj = jsonArray.getJSONObject(i);
                            StudentsInfo info = new StudentsInfo(infoObj.getString("StudentID"), infoObj.getString("StudentName"), infoObj.getString("StudentPhoto"));
                            studentsInfos.add(info);
                        }

                        StudentsAdapter adapter = new StudentsAdapter(studentsInfos, getContext());
                        mRecyclerView.setAdapter(adapter);
 //                       mRecyclerView.setItemAnimator(new DefaultItemAnimator());
 //                   }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        requestQueue.add(stringRequest);
    }

}
