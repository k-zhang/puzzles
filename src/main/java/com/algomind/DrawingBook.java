package com.algomind;

import java.util.stream.IntStream;

/*
 * Brie’s Drawing teacher asks her class to open their books to a page number.
 * Brie can either start turning pages from the front of the book or from the back of the book.
 * She always turns pages one at a time. When she opens the book, page  is always on the right side:
 *
 *      -----------------
 *      |       |       |
 *      |       |       |
 *      |       |   1   |
 *      |       |       |
 *      |       |       |
 *      -----------------
 *
 * When she flips page 1, she sees pages 2 and 3. Each page except the last page will always be printed on both sides.
 * The last page may only be printed on the front, given the length of the book.
 * If the book is n pages long, and she wants to turn to page , what is the minimum number of pages she will turn? She can start at the beginning or the end of the book.
 * Given n and p, find and print the minimum number of pages Brie must turn in order to arrive at page p.
 *
 * Function Description
 * Complete the pageCount function in the editor below. It should return the minimum number of pages Brie must turn.
 * pageCount has the following parameter(s):
 *      n: the number of pages in the book
 *      p: the page number to turn to
 *
 * Input Format
 * The first line contains an integer n, the number of pages in the book.
 * The second line contains an integer p, the page that Brie's teacher wants her to turn to.
 */

public class DrawingBook {
    public int pageCount(int n, int p) {
        if(p <= n/2) {
            return IntStream.rangeClosed(0, n / 2).filter(i -> 2*i == p || 2*i + 1 == p).findFirst().getAsInt();
        }else {
            if(n % 2 != 0) {
                if(n == p) return 0;
                else return IntStream.rangeClosed(0, n / 2).filter(i -> n - 2 * i == p || n - 2 * i - 1 == p).findFirst().getAsInt();
            }else{
                return IntStream.rangeClosed(0, n / 2).filter(i -> n - 2 * i == p || n - 2 * i + 1 == p).findFirst().getAsInt();
            }
        }
    }
}
