package test;

import constructores.Usuario;

public class Test {
	private int miDato;
	private Integer miObjeto;
	
	public static void main(String[] args) {
		int numTest;

        Usuario usuario = new Usuario("mbazan","curso");
        Usuario usuario2= usuario;        
        usuario=null;
        Usuario usuario3=usuario2;
        usuario2=null;
       
		/*
		 * System.out.println(usuario); usuario.setUsername("luis");
		 * System.out.println(usuario); S
		 * System.out.println("Usuario [username=" + usuario.getUsername() + ", password=" + usuario.getPassword() + "]");
	     */
	}
	public int getMiDato() {
		return miDato;
	}
	public void setMiDato(int miDato) {
		this.miDato = miDato;
	}
	public Integer getMiObjeto() {
		return miObjeto;
	}
	public void setMiObjeto(Integer miObjeto) {
		this.miObjeto = miObjeto;
	}

}
