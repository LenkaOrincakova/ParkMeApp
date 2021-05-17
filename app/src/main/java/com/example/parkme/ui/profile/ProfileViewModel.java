package com.example.parkme.ui.profile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.parkme.user.UserRepository;
import com.firebase.ui.auth.data.model.User;
import com.google.firebase.auth.FirebaseUser;

public class ProfileViewModel extends AndroidViewModel {
    private final UserRepository userRepository;
    private MutableLiveData<FirebaseUser> userData;


    public ProfileViewModel(@NonNull Application application) {
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

//    public LiveData<FirebaseUser> getCurrentUser()
//    {
//        return userRepository.getCurrentUser();
//    }

}