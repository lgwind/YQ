package com.lgwind.util;

import java.util.ArrayList;
import java.util.List;

import com.lgwind.dao.NewsDao;
import com.lgwind.domain.News;

public class NewsUtil {
    
    /**
     * ������Ϣ�б�
     * @param itype ��Ϣ����
     * @param finish ��Ϣ������
     * @return
     */
    public static List<News> news(String itype, int finish){
        List<News> newsList = new ArrayList<News>(); 
        try{
            //��ȡĳһ���͵�������Ϣ
            newsList = new NewsDao().getAll(itype);
            for(int i=0; i<newsList.size(); i++){
                if(newsList.get(i).getFinish()!=finish){
                    newsList.remove(i);
                    i--;
                }
            }
        }catch(Exception e){
            System.out.println("NewsUtil���news��������");
        }
        return newsList;
    }
    
    /**
     * ������Ϣ�б�
     * @param username �û���
     * @return
     */
    public static List<News> news(String username){
        List<News> newsList = new ArrayList<News>(); 
        try{
            //��ȡĳһ���͵�������Ϣ
            newsList = new NewsDao().getAllByUsername(username);
            for(int i=0; i<newsList.size(); i++){
                if(newsList.get(i).getFinish()==1){
                    newsList.remove(i);
                    i--;
                }
            }
        }catch(Exception e){
            System.out.println("NewsUtil���news��������");
        }
        return newsList;        
    }

}
