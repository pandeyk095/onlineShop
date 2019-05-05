package com.example.clothshopapp.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.clothshopapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment implements View.OnClickListener {
    private Button btnSignup;
    private EditText etUsername_Signup,etPassword_Signup,etConfPass;


    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_signup, container, false);
        etUsername_Signup=view.findViewById(R.id.etUsername_Signup);
        etPassword_Signup=view.findViewById(R.id.etPasword_Signup);
        etConfPass=view.findViewById(R.id.etConfPass_Signup);
        btnSignup=view.findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(this);
        return view;

    }
    public void onClick(View v){
        if(!validate()){
            return;
        }
        Register();

    }
    private void Register() {
        String pass1 = etPassword_Signup.getText().toString();
        String pass2 = etConfPass.getText().toString();

        //SharedPreferences sharedPreferences=get
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (pass1.equals(pass2)) {
            editor.putString("username", etUsername_Signup.getText().toString());
            editor.putString("password", etPassword_Signup.getText().toString());
            editor.commit();
            Toast.makeText(getActivity(), "Sucessfully Registered", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getActivity(), "Password Doesn't Match", Toast.LENGTH_SHORT).show();

        }
    }
    public Boolean validate(){
        boolean isValid=true;
        if(TextUtils.isEmpty(etUsername_Signup.getText().toString())){
            etUsername_Signup.setError("Please Enter Username");
            etUsername_Signup.requestFocus();
            isValid=false;
        }else if (TextUtils.isEmpty(etPassword_Signup.getText().toString())){
            etPassword_Signup.setError("Please Enter Password");
            etPassword_Signup.requestFocus();
            isValid=false;

        }else if (TextUtils.isEmpty(etConfPass.getText().toString())) {
            etConfPass.setError("Please Renter Password ");
            etConfPass.requestFocus();
            isValid = false;
        }
        return isValid;
    }
}
