package louai.com.budgetmanagement.utils;

/**
 * Created by louai on 21/08/2016.
 */

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ProgressBar;

import louai.com.budgetmanagement.R;

public class TextProgressBar
        extends ProgressBar
{
    private String a = "HP";
    private Paint b = new Paint();

    public TextProgressBar(Context paramContext)
    {
        super(paramContext);
        this.b.setColor(getResources().getColor(R.color.amber));
    }

    public TextProgressBar(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
        this.b.setColor(getResources().getColor(R.color.amber));
    }

    public TextProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
        this.b.setColor(getResources().getColor(R.color.amber));
    }

    protected void onDraw(Canvas paramCanvas)
    {
        try
        {
            super.onDraw(paramCanvas);
            Rect localRect = new Rect();
            this.b.getTextBounds(this.a, 0, this.a.length(), localRect);
            int i = getWidth() / 2;
            int j = localRect.centerX();
            int k = getHeight() / 2;
            int m = localRect.centerY();
            paramCanvas.drawText(this.a, i - j, k - m, this.b);
            return;
        }
        finally
        {

        }
    }

    public void setText(String paramString)
    {
        try
        {
            this.a = paramString;
            drawableStateChanged();
            return;
        }
        finally
        {

        }
    }

    public void setTextColor(int paramInt)
    {
        this.b.setColor(paramInt);
        this.b.setTypeface(Typeface.DEFAULT_BOLD);
        this.b.setFlags(1);
        float f = getResources().getDisplayMetrics().density;
        this.b.setTextSize(f * 14.0F);
        drawableStateChanged();
    }
}