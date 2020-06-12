package com.liqian.recyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyDecoration extends RecyclerView.ItemDecoration {
   // private int mSpanCount;

    private int mItemSize = 1;

    private Paint mPaint;

    public MyDecoration(Context context){
        mItemSize = (int) TypedValue.applyDimension(mItemSize, TypedValue.COMPLEX_UNIT_DIP,context.getResources().getDisplayMetrics());
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG) ;
        mPaint.setColor(Color.BLUE);
        /*设置填充*/
        mPaint.setStyle(Paint.Style.FILL);

    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
            drawV(c,parent);
            drawH(c,parent);
    }

    private void drawH(Canvas canvas, RecyclerView parent) {
        final int childSize = parent.getChildCount() ;


        for(int i = 0 ; i < childSize ; i ++){
            final View child = parent.getChildAt( i ) ;
            final int top = parent.getPaddingTop() ;
            final int bottom = parent.getMeasuredHeight() - parent.getPaddingBottom() ;
            //获取当前item布局参数，通过它可以知道该item的精确位置，我们通过这个位置去绘制它的分割线
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            int left = child.getRight() + layoutParams.rightMargin - mItemSize;
            int right = left + mItemSize;

            // mDividerDarwable.setBounds(left, top, right, bottom);
            // mDividerDarwable.draw(c);
            canvas.drawRect(left,top,right,bottom,mPaint);
        }
    }

    private void drawV(Canvas canvas, RecyclerView parent) {


        final int childSize = parent.getChildCount() ;


        for(int i = 0 ; i < childSize ; i ++){
            final View child = parent.getChildAt( i ) ;
            final int left = parent.getPaddingLeft() ;
            final int right = parent.getMeasuredHeight() - parent.getPaddingRight() ;
            //获取当前item布局参数，通过它可以知道该item的精确位置，我们通过这个位置去绘制它的分割线
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + layoutParams.bottomMargin;
            int bottom = top + mItemSize;

           // mDividerDarwable.setBounds(left, top, right, bottom);
           // mDividerDarwable.draw(c);
            canvas.drawRect(left,top,right,bottom,mPaint);
        }
    }

    /**
     * 设置item分割线的size
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

            outRect.set(mItemSize,mItemSize,mItemSize,mItemSize);

    }
}
