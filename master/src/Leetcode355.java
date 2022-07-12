import java.util.*;

/** 355. 设计推特 https://leetcode.cn/problems/design-twitter/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode355 {
    /**
     * 面向对象编程，把twitter抽象成用户和推文两个对象
     */
    class Twitter {
        // 全局时间戳
        private int timestamp=0;

        /**
         * 每一个推文有自己的id号，时间
         * 每一个用户的推文用链表保存，按照时间顺序进行链接
         */
        private class Tweet{
            private int id;
            private int time;
            private Tweet next;

            public Tweet(int id,int time){
                this.id=id;
                this.time=time;
                this.next=null;
            }
        }

        /**
         * 每个用户有自己的id，和关注列表(不可重)
         * 以及自己的推文链表
         */
        private class User{
            // 用户id号
            private int id;
            // 用户关注列表
            public Set<Integer> followed;
            // 推文链表
            public Tweet head;

            public User(int userId){
                followed=new HashSet<>();
                this.id=userId;
                this.head=null;
                // 每个人默认关注自己
                follow(id);
            }
            // 关注某人，直接加入关注列表即可
            public void follow(int userId){
                followed.add(userId);
            }
            // 取消关注（不可取关自己），直接从集合中移除即可
            public void unfollow(int userId){
                if(userId!=this.id){
                    followed.remove(userId);
                }
            }
            // 发送推文
            public void post(int tweetId){
                // 根据推文id和时间戳新建推文
                Tweet twt = new Tweet(tweetId, timestamp);
                // 时间戳自增(来区分时间顺序)
                timestamp++;
                // 使用头插法(可以将最新的放在最前面)
                twt.next=head;
                head=twt;
            }
        }
        // 用户集合
        HashMap<Integer,User> userMap;
        public Twitter() {
            userMap=new HashMap<>();
        }
        // 某用户发送某推文
        public void postTweet(int userId, int tweetId) {
            // 如果用户不存在则新建用户
            if(!userMap.containsKey(userId)){
                userMap.put(userId,new User(userId));
            }
            // 从用户集合中获取用户
            User user = userMap.get(userId);
            // 调用用户的post方法发送推文
            user.post(tweetId);
        }
        // 某用户获取所有关注人的10条最新的推文
        public List<Integer> getNewsFeed(int userId) {
            // 存储结果
            List<Integer> res=new ArrayList<>();
            // 如果不包含某用户，直接返回结果
            if(!userMap.containsKey(userId)){
                return res;
            }
            // 获取某用户的关注列表
            Set<Integer> followed = userMap.get(userId).followed;
            // 设置大顶堆优先队列（默认会把时间顺序最新的放在队头，加上推文链表使用头插法从而保证了推文的时间顺序）
            // 大小为关注者的数量（因为每次只放每个关注者推文链表的头节点（头节点是时间顺序最新的））
            PriorityQueue<Tweet> pq = new PriorityQueue<>(followed.size(),(a,b)->(b.time-a.time));
            for (int id : followed) {
                // 获取每个用户推文的头节点
                Tweet head = userMap.get(id).head;
                // 头节点为空，代表此用户没有发过推文，直接开始下次循环
                if(head==null){
                    continue;
                }
                // 将推文头节点加入优先堆
                pq.add(head);
            }
            // 只要优先级队列不为空
            while (!pq.isEmpty()){
                // 如果结果集大小等于10，代表以及获取前10条推文了，结束循环
                if(res.size()==10){
                    break;
                }
                // 将优先级队列中队头的（时间顺序最先的）拿出来
                Tweet poll = pq.poll();
                // 加入结果集
                res.add(poll.id);
                // 此推文链表的上还有推文
                if(poll.next!=null){
                    // 再加入优先级队列，开始下次循环
                    pq.add(poll.next);
                }
            }
            return res;
        }
        // 某用户关注另一用户
        public void follow(int followerId, int followeeId) {
            // 如果某用户不存在，则创建
            if(!userMap.containsKey(followerId)){
                User user = new User(followerId);
                userMap.put(followerId,user);
            }
            // 如果另一用户不存在，则创建
            if(!userMap.containsKey(followeeId)){
                User user = new User(followeeId);
                userMap.put(followeeId,user);
            }
            // 调用某用户的follow方法（将另一用户放入某用户的关注列表中）
            userMap.get(followerId).follow(followeeId);
        }
        // 某用户取消关注另一用户
        public void unfollow(int followerId, int followeeId) {
            // 如果某用户不存在，则不执行任何操作，否则调用某用户的unfollow方法（从某用户的关注list中移除另一用户）
            if(userMap.containsKey(followerId)){
                User user = userMap.get(followerId);
                user.unfollow(followeeId);
            }
        }
    }
}
