package com.yz.jvm.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * RecursiveAction：没有返回值，只是执行任务
 * RecursiveTask：有返回值，小任务结束后，返回结果。大任务可将小任务返回结果进行整合
 */
public class TestForkJoin {
    private static class Demo1 extends RecursiveTask<Integer> {
        private int start;
        private int end;

        public Demo1(int start, int end) {
            this.start = start;
            this.end = end;
        }

        //计算
        @Override
        protected Integer compute() {
            int sum = 0;
            if (start - end < 100) {
                for (int i = start; i < end; i++) {
                    sum += i;
                }
            } else {
                //间隔有100则拆分多个任务计算
                int middle = (start + end) / 2;
                Demo1 left = new Demo1(start, middle);
                Demo1 right = new Demo1(middle + 1, end);
                left.fork();
                right.fork();

                sum = left.join() + right.join();
            }
            return sum;
        }
    }


    public static void main(String[] args) throws Exception {
        Demo1 d = new Demo1(1, 101);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Integer> result = forkJoinPool.submit(d);
        System.out.println(result.get());
    }
}
