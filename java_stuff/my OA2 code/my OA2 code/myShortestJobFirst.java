import java.util.*;

public class Process {
	public int arrTime;
	public int exeTime;
	public Process(int _arr, int _exe) {
		arrTime = _arr;
		exeTime = _exe;
	}
}

public class ShortestJobFirst {
	public static float Solution(int[] req, int[] dur) {
		if(req == null || dur == null || req.length != dur.length || req.length <= 1 || dur.length <= 1) return (float)0.0;
		int len = req.length;
		int crtTime = req[0];
		int waitTime = 0;
		PriorityQueue<Process> processPQ = new PriorityQueue<Process>(new Comparator<Process>(){
			@Override
			public int compare(Process p1, Process p2){
				if(p1.exeTime == p2.exeTime) return p1.arrTime - p2.arrTime;
				return p1.exeTime - p2.exeTime;
			}
		});
		int index = 1;
		processPQ.offer(new Process(req[0], dur[0]));
		while(!processPQ.isEmpty()){
			Process crtProcess = processPQ.poll();
			waitTime += crtTime - crtProcess.arrTime;
			crtTime += crtProcess.exeTime;
			for(; index < len && req[index] <= crtTime; ++index)
				processPQ.offer(new Process(req[index], dur[index]));
		}
		return (float)waitTime / len;
	}
}