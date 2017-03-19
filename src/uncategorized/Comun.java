package uncategorized;

public abstract class Comun extends GameObject
{
	private int vida;
	private int municion;
	private String nombre;
	public Comun(String nombre,int vida,int municion){
		this.nombre=nombre;
		this.vida=vida;
		this.municion=municion;
		
	}
	
	public void setVida(int numero){
		this.vida=numero;
		}
	public int getVida(){
		return this.vida;
		}
	public void setmunicion(int numero){
		this.municion=numero;
		}
	public int getmunicion(){
		return this.municion;
		}
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	

}
