package agent4367;

import java.lang.instrument.Instrumentation;

public class Agent
{	
	public static void premain(String args, Instrumentation inst)
    {
        inst.addTransformer(new ClassTransformer4367()); 
        //System.out.println("Transformer initialized");
    }
}