package klam.snow;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by K.Lam on 2014/12/11.
 */
public class SnowView extends View {

    AnimatorSet animatorSet;
    SnowGenerator mGenerator;
    public SnowView(Context context) {
        super(context);
    }

    public SnowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SnowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    public SnowView(Context context,int rId,float x,float y,SnowGenerator generator){
//        this(context);
//        setBitmap(rId);
//        setX(x);
//        setY(y);
//        this.mGenerator = generator;
//    }

    public SnowView(Context context,int rId,SnowGenerator generator){
        this(context);
        this.mGenerator = generator;
        setBitmap(rId);

    }
    Bitmap bitmap;
    int mRid;
    void setBitmap(int rId){
        this.mRid = rId;
        bitmap = BitmapFactory.decodeResource(getResources(),mRid);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(bitmap.getWidth(),bitmap.getHeight());
        setLayoutParams(layoutParams);
    }

    Paint paint = new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap,0,0,paint);
        //Log.i("snow1","bitmap size:" + bitmap.getWidth() + "," + bitmap.getHeight());
    }

    public void start(int delay){
        if(animatorSet == null){
            animatorSet = new AnimatorSet();
            //animatorSet.setDuration(5000);
            animatorSet.play(AnimatorCollection.FloatDown.get(this,mGenerator.distance - this.getY() + SnowGenerator.random(-200,200),5000));
            animatorSet.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    mGenerator.mLayout.addView(SnowView.this);
                    //Log.i("snow1","hw:" + SnowView.this.getWidth() + "," + SnowView.this.getHeight());
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    mGenerator.queue_floating.remove(SnowView.this);
                    mGenerator.queue_ready.add(SnowView.this);
                    mGenerator.mLayout.removeView(SnowView.this);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }
        AnimatorCollection.FloatDown.restore(this);
        animatorSet.setStartDelay(delay);
        animatorSet.start();
        setVisibility(VISIBLE);
    }



    /**
     * 融化
     */
    public void melt(){
        animatorSet.cancel();
        setVisibility(GONE);
    }
}
