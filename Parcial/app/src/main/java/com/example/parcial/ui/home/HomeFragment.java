package com.example.parcial.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial.MainActivity;
import com.example.parcial.R;
import com.example.parcial.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ArrayList<String> lista=new ArrayList<>();




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        lista= MainActivity.lista;
        grid();

        return root;
    }

    public void grid(){
        RecyclerView rv= binding.rvListaNotas;

        GridLayoutManager grilla=new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(grilla);

        NotaAdapter adap= new NotaAdapter(getLayoutInflater(),getContext(), lista);
        rv.setAdapter(adap);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}