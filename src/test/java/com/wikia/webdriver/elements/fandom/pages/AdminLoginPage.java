package com.wikia.webdriver.elements.fandom.pages;

import lombok.Getter;

import com.wikia.webdriver.common.core.helpers.FandomUser;
import com.wikia.webdriver.elements.fandom.FandomPage;
import com.wikia.webdriver.elements.fandom.components.WPLoginBox;

public class AdminLoginPage extends FandomPage<AdminLoginPage> {
  private final String URL = "http://qa.fandom.wikia.com/wp-admin";

  @Getter(lazy = true)
  private final WPLoginBox loginBox = new WPLoginBox();

  @Override
  public AdminLoginPage open() {
    getUrl(URL);

    return this;
  }

  public AdminLoginPage Login(FandomUser user) {
    getLoginBox().login(user);

    return this;
  }
}
