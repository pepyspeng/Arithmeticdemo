package com.arithmeticdemo;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


/**
 * Created by pepys on 2019/3/29
 * description:拍摄驾照遮罩
 */
public class CameraLicesenShade extends View {

    private Context mContext;
    /**
     * 遮罩颜色
     */
    private int mShadeColor;

    private Bitmap mShadeBitmap;

    private Bitmap mMaskBitmap;
    private Canvas mMaskCanvas;
    private Paint mMaskPaint;

    private Paint mTransparentPaint;
    private PorterDuffXfermode mPorterDuffXfermode;

    private Paint mSystemCanvasPaint;

    private int mScreenWidth;   // 屏幕的宽
    private int mScreenHeight;  // 屏幕的高
    private int borderlengthW;
    private int borderlengthH;
    private int startX;
    private int startY;

    public CameraLicesenShade(Context context) {
        this(context, null);
    }

    public CameraLicesenShade(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CameraLicesenShade(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
        initShade();
    }

    public void setmShadeColor(int mShadeColor) {
        this.mShadeColor = mShadeColor;
    }

    private void init() {
//        setWillNotDraw(false);

        if (mScreenWidth == 0) {
            DisplayMetrics dm = getResources().getDisplayMetrics();
            mScreenWidth = dm.widthPixels;
            mScreenHeight = dm.heightPixels;
        }


        mMaskPaint = new Paint();
        mMaskPaint.setColor(0xC8000000);

        mTransparentPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTransparentPaint.setColor(Color.TRANSPARENT);
        mPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        mTransparentPaint.setXfermode(mPorterDuffXfermode);

        mSystemCanvasPaint = new Paint();

    }

    public String TAG = "View";
    public String TAG1 = "dispatchTouchEvent--";
    public String TAG3 = "onTouchEvent--";

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, TAG1 + "ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, TAG1 + "ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, TAG1 + "ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, TAG1 + "ACTION_CANCEL");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, TAG3 + "ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, TAG3 + "ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, TAG3 + "ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, TAG3 + "ACTION_CANCEL");
                break;
        }
        return super.onTouchEvent(ev);
    }
    @Override
    protected void onDraw(Canvas systemCanvas) {
        super.onDraw(systemCanvas);
        // 绘制遮罩层
        if (mMaskBitmap == null) {
            mMaskBitmap = Bitmap.createBitmap(mScreenWidth, mScreenHeight, Bitmap.Config.ARGB_8888);
            mMaskCanvas = new Canvas(mMaskBitmap);
        }
        mMaskCanvas.drawRect(0, 0, mScreenWidth, startY, mMaskPaint);
        mMaskCanvas.drawRect(0, startY, startX, startY + borderlengthH, mMaskPaint);
        mMaskCanvas.drawRect(0, startY + borderlengthH, mScreenWidth, mScreenHeight, mMaskPaint);
        mMaskCanvas.drawRect(startX + borderlengthW, startY, mScreenWidth, startY + borderlengthH, mMaskPaint);
        // 在遮罩层上挖
        mMaskCanvas.drawBitmap(mShadeBitmap, startX, startY, null);
        systemCanvas.drawBitmap(mMaskBitmap, 0, 0, mSystemCanvasPaint);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void initShade() {

        if (mScreenWidth < mScreenHeight) {
            borderlengthW = mScreenWidth - dip2px(45) * 2;
            borderlengthH = (int) (borderlengthW * 16 / 9 * 0.9);
        } else {
            borderlengthH = mScreenHeight - dip2px(45) * 2;
            borderlengthW = (int) (borderlengthH * 16 / 9 * 0.9);
        }
        startX = (mScreenWidth - borderlengthW) / 2;
        startY = (mScreenHeight - borderlengthH) / 2;

        Log.e("clip", "height=" + mScreenHeight + ",width=" + mScreenWidth
                + ",borderlengthW=" + borderlengthW + ",borderlengthH=" + borderlengthH + ",startX=" + startX + ",startY=" + startY);

        mShadeBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.icon_camera_license_frame);

        // 计算缩放比例
        float scaleWidth = ((float) borderlengthW) / mShadeBitmap.getWidth();
        float scaleHeight = ((float) borderlengthH) / mShadeBitmap.getHeight();
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);

        Log.e("clip", "height=" + mScreenHeight + ",width=" + mScreenWidth
                + ",borderlengthW=" + borderlengthW + ",borderlengthH=" + borderlengthH + ",startX=" + startX + ",startY=" + startY
                + ",mShadeBitmapWidth=" + mShadeBitmap.getWidth() + ",mShadeBitmapHeight=" + mShadeBitmap.getHeight());


        // 得到新的图片
        mShadeBitmap = Bitmap.createBitmap(mShadeBitmap, 0, 0, mShadeBitmap.getWidth(), mShadeBitmap.getHeight(), matrix, true);
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dip2px(float dpValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
