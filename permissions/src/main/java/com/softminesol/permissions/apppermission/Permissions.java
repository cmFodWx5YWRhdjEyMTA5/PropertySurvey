package com.softminesol.permissions.apppermission;

import android.Manifest;

/**
 * Created by Sandeep on 21/01/2017.
 */

public class Permissions {
    public static final PermissionMapper PERMISSION_CALL_PHONE = new PermissionMapper(Manifest.permission.CALL_PHONE, 1);
    public static final PermissionMapper PERMISSION_READ_EXTERNAL_STORAGE = new PermissionMapper(Manifest.permission.READ_EXTERNAL_STORAGE, 2);
    public static final PermissionMapper PERMISSION_WRITE_EXTERNAL_STORATE = new PermissionMapper(Manifest.permission.WRITE_EXTERNAL_STORAGE, 3);
    public static final PermissionMapper PERMISSION_CAMERA_OPEN = new PermissionMapper(Manifest.permission.CAMERA, 4);
}
