package edu.umg.programacion2.seccion5;

import java.util.Scanner;

import edu.umg.programacion2.seccion5.datos.DatosIniciales;
import edu.umg.programacion2.seccion5.repositorio.GestionEmpleados;

/**
 * Menú del examen: carga la nómina inicial y permite probar los métodos de
 * GestionEmpleados. No necesitas modificar este archivo; las 3 preguntas
 * prácticas (más el reto opcional) se resuelven directamente en
 * GestionEmpleados, y este menú solo sirve para que puedas probar tu
 * propia implementación mientras la escribes.
 */
public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		GestionEmpleados gestion = new GestionEmpleados();
		gestion.cargarTodos(DatosIniciales.obtener());
		System.out.println("Nómina cargada: " + gestion.total() + " empleados.");

		boolean salir = false;
		while (!salir) {
			mostrarMenu();
			String opcion = teclado.nextLine().trim();

			switch (opcion) {
			case "1":
				gestion.imprimirFichas();
				break;
			case "2":
				System.out.printf("Nómina total: Q%.2f%n", gestion.calcularNominaTotal());
				break;
			case "3":
				System.out.println("Empleado con mayor salario: " + gestion.empleadoConMayorSalario());
				break;
			case "4":
				gestion.mostrarConteoPorTipo();
				break;
			case "5":
				gestion.mostrarNominaPorTipo();
				break;
			case "0":
				salir = true;
				break;
			default:
				System.out.println("Opción no válida.");
			}
		}

		teclado.close();
		System.out.println("Fin del examen.");
	}

	private static void mostrarMenu() {
		System.out.println();
		System.out.println("=== Sección 5 - Sistema de Nómina de Empleados ===");
		System.out.println("1) Listar fichas de todos los empleados");
		System.out.println("2) Mostrar nómina total (Pregunta práctica 1)");
		System.out.println("3) Mostrar empleado con mayor salario (Pregunta práctica 2)");
		System.out.println("4) Mostrar conteo de empleados por tipo (Pregunta práctica 3)");
		System.out.println("5) [Bonus] Mostrar nómina agrupada por tipo");
		System.out.println("0) Salir");
		System.out.print("Opción: ");
	}
}
