package com.example.parkme.ui.register_login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.parkme.user.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class LoginViewModel extends AndroidViewModel {

    private final UserRepository userRepository;
    private MutableLiveData<FirebaseUser> userData;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        userRepository = UserRepository.getInstance(application);
        userData = userRepository.getUserData();
    }

    public void login(String email, String password) {
        userRepository.login(email, password);
    }
    public MutableLiveData<FirebaseUser> getUserData() {
        return userData;
    }
    }
