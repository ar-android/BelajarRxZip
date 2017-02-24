package com.ahmadrosid.belajarrxzip.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ahmadrosid.belajarrxzip.R;
import com.ahmadrosid.belajarrxzip.api.Api;
import com.ahmadrosid.belajarrxzip.model.InfoGempa;

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

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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

    }

    private void displayError() {

    }

    @Override protected void onStop() {
        super.onStop();
        subscription.unsubscribe();
    }
}
