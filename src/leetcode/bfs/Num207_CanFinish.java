package leetcode.bfs;

import java.util.*;

public class Num207_CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            // 入度值初始化
            inDegree[prerequisites[i][0]]++;
            // 添加依赖关系: 如果邻接表中已经存在课程，则取出后添加，否则新建一个
            // key: 先修课, value: 需要完成该先修课才能选修的课程集合
            List<Integer> list = map.getOrDefault(prerequisites[i][1], new LinkedList<>());
            list.add(prerequisites[i][0]);
            map.put(prerequisites[i][1], list);
        }

        // 创建队列，并把入度为0的课程加入到队列中
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 记录修完的课程
        int count = 0;
        while (!queue.isEmpty()) {
            // 取出入度为0的课程
            int course = queue.poll();
            count++;
            if(map.containsKey(course)) {
                // 如果该课程有出度则让出度课程的入度值-1
                List<Integer> list = map.get(course);
                for(int i : list) {
                    inDegree[i]--;
                    if(inDegree[i] == 0) {
                        // 如果该课程的入度值为0了，则入队
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
