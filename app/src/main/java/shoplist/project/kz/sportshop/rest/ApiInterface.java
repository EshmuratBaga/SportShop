package shoplist.project.kz.sportshop.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import shoplist.project.kz.sportshop.response.AddFavoriteResponse;
import shoplist.project.kz.sportshop.response.ProductsResponse;
import shoplist.project.kz.sportshop.response.TempAuthResponse;

/**
 * Created by Andrey on 3/23/2017.
 */

public interface ApiInterface {

    @GET("?act=get_products&page=0&limit=10")
    Call<ProductsResponse> getProducts(@Query("cat_id") String catId, @Query("ta_id") String taId);

    @GET("?act=temp_auth")
    Call<TempAuthResponse> getTemp();

    @GET("?act=add_product_to_favourite")
    Call<AddFavoriteResponse> addToFavorite(@Query("prod_id") String id, @Query("ta_id") String taId);

    @GET("?act=del_product_from_favourite")
    Call<AddFavoriteResponse> deleteFromFavorite(@Query("prod_id") String id, @Query("ta_id") String taId);

    @GET("?act=add_product_to_cart")
    Call<AddFavoriteResponse> addToBasket(@Query("prod_id") String id, @Query("ta_id") String taId);

    @GET("?act=del_product_from_cart")
    Call<AddFavoriteResponse> deleteToBasket(@Query("prod_id") String id, @Query("ta_id") String taId);

    @GET("?act=my_favourite")
    Call<ProductsResponse> getFavorite(@Query("ta_id") String taId);

    @GET("?act=my_cart")
    Call<ProductsResponse> getBasket(@Query("ta_id") String taId);
}
