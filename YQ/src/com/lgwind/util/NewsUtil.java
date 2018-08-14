package com.lgwind.util;

import java.util.ArrayList;
import java.util.List;

import com.lgwind.dao.NewsDao;
import com.lgwind.domain.News;

public class NewsUtil {
    
    /**
     * 返回消息列表
     * @param itype 消息类型
     * @param finish 消息处理结果
     * @return
     */
    public static List<News> news(String itype, int finish){
        List<News> newsList = new ArrayList<News>(); 
        try{
            //获取某一类型的所有消息
            newsList = new NewsDao().getAll(itype);
            for(int i=0; i<newsList.size(); i++){
                if(newsList.get(i).getFinish()!=finish){
                    newsList.remove(i);
                    i--;
                }
            }
        }catch(Exception e){
            System.out.println("NewsUtil类的news函数出错");
        }
        return newsList;
    }
    
    /**
     * 返回消息列表
     * @param username 用户名
     * @return
     */
    public static List<News> news(String username){
        List<News> newsList = new ArrayList<News>(); 
        try{
            //获取某一类型的所有消息
            newsList = new NewsDao().getAllByUsername(username);
            for(int i=0; i<newsList.size(); i++){
                if(newsList.get(i).getFinish()==1){
                    newsList.remove(i);
                    i--;
                }
            }
        }catch(Exception e){
            System.out.println("NewsUtil类的news函数出错");
        }
        return newsList;        
    }

}
