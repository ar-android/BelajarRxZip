package com.ahmadrosid.belajarrxzip.api.response;

import java.util.List;

/**
 * Created by ocittwo on 2/25/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */
public class GempaTerkini {

    private String status;
    private String view;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String waktu;
        private String lintang_bujur;
        private String magnitudo;
        private String kedalaman;
        private String wilayah;
        private String img;

        public String getWaktu() {
            return waktu;
        }

        public void setWaktu(String waktu) {
            this.waktu = waktu;
        }

        public String getLintang_bujur() {
            return lintang_bujur;
        }

        public void setLintang_bujur(String lintang_bujur) {
            this.lintang_bujur = lintang_bujur;
        }

        public String getMagnitudo() {
            return magnitudo;
        }

        public void setMagnitudo(String magnitudo) {
            this.magnitudo = magnitudo;
        }

        public String getKedalaman() {
            return kedalaman;
        }

        public void setKedalaman(String kedalaman) {
            this.kedalaman = kedalaman;
        }

        public String getWilayah() {
            return wilayah;
        }

        public void setWilayah(String wilayah) {
            this.wilayah = wilayah;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }
}
