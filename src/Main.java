// Authored by : KimJeongSoo723
// Co-authored by : -
// Link : https://www.acmicpc.net/problem/2346

import java.util.*;
import java.io.*;

import static java.awt.Color.red;

public class Main {
    static int row;
    static int col;
    static int num;
    static String [][] map;
    static boolean [][] visited_red;
    static boolean [][] visited_blue;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static Ball red;
    static Ball blue;

    public static void main(String[] args) throws IOException {
        FastReader input = new FastReader();
        row = input.nextInt();
        col = input.nextInt();
        map = new String[row][col];
        visited_red = new boolean[row][col];
        visited_blue = new boolean[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                map[i][j] = input.next();

                if(map[i][j].equals("R")){
                    red = new Ball (j,i);
                }

                else if(map[i][j].equals("B")){
                    blue = new Ball(j,i);
                }
            }
        }

        bfs(red.x,red.y,blue.x,blue.y);
    }

    static void bfs(int rx,int ry,int bx,int by){
        Queue <Ball> q_red = new LinkedList<>();
        Queue <Ball> q_blue = new LinkedList<>();
        q_red.offer(new Ball(rx,ry));
        q_blue.offer(new Ball(bx,by));
        visited_red[ry][rx] = true;
        visited_blue[ry][rx] = true;

        while(!q_red.isEmpty()){
            Ball nr = q_red.poll();
            Ball nb = q_blue.poll();
            for(int i=0; i<4 ; i++) {
                int nrx = nr.x + dx[i];
                int nry = nr.y + dy[i];
                int nbx = nb.x + dx[i];
                int nby = nb.y + dy[i];
                int left;
                int right;
                int up;
                int end;

                if(visited_red[nry][nrx] && visited_blue[nry][nrx]) continue;
                if(map[nry][nrx].equals("#") && map[nby][nbx].equals("#")) continue;

                while(!map[nry+dy[i]][nrx+dx[i]].equals("#")){
                    nrx += dx[i];
                    nry += dy[i];
                    visited_red[nry][nrx] = true;
                }

                while(!map[nby+dy[i]][nbx+dx[i]].equals("#")){
                    nbx += dx[i];
                    nby += dy[i];
                    visited_blue[nby][nbx] = true;
                }

                if(nbx == nrx && nry == nby){
                    if(i==0){
                        if(nr.x>nb.x) nrx = nrx+1;
                        else nbx= nbx+1;
                    }
                    else if(i==1){
                        if(nr.x>nb.x) nbx = nbx-1;
                        else nrx= nrx-1;
                    }
                    else if(i==2){
                        if(nr.y>nb.y) nry = nry-1;
                        else nby= nby-1;
                    }
                    else{
                        if(nr.x>nb.x) nbx = nbx-1;
                        else nrx= nrx-1;
                    }
                }

                red.count();
            }
        }
    }



    static class Ball{
        int x;
        int y;

        Ball(int x,int y){
            this.x = x;
            this.y = y;
        }

        static void count(){
            num += 1;
        }

        int result(){
            return num;
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

