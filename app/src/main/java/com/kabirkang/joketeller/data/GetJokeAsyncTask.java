package com.kabirkang.joketeller.data;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.kabirkang.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by kabir on 3/28/2017.
 */

public class GetJokeAsyncTask extends AsyncTask<GetJokeAsyncTask.JokeCallback, Void, String> {
    private MyApi myApiService = null;
    private JokeCallback callback;
    @Override
    protected String doInBackground(JokeCallback... params) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        callback = params[0];

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (callback != null) {
            callback.done(result);
        }
    }

    public interface JokeCallback {
        void done(String result);
    }
}
