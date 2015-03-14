package cn.edu.bistu.tvcalendar.fragment;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;


import cn.edu.bistu.tvcalendar.DramaInfoActivity;
import cn.edu.bistu.tvcalendar.R;
import cn.edu.bistu.tvcalendar.adapter.BaseFragmentListAdapter;
import cn.edu.bistu.tvcalendar.utils.DramaTools;

/**
 * Created by Administrator on 2015/3/14.
 */
public class BaseFragment extends Fragment {

    public BaseFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmet_list, container, false);
//        mPullToRefreshListFragment = (PullToRefreshListFragment) getFragmentManager().findFragmentById(R.id.pull_refresh);
//        mPullRefreshListView = mPullToRefreshListFragment.getPullToRefreshListView();
//        mPullRefreshListView.setOnRefreshListener(this);
//        ListView listview = mPullRefreshListView.getRefreshableView();
//        listview.setAdapter(new ListAdapter(getActivity(),DramaTools.myDramas));
//        mPullToRefreshListFragment.setListShown(true);
//		if(DramaTools.dramas!=null){
		ListView listView = (ListView) view.findViewById(R.id.list);
        listView.setAdapter(new BaseFragmentListAdapter(getActivity(),DramaTools.myDramas));
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> arg0, View v, int position,
                                    long arg3) {
                String name = DramaTools.myDramas.get(position).getName();
                Toast.makeText(getActivity(), name, Toast.LENGTH_LONG).show();
                String Director = DramaTools.myDramas.get(position).getDirector();
                int Hadwatchdramanum = DramaTools.myDramas.get(position).getHadwatch();
                Boolean iswatchthisdrama = DramaTools.myDramas.get(position).getIswatchthisdrama();
                Intent intent = new Intent();
                intent.putExtra("name", name);
                intent.putExtra("Director", Director);
                intent.putExtra("Hadwatchdramanum", Hadwatchdramanum);
                intent.putExtra("iswatchthisdrama", iswatchthisdrama);
                intent.setClass(getActivity(), DramaInfoActivity.class);
                startActivity(intent);
            }
//	}else{
        });
//		//动态加载TextView:提示没有选择喜欢的剧
//	}
        return view;
    }
}
