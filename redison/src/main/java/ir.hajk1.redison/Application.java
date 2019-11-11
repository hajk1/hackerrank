package ir.hajk1.redison;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * Redis based demo application on Java
 */
public class Application implements Serializable {

  public static void main(String[] args) {
    Config config = new Config();
    // use single Redis server
    config.useSingleServer().setAddress("redis://127.0.0.1:6379");
    RedissonClient redisson = Redisson.create(config);
    // perform operations
    RBucket<String> bucket = redisson.getBucket("simpleObject");
    bucket.set("This is object value");
    RMap<String, String> map = redisson.getMap("simpleMap");
    map.put("mapKey", "This is map value");
    String objectValue = bucket.get();
    System.out.println("stored object value: " + objectValue);
    String mapValue = map.get("mapKey");
    System.out.println("stored map value: " + mapValue);
    mapValue = map.get("mapKey2");
    System.out.println("stored map value: " + mapValue);
    RMap<String, List<Application>> appMap = redisson.getMap("appMap");
    List<Application> applicationList = new ArrayList<>();
    applicationList.add(new Application());
    appMap.put("test1", applicationList);
    List<Application> a = appMap.get("test1");
    assert a != null;
    assert a.size() == 1;
    assert appMap.get("test2") == null;
    redisson.shutdown();
  }
}