package com.example.parkme.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.parkme.R;


public class ProfileFragment extends Fragment {


    private ImageView favorites, subscription, addProfileInfo;
    private TextView welcomeMessage;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        welcomeMessage = root.findViewById(R.id.welcomeMessage);
        subscription = root.findViewById(R.id.subscription);
        favorites  =root.findViewById(R.id.favorites);
        addProfileInfo = root.findViewById(R.id.addProfileInfo);

        subscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Subscription in process", Toast.LENGTH_SHORT).show();
            }
        });
        favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Favorites in process", Toast.LENGTH_SHORT).show();
            }
        });

        addProfileInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Profile info in process", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
}






