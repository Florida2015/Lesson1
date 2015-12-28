package cn.edu.nuc.lesson1;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private NavigationView menu;
    private ActionBarDrawerToggle toggle;
    private ViewPager pager;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        menu = (NavigationView) findViewById(R.id.menu);

        //Navigation 的监听事件，对应的监听方法为onNavigationItemSelect()
        menu.setNavigationItemSelectedListener(this);

        //menu.setOnClickListener(this);
        //显示Home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //显示三条线的menu
        toggle = new ActionBarDrawerToggle(this, drawer, 0, 0);
        ////该方法会自动和actionBar关联,
        // 将开关的图片显示在了action上，如果不设置，也可以有抽屉的效果，不过是默认的图标
        toggle.syncState();

        //由DrawerLayout控制Toggle,menu会根据Drawer的变化（抽出或缩回）而变化
        drawer.setDrawerListener(toggle);

        pager = (ViewPager) findViewById(R.id.pager);
        List<String> list = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            list.add(String.format("第"+"%d" +"项",i));
        }
        pager.setAdapter(new MyAdapter(getSupportFragmentManager(),list));
        tab = (TabLayout) findViewById(R.id.tab);
        tab.setupWithViewPager(pager);
    }

    /**
     * 点击 menu（三条线）的时候，左边的Navigation会弹出，再次点击Navigation会缩回
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Toggle 控制DrawerLayout
        if(toggle.onOptionsItemSelected(item)){
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public void onClick(View v) {
//        //4.0以下不能用Gravity.STRAT,为了兼容4.0以下的版本使用GravityCompat.START
//        drawer.closeDrawer(GravityCompat.START);
//        startActivity(new Intent(this,SlidingActivity.class));
//    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.item1:
                Toast.makeText(this,"第一项",Toast.LENGTH_LONG).show();
                break;
            case R.id.item2:
                break;
            case R.id.item3:
                break;
            case R.id.item4:
                //finish()代表退出当前的Activity
                // finishAffinity()代表退出所有的Activity,也就是退出应用
                ActivityCompat.finishAffinity(this);
                break;
        }
        //当点击Navigation 的任何菜单项的时候，Navigation会缩回
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
