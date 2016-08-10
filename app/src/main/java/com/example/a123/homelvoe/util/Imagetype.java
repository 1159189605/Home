package com.example.a123.homelvoe.util;

import java.util.List;

/**
 * Created by 123 on 2016/8/9.
 */
public class Imagetype {


    /**
     * list : [{"childCategoryList":[{"child_category_id":1,"child_category_name":"酒店","parent_cate_id":1},{"child_category_id":2,"child_category_name":"饭店","parent_cate_id":1},{"child_category_id":3,"child_category_name":"西点","parent_cate_id":1},{"child_category_id":4,"child_category_name":"夜宵","parent_cate_id":1},{"child_category_id":5,"child_category_name":"外卖","parent_cate_id":1},{"child_category_id":6,"child_category_name":"茶馆","parent_cate_id":1},{"child_category_id":7,"child_category_name":"零食特产","parent_cate_id":1},{"child_category_id":8,"child_category_name":"其他","parent_cate_id":1},{"child_category_id":9,"child_category_name":"小吃","parent_cate_id":1}],"parent_cate_id":1,"parent_cate_img_url":"http://123.206.87.139:80/LoveHomeTownServer/img/meishi.png","parent_cate_name":"美食"},{"childCategoryList":[{"child_category_id":10,"child_category_name":"KTV","parent_cate_id":2},{"child_category_id":11,"child_category_name":"电影","parent_cate_id":2},{"child_category_id":12,"child_category_name":"酒吧","parent_cate_id":2},{"child_category_id":13,"child_category_name":"宾馆","parent_cate_id":2},{"child_category_id":14,"child_category_name":"足疗按摩","parent_cate_id":2},{"child_category_id":15,"child_category_name":"其他","parent_cate_id":2}],"parent_cate_id":2,"parent_cate_img_url":"http://123.206.87.139:80/LoveHomeTownServer/img/yule.png","parent_cate_name":"娱乐"},{"childCategoryList":[{"child_category_id":16,"child_category_name":"买卖","parent_cate_id":3},{"child_category_id":17,"child_category_name":"租赁","parent_cate_id":3},{"child_category_id":18,"child_category_name":"其他","parent_cate_id":3}],"parent_cate_id":3,"parent_cate_img_url":"http://123.206.87.139:80/LoveHomeTownServer/img/fangchan.png","parent_cate_name":"房产"},{"childCategoryList":[{"child_category_id":19,"child_category_name":"买卖","parent_cate_id":4},{"child_category_id":20,"child_category_name":"租赁","parent_cate_id":4},{"child_category_id":21,"child_category_name":"代驾","parent_cate_id":4},{"child_category_id":22,"child_category_name":"学车","parent_cate_id":4},{"child_category_id":23,"child_category_name":"修理","parent_cate_id":4},{"child_category_id":24,"child_category_name":"其他","parent_cate_id":4}],"parent_cate_id":4,"parent_cate_img_url":"http://123.206.87.139:80/LoveHomeTownServer/img/che.png","parent_cate_name":"车"},{"childCategoryList":[{"child_category_id":25,"child_category_name":"礼仪庆典","parent_cate_id":5},{"child_category_id":26,"child_category_name":"婚车","parent_cate_id":5},{"child_category_id":27,"child_category_name":"摄影","parent_cate_id":5},{"child_category_id":28,"child_category_name":"鲜花","parent_cate_id":5},{"child_category_id":29,"child_category_name":"其他","parent_cate_id":5}],"parent_cate_id":5,"parent_cate_img_url":"http://123.206.87.139:80/LoveHomeTownServer/img/hunqing.png","parent_cate_name":"婚庆"},{"childCategoryList":[{"child_category_id":30,"child_category_name":"家/公装","parent_cate_id":6},{"child_category_id":31,"child_category_name":"建材家居","parent_cate_id":6},{"child_category_id":32,"child_category_name":"装修工人","parent_cate_id":6},{"child_category_id":33,"child_category_name":"其他","parent_cate_id":6}],"parent_cate_id":6,"parent_cate_img_url":"http://123.206.87.139:80/LoveHomeTownServer/img/zhuangxiu.png","parent_cate_name":"装修"},{"childCategoryList":[{"child_category_id":34,"child_category_name":"学校","parent_cate_id":7},{"child_category_id":35,"child_category_name":"培训","parent_cate_id":7},{"child_category_id":36,"child_category_name":"家教","parent_cate_id":7},{"child_category_id":37,"child_category_name":"其他","parent_cate_id":7}],"parent_cate_id":7,"parent_cate_img_url":"http://123.206.87.139:80/LoveHomeTownServer/img/jiaoyu.png","parent_cate_name":"教育"},{"childCategoryList":[{"child_category_id":38,"child_category_name":"全职","parent_cate_id":8},{"child_category_id":39,"child_category_name":"兼职","parent_cate_id":8},{"child_category_id":40,"child_category_name":"钟点工","parent_cate_id":8},{"child_category_id":41,"child_category_name":"临时工","parent_cate_id":8},{"child_category_id":42,"child_category_name":"其他","parent_cate_id":8}],"parent_cate_id":8,"parent_cate_img_url":"http://123.206.87.139:80/LoveHomeTownServer/img/gongzuo.png","parent_cate_name":"工作"},{"childCategoryList":[{"child_category_id":43,"child_category_name":"手机","parent_cate_id":9},{"child_category_id":44,"child_category_name":"服装","parent_cate_id":9},{"child_category_id":45,"child_category_name":"食品","parent_cate_id":9},{"child_category_id":46,"child_category_name":"酒水","parent_cate_id":9},{"child_category_id":47,"child_category_name":"数码电器","parent_cate_id":9},{"child_category_id":48,"child_category_name":"母婴玩具","parent_cate_id":9},{"child_category_id":49,"child_category_name":"美容美发","parent_cate_id":9},{"child_category_id":50,"child_category_name":"珠宝配饰","parent_cate_id":9},{"child_category_id":51,"child_category_name":"办公耗材","parent_cate_id":9},{"child_category_id":52,"child_category_name":"家居家纺","parent_cate_id":9},{"child_category_id":53,"child_category_name":"日用品","parent_cate_id":9},{"child_category_id":54,"child_category_name":"其他","parent_cate_id":9}],"parent_cate_id":9,"parent_cate_img_url":"http://123.206.87.139:80/LoveHomeTownServer/img/baihuo.png","parent_cate_name":"百货"},{"childCategoryList":[{"child_category_id":55,"child_category_name":"家居电器","parent_cate_id":10},{"child_category_id":56,"child_category_name":"服装箱包","parent_cate_id":10},{"child_category_id":57,"child_category_name":"手表珠宝","parent_cate_id":10},{"child_category_id":58,"child_category_name":"办公设施","parent_cate_id":10},{"child_category_id":59,"child_category_name":"其他","parent_cate_id":10}],"parent_cate_id":10,"parent_cate_img_url":"http://123.206.87.139:80/LoveHomeTownServer/img/tiaozao.png","parent_cate_name":"跳蚤"},{"childCategoryList":[{"child_category_id":60,"child_category_name":"投资担保","parent_cate_id":11},{"child_category_id":61,"child_category_name":"咨询顾问","parent_cate_id":11},{"child_category_id":62,"child_category_name":"演出会展","parent_cate_id":11},{"child_category_id":63,"child_category_name":"其他","parent_cate_id":11}],"parent_cate_id":11,"parent_cate_img_url":"http://123.206.87.139:80/LoveHomeTownServer/img/shangwu.png","parent_cate_name":"商务"},{"childCategoryList":[{"child_category_id":64,"child_category_name":"便民","parent_cate_id":12}],"parent_cate_id":12,"parent_cate_img_url":"http://123.206.87.139:80/LoveHomeTownServer/img/bianmin.png","parent_cate_name":"便民"},{"childCategoryList":[{"child_category_id":65,"child_category_name":"老乡会","parent_cate_id":13}],"parent_cate_id":13,"parent_cate_img_url":"http://123.206.87.139:80/LoveHomeTownServer/img/laoxianghui.png","parent_cate_name":"老乡汇"},{"childCategoryList":[{"child_category_id":66,"child_category_name":"外卖汇","parent_cate_id":14}],"parent_cate_id":14,"parent_cate_img_url":"http://123.206.87.139:80/LoveHomeTownServer/img/mrtx_pic.png","parent_cate_name":"外卖汇"},{"childCategoryList":[{"child_category_id":67,"child_category_name":"其他","parent_cate_id":15}],"parent_cate_id":15,"parent_cate_img_url":"http://123.206.87.139:80/LoveHomeTownServer/img/qita.png","parent_cate_name":"其他"}]
     * msg : success
     * result : 200
     */

    private String msg;
    private int result;
    /**
     * childCategoryList : [{"child_category_id":1,"child_category_name":"酒店","parent_cate_id":1},{"child_category_id":2,"child_category_name":"饭店","parent_cate_id":1},{"child_category_id":3,"child_category_name":"西点","parent_cate_id":1},{"child_category_id":4,"child_category_name":"夜宵","parent_cate_id":1},{"child_category_id":5,"child_category_name":"外卖","parent_cate_id":1},{"child_category_id":6,"child_category_name":"茶馆","parent_cate_id":1},{"child_category_id":7,"child_category_name":"零食特产","parent_cate_id":1},{"child_category_id":8,"child_category_name":"其他","parent_cate_id":1},{"child_category_id":9,"child_category_name":"小吃","parent_cate_id":1}]
     * parent_cate_id : 1
     * parent_cate_img_url : http://123.206.87.139:80/LoveHomeTownServer/img/meishi.png
     * parent_cate_name : 美食
     */

    private List<ListBean> list;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private int parent_cate_id;
        private String parent_cate_img_url;
        private String parent_cate_name;
        /**
         * child_category_id : 1
         * child_category_name : 酒店
         * parent_cate_id : 1
         */

        private List<ChildCategoryListBean> childCategoryList;

        public int getParent_cate_id() {
            return parent_cate_id;
        }

        public void setParent_cate_id(int parent_cate_id) {
            this.parent_cate_id = parent_cate_id;
        }

        public String getParent_cate_img_url() {
            return parent_cate_img_url;
        }

        public void setParent_cate_img_url(String parent_cate_img_url) {
            this.parent_cate_img_url = parent_cate_img_url;
        }

        public String getParent_cate_name() {
            return parent_cate_name;
        }

        public void setParent_cate_name(String parent_cate_name) {
            this.parent_cate_name = parent_cate_name;
        }

        public List<ChildCategoryListBean> getChildCategoryList() {
            return childCategoryList;
        }

        public void setChildCategoryList(List<ChildCategoryListBean> childCategoryList) {
            this.childCategoryList = childCategoryList;
        }

        public static class ChildCategoryListBean {
            private int child_category_id;
            private String child_category_name;
            private int parent_cate_id;

            public int getChild_category_id() {
                return child_category_id;
            }

            public void setChild_category_id(int child_category_id) {
                this.child_category_id = child_category_id;
            }

            public String getChild_category_name() {
                return child_category_name;
            }

            public void setChild_category_name(String child_category_name) {
                this.child_category_name = child_category_name;
            }

            public int getParent_cate_id() {
                return parent_cate_id;
            }

            public void setParent_cate_id(int parent_cate_id) {
                this.parent_cate_id = parent_cate_id;
            }
        }
    }
}
