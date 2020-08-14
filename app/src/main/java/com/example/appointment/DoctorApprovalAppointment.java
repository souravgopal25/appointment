package com.example.appointment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoctorApprovalAppointment extends AppCompatActivity implements AppointmentAdapter.ListItemClickListener {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    List<AppointmentRequest> mlist;
    AppointmentAdapter appointmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_approval_appointment);
        ButterKnife.bind(this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setHasFixedSize(true);

        mlist=new ArrayList<>();
        FirebaseDatabase database1 = FirebaseDatabase.getInstance();
        DatabaseReference myRef1 = database1.getReference("APPOINTMENT").child("2").child("Pending");
        myRef1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()
                ) {
                    AppointmentRequest appointmentRequest=(AppointmentRequest) dataSnapshot.getValue(AppointmentRequest.class);
                    mlist.add(appointmentRequest);
                    System.out.println("SIZE OF MLIST"+mlist.size());

                }
                appointmentAdapter.setMlist(mlist);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("ERROR "+error.getMessage());

            }
        });
        appointmentAdapter=new AppointmentAdapter(this,mlist,this);
        recycler.setAdapter(appointmentAdapter);

        Toast.makeText(this, "SIZE OF MLIST"+mlist.size(), Toast.LENGTH_SHORT).show();
        System.out.println("SIZE OF MLIST IN MAIN ACTIVITY "+mlist.size());





    }

    @Override
    public void onListItemClick(int clickedIndex, int buttonNumber) {
        Toast.makeText(this, "Clicked on "+Integer.toString(clickedIndex) + (buttonNumber==0?"Reject":"Accept"), Toast.LENGTH_SHORT).show();
        mlist.remove(clickedIndex);

        appointmentAdapter.setMlist(mlist);

    }


}