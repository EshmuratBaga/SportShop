package shoplist.project.kz.sportshop.screen.basket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
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

        realm = Realm.getDefaultInstance();
        infoTemp = realm.where(InfoTemp.class).findFirst();

        txtPriceParent = (TextView) findViewById(R.id.txt_price);
        txtAllPrice = (TextView) findViewById(R.id.txt_all_price);
        txtDeliver = (TextView) findViewById(R.id.txt_deliver);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_basket);
        recyclerView.setHasFixedSize(true);
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
                    recyclerView.setAdapter(new BasketAdapter(getApplicationContext(),productInfos,R.layout.item_recycler_basket,txtPriceParent,txtAllPrice,txtDeliver));
                }
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                Toast.makeText(BasketActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });


    }

}
