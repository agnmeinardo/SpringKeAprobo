package spring;

import java.util.ArrayList;
import java.util.List;
 
public class Auto 
{ 
	
   public String nombre = "MiAuto";

   @Injected
   public Motor motor; 
    
   @Injected 
   public Rueda rueda; 
    
   @Injected(count=4) 
   public List<Butaca> butacas; // Falta hacer Butaca[]
   
   @Injected(singleton=true)
   public Piston piston; // singleton o singleton=true
    
   //@Injected(implementation=AutostereoSonyImple.class) 
   //private Autostereo autostereo; 
 
   // ...  

} 
