package com.example.appointment;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBase {
    private static   FirebaseDatabase database = FirebaseDatabase.getInstance();

    public static boolean putAppointmentRequest(AppointmentRequest appointmentRequest){
        DatabaseReference myRef = database.getReference("APPOINTMENT").child(appointmentRequest.getDoctorId()).child("Pending");
        return myRef.push().setValue(appointmentRequest).isSuccessful();

    }
}
