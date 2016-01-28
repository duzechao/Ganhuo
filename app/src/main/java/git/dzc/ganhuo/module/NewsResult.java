package git.dzc.ganhuo.module;

import java.util.List;

/**
 * Created by dzc on 16/1/28.
 */
public class NewsResult {

    /**
     * error : false
     * results : [{"createdAt":"2016-01-26T00:11:11.477Z","desc":"判断指定App是否位于前台的方法","objectId":"56a6b99fa3413100529d3328","publishedAt":"2016-01-27T05:14:00.963Z","type":"Android","updatedAt":"2016-01-27T05:14:01.539Z","url":"https://github.com/wenmingvs/AndroidProcess","used":true,"who":"Ailurus"},{"createdAt":"2016-01-25T15:01:42.252Z","desc":"RecyclerViewManager支持 PullToRefresh、 LoadMore 和 onItemClick，你也可以为 RecyclerView 添加页眉或页脚。","objectId":"56a638d67db2a2005a3925fa","publishedAt":"2016-01-27T05:14:00.962Z","type":"Android","updatedAt":"2016-01-27T05:14:01.505Z","url":"https://github.com/Syehunter/RecyclerViewManager","used":true,"who":"Jason"},{"createdAt":"2016-01-25T02:19:46.810Z","desc":"Android性能优化视频，文档以及工具","objectId":"56a58642128fe1005161a2ce","publishedAt":"2016-01-27T05:14:00.957Z","type":"Android","updatedAt":"2016-01-27T05:14:01.471Z","url":"http://www.finalshares.com/read-6726?f=geek&n10","used":true,"who":"有时放纵"},{"createdAt":"2016-01-25T00:36:47.400Z","desc":"聊一聊Android 6.0的运行时权限","objectId":"56a56e1f8ac247005517201c","publishedAt":"2016-01-27T05:14:00.956Z","type":"Android","updatedAt":"2016-01-27T05:14:01.756Z","url":"http://droidyue.com/blog/2016/01/17/understanding-marshmallow-runtime-permission/","used":true,"who":"鲍永章"},{"createdAt":"2015-12-31T09:25:22.145Z","desc":"固定在ScrollView顶部的View，类似于新浪微博的评论列表的顶部","objectId":"5684f48260b2cd25b7ce3588","publishedAt":"2016-01-27T05:14:00.949Z","type":"Android","updatedAt":"2016-01-27T05:14:01.666Z","url":"http://my.oschina.net/Hideeee/blog/500933","used":true,"who":"lxxself"},{"createdAt":"2016-01-26T01:44:48.750Z","desc":"支持百分比的 ProgressBar 。","objectId":"56a6cf902e958a0051837a2c","publishedAt":"2016-01-26T04:02:34.334Z","type":"Android","updatedAt":"2016-01-26T04:02:35.872Z","url":"https://github.com/natasam/Android-PercentProgressBar-lib","used":true,"who":"小梁"},{"createdAt":"2016-01-26T01:43:35.750Z","desc":"一个简单地 RecyclerView FastScroller 。","objectId":"56a6cf47816dfa005aa89903","publishedAt":"2016-01-26T04:02:34.332Z","type":"Android","updatedAt":"2016-01-26T04:02:35.838Z","url":"https://github.com/timusus/RecyclerView-FastScroll","used":true,"who":"小梁"},{"createdAt":"2016-01-26T01:39:43.128Z","desc":"使用注解自动生成 Content provider 。","objectId":"56a6ce5fa633bd02578f2220","publishedAt":"2016-01-26T04:02:34.330Z","type":"Android","updatedAt":"2016-01-26T04:02:35.836Z","url":"https://github.com/workarounds/autoprovider","used":true,"who":"小梁"},{"createdAt":"2016-01-25T08:54:11.655Z","desc":"带动画的CheckBox","objectId":"56a5e2b31532bc0053e916e7","publishedAt":"2016-01-26T04:02:34.314Z","type":"Android","updatedAt":"2016-01-26T04:02:34.856Z","url":"https://github.com/andyxialm/SmoothCheckBox","used":true,"who":"Dear宅学长"},{"createdAt":"2016-01-25T07:23:49.539Z","desc":" 论文查重方法","objectId":"56a5cd8575c4cd6397308560","publishedAt":"2016-01-26T04:02:34.312Z","type":"Android","updatedAt":"2016-01-26T04:02:35.838Z","url":"http://blog.csdn.net/lpjishu/article/details/50549071","used":true,"who":"刘朋"}]
     */

    private boolean error;
    /**
     * createdAt : 2016-01-26T00:11:11.477Z
     * desc : 判断指定App是否位于前台的方法
     * objectId : 56a6b99fa3413100529d3328
     * publishedAt : 2016-01-27T05:14:00.963Z
     * type : Android
     * updatedAt : 2016-01-27T05:14:01.539Z
     * url : https://github.com/wenmingvs/AndroidProcess
     * used : true
     * who : Ailurus
     */

    private List<NewsModule> results;

    public void setError(boolean error) {
        this.error = error;
    }

    public void setResults(List<NewsModule> results) {
        this.results = results;
    }

    public boolean isError() {
        return error;
    }

    public List<NewsModule> getResults() {
        return results;
    }

    public static class NewsModule {
        private String createdAt;
        private String desc;
        private String objectId;
        private String publishedAt;
        private String type;
        private String updatedAt;
        private String url;
        private boolean used;
        private String who;

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public String getObjectId() {
            return objectId;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public String getType() {
            return type;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public String getUrl() {
            return url;
        }

        public boolean isUsed() {
            return used;
        }

        public String getWho() {
            return who;
        }
    }
}
