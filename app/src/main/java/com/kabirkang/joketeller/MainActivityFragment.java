package com.kabirkang.joketeller;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.kabirkang.joketellerlibrary.DisplayJokeActivity;
import com.kabirkang.joketeller.data.GetJokeAsyncTask;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String TAG = MainActivityFragment.class.getName();

    @OnClick(R.id.show_joke)
    public void tellJoke(View view) {
        final AsyncTask<GetJokeAsyncTask.JokeCallback, Void, String> getJokeTask = new GetJokeAsyncTask();
        getJokeTask.execute(new GetJokeAsyncTask.JokeCallback() {
            @Override
            public void done(String result) {
                Log.d(TAG, result);
                Intent i = new Intent(getActivity(), DisplayJokeActivity.class);
                i.putExtra(DisplayJokeActivity.JOKE_EXTRA, result);
                startActivity(i);
            }
        });

    }

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }
}
