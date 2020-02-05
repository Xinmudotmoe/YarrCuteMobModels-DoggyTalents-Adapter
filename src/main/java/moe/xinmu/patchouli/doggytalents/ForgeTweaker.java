package moe.xinmu.patchouli.doggytalents;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ForgeTweaker implements ITweaker {
    @Override
    public void acceptOptions(List<String> list, File file, File file1, String s) {

    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader launchClassLoader) {
        try {
            launchClassLoader.addURL(new URL("xinmu-patchouli-doggytalents","HonMeirin",-1,"/",BaseURLStreamHandler.INSTANCE));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        launchClassLoader.registerTransformer(PatchCMMRRenderer.class.getName());
        launchClassLoader.registerTransformer(PatchLayerCMMRDoggyCollar.class.getName());
    }

    @Override
    public String getLaunchTarget() {
        return "net.minecraft.client.main.Main";
    }

    @Override
    public String[] getLaunchArguments() {
        return new String[0];
    }

    public static void dbg(String str) {
        System.out.println(str);
    }
}
