<img src="./graphics/icon.png" height="160">

# Dynamic Motion

[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![Build Status](https://travis-ci.org/pranavpandey/dynamic-motion.svg?branch=master)](https://travis-ci.org/pranavpandey/dynamic-motion)
[![Release](https://img.shields.io/maven-central/v/com.pranavpandey.android/dynamic-motion)](https://search.maven.org/artifact/com.pranavpandey.android/dynamic-motion)

**A library to provide additional functionality for [MotionLayout][motion-layout] on 
Android 4.3 (API 18) and above. It has `DynamicMotionLayout` which has a built-in `ViewPager` to create 
parallax effects that opens a huge set of possibilities for the original `MotionLayout`.**

> [!IMPORTANT]
> Since v1.0.0, it is dependent on Java 8.
<br/>Since v1.1.0, it is targeting Java 17 to provide maximum compatibility.
<br/>Since v1.2.0, the minimum SDK is Android 4.4 (API 19) to comply with the latest policies.

<img src="./graphics/preview.gif" width="280" height="486">

---

## Contents

- [Installation](#installation)
- [Usage](#usage)
    - [Replace](#replace)
    - [Page count](#page-count)
    - [Motion scene](#motion-scene)
- [License](#license)

---

## Installation

It can be installed by adding the following dependency to your `build.gradle` file:

```groovy
dependencies {
    implementation 'com.pranavpandey.android:dynamic-motion:1.2.0'
}
```

---

## Usage

It is divided into 3 simple steps and whole layout can be configured by just using the `xml` files.

> For a complete reference, please read the [documentation][documentation].

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
dynamicMotionLayout.setPageCount(int, @Nullable ViewPager2.OnPageChangeCallback);
```

### Motion scene

Add a motion scene and use `KeyFrameSet` and `KeyAttribute` to animate the views across different
pages. Please check the [sample][sample] for a [demo scene][demo scene].

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

    Copyright 2018-2024 Pranav Pandey

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


[documentation]: https://pranavpandey.github.io/dynamic-motion
[motion-layout]: https://developer.android.com/reference/android/support/constraint/motion/MotionLayout
[sample]: ./sample
[demo scene]: ./sample/src/main/res/xml/motion_scene.xml
