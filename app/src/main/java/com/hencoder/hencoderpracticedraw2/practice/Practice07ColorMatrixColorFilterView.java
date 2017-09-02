package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw2.R;

public class Practice07ColorMatrixColorFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    ColorFilter colorFilter;

    public Practice07ColorMatrixColorFilterView(Context context) {
        super(context);
    }

    public Practice07ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice07ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);

        // 使用 setColorFilter() 设置一个 ColorMatrixColorFilter
        // 用 ColorMatrixColorFilter.setSaturation() 把饱和度去掉

        /**
         * ColorMatrix 有一些自带的方法可以做简单的转换，例如可以使用 setSaturation(float sat) 来设置饱和度；
         * 另外你也可以自己去设置它的每一个元素来对转换效果做精细调整。具体怎样设置会有怎样的效果，我就不讲了（其实是我也不太会😅）。
         * 如果你有需求，可以试一下程大治同学做的这个库：StyleImageView,https://github.com/chengdazhi/StyleImageView
         */

        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);//设置饱和度为0
        colorFilter = new ColorMatrixColorFilter(matrix);
        paint.setColorFilter(colorFilter);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(bitmap, 0, 0, paint);
    }
}
