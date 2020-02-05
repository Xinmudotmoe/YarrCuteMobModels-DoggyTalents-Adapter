package moe.xinmu.patchouli.doggytalents;

import org.objectweb.asm.*;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.Objects;

public class PatchRenderCMMRWolf implements ClassTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (Objects.nonNull(className) && className.equals("yarrmateys/cuteMobModelsRemake/mobs/RenderCMMRWolf")) {
            ClassReader cr = new ClassReader(classfileBuffer);
            ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_FRAMES);
            cr.accept(new ClassVisitor(Opcodes.ASM5, cw) {
                @Override
                public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                    desc = desc.replace("net/minecraft/entity/passive/EntityWolf", "net/minecraft/entity/passive/EntityTameable");
                    MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
                    if (name.equals("getTailRotation") && desc.equals("(Lnet/minecraft/entity/passive/EntityTameable;F)F")) {
                        GeneratorAdapter ga = new GeneratorAdapter(mv, access, name, desc);
                        ga.push(0);
                        ga.loadArg(0);
                        ga.instanceOf(Type.getType("Lnet/minecraft/entity/passive/EntityWolf;"));
                        Label label1 = ga.newLabel();
                        ga.ifCmp(Type.INT_TYPE, Opcodes.IFEQ, label1);
                        ga.loadArg(0);
                        ga.checkCast(Type.getType("Lnet/minecraft/entity/passive/EntityWolf;"));
                        ga.invokeVirtual(Type.getType("Lnet/minecraft/entity/passive/EntityWolf;"), new Method("func_70920_v", "()F"));
                        ga.returnValue();
                        ga.visitLabel(label1);
                        ga.loadArg(0);
                        ga.checkCast(Type.getType("Ldoggytalents/entity/EntityDog;"));
                        ga.invokeVirtual(Type.getType("Ldoggytalents/entity/EntityDog;"), new Method("getTailRotation", "()F"));
                        ga.returnValue();
                        ga.endMethod();
                        return null;
                    }
                    if (name.equals("getEntityTextures")) {
                        return new MethodVisitor(Opcodes.ASM5, mv) {
                            @Override
                            public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
                                desc = desc.replace("net/minecraft/entity/passive/EntityWolf", "net/minecraft/entity/passive/EntityTameable");
                                owner = owner.replace("net/minecraft/entity/passive/EntityWolf", "net/minecraft/entity/passive/EntityTameable");
                                if (name.equals("func_70919_bu")) {
                                    Label label1 = new Label();
                                    Label label2 = new Label();
                                    visitTypeInsn(Opcodes.INSTANCEOF, "net/minecraft/entity/passive/EntityWolf");
                                    visitJumpInsn(Opcodes.IFEQ, label1);
                                    visitVarInsn(Opcodes.ALOAD, 1);
                                    super.visitTypeInsn(Opcodes.CHECKCAST, "net/minecraft/entity/passive/EntityWolf");
                                    super.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "net/minecraft/entity/passive/EntityWolf", name, desc, false);
                                    visitJumpInsn(Opcodes.GOTO, label2);
                                    visitLabel(label1);
//                                    visitLdcInsn(0);
                                    visitVarInsn(Opcodes.ALOAD, 1);
                                    super.visitTypeInsn(Opcodes.CHECKCAST, "doggytalents/entity/EntityDog");
                                    super.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "doggytalents/entity/EntityDog", "getMode", "()Ldoggytalents/entity/features/ModeFeature$EnumMode;", false);
                                    visitFieldInsn(Opcodes.GETSTATIC, "doggytalents/entity/features/ModeFeature$EnumMode", "BERSERKER", "Ldoggytalents/entity/features/ModeFeature$EnumMode;");
                                    super.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "doggytalents/entity/features/ModeFeature$EnumMode", "equals", "(Ljava/lang/Object;)Z", false);

                                    visitJumpInsn(Opcodes.GOTO, label2);
                                    visitLabel(label2);
                                    return;
                                }
                                super.visitMethodInsn(opcode, owner, name, desc, itf);
                            }

                            @Override
                            public void visitTypeInsn(int opcode, String type) {
                                if (opcode == Opcodes.CHECKCAST && type.equals("net/minecraft/entity/passive/EntityWolf")) {
                                    type = "net/minecraft/entity/passive/EntityTameable";
                                }
                                super.visitTypeInsn(opcode, type);
                            }
                        };
                    }
                    return new MethodVisitor(Opcodes.ASM5, mv) {
                        @Override
                        public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
                            desc = desc.replace("net/minecraft/entity/passive/EntityWolf", "net/minecraft/entity/passive/EntityTameable");
                            owner = owner.replace("net/minecraft/entity/passive/EntityWolf", "net/minecraft/entity/passive/EntityTameable");

                            super.visitMethodInsn(opcode, owner, name, desc, itf);
                        }

                        @Override
                        public void visitTypeInsn(int opcode, String type) {
                            if (opcode == Opcodes.CHECKCAST && type.equals("net/minecraft/entity/passive/EntityWolf")) {
                                type = "net/minecraft/entity/passive/EntityTameable";
                            }
                            super.visitTypeInsn(opcode, type);
                        }
                    };
                }
            }, ClassReader.EXPAND_FRAMES);
            return cw.toByteArray();
        }
        return null;
    }
}
