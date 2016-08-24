package louai.com.budgetmanagement;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

/**
 * Created by louai on 18/08/2016.
 */
public class MyApplication extends Application {
    public MyApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);

    }
}
