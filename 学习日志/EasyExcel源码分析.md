# String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";的理解

## TestFileUtil.getPath()的实现

```java
public class TestFileUtil {
    public static String getPath() {
        return TestFileUtil.class.getResource("/").getPath();
    }
}
```

> 