import java.util.*;

/**
 * Created by thanksgiving on 8/30/16.
 */
public class DesignTwitter {
    public static void main(String[] args) {
       /* Twitter obj = new Twitter();
        obj.postTweet(1, 5);
        System.out.println(obj.getNewsFeed(1));
        obj.follow(1, 2);
        obj.postTweet(2, 3);
        System.out.println(obj.getNewsFeed(1));
        obj.unfollow(1, 2);
        System.out.println(obj.getNewsFeed(1));*/

       /* Twitter obj = new Twitter();
        obj.postTweet(1, 5);
        obj.postTweet(1, 3);
        System.out.println(obj.getNewsFeed(1));*/


        Twitter obj = new Twitter();
        obj.postTweet(1, 5);
        obj.follow(1, 2);
        obj.follow(2, 1);
        System.out.println(obj.getNewsFeed(2));
        obj.postTweet(2, 6);
        System.out.println(obj.getNewsFeed(1));
        System.out.println(obj.getNewsFeed(2));
        obj.unfollow(2, 1);
        System.out.println(obj.getNewsFeed(1));
        System.out.println(obj.getNewsFeed(2));
        obj.unfollow(1, 2);
        System.out.println(obj.getNewsFeed(1));
        System.out.println(obj.getNewsFeed(2));
    }

    public static class Twitter {
        Map<Integer, PriorityQueue<Post>> feedMap;
        Map<Integer, Set<Integer>> followMap;
        int time;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            feedMap = new HashMap<>();
            followMap = new HashMap<>();
            time = 0;
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            PriorityQueue<Post> list;
            if (feedMap.containsKey(userId)) {
                list = feedMap.get(userId);
            } else {
                list = new PriorityQueue<>(new MyComparator());
            }
            list.add(new Post(time, tweetId));
            time++;
            feedMap.put(userId, list);
            Set<Integer> set;
            if (followMap.containsKey(userId)) {
                set = followMap.get(userId);
            } else {
                set = new HashSet<>();
            }
            set.add(userId);
            followMap.put(userId, set);
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            if (!followMap.containsKey(userId)) {
                return new ArrayList<>();
            }
            PriorityQueue<Post> pq = new PriorityQueue<>(new MyComparator());
            Set<Integer> followers = followMap.get(userId);
            for (Integer user : followers) {
                if (feedMap.containsKey(user)) {
                    PriorityQueue<Post> posts = feedMap.get(user);
                    int min = Math.min(10, posts.size());
                    List<Post> list = new ArrayList<>();
                    for (int i = 0; i < min; i++) {
                        Post last = posts.poll();
                        pq.add(last);
                        list.add(last);
                    }
                    for (Post p : list) {
                        posts.add(p);
                    }
                }
            }
            List<Integer> res = new ArrayList<>();
            int min = Math.min(10, pq.size());
            for (int i = 0; i < min; i++) {
                res.add(pq.poll().tweetId);
            }
            return res;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            if (followerId == followeeId) return;
            Set<Integer> set;
            if (!followMap.containsKey(followerId)) {
                set = new HashSet<>();
            } else {
                set = followMap.get(followerId);
            }
            set.add(followeeId);
            set.add(followerId);
            followMap.put(followerId, set);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            if (followerId == followeeId) return;
            Set<Integer> set;
            if (!followMap.containsKey(followerId)) {
                return;
            } else {
                set = followMap.get(followerId);
            }
            if (set.contains(followeeId)) {
                set.remove(followeeId);
                followMap.put(followerId, set);
            }
        }

        class Post {
            long timestamp;
            int tweetId;

            public Post(long timestamp, int tweetId) {
                this.timestamp = timestamp;
                this.tweetId = tweetId;
            }

            public String toString() {
                return "[" + tweetId + "]";
            }
        }

        class MyComparator implements Comparator<Post> {
            public int compare(Post a, Post b) {
                return (int) -(a.timestamp - b.timestamp);
            }
        }
    }
}
