package shoplist.project.kz.sportshop.screen.man;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shoplist.project.kz.sportshop.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ManAccessoriesFragment extends Fragment {


    public ManAccessoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_man_accessories, container, false);
    }

}
