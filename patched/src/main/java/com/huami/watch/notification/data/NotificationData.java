package com.huami.watch.notification.data;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.edotasx.amazfit.Constants;

import lanchon.dexpatcher.annotation.DexAction;
import lanchon.dexpatcher.annotation.DexEdit;
import lanchon.dexpatcher.annotation.DexIgnore;
import lanchon.dexpatcher.annotation.DexWrap;

/**
 * Created by edoardotassinari on 25/01/18.
 */

@DexEdit(defaultAction = DexAction.IGNORE)
public class NotificationData implements Parcelable {

    @DexIgnore
    public String text;

    @DexIgnore
    public static final Creator<NotificationData> CREATOR = null;

    @DexIgnore
    @Override
    public int describeContents() {
        return 0;
    }

    @DexIgnore
    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @DexWrap
    public static NotificationData from(Context var0, NotificationKeyData var1, Notification var2, boolean var3) {
        Log.d(Constants.TAG, "enter in NotificationData:from");

        NotificationData notificationData = from(var0, var1, var2, var3);

        Bundle bundle = NotificationCompat.getExtras(var2);

        CharSequence[] lines = bundle.getCharSequenceArray(Notification.EXTRA_TEXT_LINES);
        if (lines != null) {
            int index = lines.length - 1;
            notificationData.text = lines[index].toString();
        }

        Log.d(Constants.TAG, "edited notification data");

        return notificationData;
    }
}