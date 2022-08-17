import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nidal Alkharbash
 */

public class WebCrawler {

    //Queue for BFS
    static Queue<String> queue = new LinkedList<>();

    //URLs already visited
    static Set<String> visited = new HashSet<>();

    //URL Pattern regex
    static String regex = "http[s]*://(\\w+\\.)*(\\w+)";

    //Starting point
    static String root = "https://www.okan.edu.tr";

    //BFS
    public static void bfs() throws IOException{
        // Insert the root(Url) to the Queue
        queue.add(root);
        // If the queue is empty(no root(url) in the queue)
        //this will be skipped
        while(!queue.isEmpty()){
            // .poll() function to remove and return the element
            // from the queue
            String remove = queue.poll();

            //Find almost 50 websites
            // This can be modified up to the user
            // I chose 50 to get done with the execution quickly
            if(visited.size()>50)return;

            boolean a = false;
            URL url = null;
            BufferedReader br = null;

            while(!a){
                try{
                    // url contains the removed element (returned element)
                    // from the queue
                    url = new URL(remove);
                    // using BufferedReader to access the url openStream
                    br = new BufferedReader(new InputStreamReader(url.openStream()));
                    // a is true to continue the loop and look
                    // for more URLs
                    a = true;
                // Catch an issue and handle it by URL java library
                // by showing MALformedURL Exception
                }catch(MalformedURLException e){
                    // to print the url where the exception occurred
                    System.out.println("\nMalformedURL : " + remove + "\n");

                    // Getting next URL from queue
                    remove = queue.poll();
                    a = false;
                // if there's an issue URL java library will throw IOException
                }catch(IOException e){
                    System.out.println("\nIOException occurred in the following URL: " + remove +"\n");
                    // Getting next URL from queue
                    remove = queue.poll();
                    a = false;
                }
            }
            // Making mutable strings using StringBuilder() function
            // (alternative String)
            StringBuilder sb = new StringBuilder();
            // If the buffer is empty, this will have no use and will be skipped.
            while((remove = br.readLine())!=null){
                // .append() to combine the characters(strings) together.
                sb.append(remove);
            }
            // convert the StringBuilder (String alternative) to a string.
            remove = sb.toString();
            // recognizing the pattern of URL to catch and compile.
            Pattern pattern = Pattern.compile(regex);
            // Mathcing the pattern defined in regex.
            Matcher matcher = pattern.matcher(remove);
            // .find() to find the match of regex and Url
            // if it's visited, the loop will be executed.
            while(matcher.find()){

                String found = matcher.group();
                // This will be executed as long as there's a pattern
                if(!visited.contains(found)){
                    // Adding it to the founded URLs and then grouping them
                    visited.add(found);
                    // Printing the founded sites
                    System.out.println("Founded Site: "+found);
                    // adding the founded urls to the queue
                    queue.add(found);
                }
            }
        }
    }

    //Display results
    public static void CrawledWebsites(){
        System.out.println("\nWeb sites crawled : "+visited.size()+"\n");
        System.out.println("\n\nSites that has been crawled: ");
        // loop to print the crawled sites
        for(String s:visited){
            System.out.println(s);
        }
    }

    // Main method to run the code
    public static void main(String[] args){
      // Used try statement here in case it throws an exception
      // and catch the required ones to use
        try{
            // Calling the bfs() function
            bfs();
            // Calling the CrawledWebsites() function
            CrawledWebsites();
        }catch(IOException e){
            System.out.println("IOException caught : "+e);
        }
    }
}
