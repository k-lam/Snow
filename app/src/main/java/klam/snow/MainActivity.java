package klam.snow;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.widget.FrameLayout;


public class MainActivity extends Activity {
    FrameLayout layout;
    SnowGenerator generator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (FrameLayout) findViewById(R.id.ly);
        final int width = getResources().getDisplayMetrics().widthPixels;
        final int height = getResources().getDisplayMetrics().heightPixels;
//        generator = new SnowGenerator(this,new Rect(50,-100,width - 100, height /  2),30,10,layout);
//        generator.distance = height;
//        generator.generate();
//        generator.jet();
        int count = 15;
        while(count-- > 0) {
            SnowView2 view = new SnowView2(this, new Rect(50, 20, width - 50, height / 5 * 2), height -50, width);
            layout.addView(view);
            view.loopAnim();
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int count = 5;
                while(count-- > 0) {
                    SnowView2 view = new SnowView2(MainActivity.this, new Rect(100, 100, width - 100, height / 2), height, width);
                    layout.addView(view);
                    view.loopAnim();
                }
            }
        }, 5000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int count = 5;
                while(count-- > 0) {
                    SnowView2 view = new SnowView2(MainActivity.this, new Rect(100, 100, width - 100, height / 2), height, width);
                    layout.addView(view);
                    view.loopAnim();
                }
            }
        }, 8000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int count = 5;
                while(count-- > 0) {
                    SnowView2 view = new SnowView2(MainActivity.this, new Rect(100, 100, width - 100, height / 2), height, width);
                    layout.addView(view);
                    view.loopAnim();
                }
            }
        }, 11000);

    }
}
