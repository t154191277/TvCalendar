package cn.edu.bistu.tvcalendar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import cn.edu.bistu.tvcalendar.R;
import cn.edu.bistu.tvcalendar.model.Drama;
import cn.edu.bistu.tvcalendar.utils.DramaTools;

/**
 * Created by Administrator on 2015/3/14.
 */
public class BaseFragmentListAdapter extends BaseAdapter{
    private Context context;
    private List<Drama> dramas;
    private static HashMap<Integer, Boolean> isSelected;

    public BaseFragmentListAdapter(Context context , List<Drama> dramas) {
        this.context = context;
        this.dramas = dramas;
        isSelected = new HashMap<Integer, Boolean>();
        for(int i=0;i<dramas.size();i++){
            isSelected.put(i, dramas.get(i).getIsfavorite());
        }
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return dramas.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder ;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_base_list_item, parent, false);
            holder=new ViewHolder();
            holder.name = (TextView)convertView.findViewById(R.id.name);
            holder.checkBox = (CheckBox)convertView.findViewById(R.id.listcheckbox);
//			holder.imageView = (ImageView)convertView.findViewById(R.id.poster);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(dramas.get(position).getName().toString());
//		holder.imageView.setImageBitmap(null);
        holder.checkBox.setChecked(dramas.get(position).getIsfavorite());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean IsSelected) {
                if("exploreAcitivity".equals(context.getClass())){
                    if(IsSelected){
                        DramaTools.addmyDrama(dramas.get(position));
                    }else{
                        DramaTools.removeDrama(dramas.remove(position));
                    }
                }else{
                    dramas.get(position).setIsfavorite(IsSelected);
                }
            }
        });


        return convertView;
    }

    class ViewHolder{
        public TextView name;
        public CheckBox checkBox;
        public ImageView imageView;
    }
}
