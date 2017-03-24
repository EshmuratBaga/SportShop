package shoplist.project.kz.sportshop.screen.details;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import me.relex.circleindicator.CircleIndicator;
import shoplist.project.kz.sportshop.R;
import shoplist.project.kz.sportshop.adapter.DetailsSlideAdapter;
import shoplist.project.kz.sportshop.model.ProductInfo;
import shoplist.project.kz.sportshop.adapter.SliderImageAdapter;

public class DetailsActivity extends AppCompatActivity {
    private String idProduct;
    private ViewPager viewPager;
    private List<String> photo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            idProduct = getIntent().getExtras().getString("id");
        }

        Realm realm = Realm.getDefaultInstance();
        ProductInfo productInfos = realm.where(ProductInfo.class).equalTo("id",idProduct).findFirst();
        Log.d("ssss",productInfos.getName() + productInfos.getImg1() + productInfos.getImg2());
        if (productInfos.getImg1() != null){
            photo.add(productInfos.getImg1());
            photo.add(productInfos.getImg2());
            if (productInfos.getImg3().equals("")){
                photo.add(productInfos.getImg3());
            }
        }
        initWidget();
    }

    private void initWidget() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        CircleIndicator circleIndicator = (CircleIndicator) findViewById(R.id.indicator_slider);
        viewPager.setAdapter(new DetailsSlideAdapter(this,photo));
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        circleIndicator.setViewPager(viewPager);
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

}