package com.schoolbus.schoolbustracking;

import android.content.Context;
import android.content.SharedPreferences;

import com.schoolbus.schoolbustracking.activities.LoginActivity;
import com.schoolbus.schoolbustracking.fragments.login.LoginDefaultFragment;
import com.schoolbus.schoolbustracking.fragments.login.SigninFragment;
import com.schoolbus.schoolbustracking.fragments.login.SignupFragment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Eve on 7/17/17.
 */

public class LoginActivityUnitTest {

    private LoginActivity loginActivity;
    private LoginDefaultFragment loginDefaultFragment;
    private SigninFragment signinFragment;
    private SignupFragment signupFragment;
    StringBuilder stringBuilder;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    @Before
    public void setUp() {
        loginActivity = new LoginActivity();
        loginDefaultFragment = new LoginDefaultFragment();
        signinFragment = new SigninFragment();
        signupFragment = new SignupFragment();
        stringBuilder = new StringBuilder("http://rjtmobile.com/aamir/school-mgt/school_bus_driver_app/driver_login.php?&driver_password=1&driver_mobile=1");
    }

    @Mock
    Context mMockContext;

    @Test
    public void seeVerified() {
        int result = signinFragment.getTestNum();
        assertEquals(0, result);
    }

}
