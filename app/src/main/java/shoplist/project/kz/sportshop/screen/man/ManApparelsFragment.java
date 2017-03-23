package shoplist.project.kz.sportshop.screen.man;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import shoplist.project.kz.sportshop.utils.InitApi;

/**
 * A simple {@link Fragment} subclass.
 */
public class ManApparelsFragment extends Fragment {
    private RecyclerView recyclerView;

    public ManApparelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_man_apparels, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("dddd",""+123);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_man_apparels);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        InitApi.initApi(recyclerView,"5",getActivity());

    }

//    private void initApi() {
//        Log.d("dddd",""+12345);
//        ApiInterface apiInterface = ApiClient.getApiInterface();
//        Call<ProductsResponse> call = apiInterface.getProducts("5");
//        call.enqueue(new Callback<ProductsResponse>() {
//            @Override
//            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
//                if(response.isSuccessful()){
//                    ProductsResponse productsResponse = response.body();
//                    List<DataProducts> dataProducts = productsResponse.getData();
//                    List<ProductInfo> productInfos = dataProducts.get(0).getObject();
//                    Log.d("ssss","" + productInfos.size());
//                    boolean success = dataProducts.get(0).isSuccess();
//                    if (success){
//                        Log.d("ssss","true");
//                        recyclerView.setAdapter(new ManApparelsAdapter(getActivity(),productInfos,R.layout.item_recycler_view));
//                    }
//                }else {
//                    Log.d("dddd",""+13456789);
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<ProductsResponse> call, Throwable t) {
//                Log.d("dddd","err" + t.getMessage());
//            }
//        });
//    }

}
