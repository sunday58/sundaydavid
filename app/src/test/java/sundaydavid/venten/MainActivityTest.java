package sundaydavid.venten;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sundaydavid.venten.data.Api;
import sundaydavid.venten.data.ApiInterface;
import sundaydavid.venten.data.VentenFilter;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.nullable;

public class MainActivityTest {

    private List<VentenFilter> list;
    private MainActivity mainActivity;

    @Mock
    ApiInterface apiInterface;

    @Mock
    Call<List<VentenFilter>> mockCall;

    @Mock
    ResponseBody responseBody;

    @Captor
    ArgumentCaptor<Callback<List<VentenFilter>>> argumentCaptor;




    @Test
    public void textApiResponse(){


    }
}