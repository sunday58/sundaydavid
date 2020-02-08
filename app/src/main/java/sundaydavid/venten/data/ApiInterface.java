package sundaydavid.venten.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("assessment/filter.json")
    Call<List<VentenFilter>> getVentenFilter();
}
