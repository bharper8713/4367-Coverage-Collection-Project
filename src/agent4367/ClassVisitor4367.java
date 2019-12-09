package agent4367;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.AdviceAdapter;

public class ClassVisitor4367 extends ClassVisitor {

    String className;
	
	public ClassVisitor4367(final ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }
	
    //visits the class header
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) 
    {
        className = name;
        super.visit(version, access, name, signature, superName, interfaces);
        //System.out.println("Header visited");
    }

    //visits a method of the class with a method visitor
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) 
    {
		MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        
		if(mv == null)
			return mv = null;
		else
			return mv = new MethodVisitor4367(mv,className);
	}
    
	//visits a method of the class with a method visitor
	/*public MethodVisitor hookMethod(int access, String name, String desc, String signature, String[] exceptions, MethodVisitor mv) 
	{
		mv = super.visitMethod(access, name, desc, signature, exceptions);
        
		if(mv == null)
			return mv = null;
		else
		{
			System.out.println("hookMethod worked");
			return new AdviceAdapter4367(Opcodes.ASM5, mv, access, name, desc);	
		}
			
	}*/
}
