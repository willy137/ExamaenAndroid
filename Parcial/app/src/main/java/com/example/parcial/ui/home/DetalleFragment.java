package com.example.parcial.ui.home;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.parcial.MainActivity;
import com.example.parcial.R;
import com.example.parcial.databinding.ActivityMainBinding;
import com.example.parcial.databinding.FragmentDetalleBinding;

public class DetalleFragment extends Fragment {

    private DetalleViewModel mv;

    private FragmentDetalleBinding binding;

    private String nota;

    public static DetalleFragment newInstance() {
        return new DetalleFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mv=new ViewModelProvider(this).get(DetalleViewModel.class);
        binding = FragmentDetalleBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        Bundle bundle=getArguments();
        int posi=bundle.getInt("pos");
        nota=  bundle.getString("nota");
        binding.etNota.setText(nota);
        binding.btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.modificar(binding.etNota.getText()+"");
            }
        });
        mv.getMutable().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                MainActivity.lista.set(posi,s);
                Toast.makeText(getContext(),"Editado Con exito",Toast.LENGTH_SHORT).show();
            }
        });


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mv = new ViewModelProvider(this).get(DetalleViewModel.class);
        // TODO: Use the ViewModel
    }

}