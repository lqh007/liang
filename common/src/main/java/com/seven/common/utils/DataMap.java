package com.seven.common.utils;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * 
 * ClassName: DataMap 
 * @Description: 封装Map，对put，get的key进行驼峰转换。新增parse静态方法，装换ResultSet为Map
 * @author zhangbo
 * @date May 16, 2014
 */
@Component
public class DataMap extends HashMap<String, Object> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String primaryKey;
	
	public DataMap put(String key, Object value) {
		if (CameCaseUtil.isCame(key)) {
			super.put(key, value);
			return this;
		} else {
			super.put(CameCaseUtil.toCamelCase(key), value);
			return this;
		}
	}

	public Object get(Object key) {
		if(CameCaseUtil.isCame((String)key)){
			if(super.get((String)key) instanceof Clob){
				return ClobToString((Clob)super.get((String)key));
			}
			return super.get((String)key);
		}else{
			return super.get(CameCaseUtil.toCamelCase((String)key));
		}
	}

	public static DataMap parse(ResultSet rs) throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData();
		DataMap map = new DataMap();
		for (int n = 1; n <= metaData.getColumnCount(); n++) {
			String column = metaData.getColumnName(n);
			map.put(CameCaseUtil.toCamelCase(column), rs.getObject(column));
		}
		return map;
	}
	/**
	 * 
	 * @Description: 将bean转变为Map,key为驼峰命名
	 * @param @param bean
	 * @param @return   
	 * @return DataMap  
	 * @throws IntrospectionException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws
	 * @author zhangbo
	 * @date May 16, 2014
	 *
	 */
	public static DataMap getMap(Object bean){
		Class<? extends Object> cls = bean.getClass();
		DataMap map = new DataMap();
		String simpleName = cls.getSimpleName();
		//设置表名，如果设置了Table注解，则取注解的表名，如果没有，则按取类名进行下划线转化处理
		Table tab = cls.getAnnotation(Table.class);
		if(tab!=null){
			map.put("tableName", tab.name());
		}else{
				map.put("tableName", CameCaseUtil.toUnderScoreCase(simpleName));
		}
		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(cls);
			PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor propertyDescriptor : descriptors) {
				String propertyName = propertyDescriptor.getName();
				if(!propertyName.equals("class")){
					//获取get方法
					Method readMethod = propertyDescriptor.getReadMethod();
					Column c = readMethod.getAnnotation(Column.class);
					if(c == null){
						continue;
					}
					Id id = readMethod.getAnnotation(Id.class);
					if(id != null){
						map.setPrimaryKey(readMethod.getName());
					}
					Object value = readMethod.invoke(bean, new Object[0]);
					if(value != null){
						if(value instanceof String){
							map.put(propertyName, value.toString().trim());
						}else{
							map.put(propertyName, value);
						}
					}else{
						map.put(propertyName, null);
					}
				}
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return map;
	}
	public static String parseUrl(String url,Object bean){
		if(null != url){
			boolean ifq = url.contains("?");
			if(!ifq){
				url+="?";
			}
			Class<? extends Object> cls = bean.getClass();
			BeanInfo beanInfo;
			try {
				beanInfo = Introspector.getBeanInfo(cls);
				PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
				boolean ifand = false;
				for (PropertyDescriptor propertyDescriptor : descriptors) {
					String propertyName = propertyDescriptor.getName();
					if(!propertyName.equals("class")){
						//获取get方法
						Method readMethod = propertyDescriptor.getReadMethod();
						Object value = readMethod.invoke(bean, new Object[0]);
						if(value != null && !value.equals("")){
							if(!ifq){
								if(ifand){
									url += "&"+propertyName+"="+value;
								}else{
									url += propertyName+"="+value;
									ifand = true;
								}
							}else{
								url += "&"+propertyName+"="+value;
							}
							
						}
					}
				}
			} catch (IntrospectionException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return url;
	}
	
	
	public static String parseUrl(String url,DataMap bean){
		if(null != url){
			boolean ifq = url.contains("?");
			if(!ifq){
				url+="?";
			}
			boolean ifand = false;
			for (String key : bean.keySet()) {
				if(!key.equals("class") && !key.equals("tableName")){
					//获取get方法
					Object value = bean.get(key);
					if(value != null && !value.equals("")){
						if(!ifq){
							if(ifand){
								url += "&"+key+"="+value;
							}else{
								url += key+"="+value;
								ifand = true;
							}
						}else{
							url += "&"+key+"="+value;
						}
						
					}
				}
			}
		}
		return url;
	}
	
	public boolean isPrimaryKey(String key) {
		boolean flag = false;
		if(key.equals(primaryKey)){
			flag = true;
		}
		return flag;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey.substring(3,primaryKey.length());
		this.primaryKey = CameCaseUtil.toCamelCase(CameCaseUtil.toUnderScoreCase(this.primaryKey));
		this.put("primaryKey", this.primaryKey);
	}
	
	//oracle.sql.Clob类型转换成String类型
    public String ClobToString(Clob clob) {
        String reString = "";
        Reader is = null;
        try {
            is = clob.getCharacterStream();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 得到流
        BufferedReader br = new BufferedReader(is);
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer();
        while (s != null) {
            //执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
            sb.append(s);
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        reString = sb.toString();
        return reString;
    }

	public DataMap remove(String key){
		super.remove(key);
		return this;
	}
	public String getString(String key) {
		Object obj = get(key);
		return (String)obj;
	}
	public Integer getInteger(String key) {
		Object obj = get(key);

		return (Integer)obj;
	}
}
