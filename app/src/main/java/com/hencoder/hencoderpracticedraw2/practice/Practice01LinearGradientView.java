package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice01LinearGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    /**
     * 参数：
     * x0 y0 x1 y1：渐变的两个端点的位置
     * color0 color1 是端点的颜色
     * tile：端点范围之外的着色规则，类型是 TileMode。TileMode 一共有 3 个值可选：
     * CLAMP, MIRROR 和  REPEAT。
     * CLAMP （夹子模式？？？算了这个词我不会翻）会在端点之外延续端点处的颜色；
     * MIRROR 是镜像模式；REPEAT 是重复模式。具体的看一下例子就明白。
     */
    Shader shader = new LinearGradient(
            100f, 100f, 500f, 500f,
            Color.parseColor("#E91E63"), Color.parseColor("#2196F3"),
            Shader.TileMode.REPEAT
    );

    public Practice01LinearGradientView(Context context) {
        super(context);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 用 Paint.setShader(shader) 设置一个 LinearGradient
        // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        paint.setShader(shader);

        canvas.drawCircle(300, 300, 200, paint);
    }
}
