
import java.util.concurrent.*;
import java.io.*;
//Ilhaam and Mihika December 3
public class GitTest{
	static class EditFiles implements Runnable{
		private String name;

		public EditFiles(String f){
			this.name = f;
			}

		@Override
		public void run(){
			try(BufferedReader reader = new BufferedReader(new FileReader(name))){
				String line;
				while((line = reader.readLine()) != null){
					String modLine = line.toUpperCase();
				}

		}catch(IOException e){
			e.printStackTrace();
		}

		}
}

public static void main(String[] args){
long start = System.nanoTime();

new EditFiles("Frankstein.txt").run();
new EditFiles("MobyDick.txt").run();

long end = System.nanoTime();
System.out.println("Time taken(ms): "+(end-start));

long startMulti= System.nanoTime();
ExecutorService executor = Executors.newFixedThreadPool(2);
executor.execute(new EditFiles("Frankstein.txt"));
executor.execute(new EditFiles("MobyDick.txt"));
executor.shutdown();
try{
	executor.awaitTermination(1, TimeUnit.MINUTES);
}catch(InterruptedException e){
	e.printStackTrace();
}
long endMulti = System.nanoTime();
System.out.println("Time Taken MultiThread(ms): "+(endMulti-startMulti));

}


}
