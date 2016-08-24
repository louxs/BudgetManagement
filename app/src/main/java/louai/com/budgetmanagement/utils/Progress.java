package louai.com.budgetmanagement.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/**
 * Created by louai on 21/08/2016.
 */
public class Progress extends ProgressBar {
        private String text;
        private Paint textPaint;

        public Progress(Context context) {
            super(context);
            text = "0%";
            textPaint = new Paint();
            textPaint.setColor(Color.BLACK);
        }

        public Progress(Context context, AttributeSet attrs) {
            super(context, attrs);
            text = "0%";
            textPaint = new Paint();
            textPaint.setColor(Color.BLACK);
        }

        public Progress(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            text = "0%";
            textPaint = new Paint();
            textPaint.setColor(Color.BLACK);
        }

        @Override
        protected synchronized void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Rect bounds = new Rect();
            textPaint.getTextBounds(text, 0, text.length(), bounds);
            int x = getWidth() / 2 - bounds.centerX();
            int y = getHeight() / 2 - bounds.centerY();
            canvas.drawText(text, x, y, textPaint);
        }

        public synchronized void setText(String text) {
            this.text = text;
            drawableStateChanged();
        }

        public void setTextColor(int color) {
            textPaint.setColor(color);
            drawableStateChanged();
        }
    }
