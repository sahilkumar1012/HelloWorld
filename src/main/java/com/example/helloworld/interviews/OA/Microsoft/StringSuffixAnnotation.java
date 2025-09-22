package com.example.helloworld.interviews.OA.Microsoft;

import java.util.Arrays;

/**

 *
 */
public class StringSuffixAnnotation {
    static class State {
        int len, link;
        int[] next = new int[26]; // 'a' to 'z'

        State() {
            Arrays.fill(next, -1);
        }
    }

    public static long substringCalculator(String s) {
        int n = s.length();
        State[] st = new State[2 * n];
        for (int i = 0; i < 2 * n; i++) st[i] = new State();

        st[0].len = 0;
        st[0].link = -1;
        int last = 0;
        int size = 1;

        for (char ch : s.toCharArray()) {
            int c = ch - 'a';
            int cur = size++;
            st[cur].len = st[last].len + 1;
            int p = last;

            while (p != -1 && st[p].next[c] == -1) {
                st[p].next[c] = cur;
                p = st[p].link;
            }

            if (p == -1) {
                st[cur].link = 0;
            } else {
                int q = st[p].next[c];
                if (st[p].len + 1 == st[q].len) {
                    st[cur].link = q;
                } else {
                    int clone = size++;
                    st[clone].len = st[p].len + 1;
                    st[clone].link = st[q].link;
                    System.arraycopy(st[q].next, 0, st[clone].next, 0, 26);

                    while (p != -1 && st[p].next[c] == q) {
                        st[p].next[c] = clone;
                        p = st[p].link;
                    }

                    st[q].link = clone;
                    st[cur].link = clone;
                }
            }
            last = cur;
        }

        long result = 0;
        for (int i = 1; i < size; i++) {
            result += st[i].len - st[st[i].link].len;
        }
        return result;
    }
}
