package edu.umg.programacion2.seccion5.modelo;

/**
 * Un Gerente cobra su salario base más un bono fijo de gerencia.
 */
public class Gerente extends Empleado {

	private double bonoGerencial;

	public Gerente(String nombre, double salarioBase, double bonoGerencial) {
		super(nombre, salarioBase);
		this.bonoGerencial = bonoGerencial;
	}

	@Override
	public double calcularSalarioMensual() {
		return getSalarioBase() + bonoGerencial;
	}

	@Override
	public String getTipo() {
		return "Gerente";
	}

	public double getBonoGerencial() {
		return bonoGerencial;
	}
}
