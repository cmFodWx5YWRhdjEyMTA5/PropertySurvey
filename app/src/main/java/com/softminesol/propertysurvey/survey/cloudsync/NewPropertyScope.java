package com.softminesol.propertysurvey.survey.cloudsync;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.inject.Scope;

@Qualifier
@Retention(RetentionPolicy.CLASS)
public @interface NewPropertyScope {
}
