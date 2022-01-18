import cn.hutool.json.JSONUtil;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.util.CommonUtilsApplication;
import com.util.config.MongoDBConfig;
import org.bson.Document;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/8 20:01
 */
@ContextConfiguration(classes = CommonUtilsApplication.class)
public class MongoTest {

    @Resource
    private MongoDBConfig mongoDBConfig;

    @Test
    public void test(){

        MongoDatabase connByAuth = MongoDBConfig.getConnByAuth();

        MongoCollection<Document> userDocument = connByAuth.getCollection("user");

        Document document = new Document("name", "张三")
                .append("sex", "Male")
                .append("age", 22);
        // 插入
        userDocument.insertOne(document);

        // 查找
        FindIterable<Document> documents = userDocument.find();
        MongoCursor<Document> iterator = documents.iterator();
        while (iterator.hasNext()){
            Document next = iterator.next();
            System.out.println(JSONUtil.toJsonStr(next));
        }

    }

    @Test
    public void connTest(){
        MongoDatabase conn = mongoDBConfig.getConn();
    }
}
