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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.madxstudio.libs.tools.image.Configuration;
import com.madxstudio.libs.tools.image.ImageLoader;

public class TestGlideActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ImageView imageView;
    private CheckBox radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_glide);
        imageView = findViewById(R.id.image);
        radio = findViewById(R.id.button);
        radio.setOnCheckedChangeListener((buttonView, isChecked) -> displayImage(isChecked));
    }

    private void displayImage(boolean isChecked) {
        Configuration configuration = new Configuration();
        configuration.isGif = isChecked;
        configuration.scaleType = Configuration.CENTER_CROP;
        if (isChecked) {
            configuration.url = "https://devb2be.bondwith.me/co8_2.0/index" +
                    ".php/api/sticker_l/1/fcode/WorkingLife_B_1.gif/version/1.0";
        } else {
            configuration.url = "https://devb2be.bondwith.me/co8_2.0/index" +
                    ".php/api/sticker_l/1/fcode/WorldOfBugs_B_1.png/version/1.0";
        }
        ImageLoader.display(this, imageView, configuration);
    }

    @Override
    protected void onResume() {
        super.onResume();
        displayImage(radio.isChecked());
    }
}
