package week6;

import java.util.*;
public class Roads_And_Libraries {
	

    public static long solve(int n, long cl, long cr, ArrayList<TreeSet<Integer>> adj) {
        if (cl <= cr)
         {
              return (cl * n);
         }
        long minimum_cost = 0;
        boolean[] visited_nodes = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited_nodes[i]) {
                long temp_Cost = cl;
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                visited_nodes[i] = true;
                while (!stack.empty()) {
                    int u = stack.pop();
                    Iterator<Integer> it = adj.get(u).iterator();
                    while (it.hasNext()) {
                        int v = it.next();
                        if (!visited_nodes[v]) {
                            stack.push(v);
                            visited_nodes[v] = true;
                            temp_Cost += cr;
                        }
                    }
                }
                minimum_cost += temp_Cost;
            }
        }
        
        return minimum_cost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n =scanner.nextInt();
            int m = scanner.nextInt();
            long cl = scanner.nextLong();
            long cr = scanner.nextLong();
            ArrayList<TreeSet<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) { adj.add(new TreeSet<Integer>()); }
            for(int i = 0; i < m; i++){
                int start = scanner.nextInt();
                start--;
                int end = scanner.nextInt();
                end--;
                adj.get(start).add(end);
                adj.get(end).add(start);
            }
            System.out.println(Roads_And_Libraries.solve(n, cl, cr, adj));
        }
        scanner.close();
    }
    
}
