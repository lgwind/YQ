package com.lgwind.util;

import java.util.Calendar;

public class IData {
    
    /**
     * ������ʱ�䣬�꣬��ʱ����
     */
    public static int year=year();
    /**
     * ������ʱ�䣬�£���ʱ����
     */
    public static int month=month();
    
    /**
     * ��ȡ��ǰ���
     * @return
     */
    public static int year(){
        //Calendar��ľ�̬����getInstance()���Գ�ʼ��һ����������
        Calendar cal = Calendar.getInstance();
        //���ص�ǰ���
        return cal.get(Calendar.YEAR);
    }
    
    /**
     * ��ȡ��ǰ�·�
     * @return
     */
    public static int month(){
        Calendar cal = Calendar.getInstance();
        //��ȡ��ǰ�·�
        int month = cal.get(Calendar.MONTH) + 1;
//        if(month<10){
//            return "0"+month;
//        }
        return month;
    }
    
    /**
     * ��ȡ��ǰ����
     * @return
     */
    public static int day(){
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DATE);
    }
    
    /**
     * ��ȡ��ǰСʱ��
     * @return
     */
    public static int hour(){
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.HOUR_OF_DAY);
    }
    /**
     * ��ȡ���ڵ��ַ�ֵ
     * @return
     */
    public static String getDate(){
        String date = ""+IData.year();
        date+="-";
        if(IData.month()<10){
            date+="0";
        }
        date+=IData.month();
        date+="-";
        if(IData.day()<10){
            date+="0";
        }
        date+=IData.day();
        return date;
    }
    /**
     * ��ȡ��ǰʱ�� �ַ���
     * @return
     */
    public static String getTime(){
        Calendar cal = Calendar.getInstance();
        String time = "";
        if(cal.get(Calendar.HOUR_OF_DAY)<10){
            time+="0";
        }
        time+=cal.get(Calendar.HOUR_OF_DAY);
        time+=":";
        if(cal.get(Calendar.MINUTE)<10){
            time+="0";
        }
        time+=cal.get(Calendar.MINUTE);
        time+=":";
        if(cal.get(Calendar.SECOND)<10){
            time+="0";
        }
        time+=cal.get(Calendar.SECOND);
        return time;
    }
    
    /**
     * ʱ���ַ���תΪ����int
     * @param time ʱ���ַ��� ��ʽ 09:01:50
     * @return
     */
    public static int timeNum(String time){
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);
        int second = Integer.parseInt(times[2]);
        return hour*60*60+minute*60+second;
    }
    
    /**
     * ��ȡ��ǰ�������ڼ�
     * @return
     */
    public static int weekDay(){
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_WEEK);
        //https://bbs.csdn.net/topics/391937179
    }
    
    /**
     * ��ȡĳ��ĳ��ĳ�������ڼ�
     * @return
     */
    public static int weekOfDay(int year, int month, int day){
        
        Calendar time =Calendar.getInstance();
        //����������ÿ�ʼ���ڣ�ע����Ҫ����Ϊ��ĩ
        //����������(2018)��(4)��(1)��ע�������4�£�����ʱ��Ҫ��1�����£�
        time.set(year, month-1, day);
        int weekOfDay=time.get(Calendar.DAY_OF_WEEK)-1;
        //һ�ܵ�һ������java���������죬����Ҫ��1
        //System.out.println(year+"��"+month+"��"+day+"����"+numDay(weekOfDay));
        
        return weekOfDay;
    }
    
    /**
     * ���ָ�Ϊ����
     * @param day
     * @return
     */
    public static String numDay(int day){
        String daystr="����";
        if(day==0){daystr+="��";}
        else if(day==1){daystr+="һ";}
        else if(day==2){daystr+="��";}
        else if(day==3){daystr+="��";}
        else if(day==4){daystr+="��";}
        else if(day==5){daystr+="��";}
        else if(day==6){daystr+="��";}
        return daystr;
    }
    
    /**
     * ��ȡĳ��ĳ���м��죿
     * @param year
     * @param month
     * @return
     */
    public static int daysOfMonth(int year, int month){
        Calendar c = Calendar.getInstance();
        c.set(year, month, 0); //��������Ϊint����

        int daysOfMonth = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(year + "��" + month + "����" + daysOfMonth + "��");
        return daysOfMonth;
    }
    
    
    /**
     * ��ȡĳ��ĳ����ʾ�������ַ�������
     * @return
     */
    public static String[] days(int year, int month){
        //��ȡĳ��ĳ�µĵ�һ�������ڼ�
        int weekOfDay = weekOfDay(year, month, 1);
        //�жϵ�ǰ���м���
        int daysOfMonth = daysOfMonth(year, month);
        
        String [] days;
        if(weekOfDay+daysOfMonth<=28){
            days=new String[28];
        }else if (weekOfDay+daysOfMonth<=35){
            days=new String[35];
        }else{
            days=new String[42];
        }
        //����ո�
        int i=0;
        for(; i<weekOfDay; i++){
            days[i]="";
        }
        //��������
        for(int j=1;j<=daysOfMonth;i++,j++){
            days[i]=""+j;
        }
        //����ո�
        for(;i<days.length;i++){
            days[i]="";
        }        
        //���صõ������ڱ�
        return days;
    }   
    
}
