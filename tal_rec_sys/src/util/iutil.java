package util;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

public class iutil {

//    public static String[] getValuesFromCookies(Cookie []cookies, String []keys){
//        // 注意：当cookies如果没有包含所有的keys对应的cookie，则会返回null
//        // 即当所有value都被找到时，才会返回values数组，否则返回null
//        int len=keys.length;
//        String values[]=new String[len];
//        boolean []mask=new boolean[len];
//        for(boolean i:mask)i=true;
//        int flag=-len;
//        for(Cookie cookie:cookies){
//            for(int i:range(len)){
//                if(mask[i]&&cookie.getName().equals(keys[i])){
//                    values[i]=cookie.getValue();
//                    mask[i]=false;
//                    ++flag;
//                    if(flag==0)break;
//                }
//            }
//        }
//        if(flag!=0)return null;
//        else return values;
//    }

    public static int [] range(int end){
        int value[]=new int[end];
        for(int i=0;i<end;++i)value[i]=i;
        return value;
    }

    public static String[][] transpose(String [][]array){
        int nrow=array.length;
        int ncol=array[0].length;
        String [][]t_array=new String[ncol][nrow];
        for(int i:range(nrow)){
            for(int j:range(ncol))t_array[j][i]=array[i][j];
        }
        return t_array;
    }

    public static String getDate(){
        Date date=new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        return "'"+df.format(date)+"'";
    }
    
    public static String formattedDate(Date date){
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }
}
