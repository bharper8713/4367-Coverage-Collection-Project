package agent4367;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.ClassReader;

public class ClassTransformer4367 implements ClassFileTransformer{

    @Override
    //transforms the class files of the projects into bytecode
    public byte[] transform(ClassLoader classLoader, String project, Class<?> aClass, ProtectionDomain protectionDomain, byte[] bytes) throws IllegalClassFormatException 
    {
    	//TODO add the rest of the 10 projects
    	//NOTE: This project has been mainly tested on joda-time
		if (project.startsWith("org/joda/time") || project.startsWith("org/apache/commons/dbutils"))				
		{	
			ClassReader reader = new ClassReader(bytes);
			ClassWriter writer = new ClassWriter(reader, ClassWriter.COMPUTE_MAXS);
			ClassVisitor4367 visitor = new ClassVisitor4367(writer);
			
			//System.out.println("Visitor is about to start");
			reader.accept(visitor, 0);
			return writer.toByteArray();
		}	
		return bytes;
    }
}