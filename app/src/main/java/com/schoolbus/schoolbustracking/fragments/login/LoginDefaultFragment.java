package com.schoolbus.schoolbustracking.fragments.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.schoolbus.schoolbustracking.R;

/**
 * Created by Eve on 7/12/17.
 */

public class LoginDefaultFragment extends Fragment {

    ViewGroup viewGroup;
    Button toLogin, toSignup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_login_default, container, false);

        toLogin = (Button) viewGroup.findViewById(R.id.toLogin);
        toSignup = (Button) viewGroup.findViewById(R.id.toSignup);

        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumpToLogin();
            }
        });

        toSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumpToSignup();
            }
        });

        return viewGroup;
    }

    public void jumpToLogin() {

        SigninFragment signinFragment = new SigninFragment();
        getFragmentManager().beginTransaction().replace(R.id.login_container, signinFragment).addToBackStack(null).commit();
    }

    public void jumpToSignup() {

        SignupFragment signupFragment = new SignupFragment();
        getFragmentManager().beginTransaction().replace(R.id.login_container, signupFragment).addToBackStack(null).commit();
    }
}
