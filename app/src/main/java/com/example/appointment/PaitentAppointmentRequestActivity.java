package com.example.appointment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaitentAppointmentRequestActivity extends AppCompatActivity {

    @BindView(R.id.dr)
    EditText dr;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.dept)
    EditText dept;
    @BindView(R.id.problem)
    EditText problem;
    @BindView(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paitent_appointment_request);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        String mDr,mName,mDept,mProblem;
        mDr=dr.getText().toString();
        mName=name.getText().toString();
        mDept=dept.getText().toString();
        mProblem=problem.getText().toString();
        AppointmentRequest appointmentRequest=new AppointmentRequest(mName,mDr,mDept,mProblem);
        if (!FireBase.putAppointmentRequest(appointmentRequest)){
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "DEBUG", Toast.LENGTH_SHORT).show();
        }

    }
}