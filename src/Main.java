import java.util.*;
import java.io.*;


public class Main {
    static int row;
    static int col;
    static int cabbage;
    static int [][] map;
    static boolean [][] visited;
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    static int count;
    
    public static void main(String[] args) throws IOException {
        FastReader input = new FastReader();
        int testcase = input.nextInt();
        for(int i=0; i<testcase; i++){
            col = input.nextInt();
            row = input.nextInt();
            cabbage = input.nextInt();
            map = new int[row][col];
            visited = new boolean[row][col];

            for(int j=0;j<cabbage;j++){
                int cabcol = input.nextInt();
                int cabrow = input.nextInt();
                map[cabrow][cabcol] = 1;
            }
            
            for(int j=0;j<row;j++){
                for(int k=0;k<col;k++){
                    if(!visited[j][k] && map[j][k] == 1) bfs(j,k);
                }
            }

            System.out.println(count);
            count = 0;
        }
    }
    
    public static void bfs(int r, int c){
        Queue <Location> q = new LinkedList<>();
        q.offer(new Location(r,c));
        visited[r][c] = true;
        
        while(!q.isEmpty()){
            Location now = q.poll();
            for(int i=0; i<4; i++){
                int nextr = now.r + dr[i];
                int nextc = now.c + dc[i];
                
                if(nextr<0 || nextc<0 || nextr>=row || nextc>=col) continue;
                if(visited[nextr][nextc] || map[nextr][nextc] == 0) continue;
                visited[nextr][nextc] = true;
                q.offer(new Location(nextr,nextc));
            }
        }

        count++;
    }
    
    public static class Location{
        int r;
        int c;
        
        Location(int r,int c){
            this.r = r;
            this.c = c;
        }
    }





    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws IOException{
            //br = new BufferedReader(new InputStreamReader(System.in)); //백준 제출 시 주석해제를 하면 됩니다.
            br = new BufferedReader(new FileReader("input.txt")); //IDE 실행 시 주석해제를 하면 됩니다.
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

