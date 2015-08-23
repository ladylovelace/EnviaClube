/**
 * Copyright (C) 2014 Twitter Inc and other contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fabric.samples.cannonball.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.twitter.sdk.android.Twitter;

import com.digits.sdk.android.Digits;

import io.fabric.samples.cannonball.SessionRecorder;

import com.twitter.sdk.android.core.Session;


public class InitialActivity extends Activity {

    private static final String TAG = InitialActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG,"entrei");

        final Session activeSession = SessionRecorder.recordInitialSessionState(
                Twitter.getSessionManager().getActiveSession(),
                Digits.getSessionManager().getActiveSession()
        );

        if (activeSession != null) {
            startThemeActivity();
        } else {
            startLoginActivity();
        }
    }

    private void startThemeActivity() {
        //startActivity(new Intent(this, ThemeChooserActivity.class));
        startActivity(new Intent(this,MapActivity.class));
    }

    private void startLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
