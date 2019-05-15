package spring;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Factory
{
	
	public <T> T getObject(Class<T> clase) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
    InstantiationException, IllegalAccessException, InvocationTargetException{
		
		Class<?> cls = Class.forName(clase.getName());
		T objetoRaiz = clase.getConstructor().newInstance();
		
		
		// if @Component
		
		procesar(objetoRaiz);
		
		return objetoRaiz;
		
		
	}
	
	public <T> void procesar(T objetoRaiz) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		Field[] campos = objetoRaiz.getClass().getDeclaredFields();
		
		for (int i=0 ; i < campos.length ; i++) {
			
			Field campo = campos[i];
			
			///
			Class<?> clase = campo.getType(); // Devuelve el tipo (la clase) del campo
			Injected injected = campo.getAnnotation(Injected.class); // Devuelve la anotacion del campo pasandole como param la interfaz de la annotation
			
			if (injected != null){
				
				
				
				try {
					
					boolean accessible = campo.isAccessible();
					
					
					campo.setAccessible(true);
					
					Class<?> cls = Class.forName(clase.getName());
					T objeto = null;
					objeto = (T) cls.getConstructor().newInstance();
				
					
					campo.set(objetoRaiz, objeto);
					
					// Chequeo info setteada
					
					System.out.print(objeto.getClass().toString());
					
					campo.setAccessible(accessible);
					
					/*if( injected.count() > 1){
					
						
						
					}
					
					
					*/
					
				
				
				} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException
						| SecurityException e) {
					
					e.printStackTrace();
				}
				

				
			} else {
				campo.set(objetoRaiz, null);
			}
			
			
			
			///
		
			/*
			
			// Tiene anotacion Injected
			if (injected != null){
				
				if(tieneHijos(clase)) { //mal
					
					Class<?> claseHijo = getObject(clase);
					
					campo.set(claseHijo,new campo.getDeclaringClass());
					
				} else {
					
					= new campo.getType();
					
					// Verifico los casos
					
					if (injected.count() == 1 && !injected.singleton()) {
                    	Class<?> clase = campo.getType(); // Devuelve el tipo. opc: param: Field name
                    	List<clase> lista2 = new ArrayList<clase>();
                    	
                    	
                    	System.out.println(injected.count());
                    	
                    	for( int i = 1 ; i <= injected.count() ; i++ ){
                    		lista2.add(new campo.getType());
                    	}
                    	
                    	
                    	

                    } else if(injected.implementation() == "interface"){
                        System.out.println(injected.implementation());
                    } else if(injected.singleton() == 12){
                    	System.out.println(injected.singleton());
                    }
					
				}
				
				}*/
		}
		
	}
	
}