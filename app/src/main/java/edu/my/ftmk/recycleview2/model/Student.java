package edu.my.ftmk.recycleview2.model;



public class Student {
    // Attributes for a student
    private String strFullname;
    private String strStudNo;
    private String strEmail;
    private String strGender;
    private String strBirthdate;
    private String strState;

    // Constructor to initialize all attributes
    public Student(String fullname, String studNo, String email, String gender, String birthdate, String state) {
        this.strFullname = fullname;
        this.strStudNo = studNo;
        this.strEmail = email;
        this.strGender = gender;
        this.strBirthdate = birthdate;
        this.strState = state;
    }

    // Getters
    public String getStrFullname() {
        return strFullname;
    }

    public String getStrStudNo() {
        return strStudNo;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public String getStrGender() {
        return strGender;
    }

    public String getStrBirthdate() {
        return strBirthdate;
    }

    public String getStrState() {
        return strState;
    }

    // Setters
    public void setStrFullname(String strFullname) {
        this.strFullname = strFullname;
    }

    public void setStrStudNo(String strStudNo) {
        this.strStudNo = strStudNo;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public void setStrGender(String strGender) {
        this.strGender = strGender;
    }

    public void setStrBirthdate(String strBirthdate) {
        this.strBirthdate = strBirthdate;
    }

    public void setStrState(String strState) {
        this.strState = strState;
    }
}
