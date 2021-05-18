package com.example.parkme.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.parkme.user.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivityViewModel  extends AndroidViewModel {
    private  UserRepository userRepository;
    private MutableLiveData<FirebaseUser> userData;
    private MutableLiveData<Boolean> logoutData;
    public HomeActivityViewModel(@NonNull Application application) {
        super(application);
        userRepository = UserRepository.getInstance(application);
        this.userData = userRepository.getUserData();
        this.logoutData = userRepository.getLoggedOutData();
    }
    public void signOut()
    {
        userRepository.signOut();

    }
    public MutableLiveData<Boolean> getLogoutData()
    {
        return logoutData;
    }
    public MutableLiveData<FirebaseUser> getUserData()
    {
        return userData;
    }
}



