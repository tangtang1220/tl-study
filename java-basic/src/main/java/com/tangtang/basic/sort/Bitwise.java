package com.tangtang.basic.sort;

/**
 * 位运算
 */
public class Bitwise {

    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // 表示1的二进制往左移动一位
        // 00000000000000000000000000000001
        // 做移一位
        // 00000000000000000000000000000010
        System.out.println(1 << 1);

        print(1);

        // ~符号表示取反
        int a = 1;
        int b = ~a;
        System.out.println(b);
    }
}
