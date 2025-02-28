package com.example.helloworld.trie.medium;

import java.util.*;

/**
 * leetcode 1233. Remove Sub-Folders from the Filesystem
 *
 * Given a list of folders folder, return the folders after removing all sub-folders in those folders.
 * You may return the answer in any order.
 *
 * If a folder[i] is located within another folder[j], it is called a sub-folder of it.
 * A sub-folder of folder[j] must start with folder[j], followed by a "/".
 * For example, "/a/b" is a sub-folder of "/a", but "/b" is not a sub-folder of "/a/b/c".
 *
 * The format of a path is one or more concatenated strings of the form: '/' followed by one or more lowercase English letters.
 *
 * For example, "/leetcode" and "/leetcode/problems" are valid paths while an empty string and "/" are not.
 *
 * Example 1:
 *
 * Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * Output: ["/a","/c/d","/c/f"]
 * Explanation: Folders "/a/b" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
 * Example 2:
 *
 * Input: folder = ["/a","/a/b/c","/a/b/d"]
 * Output: ["/a"]
 * Explanation: Folders "/a/b/c" and "/a/b/d" will be removed because they are subfolders of "/a".
 * Example 3:
 *
 * Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
 * Output: ["/a/b/c","/a/b/ca","/a/b/d"]
 *
 * Constraints:
 *
 * 1 <= folder.length <= 4 * 10^4
 * 2 <= folder[i].length <= 100
 * folder[i] contains only lowercase letters and '/'.
 * folder[i] always starts with the character '/'.
 * Each folder name is unique.
 */

class Trie {
    Map<Character, Trie> children; // Trie structure to store characters in folder paths
    boolean eop;    // End of path marker, initially false

    public Trie() {
        children = new HashMap<>();
    }

    // Inserts only root folders into the trie and returns false if a subfolder is detected
    public boolean insert(String s) {
        Trie curr = this;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // If current path is already a root and we find a '/', it's a subfolder
            if (curr.eop && ch == '/') return false;
            Trie node = curr.children.get(ch);
            if (node == null) {  // Create a new Trie node if the character doesn't exist
                node = new Trie();
                curr.children.put(ch, node);
            }
            curr = node;
        }
        return curr.eop = true; // Mark the current node as the end of a root folder path
    }
}

public class RemoveSubFoldersfromtheFilesystem {
    Trie trie;

    public List<String> removeSubfolders(String[] folder) {
        int n = folder.length;
        trie = new Trie();
        List<String> roots = new ArrayList<>();

        // Sort folders by length to ensure shorter folders (potential roots) come first
        Arrays.sort(folder, Comparator.comparingInt(String::length));

        // Insert each folder into the trie; if it's not a subfolder, add it to the roots list
        for (String s : folder) {
            if (trie.insert(s)) {
                roots.add(s);
            }
        }
        return roots;
    }

    // Alternative approach using sorting and simple string matching
    public List<String> removeSubfoldersLoopVariant(String[] folder) {
        int n = folder.length;
        Arrays.sort(folder); // Sort lexicographically, so all subfolders appear consecutively

        List<String> roots = new ArrayList<>();
        roots.add(folder[0]); // Add the first folder as a root

        // Iterate through the sorted list and check if each folder is a subfolder of the last added root
        for (int i = 1; i < n; i++) {
            String curr = folder[i];
            String prefix = roots.get(roots.size() - 1) + "/"; // Append "/" to ensure subfolder matching

            // If current folder starts with the last root + "/", skip it (as it's a subfolder)
            if (curr.startsWith(prefix)) {
                continue;
            } else {
                roots.add(curr); // Otherwise, add it as a new root
            }
        }

        return roots;
    }
}
