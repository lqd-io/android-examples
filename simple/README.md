# Event Tracking

In this example we implement simple event tracking and user identification using Liquid's Android SDK.

### Jump Right In

It's possible to run this example and see how it works with Liquid:

* Create an App in Liquid (it's free!) or select an existing one;
* Go to the App's settings and get the Authentication Tokens;
* Open `SimpleApp.java` and replace the tokens.

### Important Code

#### User Identification

When a user is considered 'identified' is up to you and your App, but generally this happens upon some sort of login action, which is when one can be sure that the user is "Unique".

We identify the user in the [MainActivity](https://github.com/lqd-io/android-examples/blob/master/simple/src/main/java/com/onliquid/simple/MainActivity.java#L49) when they pick their name:

```java
private Liquid lqd;

public void login(View view) {
  HashMap attrs = new HashMap();
  ...
  lqd.identifyUser(name, attrs);
  ...
}
```

Because this App has no back-end, we use the user's picked `name` as a unique identifier. However, as the designation indicates, this identifier should belong to one user and **one user only** as Liquid considers that every event that arrives assigned to that identified belongs to the same person.

If you persist your users in a database, use the Database ID field as a unique_id, otherwise an email address is a good option.

`attrs` is a map where every single piece of information about the user can be stored. Age, Name, Number of Facebook friends and Twitter followers, anything can be stored here and the more information you provide the better you can take advantage of Liquid's segmentation as everything can be used when creating a segment.

#### Event Tracking

Every single relevant action the user takes in the app should be mirrorred by an event. The more events you track the better you can trace the path a user takes through your App.

An event is tracked through `track`. We have a good example when the user [buys an item](https://github.com/lqd-io/android-examples/blob/master/simple/src/main/java/com/onliquid/simple/support/ListAdapter.java#L56):

```java
public void onClick(View view1){
  HashMap<String, Object> attr = new HashMap<String, Object>();
  attr.put("name", p.getName());
  attr.put("type", p.getType());
  attr.put("price", Double.valueOf(p.getPrice()));
  attr.put("currency", p.getCurrency());
  lqd.track("Buy Product", attr);
  ...
}
```

An event is identified by a name that should represent an action the user takes. Events with the same name will all be related and organized together; differentiation can and should be done through event attributes. These can store any information that you find is relevant for that event, and can be analysed in isolation or used for segmenting events later in Liquid's dashboard.

Remember to pick **short, succint names** for your events and to use event attributes for differentiating similar Events.
