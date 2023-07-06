package com.hbl.vlinkapp.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RootUtil {
    private static Context applicationContext;
    public RootUtil(Context applicationContext){
        this.applicationContext = applicationContext;
    }
    public static final String[] knownRootAppsPackages = {
            "com.noshufou.android.su",
            "com.noshufou.android.su.elite",
            "eu.chainfire.supersu",
            "com.koushikdutta.superuser",
            "com.thirdparty.superuser",
            "com.yellowes.su",
            "com.zachspong.temprootremovejb",
            "com.ramdroid.appquarantine",
            "eu.chainfire.supersu"

    };

    public static final String[] knownDangerousAppsPackages = {
            "com.koushikdutta.rommanager",
            "com.koushikdutta.rommanager.license",
            "com.dimonvideo.luckypatcher",
            "com.chelpus.lackypatch",
            "com.ramdroid.appquarantine",
            "com.ramdroid.appquarantinepro"
    };

    public static final String[] knownRootCloakingPackages = {
            "com.devadvance.rootcloak",
            "com.devadvance.rootcloakplus",
            "de.robv.android.xposed.installer",
            "com.saurik.substrate",
            "com.zachspong.temprootremovejb",
            "com.amphoras.hidemyroot",
            "com.amphoras.hidemyrootadfree",
            "com.formyhm.hiderootPremium",
            "com.formyhm.hideroot"
    };

    public static final String[] suPaths ={
            "/data/local/",
            "/data/local/bin/",
            "/data/local/xbin/",
            "/sbin/",
            "/su/bin/",
            "/system/bin/",
            "/system/bin/.ext/",
            "/system/bin/failsafe/",
            "/system/sd/xbin/",
            "/system/usr/we-need-root/",
            "/system/xbin/"
    };


    public static final String[] pathsThatShouldNotBeWrtiable = {
            "/system",
            "/system/bin",
            "/system/sbin",
            "/system/xbin",
            "/vendor/bin",
            //"/sys",
            "/sbin",
            "/etc",
            //"/proc",
            //"/dev"
    };
    public boolean isDeviceRooted() {
        return detectRootManagementApps() || detectPotentiallyDangerousApps() || checkForBinary("su")
                || checkForBinary("busybox") || checkForDangerousProps() || checkForRWPaths()
                || detectTestKeys() || checkSuExists();
    }

    public static boolean detectTestKeys() {
        String buildTags = Build.TAGS;
        String buildFinger= Build.FINGERPRINT;
        String product= Build.PRODUCT;
        String hardware=Build.HARDWARE;
        String display=Build.DISPLAY;
        return (buildTags != null) && (buildTags.contains("test-keys")|| buildFinger.contains("genric.*test-keys")||product.contains("generic")||product.contains("sdk")||hardware.contains("goldfish")||display.contains(".*test-keys"));
    }


    public static boolean detectRootManagementApps() {
        return detectRootManagementApps(null);
    }


    public static boolean detectRootManagementApps(String[] additionalRootManagementApps) {


        ArrayList<String> packages = new ArrayList<>();
        packages.addAll(Arrays.asList(knownRootAppsPackages));
        if (additionalRootManagementApps!=null && additionalRootManagementApps.length>0){
            packages.addAll(Arrays.asList(additionalRootManagementApps));
        }

        return isAnyPackageFromListInstalled(packages);
    }


    public static boolean detectPotentiallyDangerousApps() {
        return detectPotentiallyDangerousApps(null);
    }

    public static boolean detectPotentiallyDangerousApps(String[] additionalDangerousApps) {


        ArrayList<String> packages = new ArrayList<>();
        packages.addAll(Arrays.asList(knownDangerousAppsPackages));
        if (additionalDangerousApps!=null && additionalDangerousApps.length>0){
            packages.addAll(Arrays.asList(additionalDangerousApps));
        }

        return isAnyPackageFromListInstalled(packages);
    }


    public boolean detectRootCloakingApps() {
        return detectRootCloakingApps(null);
    }


    public boolean detectRootCloakingApps(String[] additionalRootCloakingApps) {


        ArrayList<String> packages = new ArrayList<>();
        packages.addAll(Arrays.asList(knownRootCloakingPackages));
        if (additionalRootCloakingApps!=null && additionalRootCloakingApps.length>0){
            packages.addAll(Arrays.asList(additionalRootCloakingApps));
        }

        return isAnyPackageFromListInstalled(packages);
    }



    public boolean checkForSuBinary(){
        return checkForBinary("su");
    }


    public boolean checkForBusyBoxBinary(){
        return checkForBinary("busybox");
    }

    public static boolean checkForBinary(String filename) {

        String[] pathsArray = suPaths;

        boolean result = false;

        for (String path : pathsArray) {
            String completePath = path + filename;
            File f = new File(completePath);
            boolean fileExists = f.exists();
            if (fileExists) {
                result = true;
            }
        }

        return result;
    }

    private static String[] propsReader() {
        InputStream inputstream = null;
        try {
            inputstream = Runtime.getRuntime().exec("getprop").getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String propval = "";
        try {
            propval = new Scanner(inputstream).useDelimiter("\\A").next();

        } catch (NoSuchElementException e) {

        }

        return propval.split("\n");
    }

    private static String[] mountReader() {
        InputStream inputstream = null;
        try {
            inputstream = Runtime.getRuntime().exec("mount").getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (inputstream == null) return null;

        String propval = "";
        try {
            propval = new Scanner(inputstream).useDelimiter("\\A").next();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        return propval.split("\n");
    }

    private static boolean isAnyPackageFromListInstalled(List<String> packages){
        boolean result = false;

        PackageManager pm =applicationContext.getPackageManager();

        for (String packageName : packages) {
            try {
                pm.getPackageInfo(packageName, 0);
                result = true;
            } catch (PackageManager.NameNotFoundException e) {

            }
        }

        return result;
    }

    public static boolean checkForDangerousProps() {

        final Map<String, String> dangerousProps = new HashMap<>();
        dangerousProps.put("ro.debuggable", "1");
        dangerousProps.put("ro.secure", "0");

        boolean result = false;

        String[] lines = propsReader();
        for (String line : lines) {
            for (String key : dangerousProps.keySet()) {
                if (line.contains(key)) {
                    String badValue = dangerousProps.get(key);
                    badValue = "[" + badValue + "]";
                    if (line.contains(badValue)) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    public static boolean checkForRWPaths() {

        boolean result = false;

        String[] lines = mountReader();
        for (String line : lines) {
            String[] args = line.split(" ");

            if (args.length < 4){
                continue;
            }

            String mountPoint = args[1];
            String mountOptions = args[3];

            for(String pathToCheck: pathsThatShouldNotBeWrtiable) {
                if (mountPoint.equalsIgnoreCase(pathToCheck)) {
                    for (String option : mountOptions.split(",")){

                        if (option.equalsIgnoreCase("rw")){
                            result = true;
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static boolean checkSuExists() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[] { "which", "su" });
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            return in.readLine() != null;
        } catch (Throwable t) {
            return false;
        } finally {
            if (process != null) process.destroy();
        }
    }
}
