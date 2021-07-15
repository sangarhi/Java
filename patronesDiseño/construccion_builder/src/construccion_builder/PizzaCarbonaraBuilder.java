package construccion_builder;

public class PizzaCarbonaraBuilder extends PizzaBuilder{

	
	public void buildMasa(){
		pizza.setMasa("FINA");
	}
	public void buildSalsa(){
		pizza.setSalsa("CARBONARA");
	}
	public void buildRelleno(){
		pizza.addIngrediente("CHAMPI�ON");
		pizza.addIngrediente("BACON");
		pizza.addIngrediente("CEBOLLA");
	}

}
