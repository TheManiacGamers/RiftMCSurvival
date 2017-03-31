package me.yeroc.riftmcsurvival.managers;

/**
 * Created by Corey on 10/12/2016.
 */
public class PermissionsManager {
    static PermissionsManager instance = new PermissionsManager();

    private PermissionsManager() {
    }

    public static PermissionsManager getInstance() {
        return instance;
    }

    public String EXPFly_Use = ("expfly.Use");

}
