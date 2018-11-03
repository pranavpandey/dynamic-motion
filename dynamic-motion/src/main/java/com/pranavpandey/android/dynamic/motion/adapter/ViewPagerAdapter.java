/*
 * Copyright 2018 Pranav Pandey
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

package com.pranavpandey.android.dynamic.motion.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.pranavpandey.android.dynamic.motion.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

/**
 * A PagerAdapter to show different views as pages.
 * <p>It will be used internally to add dummy views inside the view pager.
 */
public class ViewPagerAdapter extends PagerAdapter {

    /**
     * A list to hold the views.
     */
    private List<View> mPages;

    public ViewPagerAdapter(@NonNull Context context, int pages) {
        this.mPages = new ArrayList<>();

        for (int i = 0; i < pages; i++) {
            mPages.add(LayoutInflater.from(context).inflate(
                    R.layout.adm_dummy_layout, new LinearLayout(context), false));
        }
    }

    @Override
    public @NonNull Object instantiateItem(@NonNull ViewGroup container, int position) {
        View page = mPages.get(position);
        container.addView(page);
        return page;
    }

    @Override
    public int getCount() {
        return mPages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
