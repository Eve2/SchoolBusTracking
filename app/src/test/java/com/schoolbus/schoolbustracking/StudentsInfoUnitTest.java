package com.schoolbus.schoolbustracking;

import com.schoolbus.schoolbustracking.models.StudentsInfo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Eve on 7/17/17.
 */

public class StudentsInfoUnitTest {

    private StudentsInfo studentsInfo;

    @Before
    public void setUp() {
        studentsInfo = new StudentsInfo("123", "Aa", "Avatar");
    }

    @Test
    public void seeID() {
        studentsInfo.setStudentID("321");
        String id = studentsInfo.getStudentID();
        assertEquals("321", id);
    }

    @Test
    public void seeName() {
        studentsInfo.setStudentName("Yu");
        String name = studentsInfo.getStudentName();
        assertEquals("Yu", name);
    }

    @Test
    public void seePhoto() {
        studentsInfo.setStudentPhoto("Photo");
        String photo = studentsInfo.getStudentPhoto();
        assertEquals("Photo", photo);
    }

}
