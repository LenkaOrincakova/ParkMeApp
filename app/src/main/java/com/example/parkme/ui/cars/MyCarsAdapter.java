package com.example.parkme.ui.cars;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkme.R;
import com.example.parkme.model.Car;

import java.util.ArrayList;

//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.Filter;
//import android.widget.Filterable;
//
//import java.util.ArrayList;
//import java.util.List;
//
public class MyCarsAdapter extends RecyclerView.Adapter<MyCarsAdapter.CarHolder> {
    private Context context;
    private ArrayList<Car> cars;


    //Constructor
    public MyCarsAdapter(Context context, ArrayList<Car> cars)
    {
        this.context = context;
        this.cars = cars;
    }


    @NonNull
    @Override
    public MyCarsAdapter.CarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false);
        return new CarHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCarsAdapter.CarHolder holder, int position) {
        Car car = cars.get(position);
        holder.setDetails(car);
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }


    //View Holder
    class CarHolder extends RecyclerView.ViewHolder{
    private TextView textCarName, textCarType;





    CarHolder(View itemView){
        super(itemView);
        textCarName = itemView.findViewById(R.id.textCarName);
        textCarType = itemView.findViewById(R.id.textCarType);
    }
    void setDetails(Car car)
    {
        textCarName.setText(car.getName());
        textCarType.setText(car.getType());
    }

}


}
//
//
//
//
//
//    @Override
//    public Object getItem(int position) {
//        return cities.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//       if(inflater == null)
//       {
//           inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//       }
//
//        return null;
//    }
//
//    @Override
//    public Filter getFilter() {
//      if(valueFilter == null)
//      {
//          valueFilter = new ValueFilter();
//      }
//        return null;
//    }
//
//    private class ValueFilter extends Filter {
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//
//            FilterResults results = new FilterResults();
//            if(constraint != null && constraint.length()>0)
//            {
//                ArrayList<City> filterList = new ArrayList<City>();
//                for (int i = 0; i < mValue.size() ; i++) {
//                    if((mValue.get(i).getName().toUpperCase()).contains(constraint.toString().toUpperCase())) {
//                        City city = new City(mValue.get(i).getName());
//                        filterList.add(city);
//                    }
//
//                }
//                results.count = filterList.size();
//                results.values = filterList;
//            }
//            else {
//                results.count = mValue.size();
//                results.values = mValue;
//            }
//        return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//            cities =(ArrayList<City>) results.values;
//            notifyDataSetChanged();
//        }
//    }
//}
