package com.example.parkme.ui.register_login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.parkme.R;
import com.example.parkme.ui.home.HomeActivity;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    private EditText email;
    private EditText password;
    private Button loginBtn;
    private TextView signUpTextView;
    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        viewModel =
                new ViewModelProvider(this).get(LoginViewModel.class);
        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
        loginBtn = findViewById(R.id.buttonLogin);
        signUpTextView = findViewById(R.id.clickOnSignUp);
        signUpTextView.setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });
        loginBtn.setOnClickListener(v -> {

                String emailText = email.getText().toString().trim();
                String passwordText = password.getText().toString().trim();

                if (TextUtils.isEmpty((emailText))) {
                    email.setError(Integer.toString(R.string.enteremailagain));
                    return;
                }

                if (TextUtils.isEmpty(passwordText)) {
                    password.setError(Integer.toString(R.string.enterpasswordagain));
                    return;
                }
                viewModel.login(emailText, passwordText);
                startActivity(new Intent(this, HomeActivity.class));
            }
        );
    }
    @Override
    public void onResume() {
        super.onResume();
        email.setText("");
        password.setText("");
    }
}

