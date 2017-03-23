package shoplist.project.kz.sportshop.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import shoplist.project.kz.sportshop.response.ProductsResponse;

/**
 * Created by Andrey on 3/23/2017.
 */

public interface ApiInterface {

    @GET("?act=get_products&page=0&limit=10")
    Call<ProductsResponse> getProducts(@Query("cat_id") String catId);
}
