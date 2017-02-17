package com.wikia.webdriver.testcases.followingtests;

import com.wikia.webdriver.common.core.annotations.Execute;
import com.wikia.webdriver.common.core.annotations.RelatedIssue;
import com.wikia.webdriver.common.core.helpers.User;
import com.wikia.webdriver.common.templates.NewTestTemplate;
import com.wikia.webdriver.pageobjectsfactory.pageobject.WikiBasePageObject;
import com.wikia.webdriver.pageobjectsfactory.pageobject.special.SpecialFollowPageObject;
import com.wikia.webdriver.pageobjectsfactory.pageobject.special.SpecialNewFilesPageObject;
import com.wikia.webdriver.pageobjectsfactory.pageobject.special.filepage.FilePagePageObject;
import com.wikia.webdriver.pageobjectsfactory.pageobject.special.watch.WatchPageObject;

import org.testng.annotations.Test;

public class FollowPhotosTests extends NewTestTemplate {

  String imageName;

  @Test(groups = "FollowPhoto")
  @Execute(asUser = User.USER)
  public void FollowPhoto_001_setup() {
    WikiBasePageObject base = new WikiBasePageObject();
    SpecialNewFilesPageObject special = base.openSpecialNewFiles(wikiURL);
    imageName = special.getRandomImageName();
    WatchPageObject watch = special.unfollowImage(wikiURL, imageName);
    watch.confirmWatchUnwatch();
    special.verifyPageUnfollowed();
  }

  @Test(groups = "FollowPhoto", dependsOnMethods = {"FollowPhoto_001_setup"})
  @Execute(asUser = User.USER)
  public void FollowPhoto_002_follow() {
    new FilePagePageObject(driver).open(imageName).follow();
  }

  @Test(groups = {"FollowPhoto", "Follow"}, dependsOnMethods = {"FollowPhoto_002_follow"})
  @Execute(asUser = User.USER)
  public void FollowPhoto_003_verify() {
    new SpecialFollowPageObject(driver).open().verifyFollowedImageVideo(imageName);
  }
}
