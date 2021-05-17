package com.example.parkme;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class AddingNewCarFragment extends Fragment
{
    private AddingNewCarViewModel viewModel;

    EditText name;
    EditText type;
    Button save;
    Button cancel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        super.onCreateView(inflater, container, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AddingNewCarViewModel.class);
        View view = inflater.inflate(R.layout.fragment_adding_new_car, container, false);
         name = view.findViewById(R.id.addCarName);
         type = view.findViewById(R.id.addCarType);
         cancel = view.findViewById(R.id.cancelBtn);
         save = view.findViewById(R.id.submit);
         save.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 List<String> lists = new ArrayList<>();
                 lists.add(String.valueOf(name.getText()));
                 lists.add(String.valueOf(type.getText()));
                 ArrayList<String> a = new ArrayList<>();
                 for (int i = 0; i<lists.size(); i++)
                 {
                     if(lists.get(i) == null || lists.get(i).equals(""))
                     {
                         Toast.makeText(getActivity(), "Please fill in both fields", Toast.LENGTH_SHORT).show();
                         a.add(lists.get(i));
                         break;
                     }
                 }
                 if(a.size() == 0)
                 {
                     viewModel.addNewCar(lists.get(0), lists.get(1));
//                     NavController navController = Navigation.findNavController(this, R.id.fragment_adding_new_car);
                     Navigation.findNavController(getView()).navigate(R.id.navigation_myCars);
//                     viewModel.insert(new Car(name.getText().toString(), type.getText().toString()));
                     Log.i("db", "this is database: " + viewModel.getAllCars().getValue().toString());

                 }
             }
         });
         cancel.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Navigation.findNavController(getView()).navigate(R.id.navigation_myCars);

             }
         });
         return view;

}}