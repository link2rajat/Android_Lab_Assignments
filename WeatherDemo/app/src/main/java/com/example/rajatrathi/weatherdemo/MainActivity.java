package com.example.rajatrathi.weatherdemo;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    private SensorManager sensorManager;
    private TextView temperatureTextview;
    private TextView pressureTextview;
    private TextView lightTextview;

    private float currentTemperature = Float.NaN;
    private float currentPressure = Float.NaN;
    private float currentLight = Float.NaN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temperatureTextview = (TextView)findViewById(R.id.temperature);
        pressureTextview = (TextView)findViewById(R.id.pressure);
        lightTextview = (TextView)findViewById(R.id.light);
        sensorManager =(SensorManager)getSystemService(Context.SENSOR_SERVICE);

        Timer updateTimer = new Timer("weatherUpdate");
        updateTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateGUI();
            }
        },0,1000);

    }
private  final SensorEventListener tempSensorEventListner = new SensorEventListener() {
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        currentTemperature = sensorEvent.values[0];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
};

    private  final SensorEventListener pressureSensorEventListner = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            currentPressure = sensorEvent.values[0];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };
    private  final SensorEventListener lightSensorEventListner = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            currentLight = sensorEvent.values[0];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };
@Override
    protected  void onResume() {
    super.onResume();


    Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    if (lightSensor != null)
    {
    sensorManager.registerListener(lightSensorEventListner,lightSensor,SensorManager.SENSOR_DELAY_NORMAL);

    }
    else
    {
    lightTextview.setText("Light Sensor Unavailable");

    }

    Sensor pressureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
    if (pressureSensor != null)
    {
        sensorManager.registerListener(pressureSensorEventListner,pressureSensor,SensorManager.SENSOR_DELAY_NORMAL);

    }
    else
    {
        pressureTextview.setText("Barometer Unavailable");

    }
    Sensor temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
    if (temperatureSensor != null)
    {
        sensorManager.registerListener(tempSensorEventListner,temperatureSensor,SensorManager.SENSOR_DELAY_NORMAL);

    }
    else
    {
        temperatureTextview.setText("Thermometer Unavailable");

    }

}

    @Override
    protected void onPause() {
        sensorManager.unregisterListener(pressureSensorEventListner);
        sensorManager.unregisterListener(tempSensorEventListner);
        sensorManager.unregisterListener(lightSensorEventListner);
        super.onPause();
    }

    private  void updateGUI(){
        runOnUiThread(new Runnable() {
            @Override
            public void run()
            {
            if(!Float.isNaN(currentPressure))
            {
            pressureTextview.setText(currentPressure+"(mBars)");
                pressureTextview.invalidate();
            }
                if(!Float.isNaN(currentLight))
                {
                String lightStr ="Sunny";
                    if (currentLight<=SensorManager.LIGHT_CLOUDY)
                        lightStr ="Night";
                    else if (currentLight<=SensorManager.LIGHT_OVERCAST)
                        lightStr ="Cloudy";
                    else if (currentLight<=SensorManager.LIGHT_SUNLIGHT)
                        lightStr ="Overcast";
                    lightTextview.setText(lightStr);
                    lightTextview.invalidate();
                }
                if (!Float.isNaN(currentTemperature))
                {
                    temperatureTextview.setText(currentTemperature+"C");
                    temperatureTextview.invalidate();
                }
            }
        });


    };
}
