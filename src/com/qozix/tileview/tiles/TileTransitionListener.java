package com.qozix.tileview.tiles;

import java.lang.ref.WeakReference;

import android.os.Handler;
import android.view.animation.Animation;


public class TileTransitionListener implements Animation.AnimationListener {

    private WeakReference<TileManager> reference;

    public TileTransitionListener( TileManager tm ) {
        reference = new WeakReference<TileManager>( tm );
    }

    @Override
    public void onAnimationStart( Animation animation ) {

    }

    @Override
    public void onAnimationRepeat( Animation animation ) {

    }

    @Override
    public void onAnimationEnd( Animation animation ) {
        new Handler().post(new Runnable() {
            public void run() {
                TileManager tileManager = reference.get();
                if( tileManager != null) {
                    // why both?  no clue...  omit either one and abuse it,  you'll get incomplete draws...
                    tileManager.invalidate();
                    tileManager.postInvalidate();
                }
            }
        });
    }

}
