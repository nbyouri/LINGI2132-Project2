package lingi2132;

// Generate bytecode for the following java code:

//package packageOfClassToGenerate;
//
//public class ClassToGenerate {
//    public static int evenoddpow(int a, int b) {
//        int c = 1;
//        while (b > 0) {
//            c = c * a;
//            b = b - 1;
//        }
//        if (c % 2 == 0) {
//            return 0;
//        } else {
//            return 42;
//        }
//    }
//
//}

import jminusminus.CLEmitter;

import java.util.ArrayList;

import static jminusminus.CLConstants.*;

public class Generator extends GlobalGenerator {
    public Generator(String out) {
        super(out);
    }

    public void generateClass() {
        CLEmitter cle = new CLEmitter(true);
        cle.destinationDir(this.outputDir);

        ArrayList<String> accessFlags = new ArrayList<String>();

        // Add Factorial class
        accessFlags.add("public");
        String className = "packageOfClassToGenerate/ClassToGenerate";
//        System.out.println(className);
        cle.addClass(accessFlags, className, "java/lang/Object", null, false);

        // add implicit no-arg constructor
        cle.addMethod(accessFlags, "<init>", "()V", null, false);
        cle.addNoArgInstruction(ALOAD_0);
        cle.addMemberAccessInstruction(INVOKESPECIAL, "java/lang/Object",
                "<init>", "()V");
        cle.addNoArgInstruction(RETURN);

        // add evenoddpow method
        accessFlags.add("static");
        cle.addMethod(accessFlags, "evenoddpow", "(II)I", null, false);
        String whileLabel = cle.createLabel();
        String ifLabel = cle.createLabel();
        String elseLabel = cle.createLabel();

            // int c = 1;
            cle.addNoArgInstruction(ICONST_1);
            cle.addNoArgInstruction(ISTORE_2);

            // while (b > 0) {
            cle.addLabel(whileLabel);
            cle.addNoArgInstruction(ILOAD_1);
            cle.addNoArgInstruction(ICONST_0);
            cle.addBranchInstruction(IF_ICMPLE, ifLabel);
                // c = c * a;
                cle.addNoArgInstruction(ILOAD_2);
                cle.addNoArgInstruction(ILOAD_0);
                cle.addNoArgInstruction(IMUL);
                cle.addNoArgInstruction(ISTORE_2);
                // b = b - 1;
                cle.addNoArgInstruction(ILOAD_1);
                cle.addNoArgInstruction(ICONST_1);
                cle.addNoArgInstruction(ISUB);
                cle.addNoArgInstruction(ISTORE_1);
                cle.addBranchInstruction(GOTO, whileLabel);
            // }
            // if (c % 2 == 0) {
            cle.addLabel(ifLabel);
            cle.addNoArgInstruction(ILOAD_2);
            cle.addNoArgInstruction(ICONST_2);
            cle.addNoArgInstruction(IREM);
            cle.addNoArgInstruction(ICONST_0);
            cle.addBranchInstruction(IF_ICMPNE, elseLabel);
                // return 0;
                cle.addNoArgInstruction(ICONST_0);
                cle.addNoArgInstruction(IRETURN);
            // } else {
                // return 42;
                cle.addLabel(elseLabel);
                cle.addOneArgInstruction(BIPUSH, 42);
                cle.addNoArgInstruction(IRETURN);
            // }
//
//        // add a main for debugging purposes
//        accessFlags.add("static");
//        cle.addMethod(accessFlags, "main", "([Ljava/lang/String;)V", null, false);
//
//        // instanciate the class
//        cle.addReferenceInstruction(NEW, "ClassToGenerate");
//        cle.addNoArgInstruction(DUP);
//        cle.addMemberAccessInstruction(INVOKESPECIAL, "ClassToGenerate", "<init>",
//                "()V");
//        cle.addNoArgInstruction(ASTORE_1);
//        cle.addNoArgInstruction(ALOAD_1);
//
//        // call method
//        cle.addNoArgInstruction(ICONST_3);
//        cle.addNoArgInstruction(ICONST_2);
//        cle.addMemberAccessInstruction(INVOKEVIRTUAL, "ClassToGenerate", "evenoddpow",
//                "(II)I");
//        cle.addNoArgInstruction(ISTORE_2);
//
//
//        // println result
//        cle.addMemberAccessInstruction(GETSTATIC, "java/lang/System", "out",
//                "Ljava/io/PrintStream;");
//        cle.addNoArgInstruction(ILOAD_2);
//        cle.addMemberAccessInstruction(INVOKEVIRTUAL, "java/io/PrintStream",
//                "println", "(I)V");
//        cle.addNoArgInstruction(RETURN);

        cle.write();

    }
}