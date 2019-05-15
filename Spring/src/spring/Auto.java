package spring;

import java.util.ArrayList;
import java.util.List;
 
public class Auto 
{ 
	
   public String nombre = "MiAuto";

   @Injected 
   public Motor motor; 
    
   //@Injected(count=4) 
   //private Rueda[] ruedas; 
    
   //@Injected(count=4) 
   //private List<Butaca> butacas; 
    
   //@Injected(implementation=AutostereoSonyImple.class) 
   //private Autostereo autostereo; 
 
   // ...  

} 
