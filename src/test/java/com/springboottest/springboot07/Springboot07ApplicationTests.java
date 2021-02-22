package com.springboottest.springboot07;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class Springboot07ApplicationTests {

    @Test
    void contextLoads() {
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(2);
        l1.add(4);
        l1.add(3);
        l1.add(9);

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(5);
        l2.add(6);
        l2.add(4);
        l2.add(8);

        LinkedList<Integer> list = addTwoNumbers(l1, l2);
        System.out.println(list);
    }


    public int findRepeatNumber(int[] nums) {
        List<Integer> ints = Arrays.stream(nums).mapToObj(i -> i).collect(Collectors.toList());
        for (int i = 0; i < ints.size(); i++) {
            if (testNumber(ints.subList(i, ints.size()))) {
                return ints.get(i);
            }
        }

        return -1;
    }

    private boolean testNumber(List<Integer> nums) {
        int i = nums.get(0);
        if (nums.subList(1, nums.size()).contains(i)) {
            return true;
        }
        return false;
    }


    //两数相加  list
    public LinkedList<Integer> addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {

        LinkedList<Integer> rs = new LinkedList<>();

        boolean flag = false;
        for (int i = 0; i < Math.max(l1.size(), l2.size()); i++) {
            if (l1.size() < l2.size()) {
                LinkedList<Integer> l3 = l1;
                l1 = l2;
                l2 = l3;
            }

            if (l1.get(i) != null) {
                Integer num1 = l1.get(i);
                if (i < l2.size()) {
                    Integer num2 = l2.get(i);
                    if (flag) {
                        rs.add((num1 + num2 + 1) % 10);
                        if ((num1 + num2 + 1) >= 10) flag = true;
                        else flag =false;
                    } else {
                        rs.add((num1 + num2) % 10);
                        if ((num1 + num2) >= 10) flag = true;
                        else flag =false;
                    }
                } else {
                    if (flag) {
                        rs.add((num1 + 1) % 10);
                        if ((num1 + 1) >= 10) flag = true;
                        else flag = false;
                    } else rs.add(num1);
                }
            }
        }

        if (flag)
            rs.add(1);
        return rs;

    }


}
