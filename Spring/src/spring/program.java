package spring;

import java.lang.reflect.InvocationTargetException;

public class program {

	public static void main(String[] args) {

		Factory factoria = new Factory();
		
		
		try {
			Auto auto = factoria.getObject(Auto.class);
			System.out.println(auto.nombre);
			System.out.println(auto.motor.nombre);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
				| InvocationTargetException e) {
			
			e.printStackTrace();
		}
		
		

	}

}
