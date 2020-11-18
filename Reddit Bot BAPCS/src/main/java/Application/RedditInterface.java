package Application;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.NetworkAdapter;
import net.dean.jraw.http.OkHttpNetworkAdapter;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.models.*;
import net.dean.jraw.oauth.Credentials;
import net.dean.jraw.oauth.OAuthHelper;
import net.dean.jraw.pagination.DefaultPaginator;
import net.dean.jraw.tree.CommentNode;
import net.dean.jraw.tree.RootCommentNode;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class RedditInterface {
    CSVDataReader csvDataReader;

    public RedditInterface() {
         csvDataReader = new CSVDataReader();
    }

    public void start() throws InterruptedException {
        // Reddit requires a User-Agent to track applications
        UserAgent userAgent = new UserAgent("bot", "com.example.ssdInfoCommenter", "v0.1", "TheSonOfDionysus");

        // Create our credentials
        Credentials credentials = Credentials.script("","","","");

        // This is what really sends HTTP requests
        NetworkAdapter adapter = new OkHttpNetworkAdapter(userAgent);

        // Authenticate and get a RedditClient instance
        RedditClient redditClient = OAuthHelper.automatic(adapter, credentials);

        // This is the main loop that will go on FOREVER but will wait for an hour before running again
        while (true) {
            // View a defined subreddit. specify options for getting 30 subreddit posts sorted by new
            DefaultPaginator.Builder<Submission, SubredditSort> paginatorBuilder = redditClient.subreddit("buildapcsales")
                    .posts()
                    .limit(30)
                    .sorting(SubredditSort.NEW);
            DefaultPaginator<Submission> paginator = paginatorBuilder.build();

            Listing<Submission> ThirtyNewPosts  = paginator.next();

            // For each loop that goes through each submission
            for (Submission s : ThirtyNewPosts) {
                // Take the title of the post and split it into a String array
                String[] submissionTitle = s.getTitle().split(" ");
                // If our bot has posted in the submission then we don't make a new comment
                boolean hasBotPostedInfoBefore = false;


                if (submissionTitle[0].equals("[SSD]")) {
                    System.out.println("Found SSD! " + s.getTitle());

                    // Request the comments of this submission.
                    RootCommentNode root = redditClient.submission(s.getId()).comments();

                    // walkTree() returns a Kotlin Sequence. Since we're using Java, we're going to have to
                    // turn it into an Iterator to get any use out of it.
                    Iterator<CommentNode<PublicContribution<?>>> it = root.walkTree().iterator();

                    while (it.hasNext()) {

                        // PublicContribution gets the next comment in the submission
                        PublicContribution<?> thing = it.next().getSubject();

                        // If the comment author is the name of this bot then we know we have posted in this submission and we skip it
                        if (thing.getAuthor().equals("TheSonOfDionysus") || thing.getAuthor().equals("SSDBot")) {
                            hasBotPostedInfoBefore = true;
                            System.out.println( thing.getAuthor() + " has already posted info");
                            break;
                        }
                    }

                    // If we have not posted in this submission before we are going to search the database for the ssd and post a formatted comment with the information for said ssd
                    // We perform two simple exact searches for the sdd before we search the entire title for a match using .contains()
                    if (!hasBotPostedInfoBefore) {
                        if (csvDataReader.searchSSD(submissionTitle[1])) {
                            redditClient.submission(s.getId()).reply(csvDataReader.print(submissionTitle[2]));
                            //System.out.println(csvDataReader.print(submissionTitle[1]));
                        } else if(csvDataReader.searchSSD(submissionTitle[2])) {
                            redditClient.submission(s.getId()).reply(csvDataReader.print(submissionTitle[2]));
                            //System.out.println(csvDataReader.print(submissionTitle[2]));
                        } else {
                            for (int i = 0; i < submissionTitle.length - 1; i++) {
                                System.out.println(submissionTitle[i] + " " + submissionTitle[i + 1]);
                                if (csvDataReader.deepSearchSSD(submissionTitle[i] + " " + submissionTitle[i + 1])) {
                                    //System.out.println(csvDataReader.printDeepSearch(submissionTitle[i] + " " + submissionTitle[i + 1]));
                                    redditClient.submission(s.getId()).reply(csvDataReader.printDeepSearch(submissionTitle[i] + " " + submissionTitle[i + 1]));
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            // After we go through all the submissions we take a break for an hour before the loop continues
            TimeUnit.MINUTES.sleep(60);
        }

    }
}
