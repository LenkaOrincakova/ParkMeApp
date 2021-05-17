package com.example.parkme.user;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class UserRepository {

   private FirebaseAuth firebaseAuth;
   private MutableLiveData<FirebaseUser> userData;
   private MutableLiveData<Boolean> loggedOutData;
    private final Application application;
    private static UserRepository instance;

    private UserRepository(Application application)
    {
        this.application = application;
        this.userData = new MutableLiveData<>();
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.loggedOutData = new MutableLiveData<>();
        if(firebaseAuth.getCurrentUser() != null)
        {
            userData.postValue(firebaseAuth.getCurrentUser());
            loggedOutData.postValue(false);
        }
    }

    public static synchronized UserRepository getInstance(Application application){
        if(instance == null)
            instance = new UserRepository(application);
        return instance;
    }

    public void login(String email, String password)
    {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    userData.postValue(firebaseAuth.getCurrentUser());
                    loggedOutData.postValue(false);
                    Toast.makeText(application.getApplicationContext(), "Succesfully Logged in", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(application.getApplicationContext(), "User does not exist, please sign up", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void register(String email, String password)
    {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(application.getApplicationContext(), "Email has been sent to verify", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(application.getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    });
//                    Toast.makeText(application.getApplicationContext(), "User registered", Toast.LENGTH_SHORT).show();
                    loggedOutData.postValue(false);
                }
                else
                {
                    Toast.makeText(application.getApplicationContext(), "User already registered", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

   public void signOut()
   {
       firebaseAuth.signOut();
       loggedOutData.postValue(true);
   }

    public String getUserID(){return firebaseAuth.getCurrentUser().getUid();}

    public String getUserEmail(){return firebaseAuth.getCurrentUser().getEmail();}

    public MutableLiveData<FirebaseUser> getUserData() {
        return userData;
    }

    public MutableLiveData<Boolean> getLoggedOutData() {
        return loggedOutData;
    }


}
