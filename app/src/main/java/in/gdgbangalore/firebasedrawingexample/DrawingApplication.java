package in.gdgbangalore.firebasedrawingexample;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Tejas on 8/21/15.
 */
public class DrawingApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
