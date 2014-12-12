package klam.snow;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.FrameLayout;


public class MainActivity extends Activity {
    FrameLayout layout;
    SnowGenerator generator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (FrameLayout) findViewById(R.id.ly);
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        generator = new SnowGenerator(this,new Rect(0,0,width, height /  2),30,10,layout);
        generator.distance = height;
        generator.generate();
        generator.jet();
    }
}
