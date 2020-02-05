package moe.xinmu.patchouli.doggytalents;

import org.objectweb.asm.*;

import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.Objects;

public class PatchModelCMMRWolf implements ClassTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (Objects.nonNull(className) && className.equals("yarrmateys/cuteMobModelsRemake/mobs/ModelCMMRWolf")) {
            ClassReader cr = new ClassReader(classfileBuffer);
            ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_FRAMES);
            cr.accept(new ClassVisitor(Opcodes.ASM5, cw) {
                @Override
                public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                    desc = desc.replace("net/minecraft/entity/passive/EntityWolf", "net/minecraft/entity/passive/EntityTameable");
                    MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
                    if (name.equals("func_78086_a")) {
                        mv = new MethodVisitor(Opcodes.ASM5, mv) {
                            @Override
                            public void visitTypeInsn(int opcode, String type) {
                                if (opcode == Opcodes.CHECKCAST) {
                                    return;
                                }
                                super.visitTypeInsn(opcode, type);
                            }

                            @Override
                            public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
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
                                    visitVarInsn(Opcodes.ALOAD, 1);
                                    super.visitTypeInsn(Opcodes.CHECKCAST, "doggytalents/entity/EntityDog");
                                    super.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "doggytalents/entity/EntityDog", "func_70909_n", desc, false);
                                    visitJumpInsn(Opcodes.GOTO, label2);
                                    visitLabel(label2);
                                    return;
                                }
                                if (name.equals("func_70906_o")) {
                                    super.visitTypeInsn(Opcodes.CHECKCAST, "net/minecraft/entity/passive/EntityTameable");
                                    owner = "net/minecraft/entity/passive/EntityTameable";
                                }

                                if (name.equals("func_70917_k")) {
                                    Label label1 = new Label();
                                    Label label2 = new Label();
                                    visitVarInsn(Opcodes.FSTORE, 9);
                                    visitTypeInsn(Opcodes.INSTANCEOF, "net/minecraft/entity/passive/EntityWolf");
                                    visitJumpInsn(Opcodes.IFEQ, label1);
                                    visitVarInsn(Opcodes.ALOAD, 1);
                                    super.visitTypeInsn(Opcodes.CHECKCAST, "net/minecraft/entity/passive/EntityWolf");
                                    visitVarInsn(Opcodes.FLOAD, 9);
                                    super.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "net/minecraft/entity/passive/EntityWolf", name, desc, false);
                                    visitJumpInsn(Opcodes.GOTO, label2);
                                    visitLabel(label1);
                                    visitVarInsn(Opcodes.ALOAD, 1);
                                    super.visitTypeInsn(Opcodes.CHECKCAST, "doggytalents/entity/EntityDog");
                                    visitVarInsn(Opcodes.FLOAD, 9);
                                    super.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "doggytalents/entity/EntityDog", "getInterestedAngle", desc, false);
                                    visitJumpInsn(Opcodes.GOTO, label2);
                                    visitLabel(label2);
                                    return;
                                }
                                if (name.equals("func_70923_f")) {
                                    Label label1 = new Label();
                                    Label label2 = new Label();
                                    visitVarInsn(Opcodes.FSTORE, 9);
                                    visitVarInsn(Opcodes.FSTORE, 10);
                                    visitTypeInsn(Opcodes.INSTANCEOF, "net/minecraft/entity/passive/EntityWolf");
                                    visitJumpInsn(Opcodes.IFEQ, label1);
                                    visitVarInsn(Opcodes.ALOAD, 1);
                                    super.visitTypeInsn(Opcodes.CHECKCAST, "net/minecraft/entity/passive/EntityWolf");
                                    visitVarInsn(Opcodes.FLOAD, 10);
                                    visitVarInsn(Opcodes.FLOAD, 9);
                                    super.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "net/minecraft/entity/passive/EntityWolf", name, desc, false);
                                    visitJumpInsn(Opcodes.GOTO, label2);
                                    visitLabel(label1);
                                    visitVarInsn(Opcodes.ALOAD, 1);
                                    super.visitTypeInsn(Opcodes.CHECKCAST, "doggytalents/entity/EntityDog");
                                    visitVarInsn(Opcodes.FLOAD, 10);
                                    visitVarInsn(Opcodes.FLOAD, 9);
                                    super.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "doggytalents/entity/EntityDog", "getShakeAngle", desc, false);
                                    visitJumpInsn(Opcodes.GOTO, label2);
                                    visitLabel(label2);
                                    return;
                                }

                                super.visitMethodInsn(opcode, owner, name, desc, itf);
                            }
                        };
                        return mv;
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
        return null;
    }
}
