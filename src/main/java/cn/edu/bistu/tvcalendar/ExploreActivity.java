package cn.edu.bistu.tvcalendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import cn.edu.bistu.tvcalendar.adapter.BaseFragmentListAdapter;
import cn.edu.bistu.tvcalendar.utils.DramaTools;

/**
 * Created by Administrator on 2015/3/14.
 */
public class ExploreActivity extends Activity {
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        mListView = (ListView)findViewById(R.id.explorelist);
        mListView.setAdapter(new BaseFragmentListAdapter(this, DramaTools.Dramas));
        mListView.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position,
                                    long arg3) {

                String name = DramaTools.Dramas.get(position).getName();
                String Director = DramaTools.Dramas.get(position).getDirector();
                int Hadwatchdramanum = DramaTools.Dramas.get(position).getHadwatch();
                Boolean iswatchthisdrama = DramaTools.Dramas.get(position).getIswatchthisdrama();
                Intent intent = new Intent();
                intent.putExtra("name", name);
                intent.putExtra("Director", Director);
                intent.putExtra("Hadwatchdramanum", Hadwatchdramanum);
                intent.putExtra("iswatchthisdrama", iswatchthisdrama);
                intent.setClass(ExploreActivity.this, DramaInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}
