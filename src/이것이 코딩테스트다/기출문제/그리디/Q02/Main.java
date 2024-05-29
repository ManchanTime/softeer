import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split("");
        int result = Integer.parseInt(in[0]);
        for(int i = 1; i < in.length ; i++) {
            int number = Integer.parseInt(in[i]);
            if(result < 1) {
                result += number;
            }
            else if(number == 0 || number == 1){
                result += number;
            }
            else{
                result *= number;
            }
        }
        System.out.println(result);
    }
}
