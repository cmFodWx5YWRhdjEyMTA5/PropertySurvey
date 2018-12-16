package com.softminesol.permissions.apppermission;
public class PermissionMapper {
    String permission;
    int requestId;
    boolean isPermissionEnabled;

    public boolean isPermissionEnabled() {
        return isPermissionEnabled;
    }

    public void setPermissionEnabled(boolean permissionEnabled) {
        isPermissionEnabled = permissionEnabled;
    }

    public PermissionMapper(String permission, int requestId) {
        this.permission = permission;
        this.requestId = requestId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
}