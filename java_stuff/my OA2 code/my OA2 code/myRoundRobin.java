import java.util.*;
/*
	Robin Waiting time
	time complexity; O(n)
	space complexity: O(n)
*/
public class Process {
	public int aTime;    // each process arrival time
	public int eTime;	 // each process executive time
	public Process(int _aTime, int _eTime) {
		aTime = _aTime;
		eTime = _eTime;
	}
}

public class RoundRobinScheduling {
	public static float Solution(int[] Atime, int[] Etime, int q) {
		if(Atime == null || Etime == null || Atime.length <= 1 || Etime.length <= 1 || Atime.length != Etime.length) return 0;
		int len = Atime.length;
		// use queue data structure to store every process
		Queue<Process> processList = new LinkedList<Process>();  
		// crtTime is total time from 0 till now, waitTime is total waiting time
		int crtTime = Atime[0], waitTime = 0;    
		// add first process into the list
		processList.add(new Process(Atime[0], Etime[0]));
		// index of all original process		
		int index = 1;   
		while(!processList.isEmpty()) {
			Process crtProcess = processList.poll();
			// add current process waiting time into total wait time
			waitTime += crtTime - crtProcess.aTime;    
			// move current time towards to the end of current process
			crtTime += crtProcess.eTime < q ? crtProcess.eTime : q;      
			//  add all process into queue which arrival time is before current time
			for(; index < len && Atime[index] <= crtTime; ++index)    
				processList.add(new Process(Atime[index], Etime[index]));
			// if current process execute time is larger than quantum, then divide current process to a new process and add at the end of queue
			if(crtProcess.eTime > q)     
				processList.add(new Process(crtTime, crtProcess.eTime - q));
		}
		return (float)waitTime / len;
	}
}