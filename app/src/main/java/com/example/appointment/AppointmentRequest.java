package com.example.appointment;

public class AppointmentRequest {
    String name;
    String DoctorId;
    String dept;
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoctorId() {
        return DoctorId;
    }

    public void setDoctorId(String doctorId) {
        DoctorId = doctorId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AppointmentRequest(String name, String doctorId, String dept, String description) {
        this.name = name;
        DoctorId = doctorId;
        this.dept = dept;
        this.description = description;
    }

}
