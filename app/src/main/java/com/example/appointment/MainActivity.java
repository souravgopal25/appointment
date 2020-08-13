package com.example.appointment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.btnNext)
    Button btnNext;
    List<Model> mlist;
    List<Model> mlistR;
    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.next)
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mlist = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String name = "ABC" + i;
            Model model = new Model(Integer.toString(i), name);
            mlist.add(model);

        }

    }


    @OnClick({R.id.btn, R.id.btnNext})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn:
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("USER").child("Profile");

                myRef.setValue(mlist);


                break;


            case R.id.btnNext:
                FirebaseDatabase database1 = FirebaseDatabase.getInstance();
                DatabaseReference myRef1 = database1.getReference("USER").child("Profile");
                myRef1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        mlistR = (List<Model>) dataSnapshot.getValue();
                        Toast.makeText(MainActivity.this, "SIZE" + mlistR.size(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Toast.makeText(MainActivity.this, error.toException().getMessage(), Toast.LENGTH_SHORT).show();
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });


                break;
        }
    }

    @OnClick(R.id.next)
    public void onViewClicked() {
        Intent intent=new Intent(this,PaitentAppointmentRequestActivity.class);
        startActivity(intent);
    }
}