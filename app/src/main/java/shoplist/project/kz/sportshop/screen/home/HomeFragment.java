package shoplist.project.kz.sportshop.screen.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.relex.circleindicator.CircleIndicator;
import shoplist.project.kz.sportshop.R;
import shoplist.project.kz.sportshop.screen.main.SliderImageAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private static ViewPager mPager;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViewPager(view);

    }

    private void initViewPager(View view) {
        mPager = (ViewPager) view.findViewById(R.id.slide_view_pager);
        CircleIndicator circleIndicator = (CircleIndicator)view.findViewById(R.id.indicatorSlider);
        mPager.setAdapter(new SliderImageAdapter(getActivity()));
        mPager.addOnPageChangeListener(viewPagerPageChangeListener);
        circleIndicator.setViewPager(mPager);
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
