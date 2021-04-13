package sofianvone.sofbuq.appbuena;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import com.example.hit_coronasnj.R;

public class JuegoVista extends View {
    int quitarAzul = 15;
    int quitarVerde = 10;

    Runnable rb;
    Handler hn;
    int milisegundos = 20;
    //le doy la posicion inicial al cartel de virus
    int imagenVirusX = -70;
    //bicho verde
    int bichoVerdeX;
    int bichoverdey;
    //bicho verde 2
    int bichoVerdeX2;
    int bichoverdey2;
    //bicho verde 3
    int bichoVerdeX3;
    int bichoverdey3;
    //bicho rojo
    int bichoRojoX;
    int bichoRojoY;
    //bicho azul
    int bichoAzulX;
    int bichoAzulY;
    //bicho rojo 2
    int bichoRojoY2;
    int bichoRojoX2;
    //variables para coger el width y el height
    int width;
    int height;
    //
    int width2;
    int height2;
    //
    int width3;
    int height3;
    //
    int width4;
    int height4;
    //
    int width5;
    int height5;
    //
    int width6;
    int height6;
    //vidas juego
    int contadorVidas = 3;
    int e, p;
    Bitmap[] vidas = new Bitmap[2];
    //variables para puntuacion
    int puntuacion = 0;
    //bitmap fondo.
    Bitmap fndo;
    Bitmap virus;
    int canWidth;
    int canHeight;
    Bitmap bichoMalo;
    Bitmap bichoMalo3;
    Bitmap bichoMalo2;
    Bitmap bichoMalo7;
    Bitmap bichoMalo5;
    Bitmap bichoMalo4;
    Bitmap corona2;
    Bitmap corona3;
    Bitmap corona4;
    Bitmap corona5;
    //contador cliks
    int contadorCliks = 0;
    int c = 0;
    int puntosVerdes = 0;
    int puntosAzules = 0;
    //poniendo musica nnivel 2
    MediaPlayer mPlayer;
    MediaPlayer mPlayer2;
    MediaPlayer mPlayer3;
    MediaPlayer mPlayer4;
    MediaPlayer mPlayer5;
    MediaPlayer mediaPlayerVidaMenos;
    MediaPlayer mRecuperarVidas;


    //context
    public JuegoVista(Context context) {
        super(context);
        //hago el hilo para repetir
        hn = new Handler();
        rb = new Runnable() {
            @Override
            public void run() {
                //esto llama al ametodo onDraw
                invalidate();
            }
        };

        fndo = BitmapFactory.decodeResource(getResources(), R.drawable.fondop);
        virus = BitmapFactory.decodeResource(getResources(), R.drawable.virus);
        bichoMalo = BitmapFactory.decodeResource(getResources(), R.drawable.bichomalo);
        bichoMalo3 = BitmapFactory.decodeResource(getResources(), R.drawable.brojo);
        bichoMalo2 = BitmapFactory.decodeResource(getResources(), R.drawable.bichomalo);
        bichoMalo7 = BitmapFactory.decodeResource(getResources(), R.drawable.bichomalo);
        bichoMalo5 = BitmapFactory.decodeResource(getResources(), R.drawable.brojo);
        bichoMalo4 = BitmapFactory.decodeResource(getResources(), R.drawable.bazul);
        corona2 = BitmapFactory.decodeResource(getResources(), R.drawable.corona1);
        corona3 = BitmapFactory.decodeResource(getResources(), R.drawable.corona2);
        corona4 = BitmapFactory.decodeResource(getResources(), R.drawable.corona4);
        corona5 = BitmapFactory.decodeResource(getResources(), R.drawable.corona5);


        //musica nivel 1
        if (mPlayer != null) {
            mPlayer.release();
        }
        mPlayer = MediaPlayer.create(getContext(), R.raw.n1);
        mPlayer.seekTo(0);
        //musica nivel 2
        if (mPlayer2 != null) {
            mPlayer2.release();
        }
        mPlayer2 = MediaPlayer.create(getContext(), R.raw.n2);
        mPlayer2.seekTo(0);
        //musica nivel 3
        if (mPlayer3 != null) {
            mPlayer3.release();
        }
        mPlayer3 = MediaPlayer.create(getContext(), R.raw.n3);
        mPlayer3.seekTo(0);
        //musica nivel 4
        if (mPlayer4 != null) {
            mPlayer4.release();
        }
        mPlayer4 = MediaPlayer.create(getContext(), R.raw.n3);
        mPlayer4.seekTo(0);
        //musica nivel 4
        if (mPlayer5 != null) {
            mPlayer5.release();
        }
        mPlayer5 = MediaPlayer.create(getContext(), R.raw.n3);
        mPlayer5.seekTo(0);
        //musica vida menos
        if (mediaPlayerVidaMenos != null) {
            mediaPlayerVidaMenos.release();
        }
        mediaPlayerVidaMenos = MediaPlayer.create(getContext(), R.raw.vidamenos);
        mediaPlayerVidaMenos.seekTo(0);
        //recuperar vidas a los 50 azules.
        if (mRecuperarVidas != null) {
            mRecuperarVidas.release();
        }
        mRecuperarVidas = MediaPlayer.create(getContext(), R.raw.recuperarvidas);
        mRecuperarVidas.seekTo(0);

        //poniendo publicidad

    }



    //vamos a poner el juego en marcha.
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //ponemos el fondo
        canvas.drawBitmap(fndo, 0, 0, null);

        //cambiar fondo cada vez que subas de nivel.
            //nivel 2
        if (puntuacion > 3000 && puntuacion <= 7000) {
            canvas.drawBitmap(corona2, 0, 0, null);
            //nivel 3
        } else if (puntuacion > 7000 && puntuacion <= 12000) {
            canvas.drawBitmap(corona3, 0, 0, null);
            //nivel 4
        } else if (puntuacion > 12000 && puntuacion <= 23000) {
            canvas.drawBitmap(corona4, 0, 0, null);
            //nivel 5
        } else if (puntuacion > 23000) {
            canvas.drawBitmap(corona5, 0, 0, null);
        }



        //ponemos la imagen del virus durante 3 segundos
        //la hacemos moverse hacia la derecha
        imagenVirusX += 50;
        canvas.drawBitmap(virus, imagenVirusX, 170, null);
        //variables para almacenar el ancho y el alto del lienzo.
        canWidth = canvas.getWidth();
        canHeight = canvas.getHeight();
        //para almacenar el alto y el ancho de los bicos
        width = bichoVerdeX + bichoMalo.getWidth();
        height = bichoverdey + bichoMalo.getHeight();
        //bicho verde 2
        width2 = bichoVerdeX2 + bichoMalo2.getWidth();
        height2 = bichoverdey2 + bichoMalo2.getHeight();
        //bicho verde 3
        width6 = bichoVerdeX3 + bichoMalo7.getWidth();
        height6 = bichoverdey3 + bichoMalo7.getHeight();
        //bicho rojo
        width3 = bichoRojoX + bichoMalo3.getWidth();
        height3 = bichoRojoY + bichoMalo3.getHeight();
        //bicho azul
        width4 = bichoAzulX + bichoMalo4.getWidth();
        height4 = bichoAzulY + bichoMalo4.getHeight();
        //bicho rojo 2
        width5 = bichoRojoX2 + bichoMalo5.getWidth();
        height5 = bichoRojoY2 + bichoMalo5.getHeight();

        //AHORA VAMOS A PONER LO QUE TE RESTA EN CADA CASO
        Paint puntosResta = new Paint();
        puntosResta.setStyle(Paint.Style.FILL);
        puntosResta.setColor(Color.GRAY);
        puntosResta.setTextSize(100);

        //sacar bicho malo de abajo hacia arriba
        //velocidad bicho verde 1
        bichoverdey -= 20;
        if (bichoverdey < 0) {
            puntuacion = puntuacion - quitarVerde;
            //hasta donde llega el virus por la parte de arriba
            bichoverdey = canvas.getHeight();
            //bichoverdey = (int) Math.floor(Math.random() * (canvas.getHeight()));
            bichoVerdeX = (int) Math.floor(Math.random() * (canvas.getWidth()));
        }

        if (bichoverdey < 0) {
            bichoverdey = 0;
        }

        if (bichoVerdeX > 800) {
            bichoVerdeX = 800;
        }

        canvas.drawBitmap(bichoMalo, bichoVerdeX, bichoverdey, null);
        //sacar bicho malo de abajo hacia arriba
        //velocidad bicho verde 2
        bichoverdey2 -= 19;
        if (bichoverdey2 < 0) {
            puntuacion = puntuacion - quitarVerde;
            //hasta donde llega el virus por la parte de arriba
            bichoverdey2 = canvas.getHeight();
            //bichoverdey = (int) Math.floor(Math.random() * (canvas.getHeight()));
            bichoVerdeX2 = (int) Math.floor(Math.random() * (canvas.getWidth()));
        }

        if (bichoverdey2 < 0) {
            bichoverdey2 = 0;
        }

        if (bichoVerdeX2 > 800) {
            bichoVerdeX2 = 800;
        }


        canvas.drawBitmap(bichoMalo2, bichoVerdeX2, bichoverdey2, null);

        //velocidad bicho verde 3
        bichoverdey3 -= 27;
        if (bichoverdey3 < 0) {
            puntuacion = puntuacion - quitarVerde;
            //hasta donde llega el virus por la parte de arriba
            bichoverdey3 = canvas.getHeight();
            //bichoverdey = (int) Math.floor(Math.random() * (canvas.getHeight()));
            bichoVerdeX3 = (int) Math.floor(Math.random() * (canvas.getWidth()));
        }

        if (bichoverdey3 < 0) {
            bichoverdey3 = 0;
        }

        if (bichoVerdeX3 > 800) {
            bichoVerdeX3 = 800;
        }

        canvas.drawBitmap(bichoMalo7, bichoVerdeX3, bichoverdey3, null);

        //bicho rojo y velocidad
        bichoRojoY -= 20;
        if (bichoRojoY < 0) {
            //hasta donde llega el virus por la parte de arriba
            bichoRojoY = canvas.getHeight();
            //bichoverdey = (int) Math.floor(Math.random() * (canvas.getHeight()));
            bichoRojoX = (int) Math.floor(Math.random() * (canvas.getWidth()));
        }

        if (bichoRojoY < 0) {
            bichoRojoY = 0;
        }

        if (bichoRojoX > 800) {
            bichoRojoX = 800;
        }

        canvas.drawBitmap(bichoMalo3, bichoRojoX, bichoRojoY, null);

        //bicho rojo 2
        //bicho rojo y velocidad
        bichoRojoY2 -= 25;
        if (bichoRojoY2 < 0) {
            //hasta donde llega el virus por la parte de arriba
            bichoRojoY2 = canvas.getHeight();
            //bichoverdey = (int) Math.floor(Math.random() * (canvas.getHeight()));
            bichoRojoX2 = (int) Math.floor(Math.random() * (canvas.getWidth()));
        }

        if (bichoRojoY2 < 0) {
            bichoRojoY2 = 0;
        }

        if (bichoRojoX2 > 800) {
            bichoRojoX2 = 800;
        }

        //los bitmap los deberia inicializar en el Context, esta pendiente de hacer para mejorar el rendimiento de la app
        canvas.drawBitmap(bichoMalo5, bichoRojoX2, bichoRojoY2, null);

        //bicho azul y velocidad
        bichoAzulY -= 20;
        if (bichoAzulY < 0) {
            puntuacion = puntuacion - quitarAzul;
            //hasta donde llega el virus por la parte de arriba
            bichoAzulY = canvas.getHeight();
            //bichoverdey = (int) Math.floor(Math.random() * (canvas.getHeight()));
            bichoAzulX = (int) Math.floor(Math.random() * (canvas.getWidth()));
        }

        if (bichoAzulY < 0) {
            bichoAzulY = 0;
        }

        if (bichoAzulX > 800) {
            bichoAzulX = 800;
        }

        canvas.drawBitmap(bichoMalo4, bichoAzulX, bichoAzulY, null);

        //pongo lo que resta cada virus en cada caso
        if(puntuacion <= 30){
            canvas.drawText("-15, Blue Virus", 45, canvas.getHeight()/2, puntosResta);
            canvas.drawText("-10, Green Virus",45, canvas.getHeight()/3, puntosResta);
        }

        //poniendo vidas
        vidas[0] = BitmapFactory.decodeResource(getResources(), R.drawable.mascarilla);
        vidas[1] = BitmapFactory.decodeResource(getResources(), R.drawable.x);
        for (int i = 0; i < 3; i++) {
            e = (int) (40 + vidas[0].getWidth() * 1.0 * i);
            p = 40;
            //pongo una X encima de una mascarilla para ver que has perdido una vida
            if (i < contadorVidas) {
                canvas.drawBitmap(vidas[0], e, p, null);
            } else {
                canvas.drawBitmap(vidas[0], e, p, null);
                canvas.drawBitmap(vidas[1], e, p, null);
            }

            //INCREMENTAR VIDA SI RECOGES 50 BICHOS AZULES **********************************
            if (c == 50 && contadorVidas < 3) {
                mRecuperarVidas.start();
                canvas.drawBitmap(vidas[0], e, p, null);
                c = 0;
                contadorVidas = 3;
            }
        }

        //Ahora voy a pintar la puntuacion.
        Paint puntos = new Paint();
        puntos.setStyle(Paint.Style.FILL);
        puntos.setColor(Color.YELLOW);
        puntos.setTextSize(100);
        canvas.drawText(String.valueOf(puntuacion), 50, 400, puntos);

        if (puntuacion < 999) {
            mPlayer.start();
        }

        //PUNTUACION ENTRE 1000-3000.
        if (puntuacion > 3000 && puntuacion < 7000) {
            mPlayer.stop();
            mPlayer2.start();
            do {
                //les subo la velocidad a los bichos ya que estariamos en el nivel 2.
                bichoAzulY -= 7;
                bichoverdey -= 6;
                bichoverdey2 -= 7;
                bichoverdey3 -= 6;
                bichoRojoY -= 6;
                bichoRojoY2 -= 7;
            } while (contadorCliks > 0);
        }

        //PUNTUACION ENTRE 3000-6000.
        if (puntuacion > 7000 && puntuacion < 12000) {
            mPlayer2.stop();
            mPlayer3.start();
            do {
                //aumento velocidad estamos en el nivel 3
                bichoAzulY -= 9;
                bichoverdey -= 10;
                bichoverdey2 -= 10;
                bichoverdey3 -= 12;
                bichoRojoY -= 8;
                bichoRojoY -= 9;
            } while (contadorCliks > 0);
        }

        //PUNTUACION ENTRE 6000-10000.
        if (puntuacion > 12000 && puntuacion < 23000) {
            mPlayer3.stop();
            mPlayer4.start();
            do {
                //aumento velocidad estamos en el nivel 4
                bichoAzulY -= 17;
                bichoverdey -= 17;
                bichoverdey2 -= 19;
                bichoverdey3 -= 18;
                bichoRojoY -= 17;
                bichoRojoY -= 16;
            } while (contadorCliks > 0);
        }

        //PUNTUACION MAYOR A 15.000
        if (puntuacion > 23000) {
            mPlayer4.stop();
            mPlayer5.start();
            do {
                //aumento velocidad estamos en el nivel 5
                bichoAzulY -= 22;
                bichoverdey -= 21;
                bichoverdey2 -= 22;
                bichoverdey3 -= 23;
                bichoRojoY -= 20;
                bichoRojoY -= 24;
            } while (contadorCliks > 0);
        }

        //que no salgan numero negativos
        if (puntuacion <= 0){
            puntuacion = 0;
        }

        /*
        Paint rectangulo = new Paint(); // NACHO: OBJETO "PAINT" PARA INDICAR LAS CARACTERÍSTICAS DEL RECTÁNGULO
        rectangulo.setColor(Color.rgb(0, 255, 0)); // NACHO: COLOR VERDE
        canvas.drawRect(0, 1700, canvas.getWidth(), 100, rectangulo); // NACHO: RECTÁNGULO

*/
        //debe de ir en la ultima linea para que tooo funciona.
        hn.postDelayed(rb, milisegundos);
    }

    //POMIENDO TIMER A PUNTO
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            //En este switch Case lo que hago es que al pulsar la pantalla me mueva el bicho verde 1 -35 en el eje Y.
            //y asi con los bichos
            case MotionEvent.ACTION_DOWN:
                if (x >= bichoVerdeX && x < (width) && y >= bichoverdey && y < (height)) {
                    bichoverdey = -35;
                    puntuacion += 15;
                    puntosVerdes++;
                } else if (x >= bichoRojoX && x < (width3) && y >= bichoRojoY && y < (height3)) {
                    mediaPlayerVidaMenos.start();
                    bichoRojoY = -40;
                    contadorVidas--;
                    //este if cuando se acaben las vidas te mande a la pantalla final
                    if (contadorVidas == 0) {
                        //enviar intent a finjuegoActividad al acabarse las vidas
                        mPlayer.stop();
                        mPlayer2.stop();
                        mPlayer3.stop();
                        mPlayer4.stop();
                        mPlayer5.stop();
                        Intent i = new Intent(getContext(), PantallaFinal.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        i.putExtra("puntosInt", puntuacion);
                        i.putExtra("puntosVerdes", puntosVerdes);
                        i.putExtra("puntosAzules", puntosAzules);
                        getContext().startActivity(i);
                    }
                    //este if cuando se acaben las vidas te mande a la pantalla final
                } else if (x >= bichoRojoX2 && x < (width5) && y >= bichoRojoY2 && y < (height5)) {
                    mediaPlayerVidaMenos.start();
                    bichoRojoY2 = -60;
                    contadorVidas--;
                    //este if cuando se acaben las vidas
                    if (contadorVidas == 0) {
                        mPlayer.stop();
                        mPlayer2.stop();
                        mPlayer3.stop();
                        mPlayer4.stop();
                        mPlayer5.stop();
                        Intent i = new Intent(getContext(), PantallaFinal.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        i.putExtra("puntosInt", puntuacion);
                        i.putExtra("puntosVerdes", puntosVerdes);
                        i.putExtra("puntosAzules", puntosAzules);
                        getContext().startActivity(i);
                    }
                } else if (x >= bichoVerdeX2 && x < (width2) && y >= bichoverdey2 && y < (height2)) {
                    bichoverdey2 = -55;
                    puntuacion += 15;
                    puntosVerdes++;
                } else if (x >= bichoAzulX && x < (width4) && y >= bichoAzulY && y < (height4)) {
                    c++;
                    bichoAzulY = -80;
                    puntuacion += 30;
                    puntosAzules++;
                } else if (x >= bichoVerdeX3 && x < (width6) && y >= bichoverdey3 && y < (height6)) {
                    bichoverdey3 = -75;
                    puntuacion += 15;
                    puntosVerdes++;
                }
                return true;
        }
        return false;
    }
}























