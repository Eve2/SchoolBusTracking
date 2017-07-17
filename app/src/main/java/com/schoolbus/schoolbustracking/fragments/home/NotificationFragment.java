package com.schoolbus.schoolbustracking.fragments.home;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.schoolbus.schoolbustracking.R;
import com.schoolbus.schoolbustracking.services.MyFirebaseMessagingService;

/**
 * Created by Eve on 7/16/17.
 */

public class NotificationFragment extends Fragment{
    ViewGroup viewGroup;
    Button subscribeButton, logTokenButton, notificationButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_notification, container, false);
        subscribeButton = (Button) viewGroup.findViewById(R.id.subscribeButton);
        logTokenButton = (Button) viewGroup.findViewById(R.id.logTokenButton);
        notificationButton = (Button) viewGroup.findViewById(R.id.notificationButton);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId  = getString(R.string.default_notification_channel_id);
            String channelName = getString(R.string.default_notification_channel_name);
            NotificationManager notificationManager =
                    getActivity().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(new NotificationChannel(channelId,
                    channelName, NotificationManager.IMPORTANCE_LOW));
        }
        if (getActivity().getIntent().getExtras() != null) {
            for (String key : getActivity().getIntent().getExtras().keySet()) {
                Object value = getActivity().getIntent().getExtras().get(key);
                Log.d(getActivity().toString(), "Key: " + key + " Value: " + value);
                // or "HomeActivity"
            }
        }

        subscribeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseMessaging.getInstance().subscribeToTopic("news");

                String msg = getString(R.string.msg_subscribed);
                Log.d("HomeActivity", msg);
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
            }
        });

        logTokenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String token = FirebaseInstanceId.getInstance().getToken();

                String msg = getString(R.string.msg_token_fmt, token);
                Log.d("HomeActivity", msg);
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
            }
        });

        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// todo: add getinstance send message
                Toast.makeText(getActivity(), "Notification Sent", Toast.LENGTH_SHORT).show();
            }
        });

        return viewGroup;
    }
}
