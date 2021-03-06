package com.avito.android.test.matcher

import android.view.View
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.viewpager.widget.ViewPager
import org.hamcrest.Description

internal class ViewPagersSelectMatcher(private val position: Int) :
    BoundedMatcher<View, ViewPager>(ViewPager::class.java) {

    override fun describeTo(description: Description) {
        description.appendText("with view pager selected tab position: $position")
    }

    override fun matchesSafely(viewPager: ViewPager): Boolean {
        return viewPager.currentItem == position
    }
}
