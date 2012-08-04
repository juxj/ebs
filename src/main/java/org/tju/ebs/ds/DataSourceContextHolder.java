package org.tju.ebs.ds;

import org.springframework.util.Assert;

public class DataSourceContextHolder {

   private static final ThreadLocal<DataSourceName> contextHolder =   
            new ThreadLocal<DataSourceName>();  
          
   public static void setCurrentDataSource(DataSourceName dsName) {  
      Assert.notNull(dsName, "customerType cannot be null");  
      contextHolder.set(dsName);  
   }  
  
   public static DataSourceName getCustomerType() {  
      return (DataSourceName) contextHolder.get();  
   }  
  
   public static void clearCurrentDataSource() {  
      contextHolder.remove();  
   }
}  