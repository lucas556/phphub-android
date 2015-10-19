package org.estgroup.phphub.model;

import android.content.Context;

import org.estgroup.phphub.api.UserApi;
import org.estgroup.phphub.api.entity.NotificationEntity;
import org.estgroup.phphub.api.entity.TopicEntity;
import org.estgroup.phphub.api.entity.UserEntity;
import org.estgroup.phphub.api.entity.element.User;
import org.estgroup.phphub.common.base.BaseModel;

import java.util.HashMap;

import rx.Observable;

public class UserModel extends BaseModel<UserApi> {
    public UserModel(Context context) {
        super(context, UserApi.class);
    }

    public Observable<UserEntity.AUser> getMyselfInfo() {
        return getService().getMyselfInfo();
    }

    public Observable<UserEntity.AUser> getUserInfo(int userId) {
        return getService().getUserInfo(userId);
    }

    public Observable<TopicEntity> getAttentions(int userId) {
        HashMap<String, String> options = new HashMap<>();
        options.put("include", "user,node,last_reply_user");

        return getService().getAttentions(userId, options);
    }

    public Observable<TopicEntity> getFavorites(int userId) {
        HashMap<String, String> options = new HashMap<>();
        options.put("include", "user,node,last_reply_user");

        return getService().getFavorites(userId, options);
    }

    public Observable<TopicEntity> getTopics(int userId) {
        HashMap<String, String> options = new HashMap<>();
        options.put("include", "user,node,last_reply_user");

        return getService().getTopics(userId, options);
    }

    public Observable<NotificationEntity> getMyNotifications() {
        HashMap<String, String> options = new HashMap<>();
        options.put("include", "from_user,topic");
        return getService().getMyNotifications(options);
    }

    public Observable<UserEntity.AUser> saveUserProfile(User userInfo) {

        return getService().saveUserProfile(userInfo.getId(), userInfo);
    }
}
