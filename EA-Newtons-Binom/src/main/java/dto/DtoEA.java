package dto;

import logic.Course;
import logic.EaRunTimeParameters;
import logic.Preferences;

import java.util.List;

public class DtoEA {
    private List<Course> courses;
    private Preferences pref;
    private EaRunTimeParameters eaRunTimeParameters;

    public DtoEA(List<Course> courses, Preferences pref, EaRunTimeParameters eaRunTimeParameters) {
        this.courses = courses;
        this.pref = pref;
        this.eaRunTimeParameters = eaRunTimeParameters;
    }

    public List<Course> getCourses() {
        return courses;
    }


    public Preferences getPref() {
        return pref;
    }


    public EaRunTimeParameters getEaRunTimeParameters() {
        return eaRunTimeParameters;
    }

    @Override
    public String toString() {
        return "DtoEA{" +
                "courses=" + courses +
                ", pref=" + pref +
                ", eaRunTimeParameters=" + eaRunTimeParameters +
                '}';
    }
}
