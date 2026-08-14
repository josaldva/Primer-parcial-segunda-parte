package edu.umg.programacion2.seccion5.modelo;

/**
 * Un Vendedor cobra su salario base más una comisión sobre lo que vendió en
 * el mes.
 */
public class Vendedor extends Empleado {

	private static final double COMISION = 0.08;

	private double ventasDelMes;

	public Vendedor(String nombre, double salarioBase, double ventasDelMes) {
		super(nombre, salarioBase);
		this.ventasDelMes = ventasDelMes;
	}

	@Override
	public double calcularSalarioMensual() {
		return getSalarioBase() + (ventasDelMes * COMISION);
	}

	@Override
	public String getTipo() {
		return "Vendedor";
	}

	public double getVentasDelMes() {
		return ventasDelMes;
	}

	public void registrarVenta(double monto) {
		this.ventasDelMes += monto;
	}
}
