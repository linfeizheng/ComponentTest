package com.huored.common_module.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

public class AnimationUtil {

    private static final OvershootInterpolator OVERSHOOT_INTERPOLATOR = new OvershootInterpolator(4);

    public static void scaleAnim(View view, float ratio) {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, ImageView.SCALE_X, ratio, 1f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, ImageView.SCALE_Y, ratio, 1f);
        animator1.setDuration(500);
        animator2.setDuration(500);
        animator1.setInterpolator(OVERSHOOT_INTERPOLATOR);
        animator2.setInterpolator(OVERSHOOT_INTERPOLATOR);
        AnimatorSet set = new AnimatorSet();
        set.play(animator1).with(animator2);
        set.start();
    }

}
