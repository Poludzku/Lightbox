#Retrolambda
-dontwarn java.lang.invoke.*

#Crashlytics
-keep class com.crashlytics.** { *; }
-keep class com.crashlytics.android.**
-keepattributes SourceFile,LineNumberTable,*Annotation*

# Retrofit
-keep class retrofit2.** { *; }
-keepclasseswithmembers class * {@retrofit2.http.* <methods>; }
-dontwarn retrofit2.**

# OKHttp
-keep class com.squareup.okhttp.** { *; }
-dontwarn com.squareup.okhttp.**
-dontwarn okio.*

-keepattributes Signature
-keepattributes Annotation
-keep class okhttp3.* { *; }
-keep interface okhttp3.* { *; }
-dontwarn okhttp3.

# Rx Java
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
    long producerIndex;
    long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}
-dontwarn sun.misc.Unsafe

#AdobeMobileAnalytics
-keeppackagenames com.adobe.mobile
-keep class com.adobe.mobile.** { *; }
-dontwarn com.adobe.mobile**

#AppDynamics
-keep class com.appdynamics.eumagent.runtime.DontObfuscate
-keep @com.appdynamics.eumagent.runtime.DontObfuscate class * { *; }

-keep class com.tesco.now.app.model.** { *; }
-keeppackagenames com.tesco.now.app.model

#Stripe
-keep class com.stripe.** { *; }

-keep class com.google.android.gms.** { *; }
# Model classes processed by Gson
#
# Write a rule like the following one to keep all the classes
# that must be processed automatically by Gson without the need
# to specify explicit @SerializedName("...") annotations.
# In this example all the classes under the
# "com.tesco.now.app.error.registration" package are preserved.
#-keep class com.tesco.now.app.error.registration.** { *; }
