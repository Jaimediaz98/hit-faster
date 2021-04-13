package sofianvone.sofbuq.appbuena;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hit_coronasnj.R;

public class InicioJuego extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_juego);

        //llamamos al main para el codigo
        //EL HILO ESPERA 5 SEGUNDOS PARA QUE NO PETE LA APP
        Thread thread = new Thread () {
            @Override public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // aquí iniciamos la segunda actividad
                    // Cuando pasen los 5 segundos, pasamos a la actividad principal de la aplicación
                    //cambiar por pulse start
                    Intent intent = new Intent(InicioJuego.this, PulseStart.class);
                    startActivity(intent);
                }
            }
        };
        thread.start();


    }
}
