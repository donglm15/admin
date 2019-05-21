package com.unicom.admin.model;

import java.util.List;

public class JSONResult {
//    类的定义
    class DataObject{
        private int total;
        private List items;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List getItems() {
            return items;
        }

        public void setItems(List items) {
            this.items = items;
        }

        public DataObject() {
        }

        public DataObject(int total, List items) {
                this.total = total;
                this.items = items;
            }
}
//数据项
    private int code;
    private Object data;
    //getter and setter
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
//有无参数
    public JSONResult() {
    }

    public JSONResult(int code, Object data) {
        this.code = code;
        this.data = data;
    }
//    public JSONResult ok(List datalist){ //业务逻辑成功后，封装数据出去
//
//        DataObject data = new DataObject();
//        data.setTotal(datalist.size());
//        data.setItems(datalist);
//
//        JSONResult result = new JSONResult();
//        result.setCode(20000);
//        result.setData(data);
//
//        return result;
//    }

    public JSONResult ok(Object datalist){ //业务逻辑成功后，封装数据出去
        JSONResult result = new JSONResult();
        result.setCode(20000);
//判断给来数据是List的情况，
         if(datalist instanceof List){
              DataObject data = new DataObject();
              data.setTotal(((List)datalist).size());
              data.setItems((List)datalist);
              result.setData(data);
          } else {
             //给来的数据不是List
             result.setData(datalist);
         }
        return result;
    }

}
