# Personalization Example

In this example we design our sample app using Liquid Variables in order to personalize the user experience.

### Jump Right In

It's possible to run this example and see the App changing in real time:

* Create an App in Liquid (it's free!) or select an existing one;
* Go to the App's settings and get the Authentication Tokens;
* Open PersonalizationApp.java and replace the tokens;
* Use the example with the different profiles;
* Once you have some information in Liquid, go to the Targets section and create one for each of the different profiles;
* Modify the variables, close and open the app, and watch the interface change.

### Available Variables

* `sort_order`
  * Available values: "clothing", "electronics, "music"
* `price_btn_merge`
  * Available values: True, False

<span>
  <img src="/readme_assets/merge.png" alt="alt text" width="200" >
  <img src="/readme_assets/not_merge.png" alt="alt text" width="200" >
</span>

### Important Code

The only thing that matters here is using variables that are known to Liquid inside the code. In this example two variables are used:

1. `sort_order` is a String that determines the order in which products appear in the list;
2. `price_btn_merge` is a Boolean that enables or disables merging the price tag with the Buy button.

`sort_order` is used in [ListAdapter.java](https://github.com/lqd-io/android-examples/blob/master/personalization/src/main/java/com/onliquid/personalization/SecondActivity.java#L75):

```java
String order = lqd.getStringVariable("sort_order", LiquidDefaults.SORT_ORDER);
customAdapter.sort(new TypeComparator(order));
```

and `price_btn_merge` is used in [ListAdapter.java](https://github.com/lqd-io/android-examples/blob/master/personalization/src/main/java/com/onliquid/personalization/support/ListAdapter.java#L62):

```java
if (lqd.getBooleanVariable("price_btn_merge", LiquidDefaults.PRICE_BTN_MERGE)) {
  textview1.setVisibility(View.GONE);
  button.setText(p.getPriceCurrency() + " Buy!");
}
```

In both cases a fallback value is defined for the App's first run in case the device is offline and can't contact Liquid. We recommend storing all the defaults in the same place. We have them in [LiquidDefaults.java](https://github.com/lqd-io/android-examples/blob/master/personalization/src/main/java/com/onliquid/personalization/LiquidDefaults.java).

That's it! Changing these values in Liquid (directly or through a target) will send them to the device and they will be applied as soon as the app is re-opened.

