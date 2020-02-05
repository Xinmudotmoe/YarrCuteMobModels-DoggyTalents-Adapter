package moe.xinmu.patchouli.doggytalents;

import org.objectweb.asm.*;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.util.Objects;

public class PreMain {
    public static void premain(String args, Instrumentation inst) {
        inst.addTransformer(new PatchCMMRRenderer());
        inst.addTransformer(new PatchRenderCMMRWolf());
        inst.addTransformer(new PatchModelCMMRWolf());
        inst.addTransformer(new PatchLayerCMMRWolfCollar());
        inst.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
                if (Objects.nonNull(className) && className.equals("moe/xinmu/patchouli/doggytalents/ForgeTweaker")) {
                    ClassReader cr = new ClassReader(classfileBuffer);
                    ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_FRAMES);
                    cr.accept(new ClassVisitor(Opcodes.ASM5, cw) {
                        @Override
                        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                            MethodVisitor visitor = super.visitMethod(access, name, desc, signature, exceptions);
                            if (name.equals("injectIntoClassLoader")) {
                                visitor.visitInsn(Opcodes.RETURN);
                                visitor.visitMaxs(0, 0);
                                return null;
                            }
                            return visitor;
                        }
                    }, ClassReader.EXPAND_FRAMES);
                    return cw.toByteArray();
                }
                return null;
            }
        });
    }
}
