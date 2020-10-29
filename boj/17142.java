import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
  static int[][] map;
	static int[][] viruses;
	static int virusesCnt, zeroCnt;
	static int[] x = {-1, 1, 0, 0};
	static int[] y = {0, 0, -1, 1};
	static int result;
	
	static class Virus {
		int x;
		int y;
		Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    	
    N = sc.nextInt();
    M = sc.nextInt();
    map = new int[N][N];
    viruses = new int[2][10];
    virusesCnt = 0;
    zeroCnt = 0;
    result = Integer.MAX_VALUE;

    for(int i=0 ; i<N ; i++){
       for(int j=0 ; j<N ; j++){
         map[i][j] = sc.nextInt();
         
         if(map[i][j] == 2) {
           viruses[0][virusesCnt] = i;
           viruses[1][virusesCnt++] = j;
         }else if(map[i][j] == 0) {
           zeroCnt++;
         }
       }
    }

    if(zeroCnt==0) {
      result = 0;
    }else {
      dfs(0, 0, new int[M]);
    }

    System.out.println(result==Integer.MAX_VALUE ? -1 : result);
  }

  public static void dfs(int d, int next, int[] selected) {
    if(d==M) {
      bfs(selected);
      return;
    }

    for(int i=next ; i<virusesCnt ; i++){
      selected[d] = i;
      dfs(d+1, i+1, selected);
    }
  }

  public static void bfs(int[] selected) {
    boolean[][] check = new boolean[N][N];
    Queue<Virus> q = new LinkedList<Virus>();

    for(int i=0 ; i<M ; i++){
      int xx = viruses[0][selected[i]];
      int yy = viruses[1][selected[i]];
      q.add(new Virus(xx, yy));
      check[xx][yy] = true;
    }

    int cnt = 0;
    int time = 0;
    while(!q.isEmpty()) {
      int qSize = q.size();

      for(int i=0 ; i<qSize ; i++){
        Virus virus = q.poll();

        for(int j=0 ; j<4 ; j++){
          int xx = virus.x + x[j];
          int yy = virus.y + y[j];

          if(xx<0 || xx>=N || yy<0 || yy>=N) continue;
          if(check[xx][yy] || map[xx][yy]==1) continue;
          if(map[xx][yy]==0) {
            cnt++;
          }
          q.add(new Virus(xx, yy));
          check[xx][yy] = true;
        }
      }

      time++;

      if(cnt == zeroCnt) {
        result = Math.min(result, time);
        break;
      }
    }
  }
}
