package com.example.parcial.ui.gallery;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.parcial.MainActivity;

public class GalleryViewModel extends AndroidViewModel {

    private  MutableLiveData<String> creado=null;

    public GalleryViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<String> getMutable() {
        if(creado==null){
            this.creado=new MutableLiveData<>();
        }
        return creado;
    }
    public void crear(String nuevo){
        if(nuevo!=null&& !nuevo.equals("")){
            MainActivity.lista.add(nuevo);
            creado.setValue(nuevo);
        }else{
            Toast.makeText(getApplication(),"Error La nota no debe estar vacia",Toast.LENGTH_LONG).show();
        }
    }
}