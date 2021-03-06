package twitterpack;

import java.util.ArrayList;
import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import utlity.Lista;


/**
 * @author tiago
 *
 */
public final class Twitterapp {	
	
	List<Lista> lx = new ArrayList<>();

	
	/**
	 * Connects the program to twitter, gets posts from there and puts them into a List<String>
	 */
	public Twitterapp() {
		
		// http://twitter4j.org
		// http://twitter4j.org/en/code-examples.html
		// https://www.youtube.com/watch?v=uYPmkzMpnxw
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("W1f0VvgWPfT8OBqVxvy4Mw")
					.setOAuthConsumerSecret("zKH2yAtRyefwsgOO8h8Szc4kru68iEm95QmIG7svw")
					.setOAuthAccessToken("36481851-VhzByC4f9MSsZES1QZQ4e4iBvA9bWGLyv9HKFpy7c")
					.setOAuthAccessTokenSecret("OahDuXF2Lhl5xlNYALhYZir6xSflAxKP9Zh89T05po");
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
			List<Status> statuses = twitter.getHomeTimeline();
			System.out.println("------------------------\n Showing home timeline \n------------------------");
			int counter = 0;
			int counterTotal = 0;
			for (Status status : statuses) {
				if (status.getUser().getName() != null) {
					//list.add("Twitter:" + status.getUser().getName() + ":" + status.getText());
					lx.add(new Lista("Twitter:" + status.getUser().getName(), status.getText(), status.getCreatedAt()));
					counter++;
				}
				counterTotal++;
			}
			System.out.println("-------------\nN� of Results: " + counter + "/" + counterTotal);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * @return list of strings with the twitter posts
	 */
	public ArrayList<Lista> getLx() {
		return (ArrayList<Lista>) lx;
	}

	
}