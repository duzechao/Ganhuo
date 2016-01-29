package git.dzc.ganhuo.module;

import java.util.List;

/**
 * Created by dzc on 16/1/29.
 */
public class DayResult {

    /**
     * category : ["iOS","Android","瞎推荐","拓展资源","福利","休息视频"]
     * error : false
     * results : {"Android":[],"iOS":[],"休息视频":[{"createdAt":"2015-08-06T13:06:17.211Z","desc":"听到就心情大好的歌，简直妖魔哈哈哈哈哈，原地址\nhttp://v.youku.com/v_show/id_XMTQxODA5NDM2.html","objectId":"55c35bc960b2750766954ec3","publishedAt":"2015-08-07T03:57:48.104Z","type":"休息视频","updatedAt":"2015-08-15T03:15:54.872Z","url":"http://www.zhihu.com/question/21778055/answer/19905413?utm_source=weibo&utm_medium=weibo_share&utm_content=share_answer&utm_campaign=share_button","used":true,"who":"lxxself"}],"拓展资源":[{"createdAt":"2015-08-07T01:36:06.932Z","desc":"Display GitHub code in tree format","objectId":"55c40b8600b08484a7f3a032","publishedAt":"2015-08-07T03:57:48.081Z","type":"拓展资源","updatedAt":"2015-08-15T03:15:54.382Z","url":"https://github.com/buunguyen/octotree","used":true,"who":"lxxself"}],"瞎推荐":[{"createdAt":"2015-08-07T01:52:30.267Z","desc":"程序员的电台FmM，这个页面chrome插件有问题啊哭，我写了回删除不了啊","objectId":"55c40f5e00b00045334934b4","publishedAt":"2015-08-07T03:57:48.084Z","type":"瞎推荐","updatedAt":"2015-08-15T03:15:54.383Z","url":"https://cmd.fm/","used":true,"who":"lxxself"}],"福利":[{"createdAt":"2015-08-07T01:21:06.112Z","desc":"8.7\u2014\u2014（1）","objectId":"55c4080240ac7d0a9507905e","publishedAt":"2015-08-07T03:57:47.310Z","type":"福利","updatedAt":"2015-08-15T03:15:54.765Z","url":"http://ww2.sinaimg.cn/large/7a8aed7bgw1eutscfcqtcj20dw0i0q4l.jpg","used":true,"who":"张涵宇"},{"createdAt":"2015-08-07T01:21:33.518Z","desc":"8.7\u2014\u2014（2）","objectId":"55c4081d60b2c9d32a67a92e","publishedAt":"2015-08-07T03:57:47.229Z","type":"福利","updatedAt":"2015-08-15T03:15:54.843Z","url":"http://ww2.sinaimg.cn/large/7a8aed7bgw1eutsd0pgiwj20go0p0djn.jpg","used":true,"who":"张涵宇"}]}
     */

    private boolean error;
    private ResultsEntity results;
    private List<String> category;

    public void setError(boolean error) {
        this.error = error;
    }

    public void setResults(ResultsEntity results) {
        this.results = results;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public boolean isError() {
        return error;
    }

    public ResultsEntity getResults() {
        return results;
    }

    public List<String> getCategory() {
        return category;
    }

    public static class ResultsEntity {
        private List<?> Android;
        private List<?> iOS;
        /**
         * createdAt : 2015-08-06T13:06:17.211Z
         * desc : 听到就心情大好的歌，简直妖魔哈哈哈哈哈，原地址
         http://v.youku.com/v_show/id_XMTQxODA5NDM2.html
         * objectId : 55c35bc960b2750766954ec3
         * publishedAt : 2015-08-07T03:57:48.104Z
         * type : 休息视频
         * updatedAt : 2015-08-15T03:15:54.872Z
         * url : http://www.zhihu.com/question/21778055/answer/19905413?utm_source=weibo&utm_medium=weibo_share&utm_content=share_answer&utm_campaign=share_button
         * used : true
         * who : lxxself
         */

        private List<休息视频Entity> 休息视频;
        /**
         * createdAt : 2015-08-07T01:36:06.932Z
         * desc : Display GitHub code in tree format
         * objectId : 55c40b8600b08484a7f3a032
         * publishedAt : 2015-08-07T03:57:48.081Z
         * type : 拓展资源
         * updatedAt : 2015-08-15T03:15:54.382Z
         * url : https://github.com/buunguyen/octotree
         * used : true
         * who : lxxself
         */

        private List<拓展资源Entity> 拓展资源;
        /**
         * createdAt : 2015-08-07T01:52:30.267Z
         * desc : 程序员的电台FmM，这个页面chrome插件有问题啊哭，我写了回删除不了啊
         * objectId : 55c40f5e00b00045334934b4
         * publishedAt : 2015-08-07T03:57:48.084Z
         * type : 瞎推荐
         * updatedAt : 2015-08-15T03:15:54.383Z
         * url : https://cmd.fm/
         * used : true
         * who : lxxself
         */

        private List<瞎推荐Entity> 瞎推荐;
        /**
         * createdAt : 2015-08-07T01:21:06.112Z
         * desc : 8.7——（1）
         * objectId : 55c4080240ac7d0a9507905e
         * publishedAt : 2015-08-07T03:57:47.310Z
         * type : 福利
         * updatedAt : 2015-08-15T03:15:54.765Z
         * url : http://ww2.sinaimg.cn/large/7a8aed7bgw1eutscfcqtcj20dw0i0q4l.jpg
         * used : true
         * who : 张涵宇
         */

        private List<福利Entity> 福利;

        public void setAndroid(List<?> Android) {
            this.Android = Android;
        }

        public void setIOS(List<?> iOS) {
            this.iOS = iOS;
        }

        public void set休息视频(List<休息视频Entity> 休息视频) {
            this.休息视频 = 休息视频;
        }

        public void set拓展资源(List<拓展资源Entity> 拓展资源) {
            this.拓展资源 = 拓展资源;
        }

        public void set瞎推荐(List<瞎推荐Entity> 瞎推荐) {
            this.瞎推荐 = 瞎推荐;
        }

        public void set福利(List<福利Entity> 福利) {
            this.福利 = 福利;
        }

        public List<?> getAndroid() {
            return Android;
        }

        public List<?> getIOS() {
            return iOS;
        }

        public List<休息视频Entity> get休息视频() {
            return 休息视频;
        }

        public List<拓展资源Entity> get拓展资源() {
            return 拓展资源;
        }

        public List<瞎推荐Entity> get瞎推荐() {
            return 瞎推荐;
        }

        public List<福利Entity> get福利() {
            return 福利;
        }

        public static class 休息视频Entity {
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

        public static class 拓展资源Entity {
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

        public static class 瞎推荐Entity {
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

        public static class 福利Entity {
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
}
