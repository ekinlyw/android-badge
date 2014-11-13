
package com.ekinlyw.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

//BadgeUtil provides static utility methods to set "badge count" on Launcher (by Samsung, LG). 
//Currently, it's working from Android 4.0. 
//But some devices, which are released from the manufacturers, are not working.

public class BadgeUtil {

    private static final String TAG = "BadgeUtil";

    private static final String ACTION_BADGE_COUNT_UPDATE = "android.intent.action.BADGE_COUNT_UPDATE";

    private static final String EXTRA_BADGE_COUNT = "badge_count";

    private static final String EXTRA_BADGE_COUNT_PACKAGE_NAME = "badge_count_package_name";

    private static final String EXTRA_BADGE_COUNT_CLASS_NAME = "badge_count_class_name";

    /**
     * Set badge count
     * 
     * @param context The context of the application package.
     * @param count Badge count to be set
     */
    public static void setBadgeCount(Context context, int count) {
        Intent badgeIntent = new Intent(ACTION_BADGE_COUNT_UPDATE);
        badgeIntent.putExtra(EXTRA_BADGE_COUNT, count);
        badgeIntent.putExtra(EXTRA_BADGE_COUNT_PACKAGE_NAME, context.getPackageName());
        badgeIntent.putExtra(EXTRA_BADGE_COUNT_CLASS_NAME, getLauncherClassName(context));
        context.sendBroadcast(badgeIntent);
    }

    /**
     * Reset badge count. The badge count is set to "0"
     * 
     * @param context The context of the application package.
     */
    public static void resetBadgeCount(Context context) {
        setBadgeCount(context, 0);
    }

    /**
     * Retrieve launcher activity name of the application from the context
     *
     * @param context The context of the application package.
     * @return launcher activity name of this application. From the
     *         "android:name" attribute.
     */
    private static String getLauncherClassName(Context context) {
        PackageManager packageManager = context.getPackageManager();

        Intent intent = new Intent(Intent.ACTION_MAIN);
        // To limit the components this Intent will resolve to, by setting an
        // explicit package name.
        intent.setPackage(context.getPackageName());
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        // All Application must have 1 Activity at least.
        // Launcher activity must be found!
        ResolveInfo info = packageManager
                .resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);

        // get a ResolveInfo containing ACTION_MAIN, CATEGORY_LAUNCHER
        // if there is no Activity which has filtered by CATEGORY_DEFAULT
        if (info == null) {
            info = packageManager.resolveActivity(intent, 0);
        }

        return info.activityInfo.name;
    }
}
