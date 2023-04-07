package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.regex.Pattern;


public class Main_1541_잃어버린_괄호_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        LinkedList<Integer> num = new LinkedList<>();
        LinkedList<String> oper = new LinkedList<>();
        String[] oper2 = {"+","-"};
        String temp ="";
        for(int i =0;i<line.length();i++){
            if(Pattern.matches("^[0-9]",Character.toString(line.charAt(i))))
                temp += line.charAt(i);
            else{
                num.add(Integer.parseInt(temp));
                oper.add(Character.toString(line.charAt(i)));
                temp = "";
            }
        }
        num.add(Integer.parseInt(temp));

        for(int i =0;i<2;i++){
            for(int j=0;j<oper.size();j++){
                if(!oper.get(j).equals(oper2[i])) continue;
                int temp1 = num.remove(j);
                int temp2 = num.remove(j);

                String tempOper = oper.remove(j);
                if(tempOper.equals("+")) num.add(j,temp1+temp2);
                else num.add(j,temp1-temp2);
                j--;
            }
        }

        System.out.println(num.get(0));

    }
}
