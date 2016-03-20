package medium;

import java.util.*;

/**
 * Created by GAOSHANSHAN835 on 2016/1/18.
 */
public class CourseSchedule {

    /**creek BFS------*/
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            throw new IllegalArgumentException("illegal prerequisites array");
        }

        int len = prerequisites.length;

        if(numCourses == 0 || len == 0){
            return true;
        }

        // counter for number of prerequisites
        int[] pCounter = new int[numCourses];
        for(int i=0; i<len; i++){
            pCounter[prerequisites[i][0]]++;
        }

        //store courses that have no prerequisites
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(pCounter[i]==0){
                queue.add(i);
            }
        }

        // number of courses that have no prerequisites
        int numNoPre = queue.size();

        while(!queue.isEmpty()){
            int top = queue.remove();
            for(int i=0; i<len; i++){
                // if a course's prerequisite can be satisfied by a course in queue
                if(prerequisites[i][1]==top){
                    pCounter[prerequisites[i][0]]--;
                    if(pCounter[prerequisites[i][0]]==0){
                        numNoPre++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return numNoPre == numCourses;
    }

    /**creek DFS----------*/
    public boolean canFinishB(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            throw new IllegalArgumentException("illegal prerequisites array");
        }

        int len = prerequisites.length;

        if(numCourses == 0 || len == 0){
            return true;
        }

        //track visited courses
        int[] visit = new int[numCourses];

        // use the map to store what courses depend on a course
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        for(int[] a: prerequisites){
            if(map.containsKey(a[1])){
                map.get(a[1]).add(a[0]);
            }else{
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(a[0]);
                map.put(a[1], l);
            }
        }

        for(int i=0; i<numCourses; i++){
            if(!canFinishDFS(map, visit, i))
                return false;
        }

        return true;
    }

    private boolean canFinishDFS(HashMap<Integer,ArrayList<Integer>> map, int[] visit, int i){
        if(visit[i]==-1)
            return false;
        if(visit[i]==1)
            return true;

        visit[i]=-1;
        if(map.containsKey(i)){
            for(int j: map.get(i)){
                if(!canFinishDFS(map, visit, j))
                    return false;
            }
        }

        visit[i]=1;

        return true;
    }

    /*static class Vertex {
        int id;
        Vertex(int id){
            this.id = id;
        }

        Set<Integer> in  = new HashSet<Integer>();
        Set<Integer> out = new HashSet<Integer>();

        boolean isSink(){
            return out.isEmpty();
        }
    }

    Vertex safe(Vertex[] G, int id){
        if(G[id] == null){
            G[id] = new Vertex(id);
        }

        return G[id];
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Vertex[] G = new Vertex[numCourses];

        for(int[] p : prerequisites){
            safe(G, p[0]).out.add(p[1]);
            safe(G, p[1]).in.add(p[0]);
        }

        Set<Vertex> S = Arrays.stream(G)
                .filter(v -> v != null)
                .collect(Collectors.toSet());
        loop:
        while(!S.isEmpty()){
            for(Vertex v : S){
                if(v.isSink()){
                    S.remove(v);

                    for(int i : v.in){
                        G[i].out.remove(v.id);
                    }
                    continue loop;
                }
            }
            return false;
        }
        return true;
    }*/
}
