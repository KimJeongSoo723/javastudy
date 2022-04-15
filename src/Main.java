// Authored by : KimJeongSoo723
// Co-authored by : -
// Link : https://www.acmicpc.net/problem/2346


import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader input = new FastReader();
        TreeMap <Integer,Integer> tm = new TreeMap<>();
        int testcase = input.nextInt();

        for(int i=0; i<testcase; i++){
            int test = input.nextInt();

            for(int j=0; j<test; j++) {
                String method = input.next();
                int num = input.nextInt();

                if (method.equals("I")) {
                    tm.put(num, tm.getOrDefault(num, 0) + 1); //I인 경우
                }
                else if (tm.size() > 0) {
                    int del = num == 1 ? tm.lastKey() : tm.firstKey();
                    tm.put(del, tm.get(del) - 1);
                    if(tm.get(del) == 0) tm.remove(del);
                }
            }
            if (tm.size() == 0) System.out.println("EMPTY");
            else System.out.println(tm.lastKey() + " " + tm.firstKey());
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

