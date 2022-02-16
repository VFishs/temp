import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 整数按特定规则转换成字母
 * Author:
 * Date:
 **/
public class NumToLetterTest {

    /**
     * 测试0-9整数转换成字母
     */
    @Test
    public void test1(){
        ConcurrentHashMap<Integer, List<String>> map = new ConcurrentHashMap<>();
        map.put(0, new ArrayList());
        map.put(1, new ArrayList());
        map.put(2, Arrays.asList("a", "b", "c"));
        map.put(3, Arrays.asList("d", "e", "f"));
        map.put(4, Arrays.asList("g", "h", "i"));
        map.put(5, Arrays.asList("j", "k", "l"));
        map.put(6, Arrays.asList("m", "n", "o"));
        map.put(7, Arrays.asList("p", "q", "r", "s"));
        map.put(8, Arrays.asList("t", "u", "v"));
        map.put(9, Arrays.asList("w", "x", "y", "z"));

        System.out.println("请您输入0-9的整数");
        Scanner sc = new Scanner(System.in);
        Integer input = checkInputStr(sc);
        List<String> list = map.get(input);
        System.out.println("您输入的是："+ input);
        if(list.size() > 0){
            String output = "";
            for (String letter : list) {
                output += letter + ",";
            }
            System.out.println(output.substring(0,output.length()-1));
        }else{
            System.out.println("0和1没有对应的字母！");
        }
    }

    /**
     * 测试0-99整数转换成字母
     */
    @Test
    public void test2(){
        ConcurrentHashMap<Integer, List<String>> map = new ConcurrentHashMap<>();
        map.put(0, new ArrayList());
        map.put(1, new ArrayList());
        map.put(2, Arrays.asList("a", "b", "c"));
        map.put(3, Arrays.asList("d", "e", "f"));
        map.put(4, Arrays.asList("g", "h", "i"));
        map.put(5, Arrays.asList("j", "k", "l"));
        map.put(6, Arrays.asList("m", "n", "o"));
        map.put(7, Arrays.asList("p", "q", "r", "s"));
        map.put(8, Arrays.asList("t", "u", "v"));
        map.put(9, Arrays.asList("w", "x", "y", "z"));

        System.out.println("请您输入0-99的整数");
        Scanner sc = new Scanner(System.in);
        Integer input = checkInputStr2(sc);
        String output = "";
        System.out.println("您输入的是："+ input);
        if(input > 9){
            int t = input / 10;
            int s = input % 10;
            List<String> tenList = map.get(t);
            List<String> sigleList = map.get(s);
            if(tenList.size() > 0){
                if(sigleList.size() > 0){
                    for (String tL : tenList) {
                        for (String sL : sigleList) {
                            output += tL+sL+",";
                        }
                    }
                }else {
                    for (String letter : tenList) {
                        output += letter + ",";
                    }
                }
                System.out.println(output.substring(0,output.length()-1));
            }else {
                if(sigleList.size() > 0){
                    for (String letter : sigleList) {
                        output += letter + ",";
                    }
                    System.out.println(output.substring(0,output.length()-1));
                }else {
                    System.out.println("0和1没有对应的字母！");
                }
            }
        }else {
            List<String> list = map.get(input);
            if(list.size() > 0){
                for (String letter : list) {
                    output += letter + ",";
                }
                System.out.println(output.substring(0,output.length()-1));
            }else{
                System.out.println("0和1没有对应的字母！");
            }
        }
    }

    /**
     * 校验0-9整数
     * @param sc Scanner
     * @return Integer
     */
    public Integer checkInputStr(Scanner sc){
        String next = sc.next();
        if(next.toCharArray().length == 1 && next.matches("^[0-9]+$")){
            return Integer.parseInt(next);
        }else {
            System.out.println("输入了非整数或者不在范围内的整数，请您重新输入0-9的整数");
            return checkInputStr(sc);
        }
    }

    /**
     * 校验0-99整数
     * @param sc Scanner
     * @return Integer
     */
    public Integer checkInputStr2(Scanner sc){
        String next = sc.next();
        if(next != null && next.matches("^[0-9]?\\d")){
            return Integer.parseInt(next);
        }else {
            System.out.println("输入了非整数或者不在范围内的整数，请您重新输入0-99的整数");
            return checkInputStr2(sc);
        }
    }
}
