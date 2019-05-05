package com.example.clothshopapp.fragment;


import android.content.Context;
import android.content.Intent;
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

import com.example.clothshopapp.DashboardActivity;
import com.example.clothshopapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements  View.OnClickListener{
    private  Button btnLogin;
    private EditText etUsername_Login,etPassword_Login;



    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        btnLogin=view.findViewById(R.id.btnLogin);
        etUsername_Login=view.findViewById(R.id.etUsername_Login);
        etPassword_Login=view.findViewById(R.id.etPassword_Login);

        btnLogin.setOnClickListener(this);

        return view;
    }
    public void onClick(View v){
        if(!validate()){
            return;
        }
        checkLogin();

    }
    private void checkLogin(){
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("user",Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username","");
        String password=sharedPreferences.getString("password","");

        String uname=etUsername_Login.getText().toString();
        String pass=etPassword_Login.getText().toString();
        if(username.equals(uname) && password.equals(pass)){
            Toast.makeText(getActivity(), "Welcome", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(getActivity().getApplicationContext(), DashboardActivity.class);
            startActivity(intent);

        }
        else{
            Toast.makeText(getActivity(), "Username or password doesn't match", Toast.LENGTH_SHORT).show();

        }
    }
    public Boolean validate(){
        boolean isValid=true;
        if(TextUtils.isEmpty(etUsername_Login.getText().toString())){
            etUsername_Login.setError("Please Enter Username");
            etUsername_Login.requestFocus();
            isValid=false;
        }else if (TextUtils.isEmpty(etPassword_Login.getText().toString())){
            etPassword_Login.setError("Please Enter Password");
            etPassword_Login.requestFocus();
            isValid=false;

        }
        return isValid;
    }

}
