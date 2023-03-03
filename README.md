# PasswordLoadingView
Provide an animation when finished the password<br>



## Looks like

![](https://github.com/Rogero0o/PasswordLoadingView/raw/master/Demo/demo.gif)

##  Usage

### Jcenter

gradle
```
compile 'com.roger.psdloadingview.library:Library:1.0.1'
```

### Config in xml

```xml
        <com.roger.psdloadingview.library.PsdLoadingView
            android:id="@+id/psdloadingview"
            android:hint="Please input password"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"/>
```

### and init in java code

```java
 	PsdLoadingView psd = (PsdLoadingView) findViewById(R.id.psdloadingview);
 	psd.init(new TranslationXAnimate());
 	psd.startLoading();
```

### Warning

If you have to getText during the animation , you should use psd.getTextDuringLoading() instead of psd.getText().

## About me

A small guy  in mainland FUJIAN China.

If you have any new idea about this project, feel free to tell me ,Tks. :smiley:


## License

	The MIT License (MIT)

	Copyright © 2015 Roger

	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the "Software"), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in
	all copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
	THE SOFTWARE.
