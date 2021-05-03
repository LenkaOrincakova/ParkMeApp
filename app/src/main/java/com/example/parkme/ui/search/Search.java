package com.example.parkme.ui.search;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.parkme.R;

////
public class Search extends AppCompatActivity{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_search);
        }
    }




////
////    private OnMapReadyCallback callback = new OnMapReadyCallback() {
////
////        /**
////         * Manipulates the map once available.
////         * This callback is triggered when the map is ready to be used.
////         * This is where we can add markers or lines, add listeners or move the camera.
////         * In this case, we just add a marker near Sydney, Australia.
////         * If Google Play services is not installed on the device, the user will be prompted to
////         * install it inside the SupportMapFragment. This method will only be triggered once the
////         * user has installed Google Play services and returned to the app.
////         */
////        @Override
////        public void onMapReady(GoogleMap googleMap) {
////            LatLng sydney = new LatLng(-34, 151);
////            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
////            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
////        }
////    };
////
////    @Nullable
////    @Override
////    public View onCreateView(@NonNull LayoutInflater inflater,
////                             @Nullable ViewGroup container,
////                             @Nullable Bundle savedInstanceState) {
////        return inflater.inflate(R.layout.fragment_search_home, container, false);
////    }
////
////    @Override
////    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
////        super.onViewCreated(view, savedInstanceState);
////        SupportMapFragment mapFragment =
////                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
////        if (mapFragment != null) {
////            mapFragment.getMapAsync(callback);
////        }
////    }
////}
//
//
////package com.example.parkme.ui.home.ui.home;
////
////import android.os.Bundle;
////import android.view.LayoutInflater;
////import android.view.View;
////import android.view.ViewGroup;
////import android.widget.TextView;
////
////import androidx.annotation.NonNull;
////import androidx.annotation.Nullable;
////import androidx.fragment.app.Fragment;
////import androidx.lifecycle.Observer;
////import androidx.lifecycle.ViewModelProvider;
////
////import com.example.parkme.ui.home.R;
////
////public class HomeFragment extends Fragment {
////
////    private HomeViewModel homeViewModel;
////
////    public View onCreateView(@NonNull LayoutInflater inflater,
////                             ViewGroup container, Bundle savedInstanceState) {
////        homeViewModel =
////                new ViewModelProvider(this).get(HomeViewModel.class);
////        View root = inflater.inflate(R.layout.fragment_home, container, false);
////        final TextView textView = root.findViewById(R.id.text_home);
////        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
////            @Override
////            public void onChanged(@Nullable String s) {
////                textView.setText(s);
////            }
////        });
////        return root;
////    }
////}
//package com.example.parkme.ui;
//
//
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ListView;
//import android.widget.SearchView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProvider;
//
//import com.example.parkme.R;
//import com.example.parkme.ui.home.HomeViewModel;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SearchHomeFragment extends Fragment {
//
//    private HomeViewModel homeViewModel;
//    SearchView searchView;
//    ListView listView;
////    List<City> cities;
////    MyAdapter adapter;
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        searchView = root.findViewById(R.id.searchView);
////        listView = root.findViewById(R.id.listView);
//
////
////        String[] Name = getResources().getStringArray(R.array.name);
////
////        cities = new ArrayList<City>();
////
////        for (int i = 0; i < Name.length ; i++) {
////            City city = new City(Name[i]);
////            cities.add(city);
////
////        }
////        for (int i = 0; i < Name.length; i++) {
////            City city = cities.get(i);
////            String s= city.getName();
////            Log.e("Name", s);
////
////
////
////        }
////        adapter = new MyAdapter(getActivity().getApplicationContext(), cities);
////        listView.setAdapter(adapter);
////        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
////            @Override
////            public boolean onQueryTextSubmit(String s) {
////                adapter.getFilter().filter(s);
////                return false;
////            }
////
////            @Override
////            public boolean onQueryTextChange(String s) {
////                adapter.getFilter().filter(s);
////                return false;
////            }
////        });
////        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
////            @Override
////            public void onChanged(@Nullable String s) {
////                textView.setText(s);
////            }
////        });
////
////
////    }
//        return root;
//    }
//}
