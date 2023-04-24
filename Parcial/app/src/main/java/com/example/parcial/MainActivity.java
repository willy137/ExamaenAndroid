package com.example.parcial;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.parcial.ui.home.HomeFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.parcial.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    public static ArrayList<String> lista = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(lista.size()==0){
            cargar();
        }


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }
    public void cargar(){
        lista.add("Matematica: Practica, practica y practica. La resolución de problemas es clave para mejorar tus habilidades matemáticas.\n" +
                "No te desanimes si no entiendes algo al principio. A veces, los conceptos matemáticos pueden ser difíciles de comprender de inmediato." +
                " Tómate el tiempo necesario para analizar el problema y preguntar a tu profesor o compañeros de clase si necesitas ayuda.");
        lista.add("Calculo: Familiarízate con las funciones básicas. Las funciones son una parte fundamental del cálculo. Aprende a trabajar con funciones comunes como las polinómicas, trigonométricas y exponenciales.\n" +
                "Conoce tus límites. El cálculo se trata de trabajar con límites y aproximaciones. Aprende a calcular límites y a aplicarlos a problemas reales.\n" +
                "No te saltes pasos. El cálculo es un proceso paso a paso, y saltarte un paso puede llevarte a cometer errores. Tómate el tiempo necesario para entender cada paso del proceso.");
        lista.add("Filosofia: Lee y reflexiona. La filosofía es una disciplina que requiere mucha lectura y reflexión. Dedica tiempo a leer obras filosóficas y reflexiona sobre sus ideas y argumentos.\n" +
                "Piensa críticamente. La filosofía es una disciplina que se basa en la argumentación y el debate. Aprende a pensar críticamente y a cuestionar las suposiciones subyacentes en los argumentos.");
        lista.add("Historia: Investiga fuentes primarias. Las fuentes primarias son documentos originales, como cartas, diarios, fotografías y periódicos de la época, que proporcionan una visión auténtica de los eventos históricos. Aprende a buscar y analizar fuentes primarias para obtener una comprensión más profunda de los eventos históricos.\n" +
                "Considera el contexto. La historia se desarrolla en un contexto social, político y económico específico. Aprende a considerar el contexto en el que tuvo lugar un evento histórico para comprender mejor sus causas y consecuencias.");
        lista.add("Logica: Aprende los principios básicos. La lógica se basa en principios básicos como la deducción, la inducción y la abducción. Aprende a aplicar estos principios para resolver problemas lógicos.\n" +
                "Identifica las falacias. Las falacias son errores comunes en el razonamiento que pueden llevar a conclusiones falsas. Aprende a identificar las falacias y a evitarlas en tus propios argumentos.\n" +
                "Practica el pensamiento crítico. La lógica es una herramienta importante para el pensamiento crítico. Practica el pensamiento crítico analizando argumentos y evaluando evidencia.");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}