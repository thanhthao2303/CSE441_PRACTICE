package com.example.ex24;

import android.graphics.Bitmap;

public class TyGia {
    private String type;
    private Bitmap bitmap;
    private String muatm;
    private String bantm;

    public TyGia(String type, String muatm, String bantm) {
        this.type = type;
        this.bitmap = bitmap;
        this.muatm = muatm;
        this.bantm = bantm;
    }

    public String getType() {
        return type;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public String getMuatm() {
        return muatm;
    }

    public String getBantm() {
        return bantm;
    }
}

