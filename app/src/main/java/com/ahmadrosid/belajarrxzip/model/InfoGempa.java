package com.ahmadrosid.belajarrxzip.model;

import com.ahmadrosid.belajarrxzip.api.response.GempaDirasakan;
import com.ahmadrosid.belajarrxzip.api.response.GempaTerkini;

/**
 * Created by ocittwo on 2/25/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */
public class InfoGempa {

    public GempaTerkini gempaTerkini;
    public GempaDirasakan gempaDirasakan;

    public GempaTerkini getGempaTerkini() {
        return gempaTerkini;
    }

    public void setGempaTerkini(GempaTerkini gempaTerkini) {
        this.gempaTerkini = gempaTerkini;
    }

    public GempaDirasakan getGempaDirasakan() {
        return gempaDirasakan;
    }

    public void setGempaDirasakan(GempaDirasakan gempaDirasakan) {
        this.gempaDirasakan = gempaDirasakan;
    }
}
