package com.example.parkme.ui.cars;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkme.R;
import com.example.parkme.model.Car;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCarsFragment extends Fragment implements MyCarsAdapter.OnListItemClickListener {

    FragmentTransaction transaction;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private MyCarsAdapter adapter;
    private ArrayList<Car> carsList;
    private MyCarsViewModel viewModel;
    private FloatingActionButton fab;
    private MyCarsFragment myCarsFragment;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                        ViewGroup container, Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())).get(MyCarsViewModel.class);
        View root = inflater.inflate(R.layout.activity_mycars, container, false);

        fab = root.findViewById(R.id.fabCars);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.navigateToCarsFragment);
            }
        });

        carsList = new ArrayList<>();
        recyclerView = root.findViewById(R.id.carsRecycleView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new MyCarsAdapter(carsList, this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        viewModel.getAllCars().observe(getViewLifecycleOwner(), carProfiles -> {
            carsList.clear();
            List<Car> cars = viewModel.getAllCarsInList();
            Collections.reverse(cars);
            carsList.addAll(cars);
            adapter.notifyDataSetChanged();
        });
        return root;
    }
    @Override
    public void onListItemClick(int clickedItemIndex) {

        viewModel.deleteCar(carsList.get(clickedItemIndex));
        carsList.remove(clickedItemIndex);
        adapter.notifyItemRemoved(clickedItemIndex);
        adapter.notifyItemRangeChanged(clickedItemIndex,adapter.getItemCount());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void deleteCar(Car car, int position) {
        viewModel.deleteCar(car);
        carsList.remove(position);
        adapter.notifyItemRemoved(position);
        adapter.notifyItemRangeChanged(position,adapter.getItemCount());
        adapter.notifyDataSetChanged();
    }
}
