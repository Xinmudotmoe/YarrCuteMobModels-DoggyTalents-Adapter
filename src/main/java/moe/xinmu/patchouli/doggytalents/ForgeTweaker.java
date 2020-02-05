package moe.xinmu.patchouli.doggytalents;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;

import java.io.File;
import java.util.List;

public class ForgeTweaker implements ITweaker {
    @Override
    public void acceptOptions(List<String> list, File file, File file1, String s) {

    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader launchClassLoader) {
        launchClassLoader.registerTransformer(PatchCMMRRenderer.class.getName());
        launchClassLoader.registerTransformer(PatchRenderCMMRWolf.class.getName());
        launchClassLoader.registerTransformer(PatchModelCMMRWolf.class.getName());
        launchClassLoader.registerTransformer(PatchLayerCMMRWolfCollar.class.getName());
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
