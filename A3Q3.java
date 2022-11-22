/* Student name : Lay Wee Chong
   Student ID : 6564434 */

package dijkstra;

/* Student name : Lay Wee Chong
   Student ID : 6564434 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.*;

class Vertex implements Comparable<Vertex>// create Vertex class
{
    public String name;
    public  Edge[]adjedges;
    public double minDistance = Double.MAX_VALUE;// initialize minDistance int Vertex class to infinity
    public Vertex parentVertex;
    
    public Vertex(String name)
    {
        this.name = name;
    }
    @Override
    public String toString()
    {
        return name;
    }
    @Override
    public int compareTo(Vertex neighbours)
    {
        return Double.compare(minDistance, neighbours.minDistance);
    }        
}

class Edge// create Edge class
{
    public final Vertex goal;
    public final double weight;
    
    public Edge(Vertex goal,double weight )
    {
        this.goal = goal;
        this.weight = weight;      
    }    
}
public class Dijkstra {

   public static void computeMinPaths(Vertex start)
    {
        start.minDistance = 0; // initialize min Distance to 0
        PriorityQueue<Vertex>priorityqueue = new PriorityQueue<>();// create a new PriorityQueue object
        
        priorityqueue.add(start);// add source vertex to piority queue
        
        do
        {
            Vertex v = priorityqueue.poll();// deletes elements at the front the queue
            
            for(Edge edge : v.adjedges )
            {
                Vertex target = edge.goal;
                double weight = edge.weight;// Vertex and weight initializations
                
                
                double distance = v.minDistance + weight;// calculate distance
                
                if(distance < target.minDistance)// algorithm to find shortest path
                {
                    priorityqueue.remove(target);
                    target.minDistance = distance;
                    target.parentVertex = v;
                    priorityqueue.add(target);                    
                }
            }
        }while(!priorityqueue.isEmpty());
        
    }
     public static List<Vertex> getShortestPathTo(Vertex target)
    {
       List<Vertex>path = new ArrayList<Vertex>();
       for(Vertex vertex = target; vertex != null;vertex = vertex.parentVertex)
       {
           path.add(vertex); // add vertex into Array List
       }
       Collections.reverse(path);
       
       return path;
    }
    public static void main(String[] args) {
          //initialize the graph base on the Singapore map
		Vertex v1 = new Vertex("-> Chua Chu Kang");
                Vertex v2 = new Vertex("-> Woodlands");
                Vertex v3 = new Vertex("-> Bukit Panjang");
                Vertex v4 = new Vertex("-> Bukit Batok");
                Vertex v5 = new Vertex("-> Jurong");
                Vertex v6 = new Vertex("-> Tuas");
                Vertex v7 = new Vertex("-> Mandai");
                Vertex v8 = new Vertex("-> Nee Soon");
                Vertex v9 = new Vertex("-> Sembawang");
                Vertex v10 = new Vertex("-> Bukit Timah");
                Vertex v11 = new Vertex("-> Upper Thomson ");
                Vertex v12 = new Vertex("-> Ang Mo Kio");
                Vertex v13 = new Vertex("-> Clementi");
                Vertex v14 = new Vertex("-> QueensTown");
                Vertex v15 = new Vertex("-> Toa Payoh");
                Vertex v16 = new Vertex("-> Bedok");
                Vertex v17 = new Vertex("-> Serangoon");
                Vertex v18 = new Vertex("-> Pasir Panjang");
                Vertex v19 = new Vertex("-> Sentosa");
                Vertex v20 = new Vertex("-> Outram");
                Vertex v21 = new Vertex("-> Marina Bay");
                Vertex v22 = new Vertex("-> Tampines");
                Vertex v23 = new Vertex("-> Changi");
                Vertex v24 = new Vertex("-> Punggol");
                
		v1.adjedges = new Edge[]{
			new Edge(v2,11),
			new Edge(v3,4),
			new Edge(v4,6),
                        new Edge(v5,22),
                        new Edge(v6,15)
		};
                v2.adjedges = new Edge[]{
                        new Edge(v1,11),
                        new Edge(v3,11),
			new Edge(v7,8),
			new Edge(v8,9),
			new Edge(v9,5)                    
		};
                v3.adjedges = new Edge[]{
                        new Edge(v1,4),
                        new Edge(v4,7),
                        new Edge(v10,6),
                        new Edge(v11,14),
                        new Edge(v12,16),
                        new Edge(v8,16),
                        new Edge(v7,15),
                        new Edge(v2,11)                                         
		};
                v4.adjedges = new Edge[]{
                        new Edge(v1,6),
                        new Edge(v6,16),
                        new Edge(v5,19),
                        new Edge(v13,7),
                        new Edge(v10,5),
                        new Edge(v12,18),
                        new Edge(v3,7)              
                };
                v5.adjedges = new Edge[]{
                        new Edge(v1,22),
                        new Edge(v6,19),
                        new Edge(v10,25),
                        new Edge(v4,19)              
                };
                v6.adjedges = new Edge[]{
                        new Edge(v1,15),
                        new Edge(v4,16),
                        new Edge(v5,19)
                };
                v7.adjedges = new Edge[]{
                        new Edge(v2,8),
                        new Edge(v3,15),
                        new Edge(v8,3),
                        new Edge(v9,6)
                    
                };
                v8.adjedges = new Edge[]{
                        new Edge(v7,3),
                        new Edge(v3,16),
                        new Edge(v12,6),
                        new Edge(v9,5)
                };
                v9.adjedges = new Edge[]{
                       new Edge(v2,5),
                       new Edge(v7,6),
                       new Edge(v8,5)
                };
                
                v10.adjedges = new Edge[]{
                       new Edge(v3,6),
                       new Edge(v4,5),
                       new Edge(v5,25),
                       new Edge(v13,5),
                       new Edge(v14,9),
                       new Edge(v15,10),
                       new Edge(v16,22),
                       new Edge(v11,11)
                };
                v11.adjedges = new Edge[]{
                      new Edge(v3,14),
                      new Edge(v10,11),
                      new Edge(v14,10),
                      new Edge(v15,6),
                      new Edge(v16,16),
                      new Edge(v17,8),
                      new Edge(v12,5)
                      
                };
                v12.adjedges = new Edge[]{
                      new Edge(v8,6),
                      new Edge(v3,16),
                      new Edge(v4,18),
                      new Edge(v11,5),
                      new Edge(v17,6)
                };
                
                v13.adjedges = new Edge[]{
                      new Edge(v4,7),
                      new Edge(v18,7),
                      new Edge(v14,5),
                      new Edge(v10,5)
                };
                v14.adjedges = new Edge[]{
                      new Edge(v10,9),
                      new Edge(v13,5),
                      new Edge(v18,6),
                      new Edge(v19,10),
                      new Edge(v20,5),
                      new Edge(v15,9),
                      new Edge(v14,10)
                };
                v15.adjedges = new Edge[]{
                      new Edge(v11,6),
                      new Edge(v10,10),
                      new Edge(v14,9),
                      new Edge(v20,8),
                      new Edge(v21,10),
                      new Edge(v16,13),
                      new Edge(v22,15),
                      new Edge(v23,18),
                      new Edge(v17,6)
                };
                v16.adjedges = new Edge[]{
                      new Edge(v11,16),
                      new Edge(v10,22),
                      new Edge(v15,13),
                      new Edge(v21,16),
                      new Edge(v20,16),
                      new Edge(v23,5)                    
                };
                v17.adjedges = new Edge[]{
                      new Edge(v12,6),
                      new Edge(v11,8),
                      new Edge(v15,6),
                      new Edge(v22,12),
                      new Edge(v23,16),
                      new Edge(v24,8)
                  
                };
               v18.adjedges = new Edge[]{
                     new Edge(v13,7),
                     new Edge(v14,6),
                     new Edge(v19,8)
               };
               v19.adjedges = new Edge[]{
                     new Edge(v18,8),
                     new Edge(v14,10),
                     new Edge(v20,6)
               };
               v20.adjedges = new Edge[]{
                     new Edge(v15,8),
                     new Edge(v14,5),
                     new Edge(v19,6),
                     new Edge(v16,16),
                     new Edge(v21,2)
               };
               v21.adjedges = new Edge[]{
                     new Edge(v15,10),
                     new Edge(v20,2),
                     new Edge(v16,16)
               };
               v22.adjedges = new Edge[]{
                     new Edge(v17,12),
                     new Edge(v15,15),
                     new Edge(v16,5),
                     new Edge(v23,5)
               };
               v23.adjedges = new Edge[]{
                     new Edge(v17,16),
                     new Edge(v15,18),
                     new Edge(v22,5)
               };
               v24.adjedges = new Edge[]{
                    new Edge(v17,8)
               };
        // user input for Start From:
               Scanner scanner =  new Scanner(System.in); 
               System.out.print("Start From: ");  
               String start_point =  scanner.nextLine();
       // switch case statements         
        switch (start_point) {
            case "Chua Chu Kang":
                computeMinPaths(v1); // compute minpath from starting location
                break;
            case "Woodlands":
                computeMinPaths(v2);
                break;
            case "Bukit Panjang":
                computeMinPaths(v3);
                break;
            case "Bukit Batok":
                computeMinPaths(v4);
                break;
            case "Jurong":
                computeMinPaths(v5);
                break;
            case "Tuas":
                computeMinPaths(v6);
                break;
            case "Mandai":
                computeMinPaths(v7);
                break;
            case "Nee Soon":
                computeMinPaths(v8);
                break;
            case "Sembawang":
                computeMinPaths(v9);
                break;
            case "Bukit Timah":
                computeMinPaths(v10);
                break;
            case "Upper Thomson":
                computeMinPaths(v11);
                break;
            case "Ang Mo Kio":
                computeMinPaths(v12);
                break;
            case "Clementi":
                computeMinPaths(v13);
                break;
            case "QueensTown":
                computeMinPaths(v14);
                break;
            case "Toa Payoh":
                computeMinPaths(v15);
                break;
            case "Bedok":
                computeMinPaths(v16);
                break;
            case "Serangoon":
                computeMinPaths(v17);
                break;
            case "Pasir Panjang":
                computeMinPaths(v18);
                break;
            case "Sentosa":
                computeMinPaths(v19);
                break;
            case "Outram":
                computeMinPaths(v20);
                break;
            case "Marina Bay":
                computeMinPaths(v21);
                break;
            case "Tampines":
                computeMinPaths(v22);
                break;
            case "Changi":
                computeMinPaths(v23);
                break;
            case "Punggol":
                computeMinPaths(v24);
                break;
            default:
                System.out.println("Invalid name");
                
            }
         // user input for To From:
            Scanner scanner_2 =  new Scanner(System.in); 
            System.out.print("To: ");  
            String Destination =  scanner_2.nextLine();
            
            //switch case statements
            switch (Destination) {
            case "Chua Chu Kang":
                System.out.println("Path: " +  getShortestPathTo(v1));// display path route
                System.out.println("Total Distance is : " +  v1.minDistance + "km");// display possible min distance
                break;
            case "Woodlands":
               System.out.println("Path: " +  getShortestPathTo(v2));
               System.out.println("Total Distance is : " +  v2.minDistance + "km");
                break;
            case "Bukit Panjang":
               System.out.println("Path: " +  getShortestPathTo(v3));
               System.out.println("Total Distance is : " +  v3.minDistance + "km" );
                break;
            case "Bukit Batok":
               System.out.println("Path: " +  getShortestPathTo(v4));
               System.out.println("Total Distance is : " +  v4.minDistance + "km");
                break;
            case "Jurong":
               System.out.println("Path: " +  getShortestPathTo(v5));
               System.out.println("Total Distance is : " +  v5.minDistance + "km");
                break;
            case "Tuas":
               System.out.println("Path: " +  getShortestPathTo(v6));
               System.out.println("Total Distance is : " +  v6.minDistance + "km");
                break;
            case "Mandai":
               System.out.println("Path: " +  getShortestPathTo(v7));
               System.out.println("Total Distance is : " +  v7.minDistance + "km");
                break;
            case "Nee Soon":
               System.out.println("Path: " +  getShortestPathTo(v8));
               System.out.println("Total Distance is : " +  v8.minDistance + "km");
                break;
            case "Sembawang":
               System.out.println("Path: " +  getShortestPathTo(v9));
               System.out.println("Total Distance is : " +  v9.minDistance + "km");
                break;
            case "Bukit Timah":
               System.out.println("Path: " +  getShortestPathTo(v10));
               System.out.println("Total Distance is : " +  v10.minDistance + "km");
                break;
            case "Upper Thomson":
               System.out.println("Path: " +  getShortestPathTo(v11));
               System.out.println("Total Distance is : " +  v11.minDistance + "km");
                break;
            case "Ang Mo Kio":
               System.out.println("Path: " +  getShortestPathTo(v12));
               System.out.println("Total Distance is : " +  v12.minDistance + "km");
                break;
            case "Clementi":
               System.out.println("Path: " +  getShortestPathTo(v13));
               System.out.println("Total Distance is : " +  v13.minDistance + "km");
                break;
            case "QueensTown":
               System.out.println("Path: " +  getShortestPathTo(v14));
               System.out.println("Total Distance is : " +  v14.minDistance + "km");
                break;
            case "Toa Payoh":
               System.out.println("Path: " +  getShortestPathTo(v15));
               System.out.println("Total Distance is : " +  v15.minDistance + "km");
                break;
            case "Bedok":
               System.out.println("Path: " +  getShortestPathTo(v16));
               System.out.println("Total Distance is : " +  v16.minDistance + "km");
                break;
            case "Serangoon":
               System.out.println("Path: " +  getShortestPathTo(v17));
               System.out.println("Total Distance is : " +  v17.minDistance + "km");
                break;
            case "Pasir Panjang":
               System.out.println("Path: " +  getShortestPathTo(v18));
               System.out.println("Total Distance is : " +  v18.minDistance + "km");
                break;
            case "Sentosa":
               System.out.println("Path: " +  getShortestPathTo(v19));
               System.out.println("Total Distance is : " +  v19.minDistance + "km");
                break;
            case "Outram":
               System.out.println("Path: " +  getShortestPathTo(v20));
               System.out.println("Total Distance is : " +  v20.minDistance + "km");
                break;
            case "Marina Bay":
               System.out.println("Path: " +  getShortestPathTo(v21));
               System.out.println("Total Distance is : " +  v21.minDistance + "km");
                break;
            case "Tampines":
               System.out.println("Path: " +  getShortestPathTo(v22));
               System.out.println("Total Distance is : " +  v22.minDistance + "km");
                break;
            case "Changi":
               System.out.println("Path: " +  getShortestPathTo(v23));
               System.out.println("Total Distance is : " +  v23.minDistance + "km");
                break;
            case "Punggol":
               System.out.println("Path: " +  getShortestPathTo(v24));
               System.out.println("Total Distance is : " +  v24.minDistance + "km");
                break;
            default:
                System.out.println("Invalid name");
                
            }
    }
    
}
