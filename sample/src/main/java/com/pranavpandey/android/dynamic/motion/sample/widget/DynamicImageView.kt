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

package com.pranavpandey.android.dynamic.motion.sample.widget

import android.content.Context
import android.graphics.PorterDuff
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.appcompat.widget.AppCompatImageView

/**
 * An [AppCompatImageView] to apply color filter according to the supplied parameters.
 */
class DynamicImageView : AppCompatImageView {

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null) : super(context, attrs) {
    }

    constructor(
        context: Context,
        attrs: AttributeSet?, defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
    }

    /**
     * Returns the filter mode to be used to tint this view.
     *
     * @return The filter mode to be used to tint this view.
     */
    private val filterMode: PorterDuff.Mode
        get() = PorterDuff.Mode.SRC_IN

    /**
     * Set color of this view according to the supplied values.
     *
     * It will be used to tint this view dynamically by using the custom attribute feature
     * of the [androidx.constraintlayout.motion.widget.MotionLayout].
     */
    fun setColor(@ColorInt color: Int) {
        setColorFilter(color, filterMode)
    }
}
