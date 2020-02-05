package moe.xinmu.patchouli.doggytalents;

import org.objectweb.asm.*;

import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.Objects;

public class PatchLayerCMMRDoggyCollar implements ClassTransformer{
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        try {
            if (Objects.nonNull(className) && className.equals("yarrmateys/cuteMobModelsRemake/mobs/layers/LayerCMMRDoggyCollar")) {
                ClassReader cr = new ClassReader(classfileBuffer);
                ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_FRAMES);
                cr.accept(new ClassVisitor(Opcodes.ASM5, cw) {
                    @Override
                    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
                        if (name.equals("func_177145_a")) {
                            return new MethodVisitor(Opcodes.ASM5, mv) {
                                @Override
                                public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
                                    if (name.equals("func_175546_cu")) {
                                        visitInsn(Opcodes.POP);
                                        visitLdcInsn(14);
                                        super.visitMethodInsn(Opcodes.INVOKESTATIC, "net/minecraft/item/EnumDyeColor", "func_176766_a", "(I)Lnet/minecraft/item/EnumDyeColor;", false);
                                        return;
                                    }
                                    super.visitMethodInsn(opcode, owner, name, desc, itf);
                                }
                            };
                        }
                        return mv;
                    }
                }, ClassReader.EXPAND_FRAMES);
                return cw.toByteArray();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
