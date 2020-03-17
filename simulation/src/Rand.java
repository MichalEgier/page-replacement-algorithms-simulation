import java.util.ArrayList;
import java.util.Random;

// Random
public class Rand implements Algorithm {
    @Override
    public void replacePage(ArrayList<Request> memory, ArrayList<Request> requests, Request currentRequest) {
    	
    	Random random = new Random();
    	
    	int pageIndexToReplace = random.nextInt(memory.size() - 1);
        
    	memory.set(pageIndexToReplace, currentRequest);
    }
}
