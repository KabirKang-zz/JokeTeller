package com.kabirkang.joketeller;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.kabirkang.joketeller.data.GetJokeAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.fail;

/**
 * Created by kabir on 4/4/2017.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class GetJokeTest implements GetJokeAsyncTask.JokeCallback {
    private final String LOG_TAG = GetJokeTest.class.getSimpleName();

    String joke;
    CountDownLatch signal;

    @Test
    public void testJoke() {
        Log.d(LOG_TAG, "TESTING JOKE BACKEND");
        try {
            signal = new CountDownLatch(1);
            new GetJokeAsyncTask().execute(this);
            signal.await(10, TimeUnit.SECONDS);
            Log.d(LOG_TAG, "JOKE: " + joke);
            assertNotNull("Null joke", joke);
            assertFalse("Empty joke", joke.isEmpty());

        } catch (Exception ex) {
            fail();
        }
    }

    @Override
    public void done(String result) {
        this.joke = result;
        signal.countDown();
    }
}
