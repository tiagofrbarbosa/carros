package br.com.livroandroid.carros.activity;

import android.support.v7.widget.Toolbar;
import br.com.livroandroid.carros.R;

/**
 * Created by tfbarbosa on 22/08/17.
 */

public class BaseActivity extends livroandroid.lib.activity.BaseActivity {

    protected void setUpToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
    }
}
