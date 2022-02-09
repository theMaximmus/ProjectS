package com.example.projects.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projects.R;
import com.example.projects.adapter.FeedRecyclerViewAdapter;
import com.example.projects.databinding.FragmentHomeBinding;
import com.example.projects.entity.FeedItem;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    RecyclerView recyclerView; //объявляем RecyclerView
    FeedRecyclerViewAdapter adapter; //объявляем adapter
    LinearLayoutManager layoutManager;//объявляем LinearLayoutManager


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Init
        recyclerView = binding.feedRecycler;
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        generateItem();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void generateItem() {
        List<FeedItem> itemList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            itemList.add(new FeedItem(
                    "Pizza "+i,
                    "100000$",
                    "https://image.shutterstock.com/shutterstock/photos/1569808198/display" +
                            "_1500/stock-photo-heart-pizza-with-mozzarella-and-tomatoes-on-a-slate" +
                            "-valentine-s-day-date-food-concept-1569808198.jpg"));
        }
        adapter = new FeedRecyclerViewAdapter(itemList, getContext());
        recyclerView.setAdapter(adapter);
    }
}