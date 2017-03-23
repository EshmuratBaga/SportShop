package shoplist.project.kz.sportshop.screen.main;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import shoplist.project.kz.sportshop.R;
import shoplist.project.kz.sportshop.adapter.ExpandableListAdapter;
import shoplist.project.kz.sportshop.model.ExpandedMenuModel;
import shoplist.project.kz.sportshop.screen.home.HomeFragment;
import shoplist.project.kz.sportshop.screen.kids.KidsAccessoriesFragment;
import shoplist.project.kz.sportshop.screen.kids.KidsApparelsFragment;
import shoplist.project.kz.sportshop.screen.kids.KidsFootwearFragment;
import shoplist.project.kz.sportshop.screen.man.ManAccessoriesFragment;
import shoplist.project.kz.sportshop.screen.man.ManApparelsFragment;
import shoplist.project.kz.sportshop.screen.man.ManFootwearFragment;
import shoplist.project.kz.sportshop.screen.sports.BasketballFragment;
import shoplist.project.kz.sportshop.screen.sports.FitnessFragment;
import shoplist.project.kz.sportshop.screen.sports.FootballFragment;
import shoplist.project.kz.sportshop.screen.sports.RunningFragment;
import shoplist.project.kz.sportshop.screen.sports.TennisFragment;
import shoplist.project.kz.sportshop.screen.woman.WomanAccessoriesFragment;
import shoplist.project.kz.sportshop.screen.woman.WomanApparelsFragment;
import shoplist.project.kz.sportshop.screen.woman.WomanFootwearFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ExpandableListAdapter mMenuAdapter;
    private ExpandableListView expandableList;
    private NavigationView navigationView;
    private List<ExpandedMenuModel> listDataHeader;
    private HashMap<ExpandedMenuModel, List<String>> listDataChild;
    private Fragment fragment;
    private String titleFragment;
    private TextView txtHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        expandableList = (ExpandableListView) findViewById(R.id.navigationmenu);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        txtHome = (TextView) findViewById(R.id.txt_home);
        txtHome.setOnClickListener(this);
        if (navigationView != null) {
            setupDrawerContent(toolbar);
        }

        prepareListData();
        mMenuAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild, expandableList);

        // setting list adapter
        expandableList.setAdapter(mMenuAdapter);

        expandableList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                if (i == 0){
                    if (i1 == 0){
                        fragment = new ManApparelsFragment();
                        titleFragment = "Одежда";
                    }
                    if (i1 == 1){
                        fragment = new ManFootwearFragment();
                        titleFragment = "Обувь";
                    }
                    if (i1 == 2){
                        fragment = new ManAccessoriesFragment();
                        titleFragment = "Принадлежности";
                    }
                }
                if (i == 1){
                    if (i1 == 0){
                        fragment = new WomanApparelsFragment();
                        titleFragment = "Одежда";
                    }
                    if (i1 == 1){
                        fragment = new WomanFootwearFragment();
                        titleFragment = "Обувь";
                    }
                    if (i1 == 2){
                        fragment = new WomanAccessoriesFragment();
                        titleFragment = "Принадлежности";
                    }
                }
                if (i == 2){
                    if (i1 == 0){
                        fragment = new KidsApparelsFragment();
                        titleFragment = "Одежда";
                    }
                    if (i1 == 1){
                        fragment = new KidsFootwearFragment();
                        titleFragment = "Обувь";
                    }
                    if (i1 == 2){
                        fragment = new KidsAccessoriesFragment();
                        titleFragment = "Принадлежности";
                    }
                }
                if (i == 3){
                    if (i1 == 0){
                        fragment = new FootballFragment();
                        titleFragment = "Футбол";
                    }
                    if (i1 == 1){
                        fragment = new BasketballFragment();
                        titleFragment = "Баскетбол";
                    }
                    if (i1 == 2){
                        fragment = new TennisFragment();
                        titleFragment = "Теннис";
                    }
                    if (i1 == 3){
                        fragment = new FitnessFragment();
                        titleFragment = "Фитнес";
                    }
                    if (i1 == 4){
                        fragment = new RunningFragment();
                        titleFragment = "Бег";
                    }
                }
                setFragment(fragment);
                setActionBarTitle(titleFragment);
                return false;
            }
        });
        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                Log.d("DEBUG", "heading clicked");
                return false;
            }
        });

    }

    private void prepareListData() {
        listDataHeader = new ArrayList<ExpandedMenuModel>();
        listDataChild = new HashMap<ExpandedMenuModel, List<String>>();

        ExpandedMenuModel item1 = new ExpandedMenuModel();
        item1.setIconName("Мужской");
        item1.setIconImg(R.drawable.ic_accessibility_green_600_24dp);
        // Adding data header
        listDataHeader.add(item1);

        ExpandedMenuModel item2 = new ExpandedMenuModel();
        item2.setIconName("Женский");
        item2.setIconImg(R.drawable.ic_pregnant_woman_red_400_24dp);
        listDataHeader.add(item2);

        ExpandedMenuModel item3 = new ExpandedMenuModel();
        item3.setIconName("Детский");
        item3.setIconImg(R.drawable.ic_child_friendly_teal_a400_24dp);
        listDataHeader.add(item3);

        ExpandedMenuModel item4 = new ExpandedMenuModel();
        item4.setIconName("Спорт");
        item4.setIconImg(R.drawable.ic_tag_faces_yellow_900_24dp);
        listDataHeader.add(item4);

        // Adding child data
        List<String> heading1 = new ArrayList<String>();
        heading1.add("Одежда");
        heading1.add("Обувь");
        heading1.add("Принадлежности");

        List<String> heading2 = new ArrayList<String>();
        heading2.add("Одежда");
        heading2.add("Обувь");
        heading2.add("Принадлежности");

        List<String> heading3 = new ArrayList<String>();
        heading3.add("Одежда");
        heading3.add("Обувь");
        heading3.add("Принадлежности");

        List<String> heading4 = new ArrayList<String>();
        heading4.add("Футбол");
        heading4.add("Баскетбол");
        heading4.add("Теннис");
        heading4.add("Фитнес");
        heading4.add("Бег");

        listDataChild.put(listDataHeader.get(0), heading1);// Header, Child data
        listDataChild.put(listDataHeader.get(1), heading2);
        listDataChild.put(listDataHeader.get(2), heading3);
        listDataChild.put(listDataHeader.get(3), heading4);

    }

    private void setupDrawerContent(Toolbar toolbar) {
        drawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };

        mDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_home:
                fragment = new HomeFragment();
                break;
        }
        setFragment(fragment);
        setActionBarTitle("Главная");
    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        mDrawerLayout.closeDrawer(navigationView);
    }

    public void setActionBarTitle(String item) {
        String title = item;
        getSupportActionBar().setTitle(title);
    }
}
