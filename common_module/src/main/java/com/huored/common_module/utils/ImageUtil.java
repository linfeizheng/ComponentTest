package com.huored.common_module.utils;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by danao on 2018/6/14.
 */
public class ImageUtil {

    public static void loadImg(String url, SimpleDraweeView imageView) {
        imageView.setImageURI(url);
    }

}
