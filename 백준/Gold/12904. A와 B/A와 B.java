import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String t = br.readLine();
		
		while(s.length() < t.length()) {
			// t의 마지막 문자가 A라면 A를 제거
			if(t.endsWith("A")) {
				t = t.substring(0, t.length()-1);
			}
				
			// t의 마지막 문자가 B라면 B 제거 후 문자열 뒤집기
			else if(t.endsWith("B")) {
				t = t.substring(0, t.length()-1);
				t = new StringBuilder(t).reverse().toString();
			}
		}
		
		if(s.equals(t)) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
	
}
