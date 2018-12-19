package com.example.fc.newmvpproject.LoginModule.Model;

 public class LoginResult {


    String name;
    String about;
    String subName;
    thumbClass thumb;

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getAbout() {
         return about;
     }

     public void setAbout(String about) {
         this.about = about;
     }

     public String getSubName() {
         return subName;
     }

     public void setSubName(String subName) {
         this.subName = subName;
     }

     public thumbClass getThumb() {
         return thumb;
     }

     public void setThumb(thumbClass thumb) {
         this.thumb = thumb;
     }
 }

class thumbClass{
     String name;
     String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
