package rodrigo.sdm.com.homeinside;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class IluminacionActivity extends AppCompatActivity {

    protected boolean luz1;
    protected boolean luz2;
    protected boolean luz3;
    protected boolean luz4;
    protected boolean luz5;
    protected boolean luz6;
    protected boolean luz7;
    protected boolean luz8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iluminacion);

        /*LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                .getSystemService(this.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_main, null, false);
        activity_ilumination.addView(contentView, 0);*/


        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(this);
        luz1=preferences.getBoolean("salon1",false);
        luz2=preferences.getBoolean("salon2",false);
        luz3=preferences.getBoolean("cocina",false);
        luz4=preferences.getBoolean("habitacionPrincipal1",false);
        luz5=preferences.getBoolean("habitacionPrincipal2",false);
        luz6=preferences.getBoolean("bano",false);
        luz7=preferences.getBoolean("habitacionSecundaria1",false);
        luz8=preferences.getBoolean("habitacionSecundaria2",false);

        ImageView image1=(ImageView) findViewById(R.id.salon_principal);
        if(luz1) image1.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_encendida_redonda));
        else  image1.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_apagada_redonda));

        ImageView image2=(ImageView) findViewById(R.id.salon_secundaria);
        if(luz2) image2.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_encendida_redonda));
        else  image2.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_apagada_redonda));

        ImageView image3=(ImageView) findViewById(R.id.cocina);
        if(luz3) image3.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_encendida_redonda));
        else  image3.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_apagada_redonda));

        ImageView image4=(ImageView) findViewById(R.id.habit_prin_central);
        if(luz4) image4.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_encendida_redonda));
        else  image4.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_apagada_redonda));

        ImageView image5=(ImageView) findViewById(R.id.habit_prin_secundaria);
        if(luz5) image5.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_encendida_redonda));
        else  image5.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_apagada_redonda));

        ImageView image6=(ImageView) findViewById(R.id.bano);
        if(luz6) image6.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_encendida_redonda));
        else  image6.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_apagada_redonda));

        ImageView image7=(ImageView) findViewById(R.id.habit_sec_central);
        if(luz7) image7.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_encendida_redonda));
        else  image7.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_apagada_redonda));

        ImageView image8=(ImageView) findViewById(R.id.habit_sec_sec);
        if(luz8) image8.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_encendida_redonda));
        else  image8.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_apagada_redonda));
    }

    @Override
    public void onPause(){
        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putBoolean("salon1", luz1);
        editor.putBoolean("salon2", luz2);
        editor.putBoolean("cocina", luz3);
        editor.putBoolean("habitacionPrincipal1", luz4);
        editor.putBoolean("habitacionPrincipal2", luz5);
        editor.putBoolean("bano", luz6);
        editor.putBoolean("habitacionSecundaria1", luz7);
        editor.putBoolean("habitacionSecundaria2", luz8);

        editor.apply();
        super.onPause();
    }
    @Override
    public void onResume(){
        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(this);
        luz1=preferences.getBoolean("salon1",false);
        luz2=preferences.getBoolean("salon2",false);
        luz3=preferences.getBoolean("cocina",false);
        luz4=preferences.getBoolean("habitacionPrincipal1",false);
        luz5=preferences.getBoolean("habitacionPrincipal2",false);
        luz6=preferences.getBoolean("bano",false);
        luz7=preferences.getBoolean("habitacionSecundaria1",false);
        luz8=preferences.getBoolean("habitacionSecundaria2",false);
        super.onResume();
    }
    public void onClickBombilla(View v){
        ImageView image=(ImageView) v;
        int id= v.getId();
        switch (id){
            case R.id.salon_principal:
                if(luz1){
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_apagada_redonda));
                    luz1=false;}
                else{
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_encendida_redonda));
                    luz1=true;};
                break;
            case R.id.salon_secundaria:
                if(luz2){
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_apagada_redonda));
                    luz2=false;}
                else{
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_encendida_redonda));
                    luz2=true;};
                break;
            case R.id.cocina:
                if(luz3){
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_apagada_redonda));
                    luz3=false;}
                else{
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_encendida_redonda));
                    luz3=true;};
                break;
            case R.id.habit_prin_central:
                if(luz4){
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_apagada_redonda));
                    luz4=false;}
                else{
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_encendida_redonda));
                    luz4=true;};
                break;
            case R.id.habit_prin_secundaria:
                if(luz5){
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_apagada_redonda));
                    luz5=false;}
                else{
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_encendida_redonda));
                    luz5=true;};
                break;
            case R.id.bano:
                if(luz6){
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_apagada_redonda));
                    luz6=false;}
                else{
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_encendida_redonda));
                    luz6=true;};
                break;
            case R.id.habit_sec_central:
                if(luz7){
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_apagada_redonda));
                    luz7=false;}
                else{
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_encendida_redonda));
                    luz7=true;};
                break;
            case R.id.habit_sec_sec:
                if(luz8){
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_apagada_redonda));
                    luz8=false;}
                else{
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.bombilla_encendida_redonda));
                    luz8=true;};
                break;
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent;

        if (id == R.id.nav_iluminacion) {
            intent= new Intent(this, IluminacionActivity.class);
            startActivity(intent);

        }/* else if (id == R.id.MainActivty.class) {

        } else if (id == R.id.nav_persianas) {

        } else if (id == R.id.nav_camara) {
            Intent intent=new Intent(this,CamaraActivity.class);

        } else if (id == R.id.nav_tools) {
            Intent intent=new Intent(this,SettingsActivity.class);

        } else if (id == R.id.nav_share) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
