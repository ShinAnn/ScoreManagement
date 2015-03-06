package edu.software.scoremanage.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenerateCode {
	
	public static String generateList(String[] items){
		StringBuilder sb = new StringBuilder();
		int i = 1;
		for(String item:items){
			sb.append(i);
			i++;
			sb.append(":"+item+"\n");
		}
		return sb.toString();
	}
	
	public static <E>String generateList(List<E> items){
		StringBuilder sb = new StringBuilder();
		int i = 1;
		for(E item:items){
			sb.append(i);
			i++;
			sb.append(":"+item.toString()+"\n");
		}
		return sb.toString();
	}
	
	public static <K,V>String generateList(Map<K,V> map){
		StringBuilder sb = new StringBuilder();
		Set<K> set = map.keySet();
		for(K k:set){
			sb.append(k.toString()+":"+map.get(k).toString()+"\n");
		}
		return sb.toString();
	}
	
	public static <E>String generateListFromSI(List<E> items){
		StringBuilder sb = new StringBuilder();
		int i = 1;
		for(E item:items){
			sb.append(i);
			i++;
			//StringItem是为生成菜单项定义的接口
			try {
				sb.append(":"+((StringItem)item).toItem()+"\n");
			} catch (Exception e) {
				sb.append(":"+item.toString()+"\n");
			}
		}
		return sb.toString();
	}
	
	public static String generateErrTips(int n){
		StringBuilder sb = new StringBuilder();
		sb.append("Wrong input!Please enter a number between 1");
		int i;
		for(i=2;i<=n;i++){
			sb.append(","+i);
		}
		return sb.toString();
	}

}
