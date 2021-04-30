import org.junit.Assert;
import org.junit.Test;

public class TestClass {

    @Test
    public void shouldReturnNullValue() {
        HashMap testhashmap = new HashMap();
        testhashmap.put(1, 3);
        Assert.assertNull(testhashmap.get(2));
    }

    @Test
    public void shouldPutToBuckets() {
        HashMap putHash = new HashMap();
        putHash.put(1, 5);
        putHash.put(1465, 5);
        putHash.put(356, 6);
        putHash.put(466, 3);
        System.out.println(putHash);
    }

    @Test
    public void shouldReturnValueByKey() {
        HashMap test = new HashMap();
        test.put(12, 3);
        long actual = test.get(12);
        Assert.assertEquals(3, actual);
    }

    @Test
    public void shouldReturnSize() {
        HashMap hashMap = new HashMap();
        hashMap.put(1,43);
        hashMap.put(1,4);
        hashMap.put(2,45);
        Assert.assertEquals(2, hashMap.size());
    }
}
