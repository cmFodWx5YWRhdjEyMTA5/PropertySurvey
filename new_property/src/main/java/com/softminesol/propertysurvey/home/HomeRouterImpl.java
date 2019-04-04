package com.softminesol.propertysurvey.home;

import android.content.Context;
import android.content.Intent;

import com.softminesol.propertysurvey.home.view.DashBoardActivity;

import routers.IHomeRouter;

public class HomeRouterImpl implements IHomeRouter {

    @Override
    public Intent getHomeIntent(Context context) {
        return DashBoardActivity.getIntent(context);
    }
}
