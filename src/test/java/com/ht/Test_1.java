package com.ht;

import org.junit.Test;

import javax.annotation.Resources;
import java.io.FileOutputStream;

public class Test_1 {
    @Test
    public void test(){
        String string = "月色真美";
//        StrBinaryTurn strBinaryTurn = new StrBinaryTurn();
//        String binString = strBinaryTurn.StrToBinStr(string);
//        System.out.println(binString);
//        String resultString = strBinaryTurn.BinStrToStr(binString);
//        System.out.println(resultString);
        String s ="";
        char[] chars = string.toCharArray();
        for (char c : chars) {

            s += Integer.toBinaryString(c) +" ";
        }
        System.out.println(s);
    }
}
