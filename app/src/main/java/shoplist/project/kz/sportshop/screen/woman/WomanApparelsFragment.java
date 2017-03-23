package shoplist.project.kz.sportshop.screen.woman;


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
public class WomanApparelsFragment extends Fragment {
    private RecyclerView recyclerView;

    public WomanApparelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_woman_apparels, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_woman_apparels);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        InitApi.initApi(recyclerView,"8",getContext());
    }
}
