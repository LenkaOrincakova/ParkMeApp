package com.example.parkme.ui.cars;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkme.R;
import com.example.parkme.model.Car;

import java.util.ArrayList;


public class MyCarsAdapter extends RecyclerView.Adapter<MyCarsAdapter.CarViewHolder> {

    private ArrayList<Car> carsList;
    final private OnListItemClickListener listener;

    class CarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

       public TextView textCarName, textCarType;
       public Button removeButton;
       public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            removeButton = itemView.findViewById(R.id.removeBtn);
            textCarName = itemView.findViewById(R.id.textCarName);
            textCarType = itemView.findViewById(R.id.textCarType);
        }

        @Override
        public void onClick(View v) {
            listener.onListItemClick(getAdapterPosition());
            listener.deleteCar(carsList.get(getAdapterPosition()), getAdapterPosition());
                    }
    }


    //Constructor
    public MyCarsAdapter(ArrayList<Car> cars, OnListItemClickListener listener)
    {
        this.listener = listener;
        this.carsList = cars;
    }
    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_items, parent, false);
        CarViewHolder evh = new CarViewHolder(view);
        return evh;
//        return new CarHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {

        Car currentCar = carsList.get(position);
        holder.textCarName.setText(currentCar.getName());
        holder.textCarType.setText(currentCar.getType());
        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.deleteCar(carsList.get(position), position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }

    public interface OnListItemClickListener{
        void onListItemClick(int clickedItemIndex);
        void deleteCar(Car car, int position);

    }
}