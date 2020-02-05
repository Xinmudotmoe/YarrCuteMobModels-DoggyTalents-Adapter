package moe.xinmu.patchouli.doggytalents;

import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.*;
import org.objectweb.asm.commons.Method;

import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.Objects;

public class PatchLayerCMMRWolfCollar implements ClassTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        try {
            if (Objects.nonNull(className) && className.equals("yarrmateys/cuteMobModelsRemake/mobs/layers/LayerCMMRWolfCollar")) {
                ClassReader cr = new ClassReader(classfileBuffer);
                ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_FRAMES);
                cr.accept(new ClassVisitor(Opcodes.ASM5, cw) {
                    @Override
                    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                        desc = desc.replace("net/minecraft/entity/passive/EntityWolf", "net/minecraft/entity/passive/EntityTameable");
                        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
                        if (name.equals("func_177145_a")) {
                            return new MethodVisitor(Opcodes.ASM5, mv) {
                                @Override
                                public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
                                    desc = desc.replace("net/minecraft/entity/passive/EntityWolf", "net/minecraft/entity/passive/EntityTameable");
                                    owner = owner.replace("net/minecraft/entity/passive/EntityWolf", "net/minecraft/entity/passive/EntityTameable");
                                    if (name.equals("func_70909_n")) {
                                        owner = "net/minecraft/entity/passive/EntityTameable";
                                    }
                                    if (name.equals("func_82150_aj")) {
                                        owner = "net/minecraft/entity/passive/EntityTameable";
                                    }
                                    if (name.equals("func_175546_cu")) {
                                        visitInsn(Opcodes.POP);
                                        visitLdcInsn(14);
                                        super.visitMethodInsn(Opcodes.INVOKESTATIC, "net/minecraft/item/EnumDyeColor", "func_176766_a", "(I)Lnet/minecraft/item/EnumDyeColor;", false);
                                        return;
                                    }
                                    super.visitMethodInsn(opcode, owner, name, desc, itf);
                                }

                                @Override
                                public void visitTypeInsn(int opcode, String type) {
                                    if (opcode == Opcodes.CHECKCAST && type.equals("net/minecraft/entity/passive/EntityWolf")) {
                                        return;
                                    }
                                    super.visitTypeInsn(opcode, type);
                                }
                            };
                        }
                        if (name.equals("func_70919_bu")) {
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
//                                        visitLdcInsn(0);
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
                                        return;
                                    }
                                    super.visitTypeInsn(opcode, type);
                                }
                            };
                        }
                        if (name.equals("func_177141_a")) {
                            GeneratorAdapter ga = new GeneratorAdapter(mv, access, name, desc);
                            ga.loadThis();
                            ga.loadArg(0);
                            ga.checkCast(Type.getType("Lnet/minecraft/entity/passive/EntityTameable;"));
                            ga.loadArg(1);
                            ga.loadArg(2);
                            ga.loadArg(3);
                            ga.loadArg(4);
                            ga.loadArg(5);
                            ga.loadArg(6);
                            ga.loadArg(7);
                            ga.invokeVirtual(Type.getType("Lyarrmateys/cuteMobModelsRemake/mobs/layers/LayerCMMRWolfCollar;"), new Method("func_177145_a", "(Lnet/minecraft/entity/passive/EntityTameable;FFFFFFF)V"));
                            ga.returnValue();
                            ga.endMethod();
                            return null;
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
                                    return;
                                }
                                super.visitTypeInsn(opcode, type);
                            }
                        };
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
