package com.tsc.api.util;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataConverter {
    /**
     *This method converts provided datatype to desired datatype
     * @param-inputData - input Data that is to be converted
     * @param-returnType - return type for data
     * @return-Generic datatype - Generic data type that is returned by function on basis of input return type
     */
    public <T> T convertData(List<List<String>> inputData,T returnType){
        if(returnType.getClass().getName().toLowerCase().contains("map")){
            HashMap<String,String> hashMap = new HashMap<>();
            for(List<String> data:inputData){
                if(data.size()>2){
                    String value = null;
                    for(int i=1;i<data.size();i++){
                        value = value==null ? data.get(i) : value+":"+data.get(i);
                    }
                    hashMap.put(data.get(0),value);
                }else
                    hashMap.put(data.get(0),data.get(1));
            }
            return (T) hashMap;
        }

        return null;
    }

    /**
     *This method converts date in GMT to epoc date
     * @param-date - input date that is to be converted
     * @param-dateFormat - dateFormat of input Date to be converted
     * @return-long - epoc datetime value of converted date in GMT
     */
    public static long getTimeFromDate(String date, String dateFormat) throws ParseException {
        SimpleDateFormat simpleDateFormat;
        if(dateFormat == null)
            simpleDateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
        else
            simpleDateFormat = new SimpleDateFormat(dateFormat,Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date parsedDate = simpleDateFormat.parse(date);
        return parsedDate.getTime();
    }

    /**
     *This method converts local datetime to GMT
     * @return-long - epoc datetime value of converted date in GMT for local
     */
    public static long getLocalTimeInGMT() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTime= dateParser.parse(format.format(date));
        return dateTime.getTime();
    }

    /**
     *This method read json file into jsonObject
     * @param-jsonFilePath - jsonFile location at root location
     * @return-JSONObject
     */
    public static JSONObject readJsonFileIntoJSONObject(String jsonFileName) {
        JSONObject jsonObject = null;
        try{
            String path = ".//src//test//resources//";
            File file = new File(path + jsonFileName);
            if(file.length() != 0L){
                BufferedReader bufferedReader = new BufferedReader(new FileReader(path + jsonFileName));
                if(bufferedReader!= null){
                    JSONParser parser = new JSONParser();
                    Object obj = parser.parse(bufferedReader);
                    // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
                    jsonObject = (JSONObject) obj;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return jsonObject;
    }

    /**
     * To generate random string
     * @param length: generated string length
     * @param lsType: numberType/stringType/upperStringType/upperStringType/mixType
     * @return
     */
    public static String getSaltString(int length,String lsType) {
        String SALTCHARS = "";
        switch (lsType) {
            case "numberType":
                SALTCHARS = "1234567890";
                break;
            case "stringType":
                SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                break;
            case "upperStringType":
                SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                break;
            case "lowerStringType":
                SALTCHARS = "abcdefghijklmnopqrstuvwxyz";
                break;
            case "mixType":
                SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
                break;
            default:
                break;
        }

        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();

        return saltStr;
    }
}
