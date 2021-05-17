package com.example.parkme.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.parkme.R;
import com.example.parkme.homeActivity;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private EditText confirmPassword;
    private Button signUpBtn;
    private TextView clickOnLogin;


    private RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        getSupportActionBar().setTitle("Home");

        email = findViewById(R.id.signUpEmail);
        password = findViewById(R.id.signUpPassword);
        confirmPassword = findViewById(R.id.signUpConfirmPassword);

        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        registerViewModel.getUserData().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser != null) {
                    Intent toMainActivityIntent = new Intent(getApplicationContext(), homeActivity.class);
                    startActivity(toMainActivityIntent);
                }
            }
        });
        signUpBtn = findViewById(R.id.buttonSignUp);
        signUpBtn.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                String emailText = email.getText().toString().trim();
                String passwordText = password.getText().toString().trim();
                String confirmPasswordText = confirmPassword.toString().trim();

                if (TextUtils.isEmpty(emailText)) {
                    email.setError("Please enter an Email");
                    return;
                }

                if (TextUtils.isEmpty(passwordText)) {
                    password.setError("Please enter a Password");
                    return;
                }

                if (passwordText.length() < 6) {
                    password.setError("Password must be longer than six characters");
                    return;
                }

                if (passwordText.equalsIgnoreCase(confirmPasswordText)) {
                    confirmPassword.setError("Passwords do not match");
                    return;
                }


                registerViewModel.register(emailText, passwordText);
            }
        });
    }
}
