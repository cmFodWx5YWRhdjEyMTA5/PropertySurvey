package frameworks.customlayout;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class TouchableWrapperLayout extends FrameLayout {

    public interface OnDragListener {
        void onLayoutDrag();

        void onLayoutIdle();
    }

    private OnDragListener listener;

    public TouchableWrapperLayout(@NonNull Context context) {
        super(context);
    }

    public TouchableWrapperLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchableWrapperLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (listener != null)
            switch (ev.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    listener.onLayoutDrag();
                    break;

                case MotionEvent.ACTION_UP:
                    listener.onLayoutIdle();
                    break;
            }
        return super.dispatchTouchEvent(ev);
    }


    public void setListener(OnDragListener listener) {
        this.listener = listener;
    }
}
