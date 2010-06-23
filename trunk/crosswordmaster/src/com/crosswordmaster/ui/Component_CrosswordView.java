package com.crosswordmaster.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class Component_CrosswordView extends View {

	private int columns = 0;
	private int rows = 0;
	
	private Paint mCrosswordPaint;
	private String mCrosswordChar;
	private int mAscent;
	
	
	public Component_CrosswordView(Context context) {
		super(context);
		initCrosswordView();
	}
	
	
	public Component_CrosswordView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initCrosswordView();
	}
	
	
	private void initCrosswordView() {
		Paint mCrosswordPaint = new Paint();
		mCrosswordPaint.setColor(0xFFFFFFFF);
		mCrosswordPaint.setAntiAlias(true);
		mCrosswordPaint.setTextSize(16);
		setPadding(0,0,0,0);
	}
	
	public void setDimensions(int columns, int rows) {
		this.columns = columns;
		this.rows	= rows;
		invalidate();
	}
	
	@Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0, 0, 50, 50, mCrosswordPaint);
    }
	
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(
        		measureWidth(widthMeasureSpec),
                measureHeight(heightMeasureSpec)
        );
    }
	
	
	private int measureWidth(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            // We were told how big to be
            result = specSize;
        } else {
            // Measure the text
            result = (int) mCrosswordPaint.measureText(mCrosswordChar) + getPaddingLeft()
                    + getPaddingRight();
            if (specMode == MeasureSpec.AT_MOST) {
                // Respect AT_MOST value if that was what is called for by measureSpec
                result = Math.min(result, specSize);
            }
        }

        return result;
    }

    /**
     * Determines the height of this view
     * @param measureSpec A measureSpec packed into an int
     * @return The height of the view, honoring constraints from measureSpec
     */
    private int measureHeight(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        mAscent = (int) mCrosswordPaint.ascent();
        if (specMode == MeasureSpec.EXACTLY) {
            // We were told how big to be
            result = specSize;
        } else {
            // Measure the text (beware: ascent is a negative number)
            result = (int) (-mAscent + mCrosswordPaint.descent()) + getPaddingTop()
                    + getPaddingBottom();
            if (specMode == MeasureSpec.AT_MOST) {
                // Respect AT_MOST value if that was what is called for by measureSpec
                result = Math.min(result, specSize);
            }
        }
        return result;
    }
	
}
