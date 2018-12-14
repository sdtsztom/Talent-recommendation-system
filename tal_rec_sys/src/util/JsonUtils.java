package util;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.SQLException;
import java.util.*;

public class JsonUtils {

    //**************************Obj2Str Method************************
    public static String toJSONString(JSONObject jsonObject)
    {
        return jsonObject.toString();
    }

    public static String toJSONString(JSONArray jsonArray)
    {
        return jsonArray.toString();
    }

    public static String toJSONString(Object object) {
        JSONObject jsonArray = JSONObject.fromObject(object);
        return jsonArray.toString();
    }

    public static <T> String toJSONString(ArrayList<T> list) {
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }
    //**************************toString Method************************

    //**************************Str2Obj Method************************
    public static <T> T Str2Obj(String json_str,Class<T> obj_class){
        JSONObject json =JSONObject.fromObject(json_str);
        return (T)JSONObject.toBean(json,obj_class);
    }

    public static <T> T[] Str2Array(String json_str,Class<T> obj_class){
        JSONArray json_array=JSONArray.fromObject(json_str);
        return (T[])JSONArray.toArray(json_array,obj_class);
    }

    //**************************toObj Method************************

    public static List<Map> toMap(CachedRowSetImpl rs, String... strings) throws SQLException {
        Map<String,String> map = null;
        List<Map> list = new ArrayList<>();
        while(rs.next()) {
            map = new HashMap<>();
            for(String s:strings) {
                map.put(s,rs.getString(s));
            }
            list.add(map);
        }
        return list;
    }

    /***
     * 将对象转换为List对象
     * @param object
     * @return
     */

    public static List toArrayList(Object object)
    {
        List arrayList = new ArrayList();

        JSONArray jsonArray = JSONArray.fromObject(object);

        Iterator it = jsonArray.iterator();
        while (it.hasNext())
        {
            JSONObject jsonObject = (JSONObject) it.next();

            Iterator keys = jsonObject.keys();
            while (keys.hasNext())
            {
                Object key = keys.next();
                Object value = jsonObject.get(key);
                arrayList.add(value);
            }
        }

        return arrayList;
    }

    /***
     * 将对象转换为Collection对象
     * @param object
     * @return
     */
    public static Collection toCollection(Object object)
    {
        JSONArray jsonArray = JSONArray.fromObject(object);

        return null;
    }

    /***
     * 将对象转换为JSON对象数组
     * @param object
     * @return
     */
    public static JSONArray toJSONArray(Object object)
    {
        return JSONArray.fromObject(object);
    }

    /***
     * 将对象转换为JSON对象
     * @param object
     * @return
     */
    public static JSONObject toJSONObject(Object object)
    {
        return JSONObject.fromObject(object);
    }

    /***
     * 将对象转换为List
     * @param object
     * @return
     */
// 返回非实体类型(Map)的List
    public static List<Map<String, Object>> toList(Object object)
    {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        JSONArray jsonArray = JSONArray.fromObject(object);
        for (Object obj : jsonArray)
        {
            JSONObject jsonObject = (JSONObject) obj;
            Map<String, Object> map = new HashMap<String, Object>();
            Iterator it = jsonObject.keys();
            while (it.hasNext())
            {
                String key = (String) it.next();
                Object value = jsonObject.get(key);
                map.put((String) key, value);
            }
            list.add(map);
        }
        return list;
    }

    /***
     * 将JSON对象数组转换为传入类型的List
     * @param
     * @param jsonArray
     * @param objectClass
     * @return
     */
    public static <T> List<T> toList(JSONArray jsonArray, Class<T> objectClass)
    {
        return JSONArray.toList(jsonArray, objectClass);
    }

    /***
     * 将对象转换为传入类型的List
     * @param
     * @para: jsonArray
     * @param: objectClass
     * @return
     */
    public static <T> List<T> toList(Object object, Class<T> objectClass)
    {
        JSONArray jsonArray = JSONArray.fromObject(object);

        return JSONArray.toList(jsonArray, objectClass);
    }

    /***
     * 将JSON对象转换为传入类型的对象
     * @param
     * @param jsonObject
     * @param beanClass
     * @return
     */
    public static <T> T toBean(JSONObject jsonObject, Class<T> beanClass)
    {
        return (T) JSONObject.toBean(jsonObject, beanClass);
    }

    /***
     * 将将对象转换为传入类型的对象
     * @param
     * @param object
     * @param beanClass
     * @return
     */
    public static <T> T toBean(Object object, Class<T> beanClass)
    {
        JSONObject jsonObject = JSONObject.fromObject(object);

        return (T) JSONObject.toBean(jsonObject, beanClass);
    }

}