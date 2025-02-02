package ru.kkuzmichev.simpleappforespresso;

import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.idling.CountingIdlingResource;

public class EspressoIdlingResources {
    private static final String RESOURCE = "GLOBAL";
    private static CountingIdlingResource idlingResource = new CountingIdlingResource(RESOURCE);
    public static void increment() {
        idlingResource.increment();
    }

    public static void decrement() {
        idlingResource.decrement();
    }

    public static IdlingResource getIdlingResource() {
        return idlingResource;
    }
}
