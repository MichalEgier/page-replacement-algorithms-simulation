import java.util.ArrayList;

public class Main {
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public class MyQueue {

	private Call [] tab;
	
	private int pointer = 0; // wskazuje na miejsce w tablicy gdzie teraz jest kolejny do odczytania Call
	
	public MyQueue(MyQueue a) {
		this.pointer=a.getPointer();
		this.tab=new Call[a.size()];
		for(int i=0;i<size();i++) {
			this.tab [i] = new Call(a.getTab()[i]);
			this.tab [i].setTimeOfCall(a.getTab()[i].getTimeOfCall());
		}
	}
	
	public MyQueue(Call[] tab) {
		
	/*	Comparator_TimeOfCall comp = new Comparator_TimeOfCall();
		
		
		
	//	this.tab = new int [tab.length];
		
	//	int [] myTab = this.tab;
		
		//JEDNAK NIE SA POTRZEBNE ALGORYTMY SORTUJACE - ZMIANA POMYSLU NA PROGRAM
		
			
		for(int i=0;i<tab.length;i++) {
			
		
			
			//selectsort w miejscu tutaj zaimplementowany bedzie
			
			Call min = tab [i];
			int minIndex = i;
	
		//	szukanie min w pozostalej czesci tablicy
			
			for(int j=i;j<tab.length-1;j++) {
				
				if(comp.compare(tab[j+1],min)<0) {min = tab[j+1]; minIndex = j+1;}
				
				
			}
			
			change(i,minIndex,tab);
			
		}
		
		
		
		this.tab=tab;
	}
	

	public Call getNext() {
		if(pointer==tab.length) return null;
		return tab[pointer++];
//		pointer++;
	}
	
	private void change(int a,int b,Call [] tab) {
		if(a!=b) {
			Call c = tab[a];
			tab[a]=tab[b];
			tab[b]=c;
		}
	}
	
	public int size() {
		return tab.length;
	}
	
	public Call[] returnRestOfTheQueueAsArray(){
		Call [] tab2 = null;
		if(pointer<size()-1)
		tab2 = new Call [size()-pointer];
		if(tab2!=null)
		for(int i=pointer;i<this.size();i++) {
			tab2[i-pointer] = new Call(this.tab[i]);
		
		}
		
		
		return tab2;
	}
	
	public Call[] returnBeginOfTheQueueAsArray() {
		//Call [] tab = null;
		if(pointer==0) return null;
		Call [] tab = new Call [pointer];
		for(int i=0;i<pointer;i++) {
			tab[i]=new Call(this.tab[i]);//this.tab[i];
		}
		return tab;
	}
	
	public int getPointer() {
		return pointer;
	}
	
	public void reverseQueue() {
		
		Call [] insideTab = new Call [this.size()];
		
		for(int i=0;i<this.size()/2;i++) {
		//	Call temp = insideTab[size()-1-i];
			insideTab[size()-1-i]=tab[i];
			
		}
		
		tab=insideTab;
		
		
		
	}
	
	public Call [] getTab() {
		return this.tab;
	}
}

	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
    private static int memorySegments = 25;
    private static int requestsNumber = 2500;
    private static int pagesNumber = 80;

    
    
    public static void main(String[] args) {
    
    	Simulation simulation = new Simulation();
        
    	ArrayList<Request> requests = RequestGenerator.generate(requestsNumber, pagesNumber);
        
   // 	System.out.println(requests);

        
    	int scRes = simulation.run(new SC(), requests, memorySegments);
        
    	int lruRes = simulation.run(new LRU(), requests, memorySegments);
        
    	int fifoRes = simulation.run(new FIFO(), requests, memorySegments);
        
    	int randRes = simulation.run(new Rand(), requests, memorySegments);
        
    	int optRes = simulation.run(new OPT(), requests, memorySegments);


        System.out.println("FIFO: " + fifoRes);
        
        System.out.println("RAND: " + randRes);
        
        System.out.println("OPT: " + optRes);
        
        System.out.println("LRU: " + lruRes);
        
        System.out.println("SC: " + scRes);
    }
}
