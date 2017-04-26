package rodrigo.sdm.com.homeinside;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import static rodrigo.sdm.com.homeinside.R.id.button_meteo;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    protected DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void buttonOnClicked(View v){
        int id= v.getId();
        Intent intent;
        switch (id){
            case R.id.button_general:
                break;
            case R.id.button_iluminacion:
                intent= new Intent(this,IluminacionActivity.class);
                startActivity(intent);
                break;
            case R.id.button_config:
                intent=new Intent(this,ConfiguracionActivity.class);
                startActivity(intent);
                break;
            case  R.id.button_about:
                intent=new Intent(this,AboutActivity.class);
                startActivity(intent);
                break;
            case  R.id.button_persianas:
                intent=new Intent(this,PPersianaActivity.class);
                startActivity(intent);
                break;
            case  R.id.button_meteo:
                intent=new Intent(this,WeatherActivity.class);
                startActivity(intent);
                break;

            case R.id.button_temperatura:
                intent = new Intent(this,TemperaturaActivity.class);
                startActivity(intent);
                break;
        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
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
            Intent intent;
            intent=new Intent(this,ConfiguracionActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent;

       if (id == R.id.nav_iluminacion) {
           intent= new Intent(this, IluminacionActivity.class);
           startActivity(intent);

        } else if (id == R.id.nav_tools) {
           intent= new Intent(this, ConfiguracionActivity.class);
           startActivity(intent);
        } else if (id == R.id.nav_about) {
           intent= new Intent(this, AboutActivity.class);
           startActivity(intent);
        } /*else if (id == R.id.nav_camara) {
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
