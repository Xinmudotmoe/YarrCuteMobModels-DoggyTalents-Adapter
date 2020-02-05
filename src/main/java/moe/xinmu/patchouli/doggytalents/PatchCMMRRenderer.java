package moe.xinmu.patchouli.doggytalents;

import org.objectweb.asm.*;

import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.Objects;

public class PatchCMMRRenderer implements ClassTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (Objects.nonNull(className) && className.equals("yarrmateys/cuteMobModelsRemake/CMMRRenderer")) {
            ClassReader cr = new ClassReader(classfileBuffer);
            ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_FRAMES);
            cr.accept(new ClassVisitor(Opcodes.ASM5, cw) {
                @Override
                public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                    MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
                    if (name.equals("init")) {
                        return new MethodVisitor(Opcodes.ASM5, mv) {
                            boolean conversion = false;
                            boolean barrier = false;

                            @Override
                            public void visitLdcInsn(Object cst) {
                                if (cst instanceof Type) {
                                    if (!barrier) {
                                        if (((Type) cst).getClassName().equals("net.minecraft.entity.passive.EntityWolf")) {
                                            conversion = true;
                                            barrier = true;
                                        }
                                    }
                                }
                                super.visitLdcInsn(cst);
                            }

                            @Override
                            public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
                                super.visitMethodInsn(opcode, owner, name, desc, itf);
                                if (conversion) {
                                    if (opcode == Opcodes.INVOKESTATIC && name.equals("registerEntityRenderingHandler")) {
                                        conversion = false;
                                        visitLdcInsn(Type.getType("Ldoggytalents/entity/EntityDog;"));
                                        visitTypeInsn(Opcodes.NEW, Type.getType("Lyarrmateys/cuteMobModelsRemake/mobs/RenderCMMRWolf;").getInternalName());
                                        visitInsn(Opcodes.DUP);
                                        visitTypeInsn(Opcodes.NEW, Type.getType("Lyarrmateys/cuteMobModelsRemake/mobs/ModelCMMRWolf;").getInternalName());
                                        visitInsn(Opcodes.DUP);
                                        visitLdcInsn(.0f);
                                        visitLdcInsn(.0f);
                                        super.visitMethodInsn(Opcodes.INVOKESPECIAL, Type.getType("Lyarrmateys/cuteMobModelsRemake/mobs/ModelCMMRWolf;").getInternalName(), "<init>", "(FF)V", false);
                                        visitLdcInsn(.3f);
                                        super.visitMethodInsn(Opcodes.INVOKESPECIAL, Type.getType("Lyarrmateys/cuteMobModelsRemake/mobs/RenderCMMRWolf;").getInternalName(), "<init>", "(Lyarrmateys/cuteMobModelsRemake/mobs/ModelCMMRWolf;F)V", false);
                                        super.visitMethodInsn(Opcodes.INVOKESTATIC, Type.getType("Lnet/minecraftforge/fml/client/registry/RenderingRegistry;").getInternalName(), "registerEntityRenderingHandler", "(Ljava/lang/Class;Lnet/minecraft/client/renderer/entity/Render;)V", false);
                                    }
                                }
                            }
                        };
                    }

                    return mv;
                }
            }, ClassReader.EXPAND_FRAMES);
            return cw.toByteArray();
        }
        return null;
    }
}
