package me.sofiworker.easemusic.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/1 20:37
 * @description recycler view侧边栏
 */
public class SideBar extends View {

    /**
     * 索引字母颜色
     */
    private static final int LETTER_COLOR = 0xFF2E8BE6;

    /**
     * 索引字母数组
     */
    public String[] letters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K","L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};

    /**
     * 控件的宽高
     */
    private int mWidth;
    private int mHeight;

    /**
     * 单元格的高度
     */
    private float mCellHeight;

    /**
     * 顶部间距
     */
    private float mMarginTop;

    private Paint mPaint;

    public SideBar(Context context) {
        super(context);
        init();
    }

    public SideBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(LETTER_COLOR);
        mPaint.setTextSize(30);
        // 去掉锯齿，让字体边缘变得平滑
        mPaint.setAntiAlias(true);
        mMarginTop = (mHeight - mCellHeight * letters.length) / 2;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //字母的坐标点：(x,y)
        if (letters.length <= 0) {
            return;
        }
        for (int i = 0; i < letters.length; i++) {
            String letter = letters[i];
            float x = ((float) mWidth / 2) - getTextWidth(letter) / 2;
            float y = mCellHeight / 2 + getTextHeight(letter) / 2 + mCellHeight * i + mMarginTop;
            canvas.drawText(letter, x, y, mPaint);
        }
    }

    /**
     * 获取字符的宽度
     *
     * @param text 需要测量的字母
     * @return 对应字母的高度
     */
    public float getTextWidth(String text) {
        Rect bounds = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), bounds);
        return bounds.width();
    }

    /**
     * 获取字符的高度
     *
     * @param text 需要测量的字母
     * @return 对应字母的高度
     */
    public float getTextHeight(String text) {
        Rect bounds = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), bounds);
        return bounds.height();
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldWidth, int oldHeight) {
        super.onSizeChanged(w, h, oldWidth, oldHeight);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        //26个字母加上“#”
        mCellHeight = (mHeight * 1f / 27);
        mMarginTop = (mHeight - mCellHeight * letters.length) / 2;
    }

    @Override
    @SuppressLint("ClickableViewAccessibility")
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                // 按下字母的下标
                int letterIndex = (int) ((event.getY() - mMarginTop) / mCellHeight);
                // 判断是否越界
                if (letterIndex >= 0 && letterIndex < letters.length) {
                    // 显示按下的字母
                    if (textView != null) {
                        textView.setVisibility(View.VISIBLE);
                        textView.setText(letters[letterIndex]);
                    }
                    //通过回调方法通知列表定位
                    if (mOnIndexChangedListener != null) {
                        mOnIndexChangedListener.onIndexChanged(letters[letterIndex]);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                if (textView != null) {
                    textView.setVisibility(View.GONE);
                }
                break;
                default:
                    break;
        }

        return true;
    }

    public interface OnIndexChangedListener {
        /**
         * 按下字母改变了
         *
         * @param index 按下的字母
         */
        void onIndexChanged(String index);
    }

    private OnIndexChangedListener mOnIndexChangedListener;

    private TextView textView;

    public void setOnIndexChangedListener(OnIndexChangedListener onIndexChangedListener) {
        this.mOnIndexChangedListener = onIndexChangedListener;
    }

    /**
     * 设置显示按下首字母的TextView
     */
    public void setSelectedIndexTextView(TextView textView) {
        this.textView = textView;
    }
}
