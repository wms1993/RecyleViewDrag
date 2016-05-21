package com.wms.recyleviewdrag.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.liaoinstan.dragrecyclerview.R;
import com.wms.recyleviewdrag.fragment.MainFragment;
import com.wms.recyleviewdrag.fragment.MyGridFragment;
import com.wms.recyleviewdrag.fragment.MyListFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            MainFragment mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment, mainFragment)
                    .commit();
        }
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.list:
                fragment = new MyListFragment();
                break;
            case R.id.grid:
                fragment = new MyGridFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment, fragment)
                .addToBackStack(null)
                .commit();
    }
}
