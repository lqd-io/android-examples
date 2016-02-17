# Push Notifications

In this example we set up our sample app in order to send Push Notifications through Liquid.

### Jump Right In

It's possible to run this example and send some Pushes with Liquid:

* Create an App in Liquid (it's free!) or select an existing one;
* Go to the App's settings and get the Authentication Tokens;
* Open `PushNotificationApp.java` and replace the tokens;
* Open `MainActivity.java`, replace `GCM_PROJECT_ID` with a valid sender id. [See how to get one for your App](https://onliquid.com/docs/dashboard/notifications#set-gcm-auth-key). 

### Important Code

#### Telling Liquid your App has pushes

```Java
  Liquid.getInstance().setupPushNotifications(this, "GCM_PROJECT_ID");
```

That's it. By telling Liquid about your GCM ID we automatically track each of your user's Device Token and let you send them Push Notifications.

#### Handling Pushes In App

Above all else we need to request permission for receivin push notifications in our manifest:

```xml
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>

<permission android:name="com.onliquid.pushnotification.permission.C2D_MESSAGE" android:protectionLevel="signature" />
<uses-permission android:name="com.onliquid.pushnotification.permission.C2D_MESSAGE" />

<uses-permission android:name="android.permission.GET_ACCOUNTS" />
<uses-permission android:name="com.google.android.c2dm.permission.RECEIVE" />
<uses-permission android:name="android.permission.WAKE_LOCK" />
<uses-permission android:name="android.permission.VIBRATE"/>
```

Then, arriving push notifications must be handled explicitely in code. Liquid provides a default handler that works perfectly with the data sent from the platform and that you can register in the manifest as well. You can see it in the example as:

```xml
<receiver
  android:name="com.google.android.gms.gcm.GcmReceiver"
  android:permission="com.google.android.c2dm.permission.SEND" >
  <intent-filter>
      <action android:name="com.google.android.c2dm.intent.RECEIVE" />
      <action android:name="com.google.android.c2dm.intent.REGISTRATION" />
      <category android:name="com.onliquid.pushnotification" />
  </intent-filter>
</receiver>

<service
  android:name="io.lqd.sdk.gcm.LQMessageHandler"
  android:exported="false" >
  <intent-filter>
      <action android:name="com.google.android.c2dm.intent.RECEIVE" />
  </intent-filter>
</service>
```

