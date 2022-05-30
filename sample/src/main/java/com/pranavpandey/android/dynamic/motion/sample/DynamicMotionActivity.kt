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

package com.pranavpandey.android.dynamic.motion.sample

import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.pranavpandey.android.dynamic.motion.sample.dialog.AboutDialogFragment
import com.pranavpandey.android.dynamic.util.DynamicColorUtils
import com.pranavpandey.android.dynamic.util.DynamicLinkUtils

class DynamicMotionActivity : AppCompatActivity(), View.OnClickListener {

    companion object {

        /**
         * Open source repository url.
         */
        const val URL_GITHUB = "https://github.com/pranavpandey/dynamic-motion"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dynamic_motion)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setSubtitle(R.string.app_name_sample)
        setSupportActionBar(toolbar)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setColorFilter(
            DynamicColorUtils.getTintColor(
            ContextCompat.getColor(this, R.color.color_accent)))

        fab.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.fab -> DynamicLinkUtils.viewUrl(this@DynamicMotionActivity, URL_GITHUB)
        }
    }

    /**
     * Fix for AppCompat 1.1.0.
     *
     * https://issuetracker.google.com/issues/140602653
     */
    override fun applyOverrideConfiguration(overrideConfiguration: Configuration?) {
        if (overrideConfiguration != null) {
            val uiMode = overrideConfiguration.uiMode
            overrideConfiguration.setTo(baseContext.resources.configuration)
            overrideConfiguration.uiMode = uiMode
        }
        super.applyOverrideConfiguration(resources.configuration)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_about) {
            AboutDialogFragment.newInstance().showDialog(this)

            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
