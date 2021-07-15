package com.herencia;

import java.util.ArrayList;
import java.util.List;

import com.herencia.ln.GesConejo;
import com.herencia.ln.GesDalmata;
import com.herencia.ln.GesLeon;
import com.herencia.ln.GesOso;
import com.herencia.ln.GesPerro;
import com.herencia.ln.GesSerpiente;
import com.herencia.ln.interfaces.IAnimal;
import com.herencia.ln.interfaces.IConejo;
import com.herencia.ln.interfaces.IHerbivoro;
import com.herencia.ln.interfaces.IMamifero;
import com.herencia.ln.interfaces.IPerro;
import com.herencia.ln.interfaces.ISerpiente;

public class Test {

	public static void main(String[] args) {
		//Creamos variables de diferente tipo
		GesConejo gConejo = new GesConejo();
		GesDalmata gDalamata = new GesDalmata();
		GesLeon gLeon = new GesLeon();
		GesOso gOso = new GesOso();
		GesPerro gPerro = new GesPerro();
		GesSerpiente gSerpiente = new GesSerpiente();
		
		
		//Aqui se muestra como objetos que sean diferentes
		//pero tengan el mismo comportamiento
		//pueden manejarse juntos
		
		
		
		//Como la lista solo admite objetos de tipo IMamifero
		//puedo almecenar todos excepto gSerpiente
		List<IMamifero> mamiferos = new ArrayList<IMamifero>();
		
		mamiferos.add(gConejo);
		mamiferos.add(gDalamata);
		mamiferos.add(gLeon);
		mamiferos.add(gOso);
		mamiferos.add(gPerro);
		//mamiferos.add(gSerpiente); //NO COMPILA
		
		//A la hora de iterarla solo podemos acceder al ámbito IMamifero
		//o de los ancestros de IMamifero
		for(IMamifero mamifero: mamiferos) {
		    mamifero.amamantar();
		    //Método heredados de IAnimal
		    //mamifero.nacer();
		    //mamifero.vivir();
		   // mamifero.morir();
		}
		for(IAnimal animal: mamiferos) {
		    animal.nacer();
		    animal.vivir();
		    animal.morir();
		}
		for(Object objeto: mamiferos) {
		    objeto.toString();
		}
		
		//Con otra lista que admita solo IAnimal,
		//podemmos introducir todos mamiferos
		//y además gSerpiente.
		List<IAnimal> animales = new ArrayList<IAnimal>();
		animales.addAll(mamiferos);
		animales.add(gSerpiente);
		
		for(IAnimal animal: animales) {
			//animal.nacer();
			//animal.vivir();
			//animal.morir();
		    
		}
		
		//CON EL MISMO OBJETO TIPIFICAMOS DE FORMA DIFERENTE
		//El Constructor GesConejo, me va permitir tipificar:
		//GesConejo/Object/IConejo/IHerbivoro/IMamifero/IAnimal
		//van a ser EL MISMO TIPO OBJETO (GESCONEJO) pero van tener
		//diferente acceso a los métodos
		Object objeto = new GesConejo();		
		IAnimal animal = new GesConejo();		
		IMamifero mamifero = new GesConejo();		
		IHerbivoro herbivoro = new GesConejo();		
		IConejo conejo = new GesConejo();
		System.out.println(objeto);
		System.out.println(animal);
		System.out.println(mamifero);
		System.out.println(herbivoro);
		System.out.println(conejo);
		
		//Hacer CAST -Cambio de tipo
		//Cuando tenemos un objeto que hemos tipado con parte de él mismo		
		GesConejo gesConejo1=(GesConejo) objeto;
		IMamifero mamifero2=(IMamifero) animal;
		IConejo iConejo=(IConejo) mamifero;
		IAnimal iAnimal=(IAnimal) herbivoro;
		Object objeto2=(Object) conejo;
				
		
		List<GesConejo> gesConejos = new ArrayList<GesConejo>();
		gesConejos.add((GesConejo)objeto);
		gesConejos.add((GesConejo)animal);	
		gesConejos.add((GesConejo)mamifero);		
		gesConejos.add((GesConejo)herbivoro);	
		gesConejos.add((GesConejo)conejo);
		
		for(GesConejo gConejoAux:gesConejos) {
			gConejoAux.saltar();
		}
		for(IAnimal animalAux:gesConejos) {
			animalAux.vivir();
		}
		
				
		//OPERADOR INSTANCEOF
		
		System.out.println("¿Es gConejo una instancia de IConejo?"+(gConejo instanceof IConejo));
		System.out.println("¿Es gConejo una instancia de IAnimal?"+(gConejo instanceof IAnimal));
		System.out.println("¿Es gSerpiente una instancia de IAnimal?"+(gSerpiente instanceof IAnimal));
		System.out.println("¿Es gSerpiente una instancia de IMamifero?"+(gSerpiente instanceof IMamifero));
		
		System.out.println(gConejo.getClass());
		
		
		for(IAnimal animalAux:animales) {
			if(animalAux instanceof ISerpiente) {
				((ISerpiente)animalAux).reptar();
			}else if( animalAux instanceof IPerro) {
				((IPerro)animalAux).ladrar();
			}
		}
		
		
		

	}

}
