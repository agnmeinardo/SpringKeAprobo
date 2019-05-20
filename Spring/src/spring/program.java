package spring;

import java.lang.reflect.InvocationTargetException;

public class program {

	public static void main(String[] args) {

		//Factory factoria = new Factory();
		
		// Los injecteds comunes los hace bien
		
		try {
			Auto auto = Factory.getObject(Auto.class);
			//System.out.println(auto.motor.nombre);
			System.out.println(auto.rueda.nombre);
			for ( int i=0; i< auto.butacas.size(); i++){
				System.out.println(auto.butacas.get(i).nombre);
			}
			System.out.println(auto.piston.nombre);
			
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
				| InvocationTargetException e) {
			
			e.printStackTrace();
		}
		
		

	}

}
