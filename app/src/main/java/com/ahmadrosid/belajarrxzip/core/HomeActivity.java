package com.ahmadrosid.belajarrxzip.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ahmadrosid.belajarrxzip.R;
import com.ahmadrosid.belajarrxzip.api.Api;
import com.ahmadrosid.belajarrxzip.core.adapter.AdapterInfoGempa;
import com.ahmadrosid.belajarrxzip.model.InfoGempa;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ocittwo on 2/25/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */

public class HomeActivity extends AppCompatActivity{

    private Subscription subscription = new CompositeSubscription();

    private TabLayout tab_info;
    private ViewPager content_info;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tab_info = (TabLayout) findViewById(R.id.tab_info);
        content_info = (ViewPager) findViewById(R.id.content_info);

        subscription = Api.getInfoGempa()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InfoGempa>() {
                    @Override public void onCompleted() {

                    }

                    @Override public void onError(Throwable e) {
                        e.printStackTrace();
                        displayError();
                    }

                    @Override public void onNext(InfoGempa infoGempa) {
                        displayInfo(infoGempa);
                    }
                });
    }

    private void displayInfo(InfoGempa infoGempa) {
        FragmentGempa terkini = new FragmentGempa();
        terkini.setGempaTerkini(infoGempa.getGempaTerkini());
        FragmentGempa dirasakan = new FragmentGempa();
        dirasakan.setGempaDirasakan(infoGempa.getGempaDirasakan());
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(terkini);
        fragments.add(dirasakan);

        AdapterInfoGempa adapterInfoGempa = new AdapterInfoGempa(getSupportFragmentManager(), fragments);
        content_info.setAdapter(adapterInfoGempa);
        tab_info.setupWithViewPager(content_info);
    }

    private void displayError() {

    }

    @Override protected void onStop() {
        super.onStop();
        subscription.unsubscribe();
    }
}
