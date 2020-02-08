package sundaydavid.venten;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sundaydavid.venten.data.Api;

import sundaydavid.venten.data.VentenFilter;



public class MainActivityTest {

   private List<VentenFilter> ventenFilters;



    @Test
    public void textApiResponse(){

        (Api.getClient().getVentenFilter()).enqueue(new Callback<List<VentenFilter>>() {
            @Override
            public void onResponse(Call<List<VentenFilter>> call, Response<List<VentenFilter>> response) {
                ventenFilters = response.body();

                Assert.assertNotNull("List should not be empty", ventenFilters);
                Assert.assertEquals("correct size", 5, ventenFilters.size());

            }

            @Override
            public void onFailure(Call<List<VentenFilter>> call, Throwable t) {

            }
        });


    }

}