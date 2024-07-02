import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create a map to store prerequisites for each course
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        // Populate the map with the prerequisites
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            preMap.get(course).add(prerequisite);
        }

        // Set to keep track of the visiting courses
        Set<Integer> visiting = new HashSet<>();

        // Iterate through each course and perform DFS
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, preMap, visiting)) {
                return false;
            }
        }
        return true;
    }

    // Helper function for depth-first search
    private boolean dfs(int course, Map<Integer, List<Integer>> preMap, Set<Integer> visiting) {
        if (visiting.contains(course)) {
            return false;
        }
        if (preMap.get(course).isEmpty()) {
            return true;
        }

        visiting.add(course);
        for (int pre : preMap.get(course)) {
            if (!dfs(pre, preMap, visiting)) {
                return false;
            }
        }
        visiting.remove(course);
        preMap.get(course).clear();
        return true;
    }
}