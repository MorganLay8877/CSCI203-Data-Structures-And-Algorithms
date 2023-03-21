import static java.lang.Math.random;
import java.util.Scanner;
/**
 //Name: : Lay Wee Chong
 * UOW id: 6564434
 * A2_Q2
 * */
class Email// create email object class
{
    private int index;
    private int cnt;
    
    Email(int index, int cnt )
    {
        index = index;
        cnt = cnt;
    }
    
    int getIndex()
    {
        return index;
    }
    void setIndex(int index)
    {
        this.index = index;
    }
    int getCnt()
    {
        return cnt;
    }
     void setCnt(int cnt)
    {
        this.cnt = cnt;
    }
}

class Queue<Email>// create queue function
{
    Node font ;// declaration of node and asssociated variables
    Node back ;
    int queueSize;
    private class Node// create node class
    {
       Email item;
       Node next;
    }
    Queue()// default constructor
    {
        font = null;
        back = null;
        queueSize = 0;     
    }
    boolean isEmpty()// hckech queue is empty
    {
       return font == null;
    }
    int size()// check queueSize
    {
        return queueSize;
    }
    Email peek()// method for returning font node value
    {
        return font.item;
    }
    public void enqueue(Email item)// create enqueue function
    {
        Node old = back;
        back = new Node();
        back.item = item;
        
       if(isEmpty())// queue is empty
       {
         font = back; // make back node equals font node
       }
       else
       {
          old.next = back;
       }
       queueSize++;//Increment queueSize
    }
    public Email dequeue()// create dequeue function
    {
      if(isEmpty())
      {
         return null; 
      }
      Email item = font.item;
      font = font.next;
     if (queueSize == 1 || isEmpty())// if queueSize is 1, back node is null
      {
         back = null;
      }
    queueSize--; //Decrement queueSize
    return item;
  }
}

class EmailQueueSimulation// create email simulation class
{
    Queue<Email>incomingMessage;// put email into queue function
    int totalNumberProcessed;
    double arrvRate;
    double sendPerMinute;
    double queuePerMinute;
    int sentAttempt_1,sentAttempt_2,sentAttempt_3,sentAttempt_4,sentAttempt_5;
    int sentAttempt_6,sentAttempt_7,sentAttempt_8,sentAttempt_9,sentAttempt_10;
    double requeuedMessage;
    //int sentAttempt_i;
    
    EmailQueueSimulation()
    {
        incomingMessage = new  Queue<Email>();
    }
    
    public void enQueue(int e)
    {
        Email index = new Email(e,0);
        incomingMessage.enqueue(index);
        arrvRate++;
    }
    public void deQueue()
    {
        if (incomingMessage.size() == 0)// base case
        {
            System.out.print("This is the base case.");
        }
        else
        {
            int randValue = (int)(Math.random() * 5 + 1);// generate random variable
            if(randValue == 1)// if randValue = 1 , message would not send
            {
                incomingMessage.peek().setCnt( incomingMessage.peek().getCnt()+ 1);
                incomingMessage.enqueue( incomingMessage.peek());// enqueue to back of queue array
                incomingMessage.dequeue();// dequeue to front of queue array
                requeuedMessage++;// increment message sent
                
            }
            else
            {
               switch(incomingMessage.peek().getCnt())// checking count value using switch case statements
               {
                   case 0:
                       sentAttempt_1++;
                       break;
                   case 1:
                       sentAttempt_2++; 
                       break;
                   case 2:
                       sentAttempt_3++;
                       break;
                   case 3:
                       sentAttempt_4++;
                       break;
                   case 4:
                       sentAttempt_5++;
                       break;
                   case 5:
                       sentAttempt_6++;
                       break;
                   case 6:
                       sentAttempt_7++;
                       break;
                   case 7:
                       sentAttempt_8++;
                       break;
                   case 8:
                       sentAttempt_9++;
                       break;
                   case 9:
                       sentAttempt_10++;
                       break;
                   default:break;
                       
               }
               incomingMessage.dequeue();
               sendPerMinute ++;              
            }
            
        }
            
    }
    public static void main(String[] args)// main method
    {
       EmailQueueSimulation s = new  EmailQueueSimulation();
       Scanner myObject = new Scanner(System.in);
       int userInput;
       System.out.print("Please enter the total minutes to run: ");
       userInput = myObject.nextInt();
       System.out.println("-----------------------------------");
       
       for(int i = 0 ; i <userInput; ++i)
       {
           int randomValue = (int)(Math.random() * 10 + 25);
           int m = 1;
           for(int k = 0; k <randomValue; ++k)
           {
               s.enQueue(m);
               m++;
               s.totalNumberProcessed ++;     
           }
           
            int sentRate = 30;// max 30 mmsg /per min
            for(int k = 0; k <sentRate; ++k)
            {
                s.deQueue();
            }
            s.queuePerMinute += s.incomingMessage.size();
           
       }
       
       double arrvRate = s.arrvRate/ userInput; //calculate averages
       double averageSentPerMinute = s.sendPerMinute /userInput;
       double averageQueue = s.queuePerMinute/userInput;
       double reQueueAverage = s.requeuedMessage/userInput;      
   
       System.out.format("Total number of messages processed: %d", s.totalNumberProcessed);
       System.out.println();
       System.out.format("The average arrival rate is: %.2f\n", arrvRate);
       System.out.println();
       System.out.format("The average number of messages sent per minute is: %.2f\n", 
       averageSentPerMinute);
       System.out.println();
       System.out.format("The average number of messages in the queue per minute is: %.2f\n", averageQueue);
       System.out.println();
       
     
       if (s.sentAttempt_1 > 0)
          System.out.format("The number of messages sent on 1st attempt: %d\n" , s. sentAttempt_1);
       else
           System.out.println("There are no messages sent on 1st attempt");
       
       if (s.sentAttempt_2 > 0)
          System.out.format("The number of messages sent on 2nd attempt: %d\n" , s. sentAttempt_2);
       else
           System.out.println("There are no messages sent on 2nd attempt");
       
       if (s.sentAttempt_3 > 0)
          System.out.format("The number of messages sent on 3rd attempt: %d\n" , s. sentAttempt_3);
       else
           System.out.println("There are no messages sent on 3rd attempt");
       
       if (s.sentAttempt_4 > 0)
          System.out.format("The number of messages sent on 4th attempt: %d\n" , s. sentAttempt_4);
       else
           System.out.println("There are no messages sent on 4th attempt");
       
       if (s.sentAttempt_5 > 0)
          System.out.format("The number of messages sent on 5th attempt: %d\n" , s. sentAttempt_5);
       else
           System.out.println("There are no messages sent on 5th attempt");
       
       if (s.sentAttempt_6 > 0)
          System.out.format("The number of messages sent on 6th attempt: %d\n" , s. sentAttempt_6);
       else
           System.out.println("There are no messages sent on 6th attempt");
       
       if (s.sentAttempt_7 > 0)
          System.out.format("The number of messages sent on 7th attempt: %d\n" , s. sentAttempt_7);
       else
           System.out.println("There are no messages sent on 7th attempt");
       
       if (s.sentAttempt_8 > 0)
          System.out.format("The number of messages sent on 8th attempt: %d\n" , s. sentAttempt_8);
       else
           System.out.println("There are no messages sent on 8th attempt");
       
       if (s.sentAttempt_9 > 0)
          System.out.format("The number of messages sent on 9th attempt: %d\n" , s. sentAttempt_9);
       else
           System.out.println("There are no messages sent on 9th attempt");
       
       if (s.sentAttempt_10 > 0)
          System.out.format("The number of messages sent on 10th attempt: %d\n" , s. sentAttempt_10);
       else
           System.out.println("There are no messages sent on 10th attempt");
           

      System.out.println();
      System.out.format("The average number of times messages had to be requeued : %.2f\n", reQueueAverage);
    }   
}
       