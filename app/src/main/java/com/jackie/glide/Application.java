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

import android.text.TextUtils;

import com.madxstudio.libs.BaseApp;
import com.madxstudio.libs.tools.LogUtil;
import com.madxstudio.libs.tools.PreferencesUtil;
import com.madxstudio.libs.tools.http.HttpUtil;
import com.madxstudio.libs.tools.image.ImageLoader;

import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created on 2018/5/25.
 *
 * @author Jackie
 * @version 1.0
 */
public class Application extends BaseApp {
    private static final String TAG = "Application";

    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoader.initImageLoader(this);
        ImageLoader.getInstance().setNeedHeader(true);//如果不需要header false
        HashMap<String, String> headers = new HashMap<>();

        headers.put("X_DEVID", AppInfoUtil.getDeviceUUID(this));
        headers.put("X_TOKEN", "");
        headers.put("X_LOGINID", "");
        headers.put("X_APPID", AppInfoUtil.getAppPackageName(this));
        headers.put("X_USERLOC", Locale.getDefault().getCountry());
        headers.put("X_APPLANG", Locale.getDefault().getLanguage());
        headers.put("X_TIMEZONE", TimeZone.getDefault().getID());
        headers.put("X_APPVER", AppInfoUtil.getAppVersionName(this));
        LogUtil.d(TAG, "headers:  " + headers.toString());
        HttpUtil.addUserHeader(headers);
    }
}
