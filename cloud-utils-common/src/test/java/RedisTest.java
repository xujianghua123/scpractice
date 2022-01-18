import redis.clients.jedis.Jedis;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/8 19:55
 */
public class RedisTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("42.192.6.87", 6379);
        jedis.set("test","tttt");
        System.out.println(jedis.get("test"));
    }
}
