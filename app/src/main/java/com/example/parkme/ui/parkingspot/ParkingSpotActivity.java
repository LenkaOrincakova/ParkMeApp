package com.example.parkme.ui.parkingspot;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkme.R;
import com.example.parkme.model.ParkingSpot;

import java.util.ArrayList;

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

        viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(ParkingSpotViewModel.class);
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
        adapter.notifyDataSetChanged();
    });

}
    @Override
    public void onListItemClick(int clickedItemIndex) {
        adapter.notifyItemRangeChanged(clickedItemIndex, adapter.getItemCount());
        adapter.notifyDataSetChanged();
    }
}
