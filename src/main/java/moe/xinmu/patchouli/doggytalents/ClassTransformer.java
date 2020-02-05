package moe.xinmu.patchouli.doggytalents;

import net.minecraft.launchwrapper.IClassTransformer;

import java.lang.instrument.ClassFileTransformer;
import java.util.Objects;

public interface ClassTransformer extends IClassTransformer, ClassFileTransformer {

    default byte[] transform(String s, String s1, byte[] bytes) {
        byte[] b = null;
        try {
            b = transform(this.getClass().getClassLoader(), s.replace(".", "/"), null, null, bytes);
        } catch (Exception e) {
            ForgeTweaker.dbg(e.getMessage());
        }
        return requireNonNullElse(b, bytes);
    }

    static <T> T requireNonNullElse(T obj, T defaultObj) {
        return (obj != null) ? obj : Objects.requireNonNull(defaultObj, "defaultObj");
    }
}
