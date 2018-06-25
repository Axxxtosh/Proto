package com.uriah.mmvm.bookmyticket;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MyBookingsFragmentLogin extends Fragment {



    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.sliding_tabs)
    TabLayout tabs;
    private HashMap<String, Integer> url_maps;
    @BindView(R.id.slider1)
    SliderLayout mDemoSlider1;

    private OngoingAdapter ongoingAdapter;

    @BindView(R.id.rv_ongoing)
    RecyclerView rv_ongoing;




    public static MyBookingsFragmentLogin newInstance() {
        return new MyBookingsFragmentLogin();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.my_bookings_fragment_login_fragment,container, false);

        ButterKnife.bind(this,view);
        setSlider();


        viewPager.setCurrentItem(2);
        // Setting ViewPager for each Tabs
        setupViewPager(viewPager);

        // Set Tabs inside Toolbar
        tabs.setupWithViewPager(viewPager);

        ongoingAdapter=new OngoingAdapter(getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rv_ongoing.setLayoutManager(mLayoutManager);

        rv_ongoing.setAdapter(ongoingAdapter);
        return view;
        }

    @Override
    public void onResume() {
        super.onResume();


    }
    private void setSlider() {
        url_maps= new HashMap<String, Integer>();
        url_maps.put("1",R.drawable.slide1);
        url_maps.put("2",R.drawable.slide3);
        url_maps.put("3",R.drawable.slide1);


        mDemoSlider1.removeAllSliders();

        for(String name : url_maps.keySet()){
            BaseSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);


            //add your extra information

            /*textSliderView.getBundle()
                    .putString("extra",name);*/

            mDemoSlider1.addSlider(textSliderView);



        }

        mDemoSlider1.startAutoCycle();

    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(NowShowing.newInstance(), "NOW SHOWING");
        adapter.addFragment(NowShowing.newInstance(), "COMING SOON");

        viewPager.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel
    }



}
