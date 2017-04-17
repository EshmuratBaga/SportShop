package shoplist.project.kz.sportshop.screen.basket;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shoplist.project.kz.sportshop.R;
import shoplist.project.kz.sportshop.adapter.BasketAdapter;
import shoplist.project.kz.sportshop.model.DataProducts;
import shoplist.project.kz.sportshop.model.InfoTemp;
import shoplist.project.kz.sportshop.model.ProductInfo;
import shoplist.project.kz.sportshop.response.ProductsResponse;
import shoplist.project.kz.sportshop.rest.ApiClient;
import shoplist.project.kz.sportshop.rest.ApiInterface;

public class BasketActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Realm realm;
    private InfoTemp infoTemp;
    private TextView txtAllPrice;
    private TextView txtDeliver;
    private TextView txtPriceParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_clear_white_24dp);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        realm = Realm.getDefaultInstance();
        infoTemp = realm.where(InfoTemp.class).findFirst();

        txtPriceParent = (TextView) findViewById(R.id.txt_price);
        txtAllPrice = (TextView) findViewById(R.id.txt_all_price);
        txtDeliver = (TextView) findViewById(R.id.txt_deliver);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_basket);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface = ApiClient.getApiInterface();
        Call<ProductsResponse> call = apiInterface.getBasket(String.valueOf(infoTemp.getId()));
        call.enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                ProductsResponse productsResponse = response.body();
                List<DataProducts> dataProducts = productsResponse.getData();
                List<ProductInfo> productInfos = dataProducts.get(0).getObject();

                boolean success = dataProducts.get(0).isSuccess();

                if (success){
                    recyclerView.setAdapter(new BasketAdapter(getApplicationContext(),productInfos,R.layout.item_recycler_basket,txtPriceParent,txtAllPrice,txtDeliver,String.valueOf(infoTemp.getId())));
                }
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                Toast.makeText(BasketActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });


    }

}
