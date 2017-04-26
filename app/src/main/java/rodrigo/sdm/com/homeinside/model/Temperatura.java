package rodrigo.sdm.com.homeinside.model;

/**
 * Created by vicov on 24/04/2017.
 */

//la clase que hay que maquetar.

public class Temperatura {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    private int temperatura;

    public Temperatura(String title, int temperatura) {
        this.title = title;
        this.temperatura = temperatura;
    }
}
