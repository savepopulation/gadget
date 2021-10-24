# gadget
**Gadget** is a library that aims to _make analytics event tracking_ **more reliable** and **configurable**.<br>

### Problems to solve
Here're a few problems that **Gadget** tries to solve.

1. Managing the tracking of the events to n platforms from a single point.
2. Adding or removing an analytics plafrom easily
3. Configuring of event tracking for different screens or conditions.
4. Google Enhanced Ecommerce implementation easier.  

### How to use?
First you need to setup **Gadget** in your **application**.
```KOTLIN
class MyAwesomeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Gadget.setup(this)
    	// .. other stuff
    }
}
```
By default **Gadget** uses it's own tracker which is called ```DefaultEventTracker``` and tracks to **Firebase Analytics** by default.
```KOTLIN
open class DefaultEventTracker(private val firebaseEventTracker: EventTracker) : EventTracker {
```
To customize the event tracking in your app, you can define your own tracker by implementing **EventTracker**
```KOTLIN
interface EventTracker {
    /*
     * Tracking function
     * Tracks the given event
     */
    fun track(event: Event)
}
```

After creating your custom event tracker, you can pass it to Gadget and use **your own tracker**.
```KOTLIN
Gadget.setup(this,myAwesomeCustomEventTracker)
```

Secondly, you should create **your own events** or you can use directly **Gadget's pre-defined events**. Your own events should impement Gadget's ```Event``` interface.
```KOTLIN
/*
 * Event
 * Generic Event interface
 * Every event has a name and params
 */
interface Event
```
If this event will be tracked to Firebase Analytics as well, you should implementd Gadget's ```FirebaseEvent``` interface. This interface has a default ```bundle``` implementation and you can override this bundle conversion anytime you want in your own event. (You can notice that some predefined **EEC events** has different ```bundle``` conversions.)
```KOTLIN
/*
 * Firebase Event
 * Defines the events that will be tracked to Firebase Analytics
 */
interface FirebaseEvent : Event {
    /*
     * Converts the event to bundle to track Firebase Analytics
     */
    fun toBundle(): Bundle {
        val bundle = Bundle()
        if (params.isNotEmpty()) {
            for (param in this.params) {
                bundle.put(param.key, param.value)
            }
        }

        return bundle
    }
} 
```

Instead of implementing your own events, you can directly use **Gadget's** ```CustomEvent``` for event tracking.
```KOTLIN
val addEvent = CustomEvent("content_add")
addEvent.putParam("type", "message")
```

And finally, you can track your event with ```Gadget```
```KOTLIN
Gadget.track(addEvent)
```

IF you want to change the event tracking strategy for a single event specifically **Gadget's track method** takes ```EventTracker``` as parameter and if you pass a different event tracker, your event will be tracked with that implementation.

### Dependency<br>
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  ```
  dependencies {
	        implementation 'com.github.savepopulation:gadget:1.0.0'
	}
  ```
