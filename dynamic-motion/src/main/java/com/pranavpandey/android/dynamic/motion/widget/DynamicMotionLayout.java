/*
 * Copyright 2019-2020 Pranav Pandey
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pranavpandey.android.dynamic.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.viewpager.widget.ViewPager;

import com.pranavpandey.android.dynamic.motion.R;
import com.pranavpandey.android.dynamic.motion.adapter.ViewPagerAdapter;

/**
 * A MotionLayout to perform operations according to the {@link ViewPager} page offset.
 */
public class DynamicMotionLayout extends MotionLayout implements ViewPager.OnPageChangeListener {

    /**
     * Constant for the unknown page count.
     */
    private static final int ADM_VALUE_UNKNOWN = -1;

    /**
     * Page count for the view pager.
     */
    private int mPageCount;

    /**
     * View pager used by this view.
     */
    private ViewPager mViewPager;

    public DynamicMotionLayout(Context context) {
        this(context, null);
    }

    public DynamicMotionLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        loadFromAttributes(attrs);
    }

    public DynamicMotionLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        loadFromAttributes(attrs);
    }

    /**
     * Load values from the supplied attribute set.
     *
     * @param attrs The supplied attribute set to load the values.
     */
    public void loadFromAttributes(@Nullable AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.DynamicMotionLayout);

        try {
            mPageCount = a.getInteger(
                    R.styleable.DynamicMotionLayout_adm_pageCount,
                    ADM_VALUE_UNKNOWN);
        } finally {
            a.recycle();
        }

        initialize();
    }

    /**
     * Initialize this view by setting the default values.
     */
    public void initialize() {
        if (mPageCount > 0) {
            setPageCount(mPageCount, null);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        setProgress((position + positionOffset) / (mPageCount - 1));
    }

    @Override
    public void onPageSelected(int position) { }

    @Override
    public void onPageScrollStateChanged(int state) { }

    /**
     * Set the page count for the view pager.
     *
     * @param pageCount The page count to be set.
     * @param onPageChangeListener The page change listener to receive page change events.
     */
    public void setPageCount(int pageCount,
            @Nullable ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mPageCount = pageCount;

        if (mViewPager == null) {
            addView(LayoutInflater.from(getContext()).inflate(
                    R.layout.adm_view_pager, this, false));
            mViewPager = findViewById(R.id.adm_view_pager);
        }

        mViewPager.setAdapter(new ViewPagerAdapter(getContext(), pageCount));
        mViewPager.addOnPageChangeListener(this);

        if (onPageChangeListener != null) {
            mViewPager.addOnPageChangeListener(onPageChangeListener);
        }

        if (mViewPager.getAdapter() != null) {
            mViewPager.getAdapter().notifyDataSetChanged();
        }
    }

    /**
     * Get the page count for the view pager.
     *
     * @return The page count for the view pager.
     */
    public int getPageCount() {
        return mPageCount;
    }

    /**
     * Get the view pager used by this view.
     *
     * @return The view pager used by this view.
     */
    public @Nullable ViewPager getViewPager() {
        return mViewPager;
    }
}
