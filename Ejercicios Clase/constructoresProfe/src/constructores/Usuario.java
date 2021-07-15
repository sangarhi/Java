package constructores;

public class Usuario {
	
	private String username;
	private String password;
	
	
	
	private Usuario(String password) {
		super();
		System.out.println("Constructor 1 password:"+this);
		this.password = password;
		
		
		}
	
	public Usuario(String username, String password) {
		this(password);
		System.out.println("Constructor 2 usernmae,password:"+this);
		this.username=username;
	}
	
	public static Usuario init(String username, String password) {
		System.out.println("Metodo inicialización");
		Usuario usuario = new Usuario(username,password);
		return usuario;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}

	/*
	 * @Override public String toString() { return "Usuario [username=" + username +
	 * ", password=" + password + "]"; }
	 */
	
	
	
	

}
