package cn.edu.nuc.lesson1;

import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

//SlidingLayout只能打开一侧
public class SlidingActivity extends AppCompatActivity implements SlidingPaneLayout.PanelSlideListener {

    private SlidingPaneLayout sliding;
    private FrameLayout view;
    private LinearLayout menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding);
        sliding = (SlidingPaneLayout) findViewById(R.id.sliding);
        view = (FrameLayout) findViewById(R.id.container);

        sliding.setPanelSlideListener(this);
        menu = (LinearLayout)findViewById(R.id.menu);
    }

    /**
     *
     * 滑动中
     * @param panel
     * @param slideOffset [0-1]
     */
    @Override
    public void onPanelSlide(View panel, float slideOffset) {
        //为了兼容SDK11以下的使用以下的方法
        ViewCompat.setPivotX(view, 0);
        ViewCompat.setScaleY(view, view.getHeight() / 2);
        ViewCompat.setScaleX(view, 1 - slideOffset * 0.5f);
        ViewCompat.setScaleY(view, 1 - slideOffset * 0.5f);
        ViewCompat.setTranslationX(menu,-menu.getWidth()/ 2 * (1-slideOffset));

        //SDK为11才可以用以下的方法
//        view.setPivotX(0);
//        view.setScaleX(1-slideOffset * 0.5f);
//        view.setScaleY(1 - slideOffset * 0.5f);
    }

    /**
     * 滑动打开
     * @param panel
     */
    @Override
    public void onPanelOpened(View panel) {

    }

    /**
     * 画动关闭
     * @param panel
     */
    @Override
    public void onPanelClosed(View panel) {

    }
}
