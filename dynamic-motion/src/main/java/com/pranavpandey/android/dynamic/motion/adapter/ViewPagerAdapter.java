/*
 * Copyright 2018-2021 Pranav Pandey
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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pranavpandey.android.dynamic.motion.R;

/**
 * A {@link RecyclerView.Adapter} to show different views as pages.
 * <p>It will be used internally to add dummy views inside the view pager.
 */
public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder> {

    /**
     * Item count for this adapter.
     */
    final int mPageCount;

    /**
     * Constructor to initialize an object of this class.
     *
     * @param pageCount The item count for this adapter.
     */
    public ViewPagerAdapter(int pageCount) {
        this.mPageCount = pageCount;
    }

    @Override
    public @NonNull ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adm_dummy_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { }

    @Override
    public int getItemCount() {
        return mPageCount;
    }

    /**
     * View holder to hold the dummy pages.
     */
    static class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * Root view used by this view holder.
         */
        private final ViewGroup root;

        /**
         * Constructor to initialize views from the supplied root.
         *
         * @param view The view for this view holder.
         */
        ViewHolder(@NonNull View view) {
            super(view);

            root = view.findViewById(R.id.adm_dummy_layout);
        }

        /**
         * Get the root view used by this view holder.
         *
         * @return The root view used by this view holder.
         */
        @NonNull ViewGroup getRoot() {
            return root;
        }
    }
}
