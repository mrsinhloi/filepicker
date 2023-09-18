package droidninja.filepicker.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.content.ContextCompat;

public class Permission13Utils {

    public static String[] getArrPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            return arrPermissionsFrom33;
        else if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
            return arrPermissionsLower29;
        } else {
            return arrPermissionsLower33;

        }
    }

    static String[] arrPermissionsLower29 = {
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    static String[] arrPermissionsLower33 = {
            Manifest.permission.CAMERA,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };


    static String[] arrPermissionsFrom33 = {
            Manifest.permission.CAMERA,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Permission13Utils.getReadStorageForImage(),
            Permission13Utils.getReadStorageForVideo()
    };

    public static String getReadStorageForImage() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            return Manifest.permission.READ_MEDIA_IMAGES;
        else
            return Manifest.permission.READ_EXTERNAL_STORAGE;
    }

    public static String getReadStorageForVideo() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            return Manifest.permission.READ_MEDIA_VIDEO;
        else
            return Manifest.permission.READ_EXTERNAL_STORAGE;
    }


    public static boolean checkPermission(Context context) {
        boolean result = true;
        for (int i = 0; i < getArrPermissions().length; i++) {
            int grant = ContextCompat.checkSelfPermission(context, getArrPermissions()[i]);
            if (grant == PackageManager.PERMISSION_DENIED) {
                result = false;
                break;
            }
        }

        return result;
    }

}
