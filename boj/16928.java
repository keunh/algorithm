import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

// 16928. 뱀과 사다리 게임
public class Main {
    static class Move{
        int num;
        int cnt;
        Move(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<Integer, Integer> ladders = new HashMap<Integer, Integer>();
        Map<Integer, Integer> snakes = new HashMap<Integer, Integer>();

        for(int i=0 ; i<N ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            ladders.put(a, b);
        }

        for(int i=0 ; i<M ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            snakes.put(a, b);
        }

        int result = 101;
        boolean[] check = new boolean[101];
        Queue<Move> q = new LinkedList<Move>();
        q.add(new Move(1, 0));
        while(!q.isEmpty()){
            Move move = q.poll();

            check[move.num] = true;

            if(move.cnt > result) continue;
            if(100-move.num<=6){
                result = Math.min(result, move.cnt+1);
                continue;
            }

            for(int i=6 ; i>=1 ; i--){
                int tmpNum = move.num+i;
                if(check[tmpNum]) continue;

                if(ladders.containsKey(tmpNum)){
                    q.add(new Move(ladders.get(tmpNum), move.cnt+1));
                }else if(snakes.containsKey(tmpNum)){
                    q.add(new Move(snakes.get(tmpNum), move.cnt+1));
                }else{
                    q.add(new Move(tmpNum, move.cnt+1));
                }
            }
        }
        System.out.println(result);
    }
}