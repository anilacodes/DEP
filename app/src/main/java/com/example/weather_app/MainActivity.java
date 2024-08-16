package com.example.weather_app;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCity;
    private TextView textViewWeather;
    private Button buttonSearch;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCity = findViewById(R.id.editTextCity);
        textViewWeather = findViewById(R.id.textViewWeather);
        buttonSearch = findViewById(R.id.buttonSearch);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = editTextCity.getText().toString().trim();
                if (!city.isEmpty()) {
                    new GetWeather().execute(city);
                } else {
                    textViewWeather.setText("Please enter a city name");
                }
            }
        });
    }

    private class GetWeather extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            String response = "";
            try {
                String city = strings[0];
                String apiKey = "cbf05460a133b5e3ebeb0f26afc9417e"; // Replace with your API key
                String urlStr = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
                URL url = new URL(urlStr);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                connection.disconnect();

                response = content.toString();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray weatherArray = jsonObject.getJSONArray("weather");
                JSONObject weatherObject = weatherArray.getJSONObject(0);
                String weatherInfo = weatherObject.getString("description");

                JSONObject mainObject = jsonObject.getJSONObject("main");
                double temp = mainObject.getDouble("temp") - 273.15; // Convert from Kelvin to Celsius

                String displayText = "Weather: " + weatherInfo + "\nTemperature: " + String.format("%.2f", temp) + "°C";
                textViewWeather.setText(displayText);

            } catch (Exception e) {
                e.printStackTrace();
                textViewWeather.setText("Error retrieving weather data. Please try again.");
            }
        }
    }
}
