package com.lgwind.util;

/**
 * ���㾭γ��
 * @author Lgwind
 *
 */
public class MapUtil {
	//private static double EARTH_RADIUS = 6378.137;
	private static double EARTH_RADIUS = 6371.393;
	private static double rad(double d)
	{
	   return d * Math.PI / 180.0;
	}

	/**
	 * ����������γ��֮��ľ���
	 * @param lat1
	 * @param lng1
	 * @param lat2
	 * @param lng2
	 * @return
	 */
	public static double getDistance(double lng1, double lat1, double lng2, double lat2)
	{
	   double radLat1 = rad(lat1);
	   double radLat2 = rad(lat2);
	   double a = radLat1 - radLat2;	
	   double b = rad(lng1) - rad(lng2);
	   double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) + 
	    Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
	   s = s * EARTH_RADIUS;
	   s = Math.round(s * 1000);
	   return s;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(MapUtil.getDistance(106.486654,29.490295,106.581515,29.615467));
	}
}
