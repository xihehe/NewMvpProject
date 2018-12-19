package com.fc.myutilmodule.CompressModule;

import java.io.File;
import java.util.List;

public interface ICompress {

    void startCompress(String msg);
    void success(List<File> files);
    void fail(String msg);

}
