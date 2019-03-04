package com.epicodus.myrestaurants;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class RestaurantsActivityTest {
    RestaurantsActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.buildActivity(RestaurantsActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void shouldNotBeNull() { assertNotNull(activity); }

    @Test
    public void titleCorrect() {
        assertThat("Test Title", activity.getTitle().toString(), equalTo("MyRestaurants"));
    }

}
