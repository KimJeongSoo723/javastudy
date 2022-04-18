// Authored by : KimJeongSoo723
// Co-authored by : -
// Link : https://www.acmicpc.net/problem/2346

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader input = new FastReader();
        Solution sol = new Solution();
        int testnumber = input.nextInt();
        for(int i=0; i<testnumber; i++) {
            int test = input.nextInt();
            System.out.print(sol.calc(test));
        }
    }
//
//2 n 인경우 n
//3 n 인경우 2 n 2 n-1.... 2 2까지의 합
//    m n 인경우 m-1 n-1 m-1 n-2 m-1 m-1까지의 합

    static class Solution {

        int calc (int n) {
            int [] data = new int [n+1];
            data[1] = 1;
            data[2] = 2;
            data[3] = 4;

            for(int i=4;i<=n;i++) {
                data[i] = data[i-1] + data[i-2] + data[i-3];
            }
            return data[n];
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

