package graph;

import java.util.*;

public class TestDFS {



private static void  dfsMatrix(int[][] adj, int v, boolean visited[]) {
    if(visited[v] == true) {
        return;
    }
    visited[v] = true;
    System.out.print(" "+v);
    for(int i =0; i<adj.length; i++) {
        if(!visited[i] && adj[v][i]==1) {
            dfsMatrix(adj, i, visited);
        }
    }

}

    private static void  bfsMatrix(int[][] adj, int v, boolean visited[]) {
        if(visited[v] == true) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        while (!queue.isEmpty()){
            int front = queue.poll();
            System.out.print(" "+front);
            for(int i =0; i<adj.length; i++) {
                if(!visited[i] && adj[front][i] ==1) {
                    queue.offer(i);
                    visited[v] = true;
                }
            }
        }

    }

private static void dfsAdj(List<Integer> adj[] , int v ,boolean[] visited){
    visited[v] =true;
    System.out.print(" "+v);
    for(int i : adj[v])
    {
        if(!visited[i]){
            dfsAdj(adj, i, visited);
        }
    }
}

private static boolean isCycleDFS(int[][]edges, int v, boolean [] visited, int parent){
    visited[v] = true;
    System.out.print(" "+v);
    for(int i =0; i<edges.length; i++) {
        if(visited[i]) {
            return  true;
        }
        return isCycleDFS(edges, i, visited, v);
    }
    return false;
}

    private static boolean isCycleBFS(int[][]edges, int v, boolean [] visited, int parent){

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        System.out.print(" "+v);
        while(!queue.isEmpty()){
            Integer front = queue.poll();
            visited[v] = true;
            for(int i =0; i<edges.length; i++) {
                if(visited[i]) {
                    return  true;
                }
                return isCycleDFS(edges, i, visited, v);
            }

        }

        return false;
    }

// innorder Traversal 
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(stack.size() > 0 || root != null) {
            while(root != null) {
                stack.add(root);
                root = root.left();
            }
            root = stack.pop();
            list.add(root.val());
            root = root.right();
        }

        return list;
    }


}
