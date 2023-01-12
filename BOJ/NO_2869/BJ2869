import java.io.*;
import java.util.*;

public class BJ2869 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
				
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		
		int day = 0;
		
		day = (V-B) / (A-B);
		
		if((V-B)%(A-B)!=0) {
			day++;
		}
		
		bw.write(String.valueOf(day));
		bw.flush();
		bw.close();

	}

}
