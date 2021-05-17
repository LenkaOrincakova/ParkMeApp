package com.example.parkme.ui.parkingspot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkme.R;
import com.example.parkme.ui.cars.MyCarsViewModel;
import com.example.parkme.webservices.ParkingSpot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ParkingSpotActivity extends AppCompatActivity implements ParkingSpotAdapter.OnListItemClickListener {

        private RecyclerView.LayoutManager layoutManager;
        private RecyclerView recyclerView;
        private ParkingSpotAdapter adapter;
        private ArrayList<ParkingSpot> parkingSpotArrayList;
        private ParkingSpotViewModel viewModel;
        private ParkingSpot parkingSpot;
        public CheckBox checkBoxFree, checkBoxPaid;

         TextView psPlacering;
        TextView psAntal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parkingspot);
        checkBoxFree = findViewById(R.id.checkboxFree);
        checkBoxPaid = findViewById(R.id.checkboxPaid);
//    @Override
//    public void onCreate(@NonNull LayoutInflater inflater,
//                         ViewGroup container, Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(ParkingSpotViewModel.class);
//        View root = inflater.inflate(R.layout.activity_parkingspot, container, false);

        parkingSpotArrayList = new ArrayList<>();

        recyclerView = findViewById(R.id.parkingSpotsRecycleView);
        recyclerView.hasFixedSize();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        viewModel.setParkingSpotMutableLiveData();

        adapter = new ParkingSpotAdapter(parkingSpotArrayList, this);
        recyclerView.setAdapter(adapter);


        parkingSpotArrayList.clear();

        viewModel.getParkingSpotMutableLiveData().observe(this, parkingSpotsCards ->
        {
            parkingSpotArrayList.clear();
            for(ParkingSpot parkingSpot : parkingSpotsCards)
            {

                parkingSpotArrayList.add(parkingSpot);
            }
//
//            parkingSpotArrayList.clear();
//        List<ParkingSpot> parkingSpots = viewModel.getAllParkingSpotsInList();
//        Collections.reverse(parkingSpots);
//        parkingSpotArrayList.addAll(parkingSpots);
        adapter.notifyDataSetChanged();
    });

}

//
//        psPlacering = findViewById(R.id.psPlacering);
//        psAntal = findViewById(R.id.psAntal);
//        viewModel.setParkingSpotMutableLiveData();
//        viewModel.getParkingSpotMutableLiveData().observe(this, parkingSpot1 -> {
//            for (ParkingSpot parkingSpot3:parkingSpot1) {
//                psPlacering.setText(parkingSpot3.getPlacering());
//                psAntal.setText(parkingSpot3.getAntal() + "");
//            }
//
//        }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        adapter.notifyItemRangeChanged(clickedItemIndex, adapter.getItemCount());
        adapter.notifyDataSetChanged();
    }


    }
