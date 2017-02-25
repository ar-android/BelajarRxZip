package com.ahmadrosid.belajarrxzip.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmadrosid.belajarrxzip.R;
import com.ahmadrosid.belajarrxzip.api.response.GempaDirasakan;
import com.ahmadrosid.belajarrxzip.api.response.GempaTerkini;
import com.ahmadrosid.belajarrxzip.core.adapter.RecyclerAdapter;

/**
 * Created by ocittwo on 2/25/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */
public class FragmentGempa extends Fragment {
    RecyclerView list;

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment, container, false);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = (RecyclerView) view.findViewById(R.id.list);
    }

    public void setGempaTerkini(GempaTerkini data) {
        RecyclerAdapter<GempaTerkini.DataBean, HolderGempaTerkini> adapter
                = new RecyclerAdapter<GempaTerkini.DataBean, HolderGempaTerkini>(data.getData(), GempaTerkini.DataBean.class,
        R.layout.item_gempa_terkini, HolderGempaTerkini.class) {
            @Override protected void bindView(HolderGempaTerkini holder, GempaTerkini.DataBean model, int position) {
                holder.bind(model);
            }
        };

        setAdapterList(adapter);
    }

    public void setGempaDirasakan(GempaDirasakan data) {
        RecyclerAdapter<GempaDirasakan.DataBean, HolderGempaDirasakan> adapter
                = new RecyclerAdapter<GempaDirasakan.DataBean, HolderGempaDirasakan>(data.getData(), GempaDirasakan.DataBean.class,
        R.layout.item_gempa_terkini, HolderGempaDirasakan.class) {
            @Override protected void bindView(HolderGempaDirasakan holder, GempaDirasakan.DataBean model, int position) {
                holder.bind(model);
            }
        };

        setAdapterList(adapter);
    }

    public void setAdapterList(RecyclerAdapter adapterList) {
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(adapterList);
    }
}
