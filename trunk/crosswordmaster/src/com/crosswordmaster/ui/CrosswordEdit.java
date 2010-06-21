package com.crosswordmaster.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

import com.crosswordmaster.R;

public class CrosswordEdit extends EditText {
	
	private Paint mCrosswordEditPaint;
	private String mCrosswordChar;
	private int mAscent;
	
	
	/*
	 * Konstruktor. Potrebny len ak vytvarame komponentu programovo.
	 * 
	 * @param context
	 */
	public CrosswordEdit(Context context) {
		super(context);
		initCrosswordEdit();
	}
	
	
	/*
	 * Konstruktor. Potrebny ak vytvarame komponentu cez XML layout.
	 * 
	 * @param context
	 * @param attrs
	 */
	public CrosswordEdit(Context context, AttributeSet attrs) {
		super(context, attrs);
		initCrosswordEdit();
		
		TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.CrosswordEdit);

        CharSequence s = a.getString(R.styleable.CrosswordEdit_text);
        if (s != null) {
            setText(s.toString());
        }

        // Retrieve the color(s) to be used for this view and apply them.
        // Note, if you only care about supporting a single color, that you
        // can instead call a.getColor() and pass that to setTextColor().
        setTextColor(a.getColor(R.styleable.CrosswordEdit_textColor, 0xFFFF0000));

        int textSize = a.getDimensionPixelOffset(R.styleable.CrosswordEdit_textSize, 0);
        if (textSize > 0) {
            setTextSize(textSize);
        }

        a.recycle();
	}
	
	
	/*
	 * Inicializujeme canvas pre nasledne vykreslovanie komponenty.
	 */
	private final void initCrosswordEdit() {
		mCrosswordEditPaint = new Paint();
		mCrosswordEditPaint.setAntiAlias(true);
		mCrosswordEditPaint.setTextSize(16);
		mCrosswordEditPaint.setColor(0xFF000000);
		setPadding(0, 0, 0, 0);
	}
	
	
	public void setText(String text) {
		mCrosswordChar = text;
		requestLayout();
		invalidate();
	}
	
	
	public void setTextSize(int size) {
		mCrosswordEditPaint.setTextSize(size);
		requestLayout();
		invalidate();
	}
	
	
	public void setTextColor(int color) {
		mCrosswordEditPaint.setColor(color);
		invalidate();
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
            result = (int) mCrosswordEditPaint.measureText(mCrosswordChar) + getPaddingLeft()
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

        mAscent = (int) mCrosswordEditPaint.ascent();
        if (specMode == MeasureSpec.EXACTLY) {
            // We were told how big to be
            result = specSize;
        } else {
            // Measure the text (beware: ascent is a negative number)
            result = (int) (-mAscent + mCrosswordEditPaint.descent()) + getPaddingTop()
                    + getPaddingBottom();
            if (specMode == MeasureSpec.AT_MOST) {
                // Respect AT_MOST value if that was what is called for by measureSpec
                result = Math.min(result, specSize);
            }
        }
        return result;
    }
    
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(getPaddingLeft(), getPaddingTop() - mAscent, getPaddingRight() + 50, getPaddingBottom() + 20, mCrosswordEditPaint);
        canvas.drawText(mCrosswordChar, getPaddingLeft(), getPaddingTop() - mAscent, mCrosswordEditPaint);
    }
}
