package com.src.estructuras;

public class Enemigo extends Comun {
	
	private final int tipo;

	public Enemigo(String nombre, int vida, int municion,int tipo) {
		super(nombre, vida, municion);
		this.tipo=tipo;
		if (this.tipo==1){
			this.setNombre("jet");
		}if (this.tipo==2){
			this.setNombre("bombardero");
		}if (this.tipo==3){
			this.setNombre("torre metralla");
		}if (this.tipo==4){
			this.setNombre("torre misil");
		}if (this.tipo==5){
			this.setNombre("Kamikaze");
		}if (this.tipo==6){
			this.setNombre("jefe");
		}
	}

}
