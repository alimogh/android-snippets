/*
 * Copyright 2014 Soichiro Kashima
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.snippet.app;

import com.snippet.R;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.TextView;

public class VersionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version);

        ((TextView) findViewById(R.id.tv_version_code)).setText(
                Integer.toString(getVersionCode()));
        ((TextView) findViewById(R.id.tv_version_name)).setText(getVersionName());
    }

    private int getVersionCode() {
        final PackageManager manager = getPackageManager();
        int versionCode;
        try {
            final PackageInfo info = manager.getPackageInfo(getPackageName(),
                    PackageManager.GET_META_DATA);
            versionCode = info.versionCode;
        } catch (NameNotFoundException e) {
            versionCode = -1;
        }
        return versionCode;
    }

    private String getVersionName() {
        final PackageManager manager = getPackageManager();
        String versionName;
        try {
            final PackageInfo info = manager.getPackageInfo(getPackageName(),
                    PackageManager.GET_META_DATA);
            versionName = info.versionName;
        } catch (NameNotFoundException e) {
            versionName = "";
        }
        return versionName;
    }
}
