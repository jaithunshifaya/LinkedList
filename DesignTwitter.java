import java.util.*;

class Twitter {

    private static int timeStamp = 0;

    
    private class Tweet {
        int tweetId;
        int time;

        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    
    private Map<Integer, List<Tweet>> tweets;

    
    private Map<Integer, Set<Integer>> followings;

    public Twitter() {
        tweets = new HashMap<>();
        followings = new HashMap<>();
    }

    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timeStamp++));
    }

    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> minHeap = new PriorityQueue<>((a, b) -> a.time - b.time);

        
        Set<Integer> followeeSet = followings.getOrDefault(userId, new HashSet<>());
        followeeSet.add(userId); 

        for (int followeeId : followeeSet) {
            List<Tweet> tList = tweets.getOrDefault(followeeId, new ArrayList<>());
            for (Tweet tweet : tList) {
                minHeap.offer(tweet);
                if (minHeap.size() > 10) {
                    minHeap.poll(); 
                }
            }
        }

        
        LinkedList<Integer> result = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            result.addFirst(minHeap.poll().tweetId);
        }

        return result;
    }

   
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        followings.putIfAbsent(followerId, new HashSet<>());
        followings.get(followerId).add(followeeId);
    }

   
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        Set<Integer> fSet = followings.get(followerId);
        if (fSet != null) {
            fSet.remove(followeeId);
        }
    }
}