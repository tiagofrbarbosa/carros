package br.com.livroandroid.carros.activity;

import android.os.Bundle;
import br.com.livroandroid.carros.R;

/**
 * Created by tfbarbosa on 22/08/17.
 */

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
    }
}
