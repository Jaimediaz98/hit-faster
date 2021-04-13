package sofianvone.sofbuq.appbuena;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hit_coronasnj.R;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //recibe el start
        Intent intent2 = getIntent();
        //recible la primera pantalla.
        Intent intent = getIntent();



        //publicidad uno
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        //llamamos a juegoView.
        JuegoVista juegoVistas = new JuegoVista(getApplicationContext());
        setContentView(juegoVistas);

    }
}
