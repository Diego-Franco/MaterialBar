package com.example.diegofranco.materialbar;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by DiegoFranco on 12/4/14.
 */
public class DetailActivityL extends BaseActivity {

    public static final String EXTRA_IMAGE = "DetailActivity:image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ImageView image = (ImageView) findViewById(R.id.image);
        ViewCompat.setTransitionName(image, EXTRA_IMAGE);
        Drawable d = (Drawable) getIntent().getExtras().getParcelable(EXTRA_IMAGE);
        image.setImageDrawable(d);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_detail;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_settings:
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public static void launch(BaseActivity activity, View transitionView, Bitmap drawable) {
//        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionView, EXTRA_IMAGE);
//        Intent intent = new Intent(activity, DetailActivityL.class);
//        intent.putExtra(EXTRA_IMAGE, drawable);
//        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }
}
