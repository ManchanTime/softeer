import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        int c0 = 0;
        int c1 = 0;
        String result = in.charAt(0) + "";
        for(int i = 1; i < in.length(); i++) {
            if(in.charAt(i) != result.charAt(result.length() - 1)) {
                if(in.charAt(i) == '0') {
                    c1++;
                }
                else{
                    c0++;
                }
                result = in.charAt(i) + "";
            }
        }
        if(result.charAt(result.length() - 1) == '0') {
            c0++;
        }else{
            c1++;
        }
        System.out.println(Math.min(c0, c1));
    }
}
