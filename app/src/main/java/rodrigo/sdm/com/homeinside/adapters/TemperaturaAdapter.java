package rodrigo.sdm.com.homeinside.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import rodrigo.sdm.com.homeinside.R;
import rodrigo.sdm.com.homeinside.holders.TemperaturaViewHolder;
import rodrigo.sdm.com.homeinside.model.Temperatura;

/**
 * Created by vicov on 24/04/2017.
 */

  //Es una clase que extiende del RecycletView.Adapter
    //Lo que hace es coger una clase cualquiera y maquetarla en el viewHolder, que es donde
    // incluiremos el cardView.
public class TemperaturaAdapter extends RecyclerView.Adapter<TemperaturaViewHolder> {

    private ArrayList<Temperatura> temperaturas;

    public TemperaturaAdapter(ArrayList<Temperatura> temperaturas) {
        this.temperaturas = temperaturas;
    }

    @Override
    // se crea una vista, que es donde se va a maquetar
    public TemperaturaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View tempCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.radiador_card,parent,false);
        return new TemperaturaViewHolder(tempCard);
    }

    @Override
    // el encargado de maquetar... llama al wiewHolder y maquetarlo
    public void onBindViewHolder(TemperaturaViewHolder holder, int position) {
        holder.updateUI(temperaturas.get(position),position);
    }

    @Override
    //cuantos item tiene lo que hay que maquetar
    public int getItemCount() {
        return temperaturas.size();
    }
}
