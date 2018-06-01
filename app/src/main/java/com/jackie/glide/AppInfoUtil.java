/*
 *              $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
 *              $                                                   $
 *              $                       _oo0oo_                     $
 *              $                      o8888888o                    $
 *              $                      88" . "88                    $
 *              $                      (| -_- |)                    $
 *              $                      0\  =  /0                    $
 *              $                    ___/`-_-'\___                  $
 *              $                  .' \\|     |$ '.                 $
 *              $                 / \\|||  :  |||$ \                $
 *              $                / _||||| -:- |||||- \              $
 *              $               |   | \\\  -  $/ |   |              $
 *              $               | \_|  ''\- -/''  |_/ |             $
 *              $               \  .-\__  '-'  ___/-. /             $
 *              $             ___'. .'  /-_._-\  `. .'___           $
 *              $          ."" '<  `.___\_<|>_/___.' >' "".         $
 *              $         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       $
 *              $         \  \ `_.   \_ __\ /__ _/   .-` /  /       $
 *              $     =====`-.____`.___ \_____/___.-`___.-'=====    $
 *              $                       `=-_-='                     $
 *              $     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   $
 *              $                                                   $
 *              $          Buddha Bless         Never Bug           $
 *              $                                                   $
 *              $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
 *
 *   Copyright (C) 2016 The Android Open Source Project By Jackie
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.jackie.glide;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;

public class AppInfoUtil {

    private final static String TAG = "AppInfoUtil";

    public static String getApplicationName(Context context) {
        int stringId = context.getApplicationInfo().labelRes;
        return context.getString(stringId);
    }

    public static String getDeviceUUID(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    /**
     * @return Application's version code from the {@code PackageManager}.
     */
    public static int getAppVersionCode(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    /**
     * @return Application's version name from the {@code PackageManager}.
     */
    public static String getAppVersionName(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    /**
     * @return Application's version name from the {@code PackageManager}.
     */
    public static String getAppPackageName(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }






}
