package com.example.parkme.ui.register_login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.parkme.user.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class RegisterViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private MutableLiveData<FirebaseUser> userData;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        this.userRepository = UserRepository.getInstance(application);
        this.userData = userRepository.getUserData();
    }

    public void register(String email, String password)
    {
        userRepository.register(email,password);
    }

    public MutableLiveData<FirebaseUser> getUserData() {
        return userData;
    }
}
