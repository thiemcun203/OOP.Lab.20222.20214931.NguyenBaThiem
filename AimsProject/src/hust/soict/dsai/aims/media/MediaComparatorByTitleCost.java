package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{
    @Override
	public int compare(Media m1, Media m2) {
		int res = m1.getTitle().compareTo(m2.getTitle());
		if(res == 0) {
			if(m1.getCost() < m2.getCost()) res = -1;
			else if(m1.getCost() > m2.getCost()) res = 1;
		}
		return res;
	}
}
