package myapplication.liangcang.shop.bean;

import java.util.List;

/**
 * Created by zhouzhou on 2017/7/7.
 */

public class BrandInfo {

    /**
     * meta : {"status":0,"server_time":"2017-07-07 14:14:30","account_id":0,"cost":0.0052618980407715,"errdata":null,"errmsg":""}
     * version : 1
     * data : {"has_more":true,"num_items":"739","items":[{"brand_id":844,"brand_name":"BALMUDA巴慕达","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/844.jpg?t=1499402977"},{"brand_id":843,"brand_name":"如果","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/843.jpg?t=1499404527"},{"brand_id":842,"brand_name":"科大讯飞","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/842.jpg?t=1499404544"},{"brand_id":841,"brand_name":"HAZE Collection","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/841.jpg"},{"brand_id":840,"brand_name":"良集","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/840.jpg"},{"brand_id":839,"brand_name":"九行","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/839.jpg?t=1498618673"},{"brand_id":838,"brand_name":"HERING","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/838.jpg"},{"brand_id":837,"brand_name":"OFESS 翱飞思","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/837.jpg"},{"brand_id":836,"brand_name":"COCO-MAT","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/836.jpg"},{"brand_id":835,"brand_name":"Queenest小燕喔","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/835.jpg"},{"brand_id":834,"brand_name":"Inaday's","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/834.jpg"},{"brand_id":833,"brand_name":"注销","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/833.jpg"},{"brand_id":832,"brand_name":"Lilt","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/832.jpg"},{"brand_id":831,"brand_name":"塔牌","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/831.jpg"},{"brand_id":830,"brand_name":"麦风","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/830.jpg"},{"brand_id":829,"brand_name":"VH","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/829.jpg"},{"brand_id":828,"brand_name":"MIRAHOME","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/828.jpg"},{"brand_id":827,"brand_name":"MOUS","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/827.jpg"},{"brand_id":826,"brand_name":"Petrus/柏翠","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/826.jpg?t=1497433209"},{"brand_id":825,"brand_name":"DOWNLAND","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/825.jpg?t=1497421482"}]}
     */

    private MetaBean meta;
    private int version;
    private DataBean data;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class MetaBean {
        /**
         * status : 0
         * server_time : 2017-07-07 14:14:30
         * account_id : 0
         * cost : 0.0052618980407715
         * errdata : null
         * errmsg :
         */

        private int status;
        private String server_time;
        private int account_id;
        private double cost;
        private Object errdata;
        private String errmsg;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getServer_time() {
            return server_time;
        }

        public void setServer_time(String server_time) {
            this.server_time = server_time;
        }

        public int getAccount_id() {
            return account_id;
        }

        public void setAccount_id(int account_id) {
            this.account_id = account_id;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public Object getErrdata() {
            return errdata;
        }

        public void setErrdata(Object errdata) {
            this.errdata = errdata;
        }

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }
    }

    public static class DataBean {
        /**
         * has_more : true
         * num_items : 739
         * items : [{"brand_id":844,"brand_name":"BALMUDA巴慕达","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/844.jpg?t=1499402977"},{"brand_id":843,"brand_name":"如果","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/843.jpg?t=1499404527"},{"brand_id":842,"brand_name":"科大讯飞","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/842.jpg?t=1499404544"},{"brand_id":841,"brand_name":"HAZE Collection","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/841.jpg"},{"brand_id":840,"brand_name":"良集","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/840.jpg"},{"brand_id":839,"brand_name":"九行","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/839.jpg?t=1498618673"},{"brand_id":838,"brand_name":"HERING","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/838.jpg"},{"brand_id":837,"brand_name":"OFESS 翱飞思","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/837.jpg"},{"brand_id":836,"brand_name":"COCO-MAT","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/836.jpg"},{"brand_id":835,"brand_name":"Queenest小燕喔","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/835.jpg"},{"brand_id":834,"brand_name":"Inaday's","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/834.jpg"},{"brand_id":833,"brand_name":"注销","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/833.jpg"},{"brand_id":832,"brand_name":"Lilt","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/832.jpg"},{"brand_id":831,"brand_name":"塔牌","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/831.jpg"},{"brand_id":830,"brand_name":"麦风","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/830.jpg"},{"brand_id":829,"brand_name":"VH","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/829.jpg"},{"brand_id":828,"brand_name":"MIRAHOME","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/828.jpg"},{"brand_id":827,"brand_name":"MOUS","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/827.jpg"},{"brand_id":826,"brand_name":"Petrus/柏翠","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/826.jpg?t=1497433209"},{"brand_id":825,"brand_name":"DOWNLAND","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/825.jpg?t=1497421482"}]
         */

        private boolean has_more;
        private String num_items;
        private List<ItemsBean> items;

        public boolean isHas_more() {
            return has_more;
        }

        public void setHas_more(boolean has_more) {
            this.has_more = has_more;
        }

        public String getNum_items() {
            return num_items;
        }

        public void setNum_items(String num_items) {
            this.num_items = num_items;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * brand_id : 844
             * brand_name : BALMUDA巴慕达
             * brand_logo : http://imgs-qn.iliangcang.com/ware/brand/844.jpg?t=1499402977
             */

            private int brand_id;
            private String brand_name;
            private String brand_logo;

            public int getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(int brand_id) {
                this.brand_id = brand_id;
            }

            public String getBrand_name() {
                return brand_name;
            }

            public void setBrand_name(String brand_name) {
                this.brand_name = brand_name;
            }

            public String getBrand_logo() {
                return brand_logo;
            }

            public void setBrand_logo(String brand_logo) {
                this.brand_logo = brand_logo;
            }

        }
    }
}
