# A simple Android Library to allow drawing in Android

Want to provide functionality to draw on an android device? You can use this Library.

Every Action is performed nativley, so you can expect the best possible performance.

## Add Library to Project:

### 1.) Add the JitPack repository to your build.gradle(project) file

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

### 2.) Add the dependency in your project

Add this line in the build.gradle(app) file

```gradle
dependencies {
    .
    .
    implementation 'com.github.Luciferx86:DoodleCanvasLibrary:0.1.0-alpha3'
    .
    .
}
```

## Use the DoodleCanvas View


```xml
.
.

<com.luciferx86.doodlecanvaslibrary.DoodleCanvas
        android:id="@+id/doodleCanvas"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
.
.
```

## Use Canvas Properties 

You can modify the canvas properties like current Paint color and Stroke Width.

### Get a reference to the canvas

```java
DoodleCanvas canvas;
.
.
.
public void onCreate(Bundle savedInstanceState)
{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filters); 

        //get reference to canvas
        canvas = findViewById(R.id.doodleCanvas);
}
.
.
```

### Set Paint Color

```java
canvas.setStrokeColor(Color.GREEN);
//set custom color
canvas.setStrokeColor(Color.parseColor("#00ffbf"));
```


### Set Stroke Width

```java
// would recommend using something between 10f and 100f
canvas.setStrokeWidth(20f);
```


### Enable or Disable drawing programmatically

```java
// true and false are self explanatory
canvas.canUserDraw(false);
```


### Undo Last move

```java
// undo last path drawn
canvas.undoMove();
```

### Enable Erasing

```java
// simply sets the paint color to White, which acts as erasing 
canvas.enableErasing();
```



### Enable Painting

```java
// restores the last saved painting configuration
canvas.enablePainting();
```


### Clear Out the canvas

```java
// removes all paths on canvas
canvas.clearCanvas();
```
