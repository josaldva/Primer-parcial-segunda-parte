package edu.umg.programacion2.seccion5.modelo;

/**
 * Clase base de la jerarquía de empleados. Encapsula el estado común
 * (nombre, salario base) e impone, mediante métodos abstractos, que cada
 * tipo de empleado sepa calcular su propio salario y decir su propio tipo.
 * <p>
 * Ningún código fuera de esta jerarquía necesita saber CÓMO se calcula el
 * salario de un Gerente, un Vendedor o un Operario: solo llama a
 * calcularSalarioMensual() y confía en el polimorfismo.
 */
public abstract class Empleado {

	private final String nombre;
	private double salarioBase;

	protected Empleado(String nombre, double salarioBase) {
		this.nombre = nombre;
		this.salarioBase = validarSalario(salarioBase);
	}

	private double validarSalario(double salario) {
		// IMPORTANTE: a diferencia de Triangulo.setBase() (que "arregla" un
		// valor negativo multiplicándolo por -1), aquí RECHAZAMOS el dato
		// inválido. Quien llama se entera de su error en vez de que el
		// objeto quede en un estado que nadie pidió.
		if (salario < 0) {
			throw new IllegalArgumentException("El salario base no puede ser negativo: " + salario);
		}
		return salario;
	}

	public abstract double calcularSalarioMensual();

	public abstract String getTipo();

	public String getNombre() {
		return nombre;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	protected void setSalarioBase(double salarioBase) {
		this.salarioBase = validarSalario(salarioBase);
	}

	@Override
	public String toString() {
		return String.format("[%s] %s - salario mensual: Q%.2f", getTipo(), nombre, calcularSalarioMensual());
	}
}
