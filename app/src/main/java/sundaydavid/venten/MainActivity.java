package sundaydavid.venten;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sundaydavid.venten.adapter.FilterAdapter;
import sundaydavid.venten.data.Api;
import sundaydavid.venten.data.VentenFilter;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";
    RecyclerView recyclerView;
    List<VentenFilter> ventenFilters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.filter_recycler);

        getUserListData();
    }

    private void getUserListData() {

        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("please wait");
        progressDialog.show();


        (Api.getClient().getVentenFilter()).enqueue(new Callback<List<VentenFilter>>() {
            @Override
            public void onResponse(Call<List<VentenFilter>> call, Response<List<VentenFilter>> response) {
                progressDialog.dismiss();
                ventenFilters = response.body();
                Log.d(TAG, "onResponse: end point " + response.body().get(0).getStartYear());
                setDataInRecyclerView();
            }

            @Override
            public void onFailure(Call<List<VentenFilter>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "check network connection", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setDataInRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        FilterAdapter filterAdapter = new FilterAdapter(MainActivity.this, ventenFilters);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(filterAdapter);
    }
}
