package twitterpack;

import java.util.ArrayList;
import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public final class Twitterapp {
	List<String> list = new ArrayList<>();
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
				// Filters only tweets from user "catarina"
				if (status.getUser().getName() != null && status.getUser().getName().contains("catarina")) {
					list.add(status.getUser().getName() + ":" + status.getText());
					counter++;
				}
				counterTotal++;
			}
			System.out.println("-------------\nN� of Results: " + counter + "/" + counterTotal);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public ArrayList<String> getList() {
		return (ArrayList<String>) list;
	}
	
	
	
	
	
}