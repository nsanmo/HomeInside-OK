package rodrigo.sdm.com.homeinside;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by ignaciosantonjamolina on 21/4/17.
 */

public class PPersianaActivity extends AppCompatActivity {


    // Persiana bajada = 0, persiana subida = 100;
    int p_1 = 0;
    int p_2 = 0;
    int p_3 = 0;
    int p_4 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppersiana);

        SharedPreferences prefPersiana= PreferenceManager.getDefaultSharedPreferences(this);
        p_1 = prefPersiana.getInt("cocinaPersiana", 50);
        p_2 = prefPersiana.getInt("salonPersiana", 50);
        p_3 = prefPersiana.getInt("habitacionPersiana", 50);
        p_4 = prefPersiana.getInt("invitadosPersiana", 50);

        if(p_1 == 0) {
            ImageView image1=(ImageView) findViewById(R.id.pbajasalon);
            image1.setImageDrawable(getResources().getDrawable(R.drawable.bajadapersiana));}
        else if (p_1 == 100) {
            ImageView image1=(ImageView) findViewById(R.id.psubesalon);
            image1.setImageDrawable(getResources().getDrawable(R.drawable.subidapersiana));
        };
        if(p_2 == 0) {
            ImageView image1=(ImageView) findViewById(R.id.pbajaCocina);
            image1.setImageDrawable(getResources().getDrawable(R.drawable.bajadapersiana));}
        else if (p_2 == 100) {
            ImageView image1=(ImageView) findViewById(R.id.psubeCocina);
            image1.setImageDrawable(getResources().getDrawable(R.drawable.subidapersiana));
        };
        if(p_3 == 0) {
            ImageView image1=(ImageView) findViewById(R.id.pbajaHabitacion);
            image1.setImageDrawable(getResources().getDrawable(R.drawable.bajadapersiana));}
        else if (p_3 == 100) {
            ImageView image1=(ImageView) findViewById(R.id.psubeHabitacion);
            image1.setImageDrawable(getResources().getDrawable(R.drawable.subidapersiana));
        };
        if(p_4 == 0) {
            ImageView image1=(ImageView) findViewById(R.id.pbajaInvitados);
            image1.setImageDrawable(getResources().getDrawable(R.drawable.bajadapersiana));}
        else if (p_4 == 100) {
            ImageView image1=(ImageView) findViewById(R.id.psubeInvitados);
            image1.setImageDrawable(getResources().getDrawable(R.drawable.subidapersiana));
        };
    }

    @Override
    public void onPause(){
        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putInt("cocinaPersiana", p_1);
        editor.putInt("salonPersiana", p_2);
        editor.putInt("habitacionPersiana", p_3);
        editor.putInt("invitadosPersiana", p_4);


        editor.apply();
        super.onPause();
    }
    @Override
    public void onResume(){
        SharedPreferences prefPersiana= PreferenceManager.getDefaultSharedPreferences(this);
        p_1 = prefPersiana.getInt("cocina", 50);
        p_2 = prefPersiana.getInt("salon", 50);
        p_3 = prefPersiana.getInt("habitacion", 50);
        p_4 = prefPersiana.getInt("invitados", 50);
        super.onResume();
    }

    public void onClickPersiana(View v){
        ImageView image=(ImageView) v;
        int id= v.getId();
        switch (id) {
            case R.id.pbajaCocina:
                if (p_1 > 0) {
                    p_1 = p_1 - 5;
                }
                if (p_1 == 0) {
                    image.setImageDrawable(getResources().getDrawable(R.drawable.bajadapersiana));
                }
                if (p_1 == 95) {
                    View parent = (View) v.getParent();
                    ((ImageView)parent.findViewById(R.id.psubeCocina)).setImageDrawable(
                            getResources().getDrawable(R.drawable.subepersiana));
                }
                break;
            case R.id.psubeCocina:
                if (p_1 < 100) {
                    p_1 = p_1 + 5;
                }
                if (p_1 == 100) {
                    image.setImageDrawable(getResources().getDrawable(R.drawable.subidapersiana));
                }
                if (p_1 == 5) {
                    View parent = (View) v.getParent();
                    ((ImageView)parent.findViewById(R.id.pbajaCocina)).setImageDrawable(
                            getResources().getDrawable(R.drawable.bajapersiana));
                }
                break;
            case R.id.pbajasalon:
                if (p_2 > 0) {
                    p_2 = p_2 - 5;
                }
                if (p_2 == 0) {
                    image.setImageDrawable(getResources().getDrawable(R.drawable.bajadapersiana));
                }
                if (p_2 == 95) {
                    View parent = (View) v.getParent();
                    ((ImageView)parent.findViewById(R.id.psubesalon)).setImageDrawable(
                            getResources().getDrawable(R.drawable.subepersiana));
                }
                break;
            case R.id.psubesalon:
                if (p_2 < 100) {
                    p_2 = p_2 + 5;
                }
                if (p_2 == 100) {
                    image.setImageDrawable(getResources().getDrawable(R.drawable.subidapersiana));
                }
                if (p_2 == 5) {
                    View parent = (View) v.getParent();
                    ((ImageView)parent.findViewById(R.id.pbajasalon)).setImageDrawable(
                            getResources().getDrawable(R.drawable.bajapersiana));
                }
                break;
            case R.id.pbajaHabitacion:
                if (p_3 > 0) {
                    p_3 = p_3 - 5;
                }
                if (p_3 == 0) {
                    image.setImageDrawable(getResources().getDrawable(R.drawable.bajadapersiana));
                }
                if (p_3 == 95) {
                    View parent = (View) v.getParent();
                    ((ImageView)parent.findViewById(R.id.psubeHabitacion)).setImageDrawable(
                            getResources().getDrawable(R.drawable.subepersiana));
                }
                break;
            case R.id.psubeHabitacion:
                if (p_3 < 100) {
                    p_3 = p_3 + 5;
                }
                if (p_3 == 100) {
                    image.setImageDrawable(getResources().getDrawable(R.drawable.subidapersiana));
                }
                if (p_3 == 5) {
                    View parent = (View) v.getParent();
                    ((ImageView)parent.findViewById(R.id.pbajaHabitacion)).setImageDrawable(
                            getResources().getDrawable(R.drawable.bajapersiana));
                }
                break;
            case R.id.pbajaInvitados:
                if (p_4 > 0) {
                    p_4 = p_4 - 5;
                }
                if (p_4 == 0) {
                    image.setImageDrawable(getResources().getDrawable(R.drawable.bajadapersiana));
                }
                if (p_4 == 95) {
                    View parent = (View) v.getParent();
                    ((ImageView)parent.findViewById(R.id.psubesalon)).setImageDrawable(
                            getResources().getDrawable(R.drawable.subepersiana));
                }
                break;
            case R.id.psubeInvitados:
                if (p_4 < 100) {
                    p_4 = p_4 + 5;
                }
                if (p_4 == 100) {
                    image.setImageDrawable(getResources().getDrawable(R.drawable.subidapersiana));
                }
                if (p_4 == 5) {
                    View parent = (View) v.getParent();
                    ((ImageView)parent.findViewById(R.id.pbajasalon)).setImageDrawable(
                            getResources().getDrawable(R.drawable.bajapersiana));
                }
                break;
        }
    }
}

