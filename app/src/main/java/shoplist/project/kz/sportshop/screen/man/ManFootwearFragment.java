package shoplist.project.kz.sportshop.screen.man;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shoplist.project.kz.sportshop.R;
import shoplist.project.kz.sportshop.utils.InitApi;

/**
 * A simple {@link Fragment} subclass.
 */
public class ManFootwearFragment extends Fragment {
    private RecyclerView recyclerView;


    public ManFootwearFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_man_footwear, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_man_footwear);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        InitApi.initApi(recyclerView,"6",getActivity());
    }
}
