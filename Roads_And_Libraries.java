package week6;

import java.util.*;
public class Roads_And_Libraries {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quries = scanner.nextInt();
        for(int queries_count = 0; queries_count < quries; queries_count++){
            int n =scanner.nextInt();
            int m = scanner.nextInt();
            long city_library = scanner.nextLong();
            long city_road = scanner.nextLong();
            ArrayList<TreeSet<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) { 
            	adj.add(new TreeSet<Integer>()); 
            	}
            for(int i = 0; i < m; i++)
            {
                int start = scanner.nextInt();
                start--;
                int end = scanner.nextInt();
                end--;
                adj.get(start).add(end);
                adj.get(end).add(start);
            }
            if (city_library <= city_road)
            {
                 System.out.println(city_library*n);
                 
            }
            else
            {
           long minimum_cost = 0;
           boolean[] visited_nodes = new boolean[n];
           for (int i = 0; i < n; i++) {
               if (!visited_nodes[i]) {
                   long temp_Cost = city_library;
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
                               temp_Cost += city_road;
                           }
                       }
                   }
                   minimum_cost += temp_Cost;
               }
           }
           
           System.out.println(minimum_cost);
            }
        }
        scanner.close();
    }
    
}
