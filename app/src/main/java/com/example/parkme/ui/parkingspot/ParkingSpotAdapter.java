package com.example.parkme.ui.parkingspot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkme.R;
import com.example.parkme.model.ParkingSpot;

import java.util.ArrayList;


public class ParkingSpotAdapter extends RecyclerView.Adapter<ParkingSpotAdapter.ParkingSpotViewHolder> {

    public ArrayList<ParkingSpot> parkingSpots;
    final private OnListItemClickListener listener;

    class ParkingSpotViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView psPlacering, psAntal, textPaid, textPrice;
        public ImageView saveAsFavorite;
        public ParkingSpotViewHolder(@NonNull View itemView) {
            super(itemView);
            psPlacering = itemView.findViewById(R.id.textStreetName);
            saveAsFavorite = itemView.findViewById(R.id.saveAsFavorite);
            psAntal = itemView.findViewById(R.id.textNumberOfSpots);
            textPrice = itemView.findViewById(R.id.textPrice);
            textPaid = itemView.findViewById(R.id.textPaid);
        }

        @Override
        public void onClick(View v) {
            listener.onListItemClick(getAdapterPosition());
        }
    }
    public ParkingSpotAdapter(ArrayList<ParkingSpot> parkingSpots, OnListItemClickListener listener)
    {
        this.listener = listener;
        this.parkingSpots = parkingSpots;
    }
    @NonNull
    public ParkingSpotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
         View view =inflater.inflate(R.layout.parking_spots_items, parent, false);
        return new ParkingSpotViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ParkingSpotViewHolder holder, int position) {
        holder.psPlacering.setText("Street: " + parkingSpots.get(position).getPlacering());
        holder.psAntal.setText("Spots: " + parkingSpots.get(position).getAntal() + "");
        holder.textPaid.setText(parkingSpots.get(position).getPaid());
        holder.textPrice.setText(parkingSpots.get(position).getPrice() + " /h");
    }
    @Override
    public int getItemCount() {
        return parkingSpots.size();
    }
    public interface OnListItemClickListener{
        void onListItemClick(int clickedItemIndex);
    }
}