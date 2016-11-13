package com.example.ayush.sharedelementanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/**
 * Created by ayush on 13/11/16
 */
public class NextActivity extends AppCompatActivity {

    private ImageView poster;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_next_activity);

        //Postpone the enter transition until image is loaded in this activity
        postponeEnterTransition();

        poster = (ImageView) findViewById(R.id.image);
        TextView title = (TextView) findViewById(R.id.title);
        TextView genre = (TextView) findViewById(R.id.genre);
        TextView year = (TextView) findViewById(R.id.year);

        //Get intent data
        Bundle bundle = getIntent().getExtras();
        //Loading image using Glide
        Glide.with(this)
                .load(bundle.getString("poster"))
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        //Image successfully loaded into image view
                        scheduleStartPostponedTransition(poster);
                        return false;
                    }
                })
                .into(poster);

        title.setText(bundle.getString("title"));
        genre.setText(bundle.getString("genre"));
        year.setText(bundle.getString("year"));
    }

    private void scheduleStartPostponedTransition(final ImageView sharedElement) {
        sharedElement.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                sharedElement.getViewTreeObserver().removeOnPreDrawListener(this);
                startPostponedEnterTransition();
                return true;
            }
        });
    }
}
