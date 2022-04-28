// Authored by : KimJeongSoo723
// Co-authored by : -
// Link : https://www.acmicpc.net/problem/2346

import javax.sound.sampled.Line;
import java.util.*;
import java.io.*;


public class Main {
static int row;
static int col;
static int [][]map;

    public static void main(String[] args) throws IOException {
        FastReader input = new FastReader();
        row = input.nextInt();
        col = input.nextInt();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                map[i][j] = input.nextInt();
            }
        }

        bfs();
    }

    static int bfs(){

    }

    static class Location{
        int r;
        int c;
        int count;

        Location(int r,int c,int count){
            this.r = r;
            this.c = c;
            this.count = count;
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

