package com.example.adsi.adoptadog;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class detallesPerrosActivity extends AppCompatActivity {

    TextView recibido, descripcionRecibido, edadRecibido, tipoRecibido, razaRecibido;
    ImageView imagenRecibido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_perros);
        recibido = (TextView) findViewById(R.id.nombreRecibido);
        edadRecibido = (TextView) findViewById(R.id.edadRecibido);
        tipoRecibido = (TextView) findViewById(R.id.tipoRecibido);
        razaRecibido = (TextView) findViewById(R.id.razaRecibido);
        descripcionRecibido = (TextView) findViewById(R.id.descripcionRecibido);
        imagenRecibido = (ImageView) findViewById(R.id.imagenRecibido);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Black.ttf");
        recibido.setTypeface(typeface);
        edadRecibido.setTypeface(typeface);
        tipoRecibido.setTypeface(typeface);
        razaRecibido.setTypeface(typeface);
        descripcionRecibido.setTypeface(typeface);

        String recibir =  getIntent().getExtras().getString("nombre");
        Integer imagen = getIntent().getExtras().getInt("imagen");
        //Toast.makeText(this, recibir + "Difference " + "Sacha" , Toast.LENGTH_SHORT).show();
        if (recibir.equals("Sacha")){
            imagenRecibido.setImageResource(R.drawable.sacha);
            edadRecibido.setText("2 años");
            tipoRecibido.setText("Hembra");
            razaRecibido.setText("Labrador");
            descripcionRecibido.setText("Perra muy linda y obediente");
        }else if (recibir.equals("Negra")){
            imagenRecibido.setImageResource(R.drawable.negra);
            edadRecibido.setText("10 Meses");
            tipoRecibido.setText("Hembra");
            razaRecibido.setText("No definido");
            descripcionRecibido.setText("Esterilizada y vacunada, tamaño mediano pequeño");
        }else if (recibir.equals("Canu")){
            imagenRecibido.setImageResource(R.drawable.kanu);
        }else if (recibir.equals("Linda")){
            imagenRecibido.setImageResource(R.drawable.linda);
        }else if (recibir.equals("Bizcocho")){
            imagenRecibido.setImageResource(R.drawable.bizcocho);
        }
        recibido.setText(recibir);

    }


}
