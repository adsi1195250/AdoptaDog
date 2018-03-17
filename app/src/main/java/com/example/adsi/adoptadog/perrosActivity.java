package com.example.adsi.adoptadog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adsi.adoptadog.adapter.perrosAdapter;
import com.example.adsi.adoptadog.models.Perros;

import java.util.ArrayList;

import static com.example.adsi.adoptadog.R.layout.cardview_perros;

public class perrosActivity extends AppCompatActivity implements View.OnClickListener{

    CardView sacha, negra, linda, canu, bizcocho;
    TextView tv1, tv2, tv3, tv4, tv5;
    ImageView tv11;
    detallesPerrosActivity fragment1= new detallesPerrosActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perros);

        /*RecyclerView recyclerView = (RecyclerView) findViewById(R.id.perrosRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        perrosAdapter perrosAdapter = new perrosAdapter(perros() , R.layout.cardview_perros, this);

        recyclerView.setAdapter(perrosAdapter);
        */
        tv1 = (TextView)findViewById(R.id.idnombre);
        tv11 = (ImageView) findViewById(R.id.idimagen);
        tv2 = (TextView)findViewById(R.id.idnombre2);
        tv3 = (TextView)findViewById(R.id.idnombre3);
        tv4 = (TextView)findViewById(R.id.idnombre4);
        tv5 = (TextView)findViewById(R.id.idnombre5);

        sacha = (CardView) findViewById(R.id.sacha);
        negra = (CardView) findViewById(R.id.negra);
        linda = (CardView) findViewById(R.id.linda);
        canu = (CardView) findViewById(R.id.canu);
        bizcocho = (CardView) findViewById(R.id.bizcocho);

        sacha.setOnClickListener(this);
        negra.setOnClickListener(this);
        linda.setOnClickListener(this);
        canu.setOnClickListener(this);
        bizcocho.setOnClickListener(this);

    }

    /*public ArrayList<Perros> perros(){
        ArrayList<Perros> perro = new ArrayList<>();
        perro.add(new Perros(R.drawable.curro , "Curro", "2 años", "criollo", "---"));
        perro.add(new Perros(R.drawable.cati, "Cati", "4 años", "Bull", "---"));
        return perro;
    }*/

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.sacha:
                Intent intent = new Intent(this, detallesPerrosActivity.class);
                intent.putExtra("nombre", tv1.getText());
                Toast.makeText(this, tv1.getText(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
            case R.id.negra:
                intent = new Intent(this, detallesPerrosActivity.class);
                intent.putExtra("nombre", tv2.getText());
                //Toast.makeText(this, tv1.getText(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
            case R.id.linda:
                intent = new Intent(this, detallesPerrosActivity.class);
                intent.putExtra("nombre", tv3.getText());
                startActivity(intent);
                break;
            case R.id.canu:
                intent = new Intent(this, detallesPerrosActivity.class);
                intent.putExtra("nombre", tv4.getText());
                startActivity(intent);
                break;
            case R.id.bizcocho:
                intent = new Intent(this, detallesPerrosActivity.class);
                intent.putExtra("nombre", tv5.getText());
                Toast.makeText(this, tv1.getText(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
        }

    }
}
