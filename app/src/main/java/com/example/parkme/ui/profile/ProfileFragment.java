package com.example.parkme.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.parkme.R;
import com.example.parkme.homeActivity;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

import static android.app.Activity.RESULT_OK;
import static com.firebase.ui.auth.AuthUI.getApplicationContext;



public class ProfileFragment extends Fragment {
    private static final int RC_SIGN_IN = 42;
    private ProfileViewModel profileViewModel;
    private EditText email;
    private EditText password;
    private Button loginBtn;
    private TextView signUpTextView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);
//        checkIfSignedIn();
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        email = root.findViewById(R.id.loginEmail);
        password = root.findViewById(R.id.loginPassword);
        loginBtn = root.findViewById(R.id.buttonLogin);
        signUpTextView = root.findViewById(R.id.clickOnSignUp);
        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRegisterIntent = new Intent(getActivity(), RegisterActivity.class);
                startActivity(toRegisterIntent);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = email.getText().toString().trim();
                String passwordText = password.getText().toString().trim();

                if (TextUtils.isEmpty((emailText)))
                {
                    email.setError(Integer.toString(R.string.enteremailagain));
                    return;
                }

                if (TextUtils.isEmpty(passwordText))
                {
                    password.setError(Integer.toString(R.string.enterpasswordagain));
                    return;
                }


                profileViewModel.login(emailText,passwordText);
            }
        });

//        profileViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        profileViewModel.getUserData().observe(getActivity(), new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if(firebaseUser != null)
                {
                    Intent toHomeActivityIntent = new Intent(getActivity(), homeActivity.class);
                    startActivity(toHomeActivityIntent);
                }
            }
        });
        return root;
    }



//    public void Login(View view)
//    {
//        String emailText = email.getText().toString().trim();
//        String passwordText = password.getText().toString().trim();
//
//        if (TextUtils.isEmpty((emailText)))
//        {
//            email.setError(Integer.toString(R.string.enteremailagain));
//            return;
//        }
//
//        if (TextUtils.isEmpty(passwordText))
//        {
//            password.setError(Integer.toString(R.string.enterpasswordagain));
//            return;
//        }
//
//
//        profileViewModel.login(emailText,passwordText);
//    }

    @Override
    public void onResume() {
        super.onResume();
        email.setText("");
        password.setText("");

    }





//
//    private void checkIfSignedIn() {
//        profileViewModel.getCurrentUser().observe(getActivity(), user -> {
//            if (user != null)
//                goToMainActivity();
//        });
//    }
//
//
//    private void goToMainActivity() {
//        startActivity(new Intent(getActivity(), homeActivity.class));
//        getActivity().finish();
//    }
//
//
//
//
//    public void signIn(View v){
//        List<AuthUI.IdpConfig> providers = Arrays.asList(
//                new AuthUI.IdpConfig.EmailBuilder().build(),
//                new AuthUI.IdpConfig.GoogleBuilder().build()
//        );
//        Intent signInIntent = AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers)
//                .setLogo(R.drawable.bluecar)
//                .build();
//        startActivityForResult(signInIntent, RC_SIGN_IN);
//    }
//
//
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode,  Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == RC_SIGN_IN) {
//            handleSignInRequest(requestCode);
//        }
//    }
//    private void handleSignInRequest(int resultCode)
//    {
//        if(resultCode == RESULT_OK)
//            goToMainActivity();
//        else
//            Toast.makeText(getActivity(), "Sign in CANCELLED", Toast.LENGTH_SHORT).show();
//    }
}






