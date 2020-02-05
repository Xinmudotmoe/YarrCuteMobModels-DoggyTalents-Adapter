package moe.xinmu.patchouli.doggytalents;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.commons.ClassRemapper;
import org.objectweb.asm.commons.SimpleRemapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class Remapper extends SimpleRemapper{
    public static final Map<String, String> transformMap;
    static List<String> rawClassResource = Arrays.asList(
            "yarrmateys/cuteMobModelsRemake/mobs/RenderCMMRWolf",
            "yarrmateys/cuteMobModelsRemake/mobs/ModelCMMRWolf",
            "yarrmateys/cuteMobModelsRemake/mobs/layers/LayerCMMRWolfCollar"
    );
    static List<String> targetClassResource=Arrays.asList(
            "yarrmateys/cuteMobModelsRemake/mobs/RenderCMMRDoggy",
            "yarrmateys/cuteMobModelsRemake/mobs/ModelCMMRDoggy",
            "yarrmateys/cuteMobModelsRemake/mobs/layers/LayerCMMRDoggyCollar"
    );
    static {
        transformMap = Collections.synchronizedMap(new HashMap<>());
        transformMap.put("yarrmateys/cuteMobModelsRemake/mobs/RenderCMMRWolf", "yarrmateys/cuteMobModelsRemake/mobs/RenderCMMRDoggy");
        transformMap.put("yarrmateys/cuteMobModelsRemake/mobs/ModelCMMRWolf", "yarrmateys/cuteMobModelsRemake/mobs/ModelCMMRDoggy");
        transformMap.put("yarrmateys/cuteMobModelsRemake/mobs/layers/LayerCMMRWolfCollar", "yarrmateys/cuteMobModelsRemake/mobs/layers/LayerCMMRDoggyCollar");
        transformMap.put("net/minecraft/entity/passive/EntityWolf", "doggytalents/entity/EntityDog");
        transformMap.put("net/minecraft/entity/passive/EntityWolf.func_70919_bu()Z", "func_70909_n");
        transformMap.put("net/minecraft/entity/passive/EntityWolf.func_70923_f()F", "getShakeAngle");
        transformMap.put("net/minecraft/entity/passive/EntityWolf.func_70920_v()F", "getTailRotation");
        transformMap.put("net/minecraft/entity/passive/EntityWolf.func_70917_k(F)F", "getInterestedAngle");
        transformMap.put("net/minecraft/entity/passive/EntityWolf.func_70923_f(FF)F", "getShakeAngle");
    }

    public static final Remapper remapper = new Remapper();

    URLClassLoader classLoader;

    public Remapper() {
        super(transformMap);
        List<URL> urls = new ArrayList<>();
        try {
            for (File f : Objects.requireNonNull(new File("mods").listFiles())) {
                urls.add(f.toURI().toURL());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        classLoader = new URLClassLoader(urls.toArray(new URL[0]));
    }

    public byte[] transform(String s) {
        if (targetClassResource.contains(s)) {
            try {

                ClassReader cr = new ClassReader(classLoader.findResource(rawClassResource.get(targetClassResource.indexOf(s)).concat(".class")).openConnection().getInputStream());
                ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_FRAMES);
                cr.accept(new ClassRemapper(cw, Remapper.remapper), ClassReader.EXPAND_FRAMES);
                return cw.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
