package SemaforoCruzamento;

import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread {
private int id;
private static int sentido=4;


private Semaphore semaforo;

public ThreadCruzamento(int num, 
	Semaphore semaforo){
	this.id = num;
	this.semaforo = semaforo;
}


@Override
public void run(){

	System.out.println("Carro #"+
		id+
		" parou no cruzamento"+
		" pretendendo se dirigir para"+
		sentido+
	".");
	
	while(this.id!=sentido){
		try{
			Thread.sleep(2000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	try {
		semaforo.acquire();
		carroCruza();
	}
		catch (InterruptedException e){
		e.printStackTrace();
	}
	finally {
		sentido = (int) (Math.random()*5);
		semaforo.release();
	}

}



private void carroCruza(){
	
	int tempoPassagem = 100;
		
	try {
		Thread.sleep(tempoPassagem);
		System.out.println("#"+
			id+
			" passou pela porta"+
		". ");
	}
	catch(InterruptedException e){
		e.printStackTrace();
	}
	
	
}

}
