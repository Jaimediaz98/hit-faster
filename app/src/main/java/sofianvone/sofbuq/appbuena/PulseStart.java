package sofianvone.sofbuq.appbuena;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hit_coronasnj.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class PulseStart extends AppCompatActivity {
    MediaPlayer mPlayer;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulse_start);
        //ponemos musica inicio
        //musica nivel 1
        if (mPlayer != null){
            mPlayer.release();
        }

        mPlayer = MediaPlayer.create(this,R.raw.inicio);
        mPlayer.seekTo(1);
        mPlayer.start();

        //publicidad uno
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }

    public void irJuego(View view) {
        mPlayer.stop();
        Intent intent = new Intent(PulseStart.this, MainActivity.class);
        startActivity(intent);

    }

    public void irInstrucciones(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("1.Red Virus, less 1  Mask." + "\n" + "2.Green Virus, +10 points." + "\n" + "3.Blue Virus, +30 points." + "\n" + "4.If you collect 50 Blue Virus, you will recover all Masks" + "\n" + "There are 5 levels so ¡Good Look!" + "\n")
                .setTitle("How to play?")
                .setCancelable(false)
                .setNeutralButton("ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void politicas(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("POLÍTICA DE PRIVACIDAD\n" +
                "El presente Política de Privacidad establece los términos en que SNJDevelopers usa y protege la\n" +
                "información que es proporcionada por sus usuarios al momento de utilizar su sitio web. Esta\n" +
                "compañía está comprometida con la seguridad de los datos de sus usuarios. Cuando le pedimos\n" +
                "llenar los campos de información personal con la cual usted pueda ser identificado, lo hacemos\n" +
                "asegurando que sólo se empleará de acuerdo con los términos de este documento. Sin embargo\n" +
                "esta Política de Privacidad puede cambiar con el tiempo o ser actualizada por lo que le\n" +
                "recomendamos y enfatizamos revisar continuamente esta página para asegurarse que está de\n" +
                "acuerdo con dichos cambios.\n" +
                "Información que es recogida\n" +
                "Nuestra App podrá recoger información personal por ejemplo: Nombre, información de contacto\n" +
                "como su dirección de correo electrónica e información demográfica. Así mismo cuando sea\n" +
                "necesario podrá ser requerida información específica para procesar algún pedido o realizar una\n" +
                "entrega o facturación.\n" +
                "Uso de la información recogida\n" +
                "Nuestra App emplea la información con el fin de proporcionar el mejor servicio posible,\n" +
                "particularmente para mantener un registro de usuarios, de pedidos en caso que aplique, y mejorar\n" +
                "nuestros productos y servicios. Es posible que sean enviados correos electrónicos\n" +
                "periódicamente a través de nuestro sitio con ofertas especiales, nuevos productos y otra\n" +
                "información publicitaria que consideremos relevante para usted o que pueda brindarle algún\n" +
                "beneficio, estos correos electrónicos serán enviados a la dirección que usted proporcione y\n" +
                "podrán ser cancelados en cualquier momento.\n" +
                "SNJDevelopers está altamente comprometido para cumplir con el compromiso de mantener su\n" +
                "información segura. Usamos los sistemas más avanzados y los actualizamos constantemente\n" +
                "para asegurarnos que no exista ningún acceso no autorizado.\n" +
                "Cookies\n" +
                "Una cookie se refiere a un fichero que es enviado con la finalidad de solicitar permiso para\n" +
                "almacenarse en su ordenador, al aceptar dicho fichero se crea y la cookie sirve entonces para\n" +
                "tener información respecto al tráfico web, y también facilita las futuras visitas a una web\n" +
                "recurrente. Otra función que tienen las cookies es que con ellas las web pueden reconocerte\n" +
                "individualmente y por tanto brindarte el mejor servicio personalizado de su web.\n" +
                "Nuestro sitio web emplea las cookies para poder identificar las páginas que son visitadas y su\n" +
                "frecuencia. Esta información es empleada únicamente para análisis estadístico y después la\n" +
                "información se elimina de forma permanente. Usted puede eliminar las cookies en cualquier\n" +
                "momento desde su ordenador. Sin embargo las cookies ayudan a proporcionar un mejor servicio\n" +
                "de los sitios web, estás no dan acceso a información de su ordenador ni de usted, a menos de\n" +
                "que usted así lo quiera y la proporcione directamente, visitas a una web . Usted puede aceptar o\n" +
                "negar el uso de cookies, sin embargo la mayoría de navegadores aceptan cookies\n" +
                "automáticamente pues sirve para tener un mejor servicio web. También usted puede cambiar la\n" +
                "configuración de su ordenador para declinar las cookies. Si se declinan es posible que no pueda\n" +
                "utilizar algunos de nuestros servicios.\n" +
                "Enlaces a Terceros\n" +
                "Este sitio web pudiera contener en laces a otros sitios que pudieran ser de su interés. Una vez\n" +
                "que usted de clic en estos enlaces y abandone nuestra página, ya no tenemos control sobre al\n" +
                "sitio al que es redirigido y por lo tanto no somos responsables de los términos o privacidad ni de la\n" +
                "protección de sus datos en esos otros sitios terceros. Dichos sitios están sujetos a sus propias\n" +
                "políticas de privacidad por lo cual es recomendable que los consulte para confirmar que usted\n" +
                "está de acuerdo con estas.\n" +
                "Control de su información personal\n" +
                "En cualquier momento usted puede restringir la recopilación o el uso de la información personal\n" +
                "que es proporcionada a nuestro sitio web. Cada vez que se le solicite rellenar un formulario,\n" +
                "como el de alta de usuario, puede marcar o desmarcar la opción de recibir información por correo\n" +
                "electrónico. En caso de que haya marcado la opción de recibir nuestro boletín o publicidad usted\n" +
                "puede cancelarla en cualquier momento.\n" +
                "Esta compañía no venderá, cederá ni distribuirá la información personal que es recopilada sin su\n" +
                "consentimiento, salvo que sea requerido por un juez con un orden judicial.\n" +
                "SNJDevelopers Se reserva el derecho de cambiar los términos de la presente Política de\n" +
                "Privacidad en cualquier momento.")
                .setTitle("privacy policies")
                .setCancelable(false)
                .setNeutralButton("ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
