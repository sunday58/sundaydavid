package sundaydavid.venten;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethod;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import sundaydavid.venten.adapter.CarDetailsAdapter;
import sundaydavid.venten.data.CarOwnersList;
import sundaydavid.venten.data.VentenFilter;

public class CarOwnersActivity extends AppCompatActivity {

    CarDetailsAdapter adapter;
    ProgressDialog dialog;

    private static String TAG = "CarOwnersActivity";
    private List<CarOwnersList> carOwnersLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_owners);


        FilterAsync filterAsync = new FilterAsync();
        filterAsync.execute();
    }


    public class FilterAsync extends AsyncTask<InputStream, Void, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog = new ProgressDialog(CarOwnersActivity.this);
            dialog.setMessage("please wait... loading car owners");
            dialog.setCancelable(false);
            dialog.setIndeterminate(false);
            dialog.show();
        }

        @Override
        protected String doInBackground(InputStream... inputStreams) {

            Intent intent = getIntent();
            final VentenFilter filtersDetails = intent.getParcelableExtra("filters");
            //filtering for only male

            if (filtersDetails.getGender().equals("") && filtersDetails.getCountries().isEmpty()
                    && filtersDetails.getColors().isEmpty()){

                InputStream is = getResources().openRawResource(R.raw.car_ownsers_data);

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(is, Charset.forName("UTF-8"))
                );

                String line = "";

                try {
                    reader.readLine();

                    while ((line = reader.readLine()) != null){
                        Log.d(TAG, "readCarOwnersData: " + line);

                        String[] tokens = line.split(",");


                        CarOwnersList list = new CarOwnersList();

                        //setters
                        list.setBio(tokens[10]);
                        list.setCar_model(tokens[5]);
                        list.setCar_model_year(tokens[6]);
                        list.setEmail(tokens[3]);
                        list.setFirst_name(tokens[1]);
                        list.setLast_name(tokens[2]);
                        list.setJob_title(tokens[9]);

                        carOwnersLists.add(list);
                    }
                }catch (IOException e){
                    Log.d(TAG, "readCarOwnersData: " + line, e);

                    Toast.makeText(CarOwnersActivity.this, "Details of car owners not found", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

                return line;
            }else if (filtersDetails.getGender().isEmpty() && filtersDetails.getColors().isEmpty()){

                InputStream is = getResources().openRawResource(R.raw.car_ownsers_data);

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(is, Charset.forName("UTF-8"))
                );

                String line = "";

                try {
                    reader.readLine();

                    while ((line = reader.readLine()) != null){
                        Log.d(TAG, "readCarOwnersData: " + line);

                        String[] tokens = line.split(",");


                        CarOwnersList list = new CarOwnersList();

                        //setters
                        list.setBio(tokens[10]);
                        list.setCar_model(tokens[5]);
                        list.setCountry(tokens[4]);
                        list.setCar_model_year(tokens[6]);
                        list.setEmail(tokens[3]);
                        list.setFirst_name(tokens[1]);
                        list.setLast_name(tokens[2]);
                        list.setJob_title(tokens[9]);

                        carOwnersLists.add(list);
                    }
                }catch (IOException e){
                    Log.d(TAG, "readCarOwnersData: " + line, e);

                    Toast.makeText(CarOwnersActivity.this, "Details of car owners not found", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

                return line;
            } else if (filtersDetails.getGender().equals("")){

                InputStream is = getResources().openRawResource(R.raw.car_ownsers_data);

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(is, Charset.forName("UTF-8"))
                );

                String line = "";

                try {
                    reader.readLine();

                    while ((line = reader.readLine()) != null){
                        Log.d(TAG, "readCarOwnersData: " + line);

                        String[] tokens = line.split(",");


                        CarOwnersList list = new CarOwnersList();

                        //setters
                        list.setBio(tokens[10]);
                        list.setCar_color(tokens[7]);
                        list.setCar_model(tokens[5]);
                        list.setCountry(tokens[4]);
                        list.setCar_model_year(tokens[6]);
                        list.setEmail(tokens[3]);
                        list.setFirst_name(tokens[1]);
                        list.setLast_name(tokens[2]);
                        list.setJob_title(tokens[9]);

                        carOwnersLists.add(list);
                    }
                }catch (IOException e){
                    Log.d(TAG, "readCarOwnersData: " + line, e);

                    Toast.makeText(CarOwnersActivity.this, "Details of car owners not found", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

                return line;

            }else if (filtersDetails.getCountries().isEmpty()){

                InputStream is = getResources().openRawResource(R.raw.car_ownsers_data);

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(is, Charset.forName("UTF-8"))
                );

                String line = "";

                try {
                    reader.readLine();

                    while ((line = reader.readLine()) != null){
                        Log.d(TAG, "readCarOwnersData: " + line);

                        String[] tokens = line.split(",");


                        CarOwnersList list = new CarOwnersList();

                        //setters
                        list.setBio(tokens[10]);
                        list.setCar_color(tokens[7]);
                        list.setCar_model(tokens[5]);
                        list.setCar_model_year(tokens[6]);
                        list.setEmail(tokens[3]);
                        list.setFirst_name(tokens[1]);
                        list.setLast_name(tokens[2]);
                        list.setJob_title(tokens[9]);
                        list.setGender(tokens[8]);

                        carOwnersLists.add(list);
                    }
                }catch (IOException e){
                    Log.d(TAG, "readCarOwnersData: " + line, e);

                    Toast.makeText(CarOwnersActivity.this, "Details of car owners not found", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

                return line;
            }else if (filtersDetails.getColors().isEmpty()){

                InputStream is = getResources().openRawResource(R.raw.car_ownsers_data);

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(is, Charset.forName("UTF-8"))
                );

                String line = "";

                try {
                    reader.readLine();

                    while ((line = reader.readLine()) != null){
                        Log.d(TAG, "readCarOwnersData: " + line);

                        String[] tokens = line.split(",");


                        CarOwnersList list = new CarOwnersList();

                        //setters
                        list.setBio(tokens[10]);
                        list.setCar_model(tokens[5]);
                        list.setCountry(tokens[4]);
                        list.setCar_model_year(tokens[6]);
                        list.setEmail(tokens[3]);
                        list.setFirst_name(tokens[1]);
                        list.setLast_name(tokens[2]);
                        list.setJob_title(tokens[9]);
                        list.setGender(tokens[8]);

                        carOwnersLists.add(list);
                    }
                }catch (IOException e){
                    Log.d(TAG, "readCarOwnersData: " + line, e);

                    Toast.makeText(CarOwnersActivity.this, "Details of car owners not found", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

                return line;
            }


           else {
                InputStream is = getResources().openRawResource(R.raw.car_ownsers_data);

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(is, Charset.forName("UTF-8"))
                );

                String line = "";

                try {
                    reader.readLine();

                    while ((line = reader.readLine()) != null) {
                        Log.d(TAG, "readCarOwnersData: " + line);

                        String[] tokens = line.split(",");

                        CarOwnersList list = new CarOwnersList();

                        //setters
                        list.setBio(tokens[10]);
                        list.setCar_color(tokens[7]);
                        list.setCar_model(tokens[5]);
                        list.setCountry(tokens[4]);
                        list.setCar_model_year(tokens[6]);
                        list.setEmail(tokens[3]);
                        list.setFirst_name(tokens[1]);
                        list.setLast_name(tokens[2]);
                        list.setJob_title(tokens[9]);
                        list.setGender(tokens[8]);

                        carOwnersLists.add(list);
                    }
                } catch (IOException e) {
                    Log.d(TAG, "readCarOwnersData: " + line, e);

                    Toast.makeText(CarOwnersActivity.this, "Details of car owners not found", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

                return line;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            RecyclerView recyclerView = findViewById(R.id.rvCarDetails);
            recyclerView.setLayoutManager(new LinearLayoutManager(CarOwnersActivity.this));
            adapter = new CarDetailsAdapter(CarOwnersActivity.this, carOwnersLists);
            recyclerView.setAdapter(adapter);
            dialog.hide();
        }

    }

}
