package nl.roelvandun.setgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.AbsListView;

public class CardView extends View {

    private static final Paint sBackgroundPaint;
    private static final Paint sBluePaint;
    private static final Paint sRedPaint;
    private static final Paint sGreenPaint;

//    private final Paint paint;
    private final CardValue cardValue;
    private AbsListView.LayoutParams params = null;

    static {
        sRedPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        sRedPaint.setColor(Color.RED);
        sRedPaint.setStyle(Paint.Style.STROKE);

        sBluePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        sBluePaint.setColor(Color.BLUE);
        sBluePaint.setStyle(Paint.Style.FILL);

        sGreenPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        sGreenPaint.setColor(Color.GREEN);
        sGreenPaint.setStyle(Paint.Style.FILL);

        sBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        sBackgroundPaint.setColor(Color.BLUE);
        sBackgroundPaint.setStyle(Paint.Style.FILL);
    }

    public CardView(Context context, CardValue cardValue) {
        super(context);
        this.cardValue = cardValue;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(0, 0, getWidth(), getHeight(), sBackgroundPaint);

        switch (cardValue.color) {
            case CardValue.COLOR_GREEN:
                break;
            case CardValue.COLOR_BLUE:
                break;
            case CardValue.COLOR_RED:
                break;
        }
        canvas.drawOval(0, 0, getWidth(), getHeight(), sRedPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(parentWidth, parentHeight);
        if (params == null) {
            double h = parentWidth * 1.1;
            int height = (int) h;
            params = new AbsListView.LayoutParams(parentWidth, height);
        }
        this.setLayoutParams(params);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
