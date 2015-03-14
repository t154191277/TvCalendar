package cn.edu.bistu.tvcalendar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import cn.edu.bistu.tvcalendar.R;

/**
 * Created by Administrator on 2015/3/14.
 */
public class DramaInfoActivity extends Activity {

    private String name ;
    private String Director;
    private Boolean iswatchthisdrama;
    private int Hadwatchdramanum;
    private Bitmap poster;
    private TextView dramaname;
    private TextView dramaDirector;
    private Button iswatch;
    private ProgressBar pBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dramainfo);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        Director = intent.getStringExtra("Director");
        iswatchthisdrama = intent.getBooleanExtra("iswatchthisdrama", false);
        Hadwatchdramanum = intent.getIntExtra("Hadwatchdramanum", 0);

        dramaname = (TextView)findViewById(R.id.drama_name);
        dramaDirector = (TextView)findViewById(R.id.drama_director);
        iswatch = (Button)findViewById(R.id.drama_iswatch);

        dramaname.setText(name);
        dramaDirector.setText(Director);
    }
}
