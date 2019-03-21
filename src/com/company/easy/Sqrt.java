package com.company.easy;

/**
 * 第69题
 * <p>
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 *
 * @author : duozl
 * @date : 2019/3/21 15:37
 */
public class Sqrt {
    public int mySqrt(int x) {
        if (0 == x) {
            return x;
        } else if (x < 4) {
            return 1;
        }

        int min = 2;
        int max = x >> 1;
        while (max > min){
            int middle = (max + min ) >> 1;
            long mult = (long) middle * middle;
            if(mult > x){
                if(max > middle - 1) {
                    max = middle - 1;
                }else {
                    return middle - 1;
                }
            }else if(mult < x){
                if(min < middle) {
                    min = middle;
                }else {
                    long mult2 = (long) (middle + 1) * (middle + 1);
                    if(mult2 > x){
                        return middle;
                    }else if(mult2 == x){
                        return middle + 1;
                    }else {
                        min = middle + 1;
                    }
                }
            }else {
                return middle;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
//        System.out.println(sqrt.mySqrt(4));
//        System.out.println(sqrt.mySqrt(5));
//        System.out.println(sqrt.mySqrt(6));
//        System.out.println(sqrt.mySqrt(7));
//        System.out.println(sqrt.mySqrt(8));
//        System.out.println(sqrt.mySqrt(9));
//        System.out.println(sqrt.mySqrt(10));
//        System.out.println(sqrt.mySqrt(11));
//        System.out.println(sqrt.mySqrt(12));
//        System.out.println(sqrt.mySqrt(13));
//        System.out.println(sqrt.mySqrt(14));
//        System.out.println(sqrt.mySqrt(15));
//        System.out.println(sqrt.mySqrt(16));
//        System.out.println(sqrt.mySqrt(17));
//        System.out.println(sqrt.mySqrt(25));
        System.out.println(sqrt.mySqrt(36));
        System.out.println(sqrt.mySqrt(2147483647));
        System.out.println(sqrt.mySqrt(2147395599));
    }
}
