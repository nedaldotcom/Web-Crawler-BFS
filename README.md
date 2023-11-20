# Web Crawler using Breadth-First Search Algorithm

This project is a simple implementation of a web crawler in Java. It uses the Breadth-First Search (BFS) algorithm to crawl websites starting from a given root URL.

## Code Explanation

1. **Queue and Set:** The `Queue` (implemented as a `LinkedList`) is used to hold URLs that are yet to be visited. The `Set` (implemented as a `HashSet`) is used to keep track of URLs that have already been visited. This is to avoid visiting the same URL more than once.

2. **URL Pattern:** A regular expression pattern for URLs is defined. This pattern is used to match URLs in the HTML content of the web pages visited.

3. **Starting Point:** The root URL for the web crawling is set in the `root` variable. This is the starting point of the crawl.

4. **BFS Algorithm:** The BFS algorithm is implemented in the `bfs()` method. BFS starts traversal from the root (top) of the tree (in this case, the root URL), and visits all the neighboring nodes at the present depth before moving on to nodes at the next depth level.

5. **Displaying Results:** The `CrawledWebsites()` method is used to display the URLs of the crawled websites.

## Usage

1. **Setting the Root URL:** Set the root URL for the web crawling in the `root` variable. This is the URL where the web crawler will start crawling.

2. **Running the Crawler:** Run the `main` method. The program will start crawling from the root URL. It will visit all the URLs linked from the root URL, then all the URLs linked from those URLs, and so on. The crawler stops when it has visited all reachable URLs or when it has visited 50 URLs, whichever comes first.

3. **Viewing the Results:** After the crawler has finished running, it will display the URLs of the crawled websites.

## Note

Please note that this is a basic implementation of a web crawler. It does not respect `robots.txt` files and it does not handle relative URLs. Use it responsibly and always respect the terms of service of the websites you are crawling.
