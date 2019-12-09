package agent4367;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.AdviceAdapter;

public class AdviceAdapter4367 extends AdviceAdapter {
	
	private String methodName;
	
	public AdviceAdapter4367(int api, MethodVisitor mv, int access, String name, String desc)
	{
		super(api, mv, access, name, desc);
		this.methodName = name;
		//System.out.println("AA initialized");
	}
	
	//[PHASE 2]
	public void visitVarInsn(int opcode, int var)
	{
		if(opStore(opcode))
		{
			//this method pushes the inputted string onto the stack
			mv.visitLdcInsn(methodName + ": " + var + System.lineSeparator());
			
			//this method calls the "visitedVar" method in StatementCoverageData
			//uses the string that was pushed in the last method as the argument for lineExecuted
			mv.visitMethodInsn(INVOKESTATIC, "agent4367/Coverage", "visitedVar", "(Ljava/lang/String;)V", false);
			
			//calls the parent method to actually visit the variable
			super.visitVarInsn(opcode, var);
		}
		
		super.visitVarInsn(opcode, var);
	}
		
	private boolean opStore(int opcode)
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
	}
}
