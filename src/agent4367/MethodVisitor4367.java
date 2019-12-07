package agent4367;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

class MethodVisitor4367 extends MethodVisitor implements Opcodes {

	String className;
	
    public MethodVisitor4367(final MethodVisitor mv, String className_original)
    {
    	//constructs the method visitor using the asm5 version and the method visitor
    	super(ASM5, mv);
    	this.className = className_original;
    	//System.out.println("Method Visitor initialized");
    }
		
	public void visitLineNumber(int lineNum, Label start) 
	{		
		//this method pushes the inputted string onto the stack
		mv.visitLdcInsn(className + ": " + lineNum + System.lineSeparator());
		
		//this method calls the "lineExecuted" method in StatementCoverageData
		//uses the string that was pushed in the last method as the argument for lineExecuted
		mv.visitMethodInsn(INVOKESTATIC, "agent4367/Coverage", "visitedLine", "(Ljava/lang/String;)V", false);
		
		//calls the parent method to actually visit the line
		super.visitLineNumber(lineNum, start);
		
		//System.out.println("Line visited");
	}
}