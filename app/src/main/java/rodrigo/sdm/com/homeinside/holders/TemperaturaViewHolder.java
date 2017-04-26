package rodrigo.sdm.com.homeinside.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import rodrigo.sdm.com.homeinside.R;
import rodrigo.sdm.com.homeinside.TemperaturaActivity;
import rodrigo.sdm.com.homeinside.model.Temperatura;

/**
 * Created by vicov on 24/04/2017.
 */

//lo que tienes dentro del cardView

public class TemperaturaViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    NumberPicker numberPicker;

    //busca los item del cardview
    public TemperaturaViewHolder(View itemView) {
        super(itemView);
        title = (TextView)itemView.findViewById(R.id.titleTemperatura);
        numberPicker = (NumberPicker)itemView.findViewById(R.id.numberPicker);

    }

    //valor que tienes en la clase y los maqueta
    public void updateUI(final Temperatura tmpe, final int pos){
        title.setText(tmpe.getTitle());
        numberPicker.setMaxValue(30);
        numberPicker.setMinValue(18);
        numberPicker.setValue(tmpe.getTemperatura());
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                TemperaturaActivity.tmp.get(pos).setTemperatura(newVal);

            }
        });
    }
}
