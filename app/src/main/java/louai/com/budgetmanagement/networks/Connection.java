package louai.com.budgetmanagement.networks;

import android.content.Context;
import android.util.Log;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessException;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.media.Stream;
import com.backendless.utils.StringUtils;

import java.util.Map;

/**
 * Created by louai on 05/08/2016.
 */
public class Connection {

    static String appVersion="v1";
    static String myAppID ="0C13351E-9C80-5986-FF1E-4BDEE9728A00";
    static String mySecretKey="553C4F22-2AEE-7D98-FF67-888FDC412700";
    private String result="null";

    public Connection() {
    }

    public Connection(String appVersion, String myAppID, String mySecretKey) {
        this.appVersion = appVersion;
        this.myAppID = myAppID;
        this.mySecretKey = mySecretKey;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public void setMyAppID(String myAppID) {
        this.myAppID = myAppID;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String getMyAppID() {
        return myAppID;
    }

    public String getMySecretKey() {
        return mySecretKey;
    }

    public void setMySecretKey(String mySecretKey) {
        this.mySecretKey = mySecretKey;
    }

    /**
     * Se connecter au serveur backendless
     * @param context
     */
    public void initApplication(Context context)
    {
        Backendless.initApp(context,myAppID,mySecretKey,appVersion);
    }

    /**
     * Register a new account
     * @param email
     * @param pass
     * @param name
     * @return
     */
    public String  register(Context context,String email,String name,String pass) {
        Backendless.initApp(context, myAppID, mySecretKey, appVersion);

        BackendlessUser user = new BackendlessUser();
        user.setProperty("email", email);
        user.setProperty("name", name);
        user.setPassword(pass);
        Backendless.UserService.register(user, new
                AsyncCallback<BackendlessUser>() {
                    public void handleResponse(BackendlessUser registeredUser) {
                    // user has been registered and now can login
                        result="ok";
                    }

                    public void handleFault(BackendlessFault fault) {
// an error has occurred, the error code can be retrieved with
                        result=fault.getMessage();
                    }
                });
        return result;
    }



}
