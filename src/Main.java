// Authored by : KimJeongSoo723
// Co-authored by : -
// Link : https://www.acmicpc.net/problem/2346

import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws IOException {
        FastReader input = new FastReader();
        int testcase = 9;
        int [] numbers = new int [testcase];
        int max = 0;
        int maxidx = 0;

        for(int i =0; i<testcase; i++){
            numbers[i] = input.nextInt();
            if(numbers[i] > max) {
                max = numbers[i];
                maxidx = i+1;
            }
        }

        System.out.print(max + "\n" + maxidx);
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

