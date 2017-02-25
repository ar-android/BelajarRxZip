package com.ahmadrosid.belajarrxzip.api;

import android.util.Log;

import com.ahmadrosid.belajarrxzip.api.response.GempaDirasakan;
import com.ahmadrosid.belajarrxzip.api.response.GempaTerkini;
import com.ahmadrosid.belajarrxzip.model.InfoGempa;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func2;

/**
 * Created by ocittwo on 2/25/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */
public class Api {
    private static final String TAG = "Api";

    static final OkHttpClient client = new OkHttpClient();

    static final String SCREET_KEY = "fd485a63d0af80d6b914892b4edeca01";
    static final String MAIN_URL = "http://ibacor.com/api/";
    static final String GEMPA_TERKINI = MAIN_URL + "bmkg?view=gempa-terkini&k=" + SCREET_KEY;
    static final String GEMPA_DIRASAKAN = MAIN_URL + "bmkg?view=gempa-dirasakan&k=" + SCREET_KEY;

    public static Observable<InfoGempa> getInfoGempa() {
        return Observable.zip(gempaTerkiniObservable(), gempaDirasakanObservable(), new Func2<GempaTerkini, GempaDirasakan, InfoGempa>() {
            @Override public InfoGempa call(GempaTerkini gempaTerkini, GempaDirasakan gempaDirasakan) {
                InfoGempa data = new InfoGempa();
                data.setGempaDirasakan(gempaDirasakan);
                data.setGempaTerkini(gempaTerkini);
                return data;
            }
        });
    }

    static Observable<GempaTerkini> gempaTerkiniObservable() {
        return Observable.create(new Observable.OnSubscribe<GempaTerkini>() {
            @Override public void call(final Subscriber<? super GempaTerkini> subscriber) {
                Request request = new Request.Builder()
                        .url(GEMPA_TERKINI)
                        .get()
                        .build();
                streamStrings(request).subscribe(new Action1<String>() {
                    @Override public void call(String s) {
                        GempaTerkini data = new Gson().fromJson(s, GempaTerkini.class);
                        subscriber.onNext(data);
                    }
                }, new Action1<Throwable>() {
                    @Override public void call(Throwable throwable) {
                        subscriber.onError(throwable);
                    }
                });
            }
        });
    }

    static Observable<GempaDirasakan> gempaDirasakanObservable() {
        return Observable.create(new Observable.OnSubscribe<GempaDirasakan>() {
            @Override public void call(final Subscriber<? super GempaDirasakan> subscriber) {
                Request request = new Request.Builder()
                        .url(GEMPA_DIRASAKAN)
                        .get()
                        .build();
                streamStrings(request).subscribe(new Action1<String>() {
                    @Override public void call(String s) {
                        GempaDirasakan data = new Gson().fromJson(s, GempaDirasakan.class);
                        subscriber.onNext(data);
                    }
                }, new Action1<Throwable>() {
                    @Override public void call(Throwable throwable) {
                        subscriber.onError(throwable);
                    }
                });
            }
        });
    }

    static Observable<String> streamStrings(final Request request) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override public void call(final Subscriber<? super String> subscriber) {
                client.newCall(request).enqueue(new Callback() {
                    @Override public void onFailure(Call call, IOException e) {
                        subscriber.onError(e);
                    }

                    @Override public void onResponse(Call call, Response response) throws IOException {
                        subscriber.onNext(response.body().string());
                    }
                });
            }
        });
    }
}
