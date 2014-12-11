package klam.snow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by K.Lam on 2014/12/11.
 */
public class SnowView extends View {
    public SnowView(Context context) {
        super(context);
    }

    public SnowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SnowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SnowView(Context context,int rId,float x,float y){
        this(context);
        setBitmap(rId);
        setTranslationX(x);
        setTranslationY(y);
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
    }
}
