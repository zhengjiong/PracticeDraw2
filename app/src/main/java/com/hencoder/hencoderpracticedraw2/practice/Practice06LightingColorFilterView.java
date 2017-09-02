package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw2.R;

public class Practice06LightingColorFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    ColorFilter removeRedColorFilter;
    ColorFilter addGreenColorFilter;

    public Practice06LightingColorFilterView(Context context) {
        super(context);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);

        /**
         * 参数里的 mul 和 add 都是和颜色值格式相同的 int 值，其中 第一个参数用来和目标像素相乘，第二个参数 用来和目标像素相加
         *
         *
         * 一个「保持原样」的「基本 LightingColorFilter 」，mul 为 0xffffff，add 为 0x000000（也就是0），那么对于一个像素，它的计算过程就是：
         R' = R * 0xff / 0xff + 0x0 = R // R' = R
         G' = G * 0xff / 0xff + 0x0 = G // G' = G
         B' = B * 0xff / 0xff + 0x0 = B // B' = B
         基于这个「基本 LightingColorFilter 」，你就可以修改一下做出其他的 filter。比如，如果你想去掉原像素中的红色，可以把它的 mul 改为 0x00ffff （红色部分为 0 ） ，那么它的计算过程就是：

         R' = R * 0x0 / 0xff + 0x0 = 0 // 红色被移除
         G' = G * 0xff / 0xff + 0x0 = G
         B' = B * 0xff / 0xff + 0x0 = B
         */
        //去掉红色
        removeRedColorFilter = new LightingColorFilter(0x00ffff, 0);

        //加强绿色
        /**
         * 前两位红色, 中间两位绿色, 最后两位蓝色
         */
        addGreenColorFilter = new LightingColorFilter(0xffffff, 0x005000);
        //addGreenColorFilter = new LightingColorFilter(0xffffff, 0x00ff00);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter

        // 第一个 LightingColorFilter：去掉红色部分
        paint.setColorFilter(removeRedColorFilter);
        canvas.drawBitmap(bitmap, 0, 0, paint);

        // 第二个 LightingColorFilter：增强绿色部分

        paint.setColorFilter(addGreenColorFilter);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 100, 0, paint);
    }
}
