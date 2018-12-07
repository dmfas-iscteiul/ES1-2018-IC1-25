package utlity;

import java.util.Date;
/*
 *  This class groups the posts and emails of the social medias into a collection of header, content and Date. The date is used to rearrange
 *  the timeline.
 */
public class Lista implements Comparable<Lista>{
		String head;
		String cont;
		Date d;
		
		public Lista(String head, String cont, Date d) {
			super();
			this.head = head;
			this.cont = cont;
			this.d= d;
		}

		public String getHead() {
			return head;
		}

		public void setHead(String head) {
			this.head = head;
		}

		public String getCont() {
			return cont;
		}

		public void setCont(String cont) {
			this.cont = cont;
		}

		public Date getD() {
			return d;
		}

		public void setD(Date d) {
			this.d = d;
		}

		@Override
		public int compareTo(Lista arg0) {
			return getD().compareTo(arg0.getD());
		}
}
