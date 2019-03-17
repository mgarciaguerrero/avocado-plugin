# avocado-plugin

[![JetBrains IntelliJ Plugins][Jetbrains-badge]][Jetbrains Repository]

 This plugin is based on [`avocado tool`][avocado tool].

`avocado` is a command line tool (similar to [`svgo`][svgo]) that optimizes Android
`VectorDrawable` (VD) and `AnimatedVectorDrawable` (AVD) xml files.

## Installation
Install [`avocado tool`][avocado tool]

Then you can install the plugin from the [`Jetbrains Repository`][Jetbrains Repository] or you can download the latest binary from [`Plugin Repository`][Plugin Repository] on this repo

## Usage
This plugin can be used in two different ways:

1. Tap on `drawable` folder to optimize all the vectors:

<p align="center">
  <img src="images/Optimize_all_vectors.png" width="400" title="Optimize all vectors">
</p>

2. Tap on any vector from `drawable` folder to optimize:

<p align="center">
  <img src="images/Optimize_one_vector.png" width="400" title="Optimize one vector">
</p>

### Examples
`avocado` rewrites the `VectorDrawable` using the smallest number of `<group>`s and `<path>`s possible, reducing their file sizes and making them faster to parse and draw at runtime. The example below shows the contents of a `VectorDrawable` before and after being run through `avocado`.

#### Before

```xml
<vector xmlns:android="http://schemas.android.com/apk/res/android" android:width="108dp" android:height="108dp" android:viewportHeight="108" android:viewportWidth="108">
  <path android:fillColor="#26A69A" android:pathData="M0,0h108v108h-108z" />
  <group android:pivotX="54" android:pivotY="54" android:scaleX="1.5" android:scaleY="1.5">
    <path android:fillColor="#00000000" android:pathData="M9,0L9,108" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M19,0L19,108" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M29,0L29,108" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M39,0L39,108" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M49,0L49,108" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M59,0L59,108" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
  </group>
  <path android:fillColor="#00000000" android:pathData="M69,0L69,108" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
  <path android:fillColor="#00000000" android:pathData="M79,0L79,108" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
  <path android:fillColor="#00000000" android:pathData="M89,0L89,108" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
  <path android:fillColor="#00000000" android:pathData="M99,0L99,108" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
  <group android:translateX="54" android:translateY="54">
    <group android:pivotX="54" android:pivotY="54" android:rotation="180">
      <path android:fillColor="#00000000" android:pathData="M0,9L108,9" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
      <path android:fillColor="#00000000" android:pathData="M0,19L108,19" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
      <path android:fillColor="#00000000" android:pathData="M0,29L108,29" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
      <path android:fillColor="#00000000" android:pathData="M0,39L108,39" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
      <path android:fillColor="#00000000" android:pathData="M0,49L108,49" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
      <path android:fillColor="#00000000" android:pathData="M0,59L108,59" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    </group>
    <path android:fillColor="#00000000" android:pathData="M0,69L108,69" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M0,79L108,79" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M0,89L108,89" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M0,99L108,99" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M19,29L89,29" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M19,39L89,39" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M19,49L89,49" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M19,59L89,59" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M19,69L89,69" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M19,79L89,79" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M29,19L29,89" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M39,19L39,89" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M49,19L49,89" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M59,19L59,89" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M69,19L69,89" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
    <path android:fillColor="#00000000" android:pathData="M79,19L79,89" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8" />
  </group>
</vector>
```

#### After

```xml
<vector xmlns:android="http://schemas.android.com/apk/res/android" android:width="108dp" android:height="108dp" android:viewportHeight="108" android:viewportWidth="108">
    <path android:fillColor="#26A69A" android:pathData="M0 0h108v108H0z"/>
    <path android:pathData="M-13.5-27v162m15-162v162m15-162v162m15-162v162m15-162v162m15-162v162M69 0v108M79 0v108M89 0v108M99 0v108m63 63h108m-108 10h108m-108 10h108m-108 10h108m-108 10h108m-108 10h108M54 123h108M54 133h108M54 143h108M54 153h108M73 83h70M73 93h70m-70 10h70m-70 10h70m-70 10h70m-70 10h70M83 73v70m10-70v70m10-70v70m10-70v70m10-70v70m10-70v70" android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
</vector>

```

## License

    Copyright 2019 Marc Garcia Guerrero

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


[avocado tool]: https://github.com/alexjlockwood/avocado
[svgo]: https://github.com/svg/svgo
[Jetbrains-badge]: https://img.shields.io/jetbrains/plugin/v/12092.svg
[Jetbrains Repository]: https://plugins.jetbrains.com/plugin/12092-vector-drawable-optimization-tool
[Plugin Repository]: https://github.com/mgarciaguerrero/avocado-plugin/releases
