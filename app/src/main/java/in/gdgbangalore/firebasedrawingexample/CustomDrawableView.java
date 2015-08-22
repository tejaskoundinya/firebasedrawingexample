package in.gdgbangalore.firebasedrawingexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by tejas on 22/8/15.
 */
public class CustomDrawableView extends View {
    private ShapeDrawable mDrawable;

    Canvas canvas;

    public int x;
    public int y;

    public CustomDrawableView(Context context, AttributeSet attrs) {
        super(context, attrs);

        x = 20;
        y = 20;

        int width = 20;
        int height = 20;

        mDrawable = new ShapeDrawable(new OvalShape());
        mDrawable.getPaint().setColor(0xff74AC23);
        mDrawable.setBounds(x, y, x + width, y + height);
    }

    protected void onDraw(Canvas canvas) {
        this.canvas = canvas;
        mDrawable.draw(canvas);
    }

}