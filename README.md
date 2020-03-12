<img src="https://raw.githubusercontent.com/pranavpandey/dynamic-motion/master/graphics/dynamic-motion.png" width="160" height="160" align="right" hspace="20">

# Dynamic Motion

[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![Build Status](https://travis-ci.org/pranavpandey/dynamic-motion.svg?branch=master)](https://travis-ci.org/pranavpandey/dynamic-motion)
[![Download](https://api.bintray.com/packages/pranavpandey/android/dynamic-motion/images/download.svg)](https://bintray.com/pranavpandey/android/dynamic-motion/_latestVersion)

A library to provide additional functionality for [MotionLayout](https://developer.android.com/reference/android/support/constraint/motion/MotionLayout) 
on Android 4.3 (API 18) and above devices.

<img src="https://raw.githubusercontent.com/pranavpandey/dynamic-motion/master/graphics/dynamic-motion.gif" width="280" height="486">

It has `DynamicMotionLayout` which has a built-in `ViewPager` to create parallax effects which will
open a huge set of possibilities for the original `MotionLayout`.

---

## Contents

- [Installation](https://github.com/pranavpandey/dynamic-motion#installation)
- [Usage](https://github.com/pranavpandey/dynamic-motion#usage)
    - [Replace](https://github.com/pranavpandey/dynamic-motion#replace)
    - [Page count](https://github.com/pranavpandey/dynamic-motion#page-count)
    - [Motion scene](https://github.com/pranavpandey/dynamic-motion#motion-scene)
- [License](https://github.com/pranavpandey/dynamic-motion#license)

---

## Installation

It can be installed by adding the following dependency to your `build.gradle` file:

```groovy
dependencies {
    implementation 'com.pranavpandey.android:dynamic-motion:0.3.0'
}
```

---

## Usage

It is divided into 3 simple steps and whole layout can be configured by just using the `xml` files.

### Replace

First, replace the original `MotionLayout` with `DynamicMotionLayout` in `xml` file.

```xml
<com.pranavpandey.android.dynamic.motion.widget.DynamicMotionLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    ...
    >

    ...
</com.pranavpandey.android.dynamic.motion.widget.DynamicMotionLayout>
```

### Page count

Set page count for `ViewPager` to divide the `transition` between different pages.

```xml
<com.pranavpandey.android.dynamic.motion.widget.DynamicMotionLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    app:adm_pageCount="4"
    ...
    >

    ...
</com.pranavpandey.android.dynamic.motion.widget.DynamicMotionLayout>
```

```java
// At runtime
dynamicMotionLayout.setPageCount(int, @Nullable ViewPager.OnPageChangeListener);
```

### Motion scene

Add a motion scene and use `KeyFrameSet` and `KeyAttribute` to animate the views across different
pages. Please check the [sample](https://github.com/pranavpandey/dynamic-motion/tree/master/sample)
for a [demo scene](https://github.com/pranavpandey/dynamic-motion/blob/master/sample/src/main/res/xml/motion_scene.xml).

```xml
<com.pranavpandey.android.dynamic.motion.widget.DynamicMotionLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    app:layoutDescription="@xml/motion_scene"
    app:adm_pageCount="4"
    ...
    >

    ...
</com.pranavpandey.android.dynamic.motion.widget.DynamicMotionLayout>
```

---

## Author

Pranav Pandey

[![GitHub](https://img.shields.io/github/followers/pranavpandey?label=GitHub&style=social)](https://github.com/pranavpandey)
[![Follow on Twitter](https://img.shields.io/twitter/follow/pranavpandeydev?label=Follow&style=social)](https://twitter.com/intent/follow?screen_name=pranavpandeydev)
[![Donate via PayPal](https://img.shields.io/static/v1?label=Donate&message=PayPal&color=blue)](https://paypal.me/pranavpandeydev)

---

## License

    Copyright 2019-2020 Pranav Pandey

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
