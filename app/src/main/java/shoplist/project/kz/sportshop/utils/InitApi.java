package shoplist.project.kz.sportshop.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shoplist.project.kz.sportshop.R;
import shoplist.project.kz.sportshop.adapter.ManApparelsAdapter;
import shoplist.project.kz.sportshop.model.DataProducts;
import shoplist.project.kz.sportshop.model.ProductInfo;
import shoplist.project.kz.sportshop.response.ProductsResponse;
import shoplist.project.kz.sportshop.rest.ApiClient;
import shoplist.project.kz.sportshop.rest.ApiInterface;

/**
 * Created by Andrey on 3/23/2017.
 */

public class InitApi {

    public static void initApi(final RecyclerView recyclerView, String catId, final Context context) {
        Log.d("dddd",""+12345);
        ApiInterface apiInterface = ApiClient.getApiInterface();
        Call<ProductsResponse> call = apiInterface.getProducts(catId);
        call.enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                if(response.isSuccessful()){
                    ProductsResponse productsResponse = response.body();
                    List<DataProducts> dataProducts = productsResponse.getData();
                    List<ProductInfo> productInfos = dataProducts.get(0).getObject();
                    Log.d("ssss","" + productInfos.size());
                    boolean success = dataProducts.get(0).isSuccess();
                    if (success){
                        Log.d("ssss","true");
                        recyclerView.setAdapter(new ManApparelsAdapter(context,productInfos, R.layout.item_recycler_view));
                    }
                }else {
                    Log.d("dddd",""+13456789);
                }

            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                Log.d("dddd","err" + t.getMessage());
            }
        });
    }
}
