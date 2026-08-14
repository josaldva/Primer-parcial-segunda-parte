package edu.umg.programacion2.seccion5.modelo;

/**
 * Un Operario cobra su salario base más un pago fijo por cada hora extra
 * trabajada en el mes.
 */
public class Operario extends Empleado {

	private static final double PAGO_POR_HORA_EXTRA = 35.0;

	private int horasExtra;

	public Operario(String nombre, double salarioBase, int horasExtra) {
		super(nombre, salarioBase);
		this.horasExtra = horasExtra;
	}

	@Override
	public double calcularSalarioMensual() {
		return getSalarioBase() + (horasExtra * PAGO_POR_HORA_EXTRA);
	}

	@Override
	public String getTipo() {
		return "Operario";
	}

	public int getHorasExtra() {
		return horasExtra;
	}
}
