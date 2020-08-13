package com.example.appointment;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBase {
    private static   FirebaseDatabase database = FirebaseDatabase.getInstance();

    public static boolean putAppointmentRequest(AppointmentRequest appointmentRequest){
        DatabaseReference myRef = database.getReference("APPOINTMENT").child(appointmentRequest.getDoctorId());
        return myRef.push().setValue(appointmentRequest).isSuccessful();

    }
}
