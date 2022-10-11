# Gadget
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

### Gadget's Google Analytics Enhanced Ecommerce Support
Google Analytics Enhanced Ecommerce reporting allows you to collect data related to ecommerce transactions: item data, impression data, product data, promotion data, and action data. This information gives you a snapshot of your company’s health by providing an overarching view of how visitors interact with your ecommerce website. [Source and more information here](https://thegood.com/insights/google-analytics-enhanced-ecommerce/)

Gadget has it's own impression trackers can be used for EEC impression tracking. You can use ```EecProductImpressionTracker``` for product impression tracking and 
```EecPromotionImpressionTracker``` for tracking your promotions. These trackers both implements **Gadget's** ```ListItemImpressionTracker<T>``` and ```LifecycleEventTracker``` implements to handle impression tracking in a with **lifecycle events**.

To collect the impressions, you can use ```addImpression``` method of ```ListItemImpressionTracker```
```KOTLIN
    /*
     * Function to track item impression
     * Call when item is viewed
     */
    fun addImpression(item: T) {
        viewedItems.add(item)
    }

    /*
     * Function to track item impression with a mapper
     * Call when item is viewed
     */
    fun addImpression(item: Any?, mapper: Function<Any, T>) {
        item?.let {
            viewedItems.add(mapper.apply(it))
        }
    }
```

To track an item selection, you can use ```trackItemSelection``` method of ```ListItemImpressionTracker```
```KOTLIN
/*
 * Tracks selection of an item in a list
 * Measure product clicks by logging a SELECT_CONTENT event
 * with an item (i.e. product) defined with the relevant fields:
 */
 fun trackItemSelection(item: T)
```

And finally, **Gadget's** ```EecProductImpressionTracker``` will track the collected impressions ```@OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)```

**Note:** You can notice that there're some out dated classes and implementations for **EEC support**. **Google Analytics 4 migration** is still on going and i'm trying to understand and replace these deprecated classes with the GA 4 implementations.

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
	        implementation 'com.github.savepopulation:gadget:1.0.2'
	}
  ```
  
### Apps Using Gadget on Production
[Phone Box](https://play.google.com/store/apps/details?id=com.raqun.phonebox)<br>
  
  * __Please send me an email if you're using Gaget on production and want to be in the list.__

### WHere Gadget comes from?
![alt text](/art/gadget.jpeg)<br><br>
[Inspector Gadget](https://en.wikipedia.org/wiki/Inspector_Gadget)<br>
[Watch this](https://www.youtube.com/watch?v=rIc13VjeAw8)

### License
```
  Copyright 2021 Taylan SABIRCAN

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

  
