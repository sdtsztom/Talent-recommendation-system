package util;

import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
    private static Properties props;

    public static void loadProps(String name) throws Exception{
        props = new Properties();
        InputStream in = PropertyUtil.class.getClassLoader().getResourceAsStream(name);
        props.load(in);
        if(in != null) in.close();
    }

    public static String getProperty(String key){
        if(null == props) return null;
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if(null == props) return null;
        return props.getProperty(key, defaultValue);
    }
}
