package com.yz.jvm.bytecode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import net.sf.cglib.asm.ClassWriter;
import net.sf.cglib.asm.MethodVisitor;
import net.sf.cglib.asm.Opcodes;

public class MytestMain {
	public static void main(String[] args) {
		// asmGenerateClass();

		// loadClass();

		// javassistGenerateClass();
	}

	public static void loadClass() {
		// 读取本地的class文件内的字节码，转换成字节码数组
		try {
			File file = new File(".");
			// InputStream input = new FileInputStream(
			// file.getCanonicalPath()
			// + "\\bin\\com\\yz\\bytecode\\Programmer.class");
			InputStream input = new FileInputStream("d:\\Programmer.class");
			byte[] result = new byte[1024];
			int count = input.read(result);
			// 使用自定义的类加载器将 byte字节码数组转换为对应的class对象
			MyClassLoader loader = new MyClassLoader();
			Class<?> clazz = loader.defineMyClass(result, 0, count);
			// 测试加载是否成功，打印class 对象的名称
			System.out.println(clazz.getCanonicalName());
			Method[] aaMethods = clazz.getMethods();
			for (Method method : aaMethods) {
				System.out.println(method.getName());
			}

			// 实例化一个Programmer对象
			Object o = clazz.newInstance();
			// 调用Programmer的code方法
			clazz.getMethod("code", null).invoke(o, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void asmGenerateClass() {
		ClassWriter classWriter = new ClassWriter(0);
		// 通过visit方法确定类的头部信息
		classWriter.visit(Opcodes.V1_6,// java版本
				Opcodes.ACC_PUBLIC,// 类修饰符
				"Programmer", // 类的全限定名
				null, "java/lang/Object", null);

		// 创建构造函数
		MethodVisitor mv = classWriter.visitMethod(Opcodes.ACC_PUBLIC,
				"<init>", "()V", null, null);
		mv.visitCode();
		mv.visitVarInsn(Opcodes.ALOAD, 0);
		mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>",
				"()V");
		mv.visitInsn(Opcodes.RETURN);
		mv.visitMaxs(1, 1);
		mv.visitEnd();

		// 定义code方法
		MethodVisitor methodVisitor = classWriter.visitMethod(
				Opcodes.ACC_PUBLIC, "code", "()V", null, null);
		methodVisitor.visitCode();
		methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System",
				"out", "Ljava/io/PrintStream;");
		methodVisitor.visitLdcInsn("test generate Class.....");
		methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL,
				"java/io/PrintStream", "println", "(Ljava/lang/String;)V");
		methodVisitor.visitInsn(Opcodes.RETURN);
		methodVisitor.visitMaxs(2, 2);
		methodVisitor.visitEnd();
		classWriter.visitEnd();
		// 使classWriter类已经完成
		// 将classWriter转换成字节数组写到文件里面去
		byte[] data = classWriter.toByteArray();
		File file = new File("D://Programmer.class");
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(file);
			fout.write(data);
			fout.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	}

	public static void javassistGenerateClass() {
		ClassPool pool = ClassPool.getDefault();
		try {
			// 创建Programmer类
			CtClass cc = pool.makeClass("com.samples.Programmer");
			// 定义code方法
			CtMethod method = CtNewMethod.make("public void code(){}", cc);
			// 插入方法代码
			method.insertBefore("System.out.println(\"javassist generate class.....\");");
			cc.addMethod(method);
			// 保存生成的字节码
			cc.writeFile("d://temp");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
