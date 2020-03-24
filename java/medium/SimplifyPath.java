package com.yangchd.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangchd 2018/10/30
 *
 * 71.Simplify Path
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * path = "/a/../../b/../c//.//", => "/c"
 * path = "/a//b////c/d//././/..", => "/a/b/c"
 *
 * In a UNIX-style file system, a period ('.') refers to the current directory, so it can be ignored in a simplified path. Additionally, a double period ("..") moves up a directory, so it cancels out whatever the last directory was. For more information, look here: https://en.wikipedia.org/wiki/Path_(computing)#Unix_style
 *
 * Corner Cases:
 *
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class SimplifyPath {
    class Solution {
        public String simplifyPath(String path) {
            if (null == path || "".equals(path)) {
                return null;
            }
            if ("/".equals(path) || "/../".equals(path)) {
                return "/";
            }
            String[] dirs = path.split("/");
            List<String> list = new ArrayList<String>();
            for (String dir : dirs) {
                if ("..".equals(dir)) {
                    if (!list.isEmpty()) {
                        list.remove(list.size() - 1);
                    }
                    continue;
                }
                if (".".equals(dir)) {
                    continue;
                }
                if (null == dir || "".equals(dir)) {
                    continue;
                }
                list.add(dir);
            }
            StringBuilder sb = new StringBuilder();
            if (list.isEmpty()) {
                return "/";
            }
            for (String str : list) {
                sb.append("/").append(str);
            }
            return sb.toString();
        }
    }
}
