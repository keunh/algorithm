import java.io.IOException;
import java.util.*;

public class Main {
	static int N, M;
	static int homesCnt, chisCnt;
	static int homes[][], chis[][];
	static int result;
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
	
		N = sc.nextInt();
		M = sc.nextInt();
		int tmpHomes[][] = new int[2][100];
		chis = new int[2][13];
		homesCnt = 0;
		chisCnt = 0;
		
		for(int i=0 ; i<N ; i++){
			for(int j=0 ; j<N ; j++){
				int tmp = sc.nextInt();
				if(tmp==1){
					tmpHomes[0][homesCnt] = i;
					tmpHomes[1][homesCnt] = j;
					homesCnt++;
				}else if(tmp==2){
					chis[0][chisCnt] = i;
					chis[1][chisCnt] = j;
					chisCnt++;
				}
			}
		}
		
		homes = new int[homesCnt][chisCnt];
		for(int i=0 ; i<homesCnt ; i++){
			for(int j=0 ; j<chisCnt ; j++){
				homes[i][j] = Math.abs(tmpHomes[0][i]-chis[0][j]) + Math.abs(tmpHomes[1][i]-chis[1][j]);
			}
		}
		
		boolean check[] = new boolean[chisCnt];
		result = Integer.MAX_VALUE;
		dfs(0, 0, check);
		
		System.out.println(result);
	}
	
	public static void dfs(int d, int index, boolean[] check){
		if(d==M){
			int sum = 0;
			for(int i=0 ; i<homesCnt ; i++){
				int tmp = Integer.MAX_VALUE;
				for(int j=0 ; j<chisCnt ; j++){
					if(check[j]){
						tmp = Math.min(tmp, homes[i][j]);
					}
				}
				sum+=tmp;
			}
			result = Math.min(result, sum);
		}
		
		for(int i=index ; i<chisCnt ; i++){
			check[i] = true;
			dfs(d+1, i+1, check);
			check[i] = false;
		}
	}
}
