package com.epicodus.myrestaurants;


import android.content.Intent;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void activityNotNull() { assertNotNull(activity); }

    @Test
    public void validateAppTitleTextViewValue() {
        TextView title = (TextView) activity.findViewById(R.id.appTitle);
        assertTrue("MyRestaurants".equals(title.getText().toString()));
    }

    @Test
    public void findRestaurantsButtonActivity() {
        activity.findViewById(R.id.findRestaurantsButton).performClick();
        Intent expectedIntent = new Intent(activity, RestaurantsActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }

}
