package Year2020;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode355 {

    public static void main(String[] args) {

//        ["Twitter","postTweet","getNewsFeed","follow","getNewsFeed","unfollow","getNewsFeed"]
//[[],[1,1],[1],[2,1],[2],[2,1],[2]]

        Twitter twitter = new Twitter();
        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.follow(1, 5);
//        twitter.postTweet(1, 1);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        twitter.getNewsFeed(1);


    }

    static class Twitter {

        private int date = 0;
        private Map<Integer, User> userMap;

        class User {
            public List<Tweet> tweets = new ArrayList<>();
            public Set<Integer> follows = new HashSet<>();
        }

        class Tweet {
            public int tweetId;
            public int createDate;

            public Tweet(int tweetId) {
                this.tweetId = tweetId;
                createDate = date;
                date++;
            }

            public int getCreateDate() {
                return createDate;
            }

        }

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            userMap = new HashMap<>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            User user = userMap.computeIfAbsent(userId, v -> new User());
            Tweet tweet = new Tweet(tweetId);
            user.tweets.add(tweet);
            if (user.tweets.size()>10){
                user.tweets.remove(0);
            }
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            List<Tweet> allTweetList = new ArrayList<>();
            User user = userMap.get(userId);
            if (user != null) {
                allTweetList.addAll(user.tweets);
                if (user.follows != null) {
                    user.follows.forEach(v -> {
                        if (userMap.get(v) != null) {
                            allTweetList.addAll(userMap.get(v).tweets);
                        }
                    });
                }
            }
            allTweetList.sort(Comparator.comparing(Tweet::getCreateDate).reversed());
            return allTweetList.stream().limit(10).map(v -> v.tweetId).collect(Collectors.toList());
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            User user = userMap.computeIfAbsent(followerId, v -> new User());
            if (followeeId!=followerId) {
                user.follows.add(followeeId);
            }
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            User user = userMap.get(followerId);
            if (user!=null) {
                user.follows.remove(followeeId);
            }
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}