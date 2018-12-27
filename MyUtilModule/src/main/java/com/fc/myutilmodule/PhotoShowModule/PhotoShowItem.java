package com.fc.myutilmodule.PhotoShowModule;

import java.io.Serializable;

public class PhotoShowItem implements Serializable{

    private Object uri;


    public Object getUri() {
        return uri;
    }

    public void setUri(Object uri) {
        this.uri = uri;
    }
}
