/*
 * Copyright 2018-2022 Pranav Pandey
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

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.pranavpandey.android.dynamic.motion.R;
import com.pranavpandey.android.dynamic.motion.adapter.ViewPagerAdapter;

/**
 * A {@link MotionLayout} to perform operations according to the {@link ViewPager2} page offset.
 */
public class DynamicMotionLayout extends MotionLayout {

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
    private ViewPager2 mViewPager;

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

    /**
     * Set the page count for the view pager.
     *
     * @param pageCount The page count to be set.
     * @param onPageChangeCallback The callback to receive page change events.
     */
    @SuppressLint("NotifyDataSetChanged")
    public void setPageCount(int pageCount,
            @Nullable ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.mPageCount = pageCount;

        if (mViewPager == null) {
            addView(LayoutInflater.from(getContext()).inflate(
                    R.layout.adm_view_pager, this, false));
            mViewPager = findViewById(R.id.adm_view_pager);
        }

        mViewPager.setAdapter(new ViewPagerAdapter(pageCount));
        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position,
                    float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);

                setProgress((position + positionOffset) / (mPageCount - 1));

                if (onPageChangeCallback != null) {
                    onPageChangeCallback.onPageScrolled(position,
                            positionOffset, positionOffsetPixels);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                if (onPageChangeCallback != null) {
                    onPageChangeCallback.onPageSelected(position);
                }
            }

            @Override
            public void onPageScrollStateChanged(@ViewPager2.ScrollState int state) {
                super.onPageScrollStateChanged(state);

                if (onPageChangeCallback != null) {
                    onPageChangeCallback.onPageScrollStateChanged(state);
                }
            }
        });

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
    public @Nullable ViewPager2 getViewPager() {
        return mViewPager;
    }
}
