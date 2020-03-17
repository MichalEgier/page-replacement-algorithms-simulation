
import java.util.ArrayList;
import java.util.Random;

public class RequestGenerator {
    
	public static ArrayList<Request> generate(int seqLen, int maxPageNum) {
   /* 
		ArrayList<Request> result = new ArrayList<>();
      
        ArrayList<Integer> seq = new ArrayList<>(); //RandomNums.getSequnce(seqLen, 0, maxPageNum);

        
      
        
        
    
        
        
        /*
        seq.add(1);
        seq.add(2);
        seq.add(3);
        seq.add(4);
        seq.add(1);
        seq.add(2);
        seq.add(5);
        seq.add(1);
        seq.add(2);
        seq.add(3);
        seq.add(4);
        seq.add(5);
        
        
        ArrayList<Request> allPossibleRequests = new ArrayList<>();
        
        for (int i = 1; i <= 5; i++) {
        
        	allPossibleRequests.add(new Request(i));
        
        }

        for (int nextPage : seq) {
        
        	result.add(allPossibleRequests.get(nextPage-1));
        }

        return result;	*/
		
		ArrayList <Request> listOfRequests = new ArrayList <Request>();
		
		int repeat = 0;
		
		for(int i=0;i<seqLen;i++) {
			
			int next=generatePage(repeat,maxPageNum,0,maxPageNum/2,30,50);
			repeat=next;
			listOfRequests.add(new Request(next));
		}
		
		return listOfRequests;
		
    }
	
	private static int generatePage(int repeat,int maxRandom,int startOfBigChance,int endOfBigChance,int chanceOfRepeat,int chanceOfTakingBigChanceSet) {
		
		Random random = new Random();
		
		//pierw sprawdzenie czy sie nie powtorzy
		
		if(random.nextInt(100)<chanceOfRepeat) return repeat;
		
		if(random.nextInt(100)<chanceOfTakingBigChanceSet) 
			
			return (random.nextInt(endOfBigChance-startOfBigChance) + startOfBigChance);
			
		return random.nextInt(maxRandom);
			
		
		
		
		
		//if(random.nextInt(maxRandom)<=chance)
		
	}
}
        
	