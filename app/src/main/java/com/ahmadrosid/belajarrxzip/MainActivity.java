package com.ahmadrosid.belajarrxzip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.functions.Func3;

public class MainActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);

        getHelloWorldInteger().subscribe(new Action1<Integer>() {
            @Override public void call(Integer s) {
                text.setText("" + s);
            }
        });
    }

    public Observable<String> getHello() {
        return Observable.just("Hello ");
    }

    public Observable<String> getWorld() {
        return Observable.just("World");
    }

    public Observable<Integer> getHelloWorldInteger() {
        return Observable.zip(getHello(), getWorld(), new Func2<String, String, Integer>() {
            @Override public Integer call(String s, String s2) {
                return s.length() + s2.length();
            }
        });
    }

    public Observable<String> getHelloWorldString() {
        return Observable.zip(getHello(), getWorld(), new Func2<String, String, String>() {
            @Override public String call(String s, String s2) {
                return s + s2;
            }
        });
    }

    public Observable<String> getHelloWorldMore() {
        return Observable.zip(getHello(), getWorld(), getHelloWorldInteger(),
                new Func3<String, String, Integer, String>() {
                    @Override
                    public String call(String v1, String v2, Integer v3) {
                        return v1 + v2 + v3;
                    }
                });
    }
}
