package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerActions.open;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.ViewInteraction;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class EspressoIdlingResourcesTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);
    @Before
    public void registerIdlingResource (){
        IdlingRegistry.getInstance().register(EspressoIdlingResources.getIdlingResource());
    }
    //@After... Здесь отключаемся от счётчика
    @After
    public void unregisterIdlingResource (){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.getIdlingResource());
    }
    @Test
    public void testName() {
        ViewInteraction drawer = onView(withId(R.id.drawer_layout));
        drawer.check(matches(isClosed())).perform(open());
        ViewInteraction element = onView(
                withId(R.id.nav_gallery)
        );
        element.perform(click());
        ViewInteraction item = onView(withText("7"));
        item.check(
                matches(isDisplayed()));
    }
}
