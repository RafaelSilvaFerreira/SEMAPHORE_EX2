package SemaforoCruzamento;

import SemaforoCruzamento.ThreadCruzamento;
import java.util.concurrent.Semaphore;


public class Cruzamento{

public static Semaphore semaforo;

public static void main(){
	int carros = 4;
	int sentidos  = 1;
	
	semaforo = new Semaphore(sentidos);
	for (int i=0; i<= carros; i++){
		Thread cruzamento = new
			ThreadCruzamento(i,semaforo);
		cruzamento.start();
	}
}


}
