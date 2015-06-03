package cn.edu.bistu.tvcalendar;

import android.app.Activity;
import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import cn.edu.bistu.tvcalendar.adapter.BaseFragmentPagerAdapter;


public class MainActivity extends ActionBarActivity {

    private Button last_btn,today_btn,tom_btn;
    private ViewPager viewPager ;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initandsetview();

		//
        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(new BaseFragmentPagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(1);
    }

    private void initandsetview() {
        last_btn = (Button)findViewById(R.id.last);
        today_btn = (Button)findViewById(R.id.today);
        tom_btn = (Button)findViewById(R.id.tomorow);

        last_btn.setOnClickListener(new btn_listener(0));
        today_btn.setOnClickListener(new btn_listener(1));
        tom_btn.setOnClickListener(new btn_listener(2));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.explore :{
                Intent intent = new Intent();
                intent.setClass(this, ExploreActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.action_settings :{
                Toast.makeText(MainActivity.this, "setting...", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.notification  : {
                int i = 0;
                notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Intent intent = new Intent(this,DramaInfoActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                Notification notification = new Notification.Builder(MainActivity.this).setContentIntent(pendingIntent)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setWhen(System.currentTimeMillis()).setContentTitle("TVCanlendar")
                        .setContentText("你追的剧集更新啦。！！！")
                        .setAutoCancel(true)
                        .setTicker("你追的剧集更新啦。！！！")
                        .build();
                notificationManager.notify(i, notification);
                i++;
                //删除通知
//    			notificationManager.cancel(0);
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    class btn_listener implements OnClickListener{
        int num ;
        public btn_listener(int num) {
            this.num = num;
        }

        @Override
        public void onClick(View v) {
            viewPager.setCurrentItem(num);
        }


    }

}
