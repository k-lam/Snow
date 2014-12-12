package klam.snow;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by Administrator on 2014/12/12.
 */
public class AnimatorCollection {

    static class FloatDown{
        static ObjectAnimator get(View view,float distance){
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view,"y",view.getY(),distance + view.getY());
            objectAnimator.setInterpolator(new LinearInterpolator());
            objectAnimator.setDuration(5000);
            return  objectAnimator;
        }

        static ObjectAnimator get(View view,float distance,int duration){
            return  get(view,distance).setDuration(duration);
        }

        static void restore(SnowView view){
            view.mGenerator.setPosition(view);
        }
    }

}
