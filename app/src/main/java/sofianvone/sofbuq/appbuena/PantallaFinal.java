package sofianvone.sofbuq.appbuena;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hit_coronasnj.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class PantallaFinal extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
        int puntos;
        int pverdes;
        int pazules;
        TextView tv;
        TextView v;
        TextView a;
        MediaPlayer vidafinal;
        ImageView imageView4;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_final);
        //recibimos el intent de cuando se acaben los corazones.
        Intent intent = getIntent();
        //esto lo hago para traer la puntuacion.
        puntos = getIntent().getIntExtra("puntosInt",0);
        pverdes = getIntent().getIntExtra("puntosVerdes",0);
        pazules = getIntent().getIntExtra("puntosAzules",0);
        //paso de int a string para poder imprimir por pantalla en textview
        String h = String.valueOf(puntos);
        String verdes = String.valueOf(pverdes);
        String azules = String.valueOf(pazules);

        tv = findViewById(R.id.tv1);
        v = findViewById(R.id.verdes);
        a = findViewById(R.id.azules);
        imageView4 = findViewById(R.id.imageView4);

        //pongo el texto
        tv.setText("PUNTUATION: " + h);
        v.setText("GREEN VIRUS: " + verdes);
        a.setText("BLUE VIRUS: " + azules);

        //musica vida menos
        if (vidafinal != null){
            vidafinal.release();
        }

        vidafinal = MediaPlayer.create(this,R.raw.avisofinal);
        vidafinal.seekTo(0);
        vidafinal.start();

        //banner normal
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);





        //intestial
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6583708177225831/1098021458");
        AdRequest request = new AdRequest.Builder()
                //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstitialAd.loadAd(request);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());



    }

    //este es el boton del game over para volver a juagar.
    public void enviarHaciaJuego(View view) {
        vidafinal.stop();

        Intent  intent= new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }




    }

    public void irMenu(View view) {
        Intent  menu= new Intent(this, PulseStart.class);
        menu.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(menu);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }






}
