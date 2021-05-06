package com.example.parkme.ui.cars;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkme.R;
import com.example.parkme.model.Car;

import java.util.ArrayList;

public class MyCarsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyCarsAdapter adapter;
    private ArrayList<Car> carsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycars);

        initializeCardView();

    }

    private void initializeCardView() {
        recyclerView = findViewById(R.id.recycleViewCards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        carsList = new ArrayList<>();

        adapter = new MyCarsAdapter(this, carsList);
        recyclerView.setAdapter(adapter);
        
        createDataForCards();
    }

    private void createDataForCards() {
        Car car = new Car("Mazda", "Sport");
        carsList.add(car);
        adapter.notifyDataSetChanged();

    }
}
