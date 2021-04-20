//package com.example.parkme.ui.home;
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
//public class MyAdapter extends BaseAdapter implements Filterable {
//    private Context context;
//    private List<City> cities;
//    private LayoutInflater inflater;
//    List<City> mValue;
//    ValueFilter valueFilter;
//
//    public MyAdapter(Context context, List<City> cities){
//        this.context = context;
//        this.cities = cities;
//        mValue = cities;
//    }
//    @Override
//    public int getCount() {
//        return cities.size();
//    }
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
