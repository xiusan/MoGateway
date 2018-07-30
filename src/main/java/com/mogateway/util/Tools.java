package com.mogateway.util;

import com.mogateway.entity.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.xml.bind.JAXBException;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Tools {
	
	public static Double round(Double value) {
		BigDecimal b = new BigDecimal(value);
		return b.setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
	/**  
     * 将json对象中包含的null和JSONNull属性修改成""  
     * @param jsonObj  
     */  
    @SuppressWarnings("unchecked")
	public static void filterNull(JSONObject jsonObj){  
        Iterator<String> it = jsonObj.keys();  
        Object obj = null;  
        String key = null;  
        while (it.hasNext()) {  
            key = it.next();  
            obj = jsonObj.get(key);  
            if(obj instanceof JSONObject){  
                filterNull((JSONObject)obj);  
            }  
            if(obj instanceof JSONArray){  
                JSONArray objArr = (JSONArray) obj;  
                for(int i=0; i<objArr.size(); i++){  
                    filterNull(objArr.getJSONObject(i));  
                }  
            }  
            if(obj == null || obj instanceof JSONNull){  
                jsonObj.put(key, "");  
            }  
        }  
    }  

	private static Logger log = Logger.getLogger(Tools.class);
	
	/**
	 * 随机生成六位数验证码
	 * @return
	 */
	public static int getRandomNum(){
		 Random r = new Random();
		 return r.nextInt(900000)+100000;//(Math.random()*(999999-100000)+100000)
	}
	
	public static String getKey(String equipmentID, String attr) {
		return (equipmentID + ":" + attr).trim();
	}
	
    public static byte[] str2Bcd(String asc) {  
        int len = asc.length();  
        int mod = len % 2;  
        if (mod != 0) {  
            asc = "0" + asc;  
            len = asc.length();  
        }  
        byte abt[] = new byte[len];  
        if (len >= 2) {  
            len = len / 2;  
        }  
        byte bbt[] = new byte[len];  
        abt = asc.getBytes();  
        int j, k;  
        for (int p = 0; p < asc.length() / 2; p++) {  
            if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {  
                j = abt[2 * p] - '0';  
            } else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {  
                j = abt[2 * p] - 'a' + 0x0a;  
            } else {  
                j = abt[2 * p] - 'A' + 0x0a;  
            }  
            if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {  
                k = abt[2 * p + 1] - '0';  
            } else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {  
                k = abt[2 * p + 1] - 'a' + 0x0a;  
            } else {  
                k = abt[2 * p + 1] - 'A' + 0x0a;  
            }  
            int a = (j << 4) + k;  
            byte b = (byte) a;  
            bbt[p] = b;  
        }  
        return bbt;  
    }
    
    public static byte[] str2Bcd0(String asc) {  
        int len = asc.length();  
        int mod = len % 2;  
        if (mod != 0) {  
            asc = "0" + asc;  
            len = asc.length();  
        }  
        byte abt[] = new byte[len];  
        if (len >= 2) {  
            len = len / 2;  
        }  
        byte bbt[] = new byte[len];  
        abt = asc.getBytes();  
        int j, k;  
        for (int p = 0; p < asc.length() / 2; p++) {  
            if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {  
                j = abt[2 * p] - '0';  
            } else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {  
                j = abt[2 * p] - 'a' + 0x0a;  
            } else {  
                j = abt[2 * p] - 'A' + 0x0a;  
            }  
            if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {  
                k = abt[2 * p + 1] - '0';  
            } else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {  
                k = abt[2 * p + 1] - 'a' + 0x0a;  
            } else {  
                k = abt[2 * p + 1] - 'A' + 0x0a;  
            }  
            int a = (j << 4) + k;  
            byte b = (byte) a;  
            bbt[p] = b;  
        }
        len = bbt.length;
        byte[] result = new byte[4];
        if (len == 4) {
			result[0] = bbt[3];
			result[1] = bbt[2];
			result[2] = bbt[1];
			result[3] = bbt[0];
		} else if (len == 3) {
			result[0] = bbt[2];
			result[1] = bbt[1];
			result[2] = bbt[0];
			result[3] = 0x00;
		} else if (len == 2) {
			result[0] = bbt[1];
			result[1] = bbt[0];
			result[2] = 0x00;
			result[3] = 0x00;
		} else if (len == 1) {
			result[0] = bbt[0];
			result[1] = 0x00;
			result[2] = 0x00;
			result[3] = 0x00;
		} else {
			result[0] = 0x00;
			result[1] = 0x00;
			result[2] = 0x00;
			result[3] = 0x00;
		}
        return result;
    }
    
    public static byte[] str2Bcd1(String asc) {  
        int len = asc.length();  
        int mod = len % 2;  
        if (mod != 0) {  
            asc = "0" + asc;  
            len = asc.length();  
        }  
        byte abt[] = new byte[len];  
        if (len >= 2) {  
            len = len / 2;  
        }  
        byte bbt[] = new byte[len];  
        abt = asc.getBytes();  
        int j, k;  
        for (int p = 0; p < asc.length() / 2; p++) {  
            if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {  
                j = abt[2 * p] - '0';  
            } else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {  
                j = abt[2 * p] - 'a' + 0x0a;  
            } else {  
                j = abt[2 * p] - 'A' + 0x0a;  
            }  
            if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {  
                k = abt[2 * p + 1] - '0';  
            } else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {  
                k = abt[2 * p + 1] - 'a' + 0x0a;  
            } else {  
                k = abt[2 * p + 1] - 'A' + 0x0a;  
            }  
            int a = (j << 4) + k;  
            byte b = (byte) a;  
            bbt[p] = b;  
        }
        len = bbt.length;
        byte[] result = new byte[3];
        if (len == 3) {
			result[0] = bbt[2];
			result[1] = bbt[1];
			result[2] = bbt[0];
		} else if (len == 2) {
			result[0] = bbt[1];
			result[1] = bbt[0];
			result[2] = 0x00;
			result[3] = 0x00;
		} else if (len == 1) {
			result[0] = bbt[0];
			result[1] = 0x00;
			result[2] = 0x00;
		} else {
			result[0] = 0x00;
			result[1] = 0x00;
			result[2] = 0x00;
		}
        return result;
    }

	public static String byte2HexStr(byte[] b) {
	    String stmp = "";
	    StringBuilder sb = new StringBuilder("");
	    for (int n = 0; n < b.length; n++) {
	        stmp = Integer.toHexString(b[n] & 0xFF);
	        sb.append((stmp.length() == 1) ? "0" + stmp : stmp);
	    }
	    return sb.toString().toUpperCase().trim();
	}
	
	public static byte[] File2byte(File file)  
    {  
        byte[] buffer = null;  
        try {   
            FileInputStream fis = new FileInputStream(file);  
            ByteArrayOutputStream bos = new ByteArrayOutputStream();  
            byte[] b = new byte[1024];  
            int n;  
            while ((n = fis.read(b)) != -1)  
            {  
                bos.write(b, 0, n);  
            }  
            fis.close();  
            bos.close();  
            buffer = bos.toByteArray();  
        }  
        catch (FileNotFoundException e)  
        {  
            e.printStackTrace();  
        }  
        catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
        return buffer;  
    }
	
	/**
	 * 检测字符串是否不为空(null,"","null")
	 * @param s
	 * @return 不为空则返回true，否则返回false
	 */
	public static boolean notEmpty(String s){
		return s!=null && !"".equals(s) && !"null".equals(s);
	}

    /** 压缩单个文件*/
    public static int ZipFile(String filepath ,String zippath) {
    	try {
            File file = new File(filepath);
            File zipFile = new File(zippath.concat(".zip"));
            if (!zipFile.exists()) {
				zipFile.createNewFile();
			}
            InputStream input = new FileInputStream(file);
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
            zipOut.putNextEntry(new ZipEntry(file.getName()));
            int temp = 0;
            while((temp = input.read()) != -1){
                zipOut.write(temp);
            }
            input.close();
            zipOut.flush();
            zipOut.close();
            zipFile = null;
            file = null;
            return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}
    
    /**
     * 解压文件
     * 
     * @param filePath
     *            压缩文件路径
     * @throws IOException 
     */
    public static String unzip(String filePath){
    	String result = null;
        File source = new File(filePath);
        if (source.exists()) {
            ZipInputStream zis = null;
            BufferedOutputStream bos = null;
            try {
                zis = new ZipInputStream(new FileInputStream(source));
                ZipEntry entry = null;
                while ((entry = zis.getNextEntry()) != null
                        && !entry.isDirectory()) {
                    result = entry.getName();
                    File target = new File(source.getParent(), entry.getName());
                    if (!target.getParentFile().exists()) {
                        // 创建文件父目录
                        target.getParentFile().mkdirs();
                    }
                    // 写入文件
                    bos = new BufferedOutputStream(new FileOutputStream(target));
                    int read = 0;
                    byte[] buffer = new byte[1024 * 10];
                    while ((read = zis.read(buffer, 0, buffer.length)) != -1) {
                        bos.write(buffer, 0, read);
                    }
                    bos.flush();
                }
                zis.closeEntry();
                zis.close();
                bos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
    
    /** *//**文件重命名 
     * @param path 文件目录 
     * @param oldname  原来的文件名 
     * @param newname 新文件名 
     */ 
     public static void renameFile(String path,String oldname,String newname){ 
         if(!oldname.equals(newname)){//新的文件名和以前文件名不同时,才有必要进行重命名 
             File oldfile = new File(path + "/" + oldname); 
             File newfile = new File(path + "/" + newname); 
             if(!oldfile.exists()){
                 return;//重命名文件不存在
             }
             if(newfile.exists())//若在该目录下已经有一个文件和新文件名相同，则不允许重命名 
                 System.out.println(newname + "已经存在！"); 
             else{ 
                 oldfile.renameTo(newfile); 
             } 
         }else{
             System.out.println("新文件名和旧文件名相同...");
         }
     }

    public static Date ObjToDate(Object obj){
        SimpleDateFormat sdf = null;
        Date date = null;
        if(obj != null){
            try{
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                date = sdf.parse(obj.toString());
                return date;
            }catch(Exception e){
                e.printStackTrace();
            };
        }else{
            return null;
        }

        return date;
    }
    
    public static String getFileName(String f) {
        String fname = "";
        int i = f.lastIndexOf('.');
 
        if (i > 0 &&  i < f.length() - 1) {
            fname = f.substring(0,i);
        }       
        return fname;
    }

    /**
     * gzip格式解压
     * @param inFileName 要解压的文件名
     */
    public static String unGzip(String inFileName) {
    	String result = null;
        try {
            GZIPInputStream in = null;
            try {
                in = new GZIPInputStream(new FileInputStream(inFileName));
            } catch(FileNotFoundException e) {
            	log.error("解压文件不存在!");
            }
            String outFileName = getFileName(inFileName).concat(".txt");
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(outFileName);
            } catch (FileNotFoundException e) {
               log.error("写入" + outFileName + "异常");
            }
            
            byte[] buf = new byte[4 * 1024];
            int len = 0;
            
            while((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
            }
 
            log.info(inFileName + "解压成功!");
            in.close();
            out.close();
            result = outFileName;
        
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return result;
    }
    
	/**
	 * 检测字符串是否为空(null,"","null")
	 * @param s
	 * @return 为空则返回true，不否则返回false
	 */
	public static boolean isEmpty(String s){
		return s==null || "".equals(s) || "null".equals(s);
	}

	/**
	 * 字符串转换为字符串数组
	 * @param str 字符串
	 * @param splitRegex 分隔符
	 * @return
	 */
	public static String[] str2StrArray(String str,String splitRegex){
		if(isEmpty(str)){
			return null;
		}
		return str.split(splitRegex);
	}

	/**
	 * 用默认的分隔符(,)将字符串转换为字符串数组
	 * @param str	字符串
	 * @return
	 */
	public static String[] str2StrArray(String str){
		return str2StrArray(str,",\\s*");
	}

	/**
	 * 按照yyyy-MM-dd HH:mm:ss的格式，日期转字符串
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String date2Str(Date date){
		if (date == null) {
			return "";
		}
		return date2Str(date,"yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 按照yyyy-MM-dd HH:mm:ss的格式，字符串转datetime
	 * @param date
	 * @return
	 */
	public static Date str2DateTime(String date){
		if(date.length() == 10) {
			date = date + " 00:00:00";
		} else if(date.length() == 13) {
			date = date + ":00:00";
		} else if (date.length() == 16) {
			date = date + ":00";
		}
		if(notEmpty(date)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new Date();
		}else{
			return null;
		}
	}
	
	public static Date str2DateTime(String date, String formate){
		if(date.length() == 10) {
			date = date + " 00:00:00";
		} else if(date.length() == 13) {
			date = date + ":00:00";
		} else if (date.length() == 16) {
			date = date + ":00";
		}
		if(notEmpty(date)){
			SimpleDateFormat sdf = new SimpleDateFormat(formate);
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new Date();
		}else{
			return null;
		}
	}
	
	public static String time2Str(Time time){
		if(time!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			return sdf.format(time);
		}else{
			return "";
		}
	}
	
	 public static Time str2Time(String strDate) {  
	     String str = strDate;  
	     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	     Date d = null;
	     try {  
	         d = format.parse(str);  
	     } catch (Exception e) {  
	         e.printStackTrace();  
	     }  
	     Time time = new Time(d.getTime());  
	     return time;  
	 } 


	/**
	 * 按照yyyy-MM-dd HH:mm:ss的格式，字符串转date
	 * @param date
	 * @return
	 */
	public static Date str2Date(String date){
		if(notEmpty(date)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new Date();
		}else{
			return null;
		}
	}

	/**
	 * 按照参数format的格式，日期转字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2Str(Date date,String format){
		if(date!=null){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}else{
			return "";
		}
	}

	/**
	 * 把时间根据时、分、秒转换为时间段
	 * @param StrDate
	 */
	public static String getTimes(String StrDate){
		String resultTimes = "";

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date now;

	    try {
	    	now = new Date();
	    	Date date=df.parse(StrDate);
	    	long times = now.getTime()-date.getTime();
	    	long day  =  times/(24*60*60*1000);
	    	long hour = (times/(60*60*1000)-day*24);
	    	long min  = ((times/(60*1000))-day*24*60-hour*60);
	    	long sec  = (times/1000-day*24*60*60-hour*60*60-min*60);

	    	StringBuffer sb = new StringBuffer();
	    	if(hour>0 ){
	    		sb.append(hour+"小时前");
	    	} else if(min>0){
	    		sb.append(min+"分钟前");
	    	} else{
	    		sb.append(sec+"秒前");
	    	}

	    	resultTimes = sb.toString();
	    } catch (ParseException e) {
	    	e.printStackTrace();
	    }

	    return resultTimes;
	}

	/**
	 * 文件中写入内容
	 * @param filePath  文件路径
	 * @param content  写入的内容
	 */
	public static void writeFile(String fileP, String content, boolean isAbsolutePath) throws IOException{
		String filePath = "";
		if (isAbsolutePath) {
			filePath = fileP.trim();
			File file = new File(filePath);
			if(file != null && !file.exists()){
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}
				file.createNewFile();
			}
		} else {
			filePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))+"../../";	//项目路径
			filePath = (filePath.trim() + fileP.trim()).substring(6).trim();
			if(filePath.indexOf(":") != 1){
				filePath = File.separator + filePath;
			}
		}
        OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(filePath),"utf-8");
        BufferedWriter writer=new BufferedWriter(write);
        writer.write(content);
        writer.close();
	}

	/**
	  * 验证邮箱
	  * @param email
	  * @return
	  */
	 public static boolean checkEmail(String email){
	  boolean flag = false;
	  try{
	    String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	    Pattern regex = Pattern.compile(check);
	    Matcher matcher = regex.matcher(email);
	    flag = matcher.matches();
	   }catch(Exception e){
	    flag = false;
	   }
	  return flag;
	 }

	 /**
	  * 验证手机号码
	  * @param mobiles
	  * @return
	  */
	 public static boolean checkMobileNumber(String mobileNumber){
	  boolean flag = false;
	  try{
	    Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
	    Matcher matcher = regex.matcher(mobileNumber);
	    flag = matcher.matches();
	   }catch(Exception e){
	    flag = false;
	   }
	  return flag;
	 }

	/**
	 * 读取txt里的单行内容
	 * @param filePath  文件路径
	 */
	public static String readTxtFile(String fileP) {
		try {

			String filePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))+"../../";	//项目路径
			filePath = filePath.replaceAll("file:/", "");
			filePath = filePath.replaceAll("%20", " ");
			filePath = filePath.trim() + fileP.trim();
			if(filePath.indexOf(":") != 1){
				filePath = File.separator + filePath;
			}
			String encoding = "utf-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { 		// 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
				new FileInputStream(file), encoding);	// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					return lineTxt;
				}
				read.close();
			}else{
				System.out.println("找不到指定的文件,查看此路径是否正确:"+filePath);
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
		}
		return "";
	}
	
	public static String readTxt(String filePath){
		String lineTxt = null;
        try {
            String encoding="utf-8";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                lineTxt = bufferedReader.readLine();
                read.close();
            } else {
            	System.out.println("找不到指定的文件".concat(filePath));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lineTxt;
    }


	public static void main(String[] args) {
		System.out.println(getRandomNum());
	}

    public static Object ConvertHashMap(Class<?> z, Object obj) {

        HashMap<String,Object> map = new HashMap<String,Object>();
        try{
        Field[] fields = z.getDeclaredFields();
        for(Field field : fields) {
            Method method = z.getMethod("get".concat(field.getName().substring(0, 1).toUpperCase()+field.getName().substring(1)));
            map.put(field.getName().substring(0, 1).toUpperCase()+field.getName().substring(1), method.invoke(obj));
        }
    } catch(Exception e) {
        e.printStackTrace();
    }

    return map;
}
    // 获得当前系统时间
    public static Date getNowtimeTwo() throws ParseException {
    	Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sdf.format(d);
        return sdf.parse(now);
    }

    public static Object ConvertObject(Class<?> z, HashMap<String,Object> map) {

        Object obj = new Object();
        try{
        Field[] fields = z.getDeclaredFields();
        obj = z.newInstance();
        for(Field field : fields) {
            Method method = z.getMethod("set".concat(field.getName().substring(0, 1).toUpperCase()+field.getName().substring(1)),field.getType());
            method.invoke(obj, map.get(field.getName().substring(0, 1).toUpperCase()+field.getName().substring(1)));
        }
    } catch(Exception e) {
        e.printStackTrace();
    }

    return obj;
}
    /**
     * ConfigurationInfo Deserialize
     * @param is
     * @return
     */
    public static Object deserializeSingleObject(InputStream is) {
        XMLDecoder xd = new XMLDecoder(is);
        Object obj = xd.readObject();
        xd.close();
        return obj;
    }
    /**
     * ConfigurationInfo Serializable
     * @param os
     * @param obj
     */
    public static void serializeSingleObject(OutputStream os, Object obj) {
        XMLEncoder xe = new XMLEncoder(os, "UTF-8", true, 0);
        xe.writeObject(obj);
        xe.close();
    }

   /* *//**
     * 发送邮件
     * @param email 收件人邮箱
     * @param title 主题
     * @param message 内容
     * @return true为发送成功;false为发送失败
     * @throws JAXBException
     *//*
    public static boolean sendMail(String email,String title, String message) throws JAXBException {
    	boolean ret = false;
    	String filePath = Const.SYSTEMCONFIG_PATH_BUS;
		File file = new File(filePath + Const.SYSNAMEINFO);
        MailSenderInfo mailInfo = new MailSenderInfo();
		if (file.exists()) {
			XmlSerializer<MailInfo> xSerializer = new XmlSerializer<MailInfo>();
			mailInfo.setMailServerHost(xSerializer.unMarshallXml(file, MailInfo.class).getMailServerHost());
			mailInfo.setMailServerPort(xSerializer.unMarshallXml(file, MailInfo.class).getMailServerPort());
			mailInfo.setFromAddress(xSerializer.unMarshallXml(file, MailInfo.class).getSenderAddress());
			mailInfo.setUserName(xSerializer.unMarshallXml(file, MailInfo.class).getUserName());
			mailInfo.setPassword(xSerializer.unMarshallXml(file, MailInfo.class).getPassword());
		} else {
			mailInfo.setMailServerHost(Const.MAILSERVERHOST);
			mailInfo.setMailServerPort(Const.MAILSERVERPORT);
			mailInfo.setFromAddress(Const.SENDERADDRESS);
			mailInfo.setUserName(Const.USERNAME_BUS);
			mailInfo.setPassword(Const.PASSWORD);
		}
        // 是否需要身份验证
        mailInfo.setValidate(true);
        // 设置接受者邮箱地址
        mailInfo.setToAddress(email);
        // 设置邮件标题
        mailInfo.setSubject(title);
        // 设置邮件内容
        mailInfo.setContent(message);
        SimpleMailSender sms = new SimpleMailSender();
        // 发送文体格式
        ret = sms.sendTextMail(mailInfo);
        // 发送html格式
        //sms.sendHtmlMail(mailInfo);

        return ret;
    }*/
    public static void saveBase64DataToImage(String base64Data, String filePath) throws Exception {
    	BASE64Decoder d = new BASE64Decoder();
    	byte[] bs = d.decodeBuffer(base64Data);
    	File file = new File(filePath);
    	if (!file.exists()) {
    		if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
    		file.createNewFile();
    	}
    	FileOutputStream os = new FileOutputStream(filePath);
    	os.write(bs);
    	os.close();
    	os = null;
    }
    public static String readLocalImageToBase64(File file) throws Exception {
    	FileInputStream in = new FileInputStream(file);
		byte[] data = new byte[in.available()];
		in.read(data);
		in.close();
		return new BASE64Encoder().encode(data);
    }
    
    public static boolean isNumeric(String str){
	   Pattern pattern = Pattern.compile("[0-9]+");
	   Matcher isNum = pattern.matcher(str);
	   if(!isNum.matches()){
	       return false;
	   }
	   return true;
    }
    
	public static String secToTime(int time) {
	    String timeStr = null;
	    int hour = 0;
	    int minute = 0;
	    int second = 0;
	    if (time <= 0)
	        return "0秒";
	    else {
	        minute = time / 60;
	        if (minute < 60) {
	            second = time % 60;
	            timeStr = String.valueOf(minute) + "分" + String.valueOf(second) + "秒";
	        } else {
	            hour = minute / 60;
	            minute = minute % 60;
	            second = time - hour * 3600 - minute * 60;
	            timeStr = String.valueOf(hour) + "小时" + String.valueOf(minute) + "分" + String.valueOf(second) + "秒";
	        }
	    }
	    return timeStr;
	}
	
	public static String convertMsg(RedisTemplate<Serializable, Object> redisTemplate, Message message) {
		byte[] body = message.getBody();
		return redisTemplate.getValueSerializer().deserialize(body).toString();
	}

    /**
     * 获取当前用户
     * @return
     */
	public static User getUser() {
        User user = new User();
        user.setUserName("admin");

		return user;
	}


}
