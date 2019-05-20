package spring;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Factory
{
	
	
	
	public static <T> T getObject(Class<T> clase) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
    InstantiationException, IllegalAccessException, InvocationTargetException{
		
		Class<?> cls = Class.forName(clase.getName());
		T objetoRaiz = clase.getConstructor().newInstance();
		
		
		// if @Component
		
		procesar(objetoRaiz);
		
		return objetoRaiz;
		
		
	}
	
	private static <T> void procesar(T objetoRaiz) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		Field[] campos = objetoRaiz.getClass().getDeclaredFields();
		
		ArrayList singletons = new ArrayList<>();
		
		for (int i=0 ; i < campos.length ; i++) {
			
			Field campo = campos[i];
			
			System.out.println(campo.getType().toString()); // List
			
			
			Class<?> clase = campo.getType(); // Devuelve el tipo (la clase) del campo
			
			Injected injected = campo.getAnnotation(Injected.class); // Devuelve la anotacion del campo pasandole como param la interfaz de la annotation
			
			
			if (injected != null){
				
				
				
				try {
					
					// Modifico para que el campo pueda ser modificable/accesible
					boolean accessible = campo.isAccessible();
					campo.setAccessible(true);
					
					// Chequeo el caso de que sea una lista
					if (injected.count() > 1) {
					
						// Acá obtengo de qué tipo tiene que ser los elementos de la lista
						ParameterizedType tipo = (ParameterizedType)campo.getGenericType();
						Class<?> specificListClass = (Class<?>) tipo.getActualTypeArguments()[0];
						System.out.println(specificListClass);
			        
						List lista = new ArrayList();
						
						for (int j=1; j<= injected.count(); j++){
							T objeto = null;
							objeto = (T) specificListClass.getConstructor().newInstance();
							lista.add(objeto);
						}
						
						campo.set(objetoRaiz, lista);
						
					} else {
						// Genero la clase e instancio el objeto a usar
						Class<?> cls = Class.forName(clase.getName());
						//System.out.println(clase.getName());
						T objeto = null;
						objeto = (T) cls.getConstructor().newInstance();
						
						
						if(injected.singleton()){
							singletons.add(objeto);
						}
						
						campo.set(objetoRaiz, objeto);
					}
					
					
					
				
					
					
					
					
					
					
					
					// Chequeo info setteada
					
					campo.setAccessible(accessible);
					
					/*if( injected.count() > 1){
					
						
						
					}
					
					
					*/

				
				} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException
						| SecurityException e) {
					
					e.printStackTrace();
				}
				

				
			} else {
				
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