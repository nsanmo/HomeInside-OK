package rodrigo.sdm.com.homeinside;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ignaciosantonjamolina on 19/4/17.
 */

public class GetWeatherAsyncTask extends AsyncTask<Void, Void, Weather> {

    // Reference to the activity that launched the asynchronous task
    private WeatherActivity parent = null;

    public void setParent(WeatherActivity parent) {
        this.parent = parent;
    }
    Weather wobject = new Weather();
    /*
        Access the web service in a background thread
    */
    @Override
    protected Weather doInBackground(Void... params) {

        String body = null;
        // Build the URI to access the web service at http://api.forismatic.com/api/1.0/
        Uri.Builder uriBuilder = new Uri.Builder();

        uriBuilder.scheme("http");
        uriBuilder.authority("api.openweathermap.org");
        uriBuilder.appendPath("data");
        uriBuilder.appendPath("2.5");
        uriBuilder.appendPath("weather");
        uriBuilder.appendQueryParameter("q", "London");
        uriBuilder.appendQueryParameter("APPID", "a4d47e1f013caa3f3718785b5c8b9dab");

        Log.d("url", uriBuilder.toString());

    try {
        // Creates a new URL from the URI
        URL url = new URL(uriBuilder.build().toString());

        // Get a connection to the web service
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoInput(true);

        // Process the response if it was successful (HTTP_OK = 200)
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            // Open an input channel to receive the response from the web service
            InputStreamReader isr = new InputStreamReader(connection.getInputStream());
            Log.i("responde connection", connection.getResponseCode()+"");
            // Create a Gson object through a GsonBuilder to process the response
            BufferedReader br = new BufferedReader(isr);
            String lectura = br.readLine();
            Log.i("LECTURA", lectura);

            /*    Gson gson = new Gson();
            try {
                // Deserializes the JSON response into a Quotation object
                result = gson.fromJson(isr, Weather.class);
            } catch (JsonSyntaxException | JsonIOException e) {
                e.printStackTrace();
            }*/
        try{

            JSONObject result = new JSONObject(lectura);
            String temp = result.getJSONObject("main").getString("temp");
            String humidity = result.getJSONObject("main").getString("humidity");
            String viento = result.getJSONObject("wind").getString("speed");
            JSONArray array = result.getJSONArray("weather");
            String desc = array.getJSONObject(0).getString("description");

            Double gradosK = Double.parseDouble(temp);
            Double gradosC = (gradosK-273.15);
            wobject.setTemperatura(round(gradosC,2));
            wobject.setHumedad(Double.parseDouble(humidity));
            wobject.setViento(Double.parseDouble(viento));
            wobject.setPrecipitaciones(desc);


} catch(Exception e){e.printStackTrace();}

            // Close the input channel
            isr.close();
        }

        // Close the connection
        connection.disconnect();

    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Return the received Quotation object
    return wobject;
}

    /*
        Update the interface of activity that launched the asynchronous task
    */
    @Override
    protected void onPostExecute(Weather param) {
        // Quotation received
        if (param != null) {
            this.parent.gotWeather(param.getTemperatura(), param.getHumedad(),param.getPrecipitaciones(),param.getViento());
        }
        // No response received
        else {
            this.parent.resetWeather();
        }
        super.onPostExecute(param);
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
