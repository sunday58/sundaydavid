package sundaydavid.venten;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sundaydavid.venten.data.Api;
import sundaydavid.venten.data.ApiInterface;
import sundaydavid.venten.data.VentenFilter;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainActivityTest {

    private List<VentenFilter> books;
    private MainActivity booksPresenter;

    @Mock
    ApiInterface bookService;

    @Mock
    Call<List<VentenFilter>> mockCall;

    @Mock
    ResponseBody responseBody;

    @Captor
    ArgumentCaptor<Callback<List<VentenFilter>>> argumentCaptor;



    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        booksPresenter = new MainActivity();
        books = Collections.singletonList(new VentenFilter());
    }

    @Test
    public void textApiResponse(){

        when(bookService.getVentenFilter()).thenReturn(mockCall);
        Response<List<VentenFilter>> res = Response.success(books);

        booksPresenter.getUserListData();

        verify(mockCall).enqueue(argumentCaptor.capture());
        argumentCaptor.getValue().onResponse(null, res);

        verify(booksPresenter.ventenFilters).get(0);

    }
}