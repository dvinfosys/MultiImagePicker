#MultiImagePicker
[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)
An android library that allows selection of multiple images from gallery. It shows an initial
album chooser and then images in selected album. Can limit the number of images that
can be selected. Can be used in apps with APK 11 onwards.

#Usage
Include this library in your project using gradle (thanks to [JitPack.io](https://github.com/jitpack-io)).

For using the latest build, replace the tag in dependencies above with latest commit hash. Example:
```gradle
repositories {
  maven {
    url "https://jitpack.io"
  }
}

dependencies {
  implementation 'com.github.dvinfosys:MultiImagePicker:1.0.0'
}
```

Check out [MultiImagePicker releases](https://github.com/dvinfosys/MultiImagePicker/releases) to see more stable versions.

In project's AndroidManifest.xml, add the following under application node:
```xml
<activity android:name="com.dvinfosys.multiimagepicker.Activitys.AlbumPickerActivity">
    <intent-filter>
        <category android:name="ANDROID.INTENT.CATEGORY.DEFAULT"/>
    </intent-filter>
</activity>
```
   In the activity from where you want to call image selector, create Intent as follows:
```java
Intent intent = new Intent(MainActivity.this, AlbumPickerActivity.class);
intent.putExtra(Constants.INTENT_EXTRA_LIMIT, numberOfImagesToSelect);
startActivityForResult(intent, Constants.REQUEST_CODE);
```
   and override onActivityResult as follows:
```java
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
  if (requestCode == Constants.REQUEST_CODE && resultCode == RESULT_OK && data != null) {
    //The array list has the image paths of the selected images
    ArrayList<Image> images = data.getParcelableArrayListExtra(Constants.INTENT_EXTRA_IMAGES);
    ...  
}
```
#Example

<img src="/document/example.gif" width="400" height="700"/>

Checkout my other contributions, https://github.com/dvinfosys?tab=repositories

#License
```license
Copyright [2020] [DV Infosys]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
