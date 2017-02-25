package com.ahmadrosid.belajarrxzip.core;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ahmadrosid.belajarrxzip.R;
import com.ahmadrosid.belajarrxzip.api.response.GempaTerkini;

/**
 * Created by ocittwo on 2/25/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */
public class HolderGempaTerkini extends RecyclerView.ViewHolder{

    private TextView waktu;
    private TextView wilayah;

    public HolderGempaTerkini(View itemView) {
        super(itemView);
        waktu = (TextView) itemView.findViewById(R.id.waktu);
        wilayah = (TextView) itemView.findViewById(R.id.wilayah);
    }


    public void bind(GempaTerkini.DataBean model) {
        waktu.setText(model.getWaktu());
        wilayah.setText(model.getWilayah());
    }
}
