package com.flexhamp.leetcode;



/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.
 */
public class GuessNumberHigherOrLower {
    public static void main(String[] args) {
        System.out.println(guessNumber(1420736637));
    }

    public static int guessNumber(int n) {
        int pick = n / 2;
        int answwer = 1;
        while(answwer != 0) {
            pick += answwer = guess(pick);
        }
        return pick;
    }

    public static int guessNumber2(int n) {
        int left = 1, right = n;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(guess(mid) == 0) return mid;
            else if(guess(mid) == 1) left = mid + 1;
            else if(guess(mid) == -1) right = mid -1;
        }
        return -1;
    }

    public int guessNumber3(int n) {

        int start = 1;
        int end = n;
        do{
            int mid = (end-start)/2 + start;
            int guess = guess(mid);
            if(guess == 0){
                return mid;
            }else if(guess == -1){
                end = mid-1;
            }else if(guess == 1){
                start = mid+1;
            }
        }while(start<=end);

        return -1;
    }

    static int guess(int num) {
        int a = 1150769282;
        return Integer.compare(a, num);
    }
}
