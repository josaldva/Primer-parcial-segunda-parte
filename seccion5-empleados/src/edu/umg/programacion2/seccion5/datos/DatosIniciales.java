package edu.umg.programacion2.seccion5.datos;

import edu.umg.programacion2.seccion5.modelo.Empleado;
import edu.umg.programacion2.seccion5.modelo.Gerente;
import edu.umg.programacion2.seccion5.modelo.Operario;
import edu.umg.programacion2.seccion5.modelo.Vendedor;

/**
 * Nómina de arranque para probar el examen sin tener que capturar datos a
 * mano.
 */
public class DatosIniciales {

	public static Empleado[] obtener() {
		return new Empleado[] {
				new Gerente("Ana López", 8000.0, 500.0),
				new Gerente("Carlos Pérez", 8200.0, 700.0),
				new Vendedor("Marta Ruiz", 3200.0, 15000.0),
				new Operario("José Gómez", 3000.0, 12),
				new Operario("Luisa Marín", 3000.0, 8),
				new Operario("Pedro Duarte", 3100.0, 20)
		};
	}
}
