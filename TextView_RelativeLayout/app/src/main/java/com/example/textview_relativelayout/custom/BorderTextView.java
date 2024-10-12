package com.example.textview_relativelayout.custom;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;



public class BorderTextView extends androidx.appcompat.widget.AppCompatTextView{

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int sroke_width=1;
        Paint paint = new Paint();
        paint.setStrokeWidth(58);
        paint.setColor(Color.GREEN);
        canvas.drawLine(0,0,this.getWidth()-sroke_width,0,paint);


    }

    public BorderTextView(Context context) {
        super(context);
    }

    public BorderTextView( Context context,  AttributeSet attrs) {
        super(context, attrs);
    }
}
