package com.example.appointment;

public class AppointmentRequest {
   String dept;
   String description;
   String doctorId;
   String name;

    public AppointmentRequest(String dept, String description, String doctorId, String name) {
        this.dept = dept;
        this.description = description;
        this.doctorId = doctorId;
        this.name = name;
    }

    public AppointmentRequest() {
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

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
