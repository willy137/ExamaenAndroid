package com.example.parcial.ui.home;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.example.parcial.MainActivity;

public class DetalleViewModel extends AndroidViewModel {

    private MutableLiveData<String> nota=null;

    public DetalleViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMutable() {
        if(nota==null){
            this.nota=new MutableLiveData<>();
        }
        return nota;
    }

    public void modificar(String nuevo){
        if(nuevo!=null && !nuevo.equals("")){
            nota.setValue(nuevo);
        }else{
            Toast.makeText(getApplication(),"Error No puede Dejarlo Vacio",Toast.LENGTH_LONG).show();
        }
    }

}