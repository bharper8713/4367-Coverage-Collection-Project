package agent4367;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.AdviceAdapter;

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
		
		//this method calls the "visitedLine" method in StatementCoverageData
		//uses the string that was pushed in the last method as the argument for lineExecuted
		mv.visitMethodInsn(INVOKESTATIC, "agent4367/Coverage", "visitedLine", "(Ljava/lang/String;)V", false);
		
		//calls the parent method to actually visit the line
		super.visitLineNumber(lineNum, start);
		
		//System.out.println("Line visited");
	}
	
	public void visitLocalVariable(String varName, String description, String sig, Label start, Label end, int index)
	{
		//this method pushes the inputted string onto the stack
				mv.visitLdcInsn(className + ": " + varName + System.lineSeparator());
				
				//this method calls the "visitedVar" method in StatementCoverageData
				//uses the string that was pushed in the last method as the argument for lineExecuted
				mv.visitMethodInsn(INVOKESTATIC, "agent4367/Coverage", "visitedVar", "(Ljava/lang/String;)V", false);
				
				//calls the parent method to actually visit the line
				super.visitLocalVariable(varName, description, sig, start, end, index);
	}
	
    /*public AdviceAdapter visitVarInsn(int access, String name, String desc, String signature, String[] exceptions) 
    {
		AdviceAdapter aa = super.visitVarInsn();
        return aa == null ? null : new AdviceAdapter4367(Opcodes.ASM5, mv, access, name, desc);
    }*/
	
    
    /*public void visitVarInsn(int opcode, int var)
	{
		if(opStore(opcode))
		{
			
			System.out.println("visitvarinsn working");
			//this method pushes the inputted string onto the stack
			//TODO, replace class name with method name
			mv.visitLdcInsn(className + ": " + var + System.lineSeparator());
			
			//this method calls the "lineExecuted" method in StatementCoverageData
			//uses the string that was pushed in the last method as the argument for lineExecuted
			mv.visitMethodInsn(INVOKESTATIC, "agent4367/Coverage", "visitedVar", "(Ljava/lang/String;)V", false);
			
			//calls the parent method to actually visit the variable
			super.visitVarInsn(opcode, var);
		}
		
		//super.visitVarInsn(opcode, var);
	}*/
		
	/*private boolean opStore(int opcode)
	{
		//if the bytecode instruction is a store instruction, return true
		switch (opcode)
		{
		case ISTORE:
		case LSTORE:	
		case FSTORE:
		case DSTORE:
		case ASTORE:
			return true;
		default:
			return false;
		}	
	}*/
}