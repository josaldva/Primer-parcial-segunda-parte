package edu.umg.programacion2.seccion5.repositorio;

import edu.umg.programacion2.seccion5.modelo.Empleado;

/**
 * Responsabilidad única de esta clase: guardar y consultar empleados. NO
 * sabe cómo se calcula el salario de nadie -- eso es responsabilidad de
 * cada subclase de Empleado (polimorfismo). Si mañana se agrega un nuevo
 * tipo de empleado, esta clase no cambia en absoluto.
 * <p>
 * IMPORTANTE: esta clase guarda los empleados en un arreglo (arreglo de
 * tamaño fijo), no en un ArrayList ni en ninguna otra colección de
 * java.util. Eso significa que la "nómina" tiene una capacidad máxima
 * definida al crear el objeto, e igual que con cualquier arreglo, hay que
 * lleva la cuenta manualmente de cuántos espacios están realmente
 * ocupados (por eso existe el contador {@code cantidad}).
 */
public class GestionEmpleados {

	private static final int CAPACIDAD_MAXIMA = 50;

	private final Empleado[] empleados = new Empleado[CAPACIDAD_MAXIMA];
	private int cantidad = 0;

	public void agregar(Empleado empleado) {
		// Cuidado: a diferencia de un ArrayList, este arreglo NO crece solo.
		// Si ya se llenó, no hay dónde guardar un empleado más.
		if (cantidad >= CAPACIDAD_MAXIMA) {
			throw new IllegalStateException("La nómina ya alcanzó su capacidad máxima de " + CAPACIDAD_MAXIMA
					+ " empleados.");
		}
		empleados[cantidad] = empleado;
		cantidad++;
	}

	public void cargarTodos(Empleado[] empleadosACargar) {
		for (Empleado empleado : empleadosACargar) {
			agregar(empleado);
		}
	}

	/**
	 * Devuelve una copia del arreglo interno (solo con los espacios
	 * realmente ocupados). Se devuelve una copia, y no el arreglo interno
	 * directamente, para que nadie fuera de esta clase pueda modificar la
	 * nómina "por atrás" (mismo espíritu de encapsulamiento que usar
	 * getters en vez de exponer atributos).
	 */
	public Empleado[] listarTodos() {
		Empleado[] copia = new Empleado[cantidad];
		for (int i = 0; i < cantidad; i++) {
			copia[i] = empleados[i];
		}
		return copia;
	}

	public int total() {
		return cantidad;
	}

	/**
	 * Ya resuelto: sirve de referencia para las 3 preguntas prácticas de
	 * abajo. Recorre a todos los empleados e imprime su ficha completa
	 * (nombre, tipo y salario calculado polimórficamente).
	 */
	public void imprimirFichas() {
		for (int i = 0; i < cantidad; i++) {
			System.out.println(empleados[i]);
		}
	}

	/**
	 * PREGUNTA PRÁCTICA 1 (20 pts)
	 * <p>
	 * Enunciado: recorre todos los empleados y devuelve la suma de
	 * calcularSalarioMensual() de cada uno. No importa si son Gerente,
	 * Vendedor u Operario: cada uno sabe calcular el suyo (polimorfismo).
	 * <p>
	 * Entrada/salida de ejemplo: con un Gerente que calcula Q8500.00 y un
	 * Vendedor que calcula Q4200.00, calcularNominaTotal() debe devolver
	 * 12700.0.
	 * <p>
	 * Pista: recorre el arreglo interno solo hasta la posición
	 * {@code cantidad - 1} (igual que en imprimirFichas()), y suma
	 * empleados[i].calcularSalarioMensual() en cada vuelta.
	 * <p>
	 * Criterios de evaluación:
	 * <ul>
	 * <li>Recorre todos los empleados cargados (no solo el primero).</li>
	 * <li>No usa instanceof ni pregunta el tipo de cada empleado.</li>
	 * <li>Retorna 0.0 (no una excepción) si no hay empleados cargados.</li>
	 * </ul>
	 */
	public double calcularNominaTotal() {
		// TODO: completar
		return 0.0;
	}

	/**
	 * PREGUNTA PRÁCTICA 2 (20 pts)
	 * <p>
	 * Enunciado: recorre manualmente el arreglo de empleados y devuelve el
	 * Empleado cuyo calcularSalarioMensual() sea el más alto.
	 * <p>
	 * Entrada/salida de ejemplo: si hay tres empleados con salarios
	 * calculados 8500.0, 4200.0 y 5100.0, debe devolver el que calculó
	 * 8500.0.
	 * <p>
	 * Pista: mismo patrón que buscar el máximo en un arreglo de números:
	 * guarda una referencia al "mejor hasta ahora" (empieza con el primer
	 * empleado) y compárala contra cada uno de los siguientes.
	 * <p>
	 * Criterios de evaluación:
	 * <ul>
	 * <li>Recorre el arreglo con un for manual (no usa ninguna utilidad
	 * externa para ordenar o comparar).</li>
	 * <li>Retorna null (no lanza excepción) si no hay empleados
	 * cargados.</li>
	 * <li>Compara calcularSalarioMensual(), no salarioBase.</li>
	 * </ul>
	 */
	public Empleado empleadoConMayorSalario() {
		// TODO: completar
		return null;
	}

	/**
	 * PREGUNTA PRÁCTICA 3 (20 pts)
	 * <p>
	 * Enunciado: recorre todos los empleados e imprime, para cada tipo
	 * distinto (usando empleado.getTipo() como criterio: "Gerente",
	 * "Vendedor", "Operario"), cuántos empleados hay de ese tipo. Un
	 * formato de salida válido es: {@code Gerente: 2}.
	 * <p>
	 * Entrada/salida de ejemplo: con 2 Gerentes, 1 Vendedor y 3 Operarios,
	 * debe imprimir tres líneas equivalentes a "Gerente: 2",
	 * "Vendedor: 1", "Operario: 3" (en cualquier orden).
	 * <p>
	 * Pista: como no hay Map disponible, usa dos arreglos "paralelos": uno
	 * de {@code String} para los tipos ya vistos y uno de {@code int} para
	 * sus conteos (ambos de tamaño {@code cantidad}, que es más que
	 * suficiente). Por cada empleado: busca su tipo dentro del arreglo de
	 * tipos ya vistos.
	 * <ul>
	 * <li>Si lo encuentras, suma 1 al conteo en esa misma posición.</li>
	 * <li>Si no lo encuentras, agrégalo como un tipo nuevo con conteo 1.</li>
	 * </ul>
	 * Al final, recorre solo las posiciones realmente usadas e imprímelas.
	 * <p>
	 * Criterios de evaluación:
	 * <ul>
	 * <li>Usa empleado.getTipo() (polimorfismo), no instanceof.</li>
	 * <li>No usa Map, HashMap ni ninguna clase de java.util: solo
	 * arreglos.</li>
	 * <li>No imprime nada si no hay empleados cargados.</li>
	 * <li>Cada tipo aparece una sola vez en la salida, con el conteo
	 * correcto.</li>
	 * </ul>
	 */
	public void mostrarConteoPorTipo() {
		// TODO: completar
	}

	/**
	 * RETO OPCIONAL (10 pts extra)
	 * <p>
	 * Enunciado: igual que mostrarConteoPorTipo(), pero en vez de contar
	 * cuántos empleados hay de cada tipo, imprime la nómina total (suma de
	 * calcularSalarioMensual()) agrupada por tipo de empleado. Un formato
	 * de salida válido es: {@code Gerente: Q17200.00}.
	 * <p>
	 * Pista: combina la idea de mostrarConteoPorTipo() (arreglos paralelos
	 * buscando el tipo ya visto) con la de calcularNominaTotal() (sumar
	 * salarios), pero acumulando en un arreglo de {@code double} en vez de
	 * uno de {@code int}.
	 */
	public void mostrarNominaPorTipo() {
		// TODO: completar (opcional)
	}
}
