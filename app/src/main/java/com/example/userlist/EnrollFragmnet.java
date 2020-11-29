package com.example.userlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;



public class EnrollFragmnet extends Fragment {
    private static final String TAG = "EnrollFragment";
    DatabaseHelper mDatabaseHelper;
    private EditText editText1;
    private Button btnSendData;
    private EditText editText2;
    private EditText editText5;
    private EditText editText6;
    private EditText editText7;
    private EditText editText8;
    private EditText editText9;
    private EditText editText4;
    private EditText editText3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View rootView = inflater.inflate(R.layout.fragment_enroll, container, false);
        mDatabaseHelper = new DatabaseHelper(getActivity());
        editText1 = (EditText) rootView.findViewById(R.id.textInputLayout);
        editText2 = (EditText) rootView.findViewById(R.id.textInputLayout2);
        editText5 = (EditText) rootView.findViewById(R.id.textInputLayout5);
        editText6 = (EditText) rootView.findViewById(R.id.textInputLayout6);
        editText7 = (EditText) rootView.findViewById(R.id.textInputLayout7);
        editText8 = (EditText) rootView.findViewById(R.id.textInputLayout8);
        editText9 = (EditText) rootView.findViewById(R.id.textInputLayout9);
        editText3 = (EditText) rootView.findViewById(R.id.textInputLayout3);
        editText4 = (EditText) rootView.findViewById(R.id.textInputLayout4);
        btnSendData = (Button) rootView.findViewById(R.id.user_btn);
        addData();
        return rootView;
    }

    public void addData() {
        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseHelper.addData(
                        editText1.getText().toString(),
                        editText2.getText().toString(),
                        editText3.getText().toString(),
                        editText5.getText().toString(),
                        editText6.getText().toString(),
                        editText7.getText().toString(),
                        editText8.getText().toString(),
                        editText9.getText().toString(),
                        editText4.getText().toString()
                );
            }
        });

    }
}
