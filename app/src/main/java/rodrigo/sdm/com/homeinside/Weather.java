package rodrigo.sdm.com.homeinside;

/**
 * Created by ignaciosantonjamolina on 19/4/17.
 */

public class Weather {
    Double temperatura;
    Double humedad;
    String precipitaciones;
    Double viento;

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getHumedad() {
        return humedad;
    }

    public void setHumedad(Double humedad) {
        this.humedad = humedad;
    }

    public String getPrecipitaciones() {
        return precipitaciones;
    }

    public void setPrecipitaciones(String precipitaciones) {
        this.precipitaciones = precipitaciones;
    }

    public Double getViento() {
        return viento;
    }

    public void setViento(Double viento) {
        this.viento = viento;
    }
}
