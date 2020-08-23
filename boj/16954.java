import java.io.*;
import java.util.*;

public class Main {
	static int[] x = {0, -1, -1, -1, 0, 0, 1, 1, 1};
	static int[] y = {0, -1, 0, 1, -1, 1, -1, 0, 1};
  
	static class XY {
		int x, y;
		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] map = new char[8][8];
		
		for(int i=0 ; i<8 ; i++) {
			String str = br.readLine();
			for(int j=0 ; j<8 ; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		boolean[][] visited = new boolean[8][8];
		Queue<XY> q = new LinkedList<>();
		q.add(new XY(7,0));
		
		while(!q.isEmpty()) {			
			int size = q.size();

			for(int z=0 ; z<size ; z++) {
				XY xy = q.poll();
				
				if(map[xy.x][xy.y]!='.') continue;
				if(xy.x==0) {
					System.out.println(1);
					System.exit(0);
				}
				
				for(int i=0 ; i<x.length ; i++) {
					int xx = xy.x + x[i];
					int yy = xy.y + y[i];
					
					if(xx<0 || yy<0 || xx>=8 || yy>=8) continue;
					if(map[xx][yy]!='.' || visited[xx][yy]) continue;
					
					q.add(new XY(xx, yy));
				}
        visited[xy.x][xy.y] = true;
			}
			
			for(int i=7 ; i>0 ; i--) {
				for(int j=0 ; j<8 ; j++) {
					map[i][j] = map[i-1][j];
				}
			}
			Arrays.fill(map[0], '.');
		}
		System.out.println(0);
	}
}
